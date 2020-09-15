package com.example.grapeleafdisease

import android.Manifest.permission.*
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.startActivity
import com.google.firebase.ml.custom.*
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            dispatchTakePictureIntent()
        }


        val PERMISSIONS_STORAGE = arrayOf(
            READ_EXTERNAL_STORAGE,
            WRITE_EXTERNAL_STORAGE,
            INTERNET

        )
        val permission =
            ActivityCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE)
        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                PERMISSIONS_STORAGE, 1

            )
        }




    }

    val REQUEST_IMAGE_CAPTURE = 1

    fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            setContentView(R.layout.activity_main)
            val progressBar=findViewById<ProgressBar>(R.id.progressBar)


            progressBar.visibility = View.VISIBLE;
            doAI(imageBitmap)
        }
    }


    private fun doAI(image: Bitmap) {
        val bitmap = Bitmap.createScaledBitmap(image, 224, 224, true)

        val batchNum = 0
        val input = Array(1) { Array(224) { Array(224) { FloatArray(3) } } }
        for (x in 0..223) {
            for (y in 0..223) {
                val pixel = bitmap.getPixel(x, y)
                // Normalize channel values to [-1.0, 1.0]. This requirement varies by
                // model. For example, some models might require values to be normalized
                // to the range [0.0, 1.0] instead.
                input[batchNum][x][y][0] = (Color.red(pixel) - 127) / 255.0f
                input[batchNum][x][y][1] = (Color.green(pixel) - 127) / 255.0f
                input[batchNum][x][y][2] = (Color.blue(pixel) - 127) / 255.0f
            }


        }
        val localModel = FirebaseCustomLocalModel.Builder()
            .setAssetFilePath("model_unquant.tflite")
            .build()
        /*
        val remoteModel = FirebaseCustomRemoteModel.Builder("Model").build()

        val conditions = FirebaseModelDownloadConditions.Builder()
            .requireWifi()
            .build()

        FirebaseModelManager.getInstance().download(remoteModel, conditions)

        FirebaseModelManager.getInstance().isModelDownloaded(remoteModel)
            .addOnSuccessListener { isDownloaded ->
                val options =
                    if (isDownloaded) {

                    } else {

                    }*/
                val interpreter = FirebaseModelInterpreter.getInstance(FirebaseModelInterpreterOptions.Builder(localModel).build())
                val inputOutputOptions = FirebaseModelInputOutputOptions.Builder()
                    .setInputFormat(0, FirebaseModelDataType.FLOAT32, intArrayOf(1, 224, 224, 3))
                    .setOutputFormat(0, FirebaseModelDataType.FLOAT32, intArrayOf(1, 2))
                    .build()

                val inputs = FirebaseModelInputs.Builder()
                    .add(input)
                    .build()
                interpreter?.run(inputs, inputOutputOptions)
                    ?.addOnSuccessListener { result ->
                        val output = result.getOutput<Array<FloatArray>>(0)
                        val probabilities = output[0]

                       
                        var labels = listOf<String>("Echter Mehltau", "Falscher Mehltau")
                        for (i in probabilities.indices) {
                            val label = labels[i]
                            Log.i("MLKit", String.format("%s: %1.4f", label, probabilities[i]))


                        }
                        progressBar.visibility = View.INVISIBLE;
                        setContentView(R.layout.result)

                        val df = DecimalFormat("###")
                        df.roundingMode = RoundingMode.CEILING

                        val imageView=findViewById<ImageView>(R.id.imageView)
                        imageView.visibility = View.VISIBLE;
                        imageView.setImageBitmap(image);
                        val sorted=probabilities.sortedArrayDescending()

                        val button2 = findViewById<Button>(R.id.button2)

                        button2.setOnClickListener {
                            googlesearch(labels[probabilities.indexOf(sorted[0])])
                        }

                        val button3 = findViewById<Button>(R.id.button3)

                        button3.setOnClickListener {
                            googlesearch(labels[probabilities.indexOf(sorted[1])])
                        }

                        val button4 = findViewById<Button>(R.id.button4)
                        button4.setOnClickListener {
                            dispatchTakePictureIntent()
                        }

                        val textView1=findViewById<TextView>(R.id.textView1)
                        textView1.text = df.format(sorted[0]*100).toString()+'%'

                        button2.text=labels[probabilities.indexOf(sorted[0])]

                        val textView2=findViewById<TextView>(R.id.textView2)
                        textView2.text = df.format(sorted[1]*100).toString()+'%'
                        button3.text=labels[probabilities.indexOf(sorted[1])]




                    }
                    ?.addOnFailureListener { _ ->
                        print("Error")
                    }


            }




    }
    fun googlesearch(keyword: String){
        val i2 = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://www.google.com/search?q="+keyword)
        )
       // startActivity(i2)
        val intent =
            Intent(Intent.ACTION_VIEW).setData(Uri.parse("http://www.stackoverflow.com"))
        //startActivity(intent)


    }











