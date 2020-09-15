<a href="https://raw.githubusercontent.com/MareSeestern/VineLeafDisease/master/res/IMG_2417.JPG?token=AK7DBRW6IEW2N3ABYX6NDZ27ND43U" title="vine" alt="vine"></a>



# Vine Leaf Disease 

> Klassifizieren von Weinblattkrankheiten mit Künstlicher Intelligenz

> Erstellt von: Maria-Theresa Licka und Mario Schweikert



## Table of Contents 

- [Projektbeschreibung](#Projektschreibung)
- [Inhalt](#Inhalt)
- [Setup](#Setup)


---

## Projektbeschreibung
Wir haben eine Handy-App programmiert die Blattkrankheiten von Weinreben mit Hilfe von Künstlicher Intelligenz klassifiziert. 

Dadurch erhoffen wir uns einen deutlich geringeren Pestizideinsatz, da die Krankheit früh und einfach mit unserer App erkannt, bestimmt und behandelt werden kann bevor sie sich auf weitere Weinreben ausweitet bzw. sie die Pflanzen so stark schwächt, dass der Ertrag enorm sinkt. Daher wirkt sich unser Projekt auch positiv auf den Ertrag aus, wodurch langfristig Nutzanbaufläche reduziert werden kann.

Im Moment unterscheidet bzw. erkennt unsere künstliche Intelligenz (KI), verbunden mit unserer App zwischen vier verschiedenen Krankheitstypen (Echter Mehltau, falscher Mehltau, Esca und Schwarzholzkrankheit). Da eine KI für das Training eine sehr großen Datensatz benötigt, diese jedoch nur in begrenztem Umfang zur Verfügung stehen haben wir auch eigene Aufnahmen der Blattkrankheiten gemacht. Zukünftig planen wir den Datensatz auf weitere Weinrebenkrankheiten auszuweiten. Zudem planen wir andere landwirtschaftliche Nutzpflanzen mit häufigen Schädlings- und Pilzbefällen hinzufügen und somit den Pestizideinsatz allgemein deutlich zu verringern.

Wie funktioniert die KI bzw. App für den Anwender? Die Anwendung ist sehr einfach: Nach dem Download und öffnen unserer App wird ein Bild von dem Weinrebenblatt mit dem Handy gemacht. Das erstellt Bild wird von der KI analysiert und gibt anschließend die klassifizierte Krankheits aus.


## Inhalt

Unser Projekt lässt sich in folgende Parts unterteilen:
- Python Datei, um Bilder zu formatieren und aus Videos zu exportieren (siehe Ordner PreProcessing)
- Python Notebook, um das Modell zu trainieren und anschließen zu speichern.
- Python Datei, um das Modell zu testen
- Android Studio Projekt, welche mit dem Modell als '.tflite' die Krankheit klassifiziert

# Clone

- Klone dieses Repository mit Hilfe von GitHub Desktop oder über den Browser auf Deine lokale Maschiene.

# Setup
Wir nutzen als Programme Android Studio (4.0.1) und Anaconda. 

## Trainieren von dem Modell (Datensatz benötigt)
Der selbsterstellte Datensatz sollte hier über Kaggle heruntergeladen werden und in VineLeafDisease\data eingefügt werden.
> Installieren von den nötigen Bibliotheken in "Anaconda Prompt"

```shell
$ pip install -r requirements.txt
```

> Nun kann das Training über folgenden Befehl gestartet werden:

```shell
$ cd train
$ python train_model.py
```


## Builden von der App

Dazu wird das der Ordner App in Android-Studio geöffnet. Man erkennt unter "layouts" die grafischen Oberflächen und unter "MainActivity.java" den grundliegenden Code.
Wir empfehlen folgende Web-Links, um das Projekt selbst zu builden oder man installiert einfach die fertige .apk (siehe <a href="https://github.com/MareSeestern/VineLeafDisease#apk-installieren">APK installieren</a>)

<a href="https://developer.android.com/studio/run/device">Einmalig auf lokalem Handy oder Simulator ausführen</a>

<a href="https://abhiandroid.com/androidstudio/generate-signed-apk-android-studio.html">.apk builden</a>



## APK installieren
Dazu scannst du diesen QR-Code mit deinem Smartphone:
![](https://raw.githubusercontent.com/MareSeestern/VineLeafDisease/master/res/AppQR.png?token=AK7DBRV5YTJ3IDPGSTZFSK27NHMRO)

oder nutzt diesen <a href="https://drive.google.com/file/d/1npnsMtaIsVVsbCF-eiqHoJnudZju3qF-/view?usp=sharing">Link</a> :

Er führt zu einer .apk von Google-Drive. In naher Zukunft veröffentlichen wir unsere App auch im <strong>PlayStore</strong>

- Scannen des QR-Codes
- Auswählen des Google Accounts
- Mit Paket-Installer öffnen
- Installieren (geg. Externe-Quellen erlauben oder ähnliche Warnungen akzeptieren)
- Nach der Installation App öffnen und Zuhriff auf Medien und Dateien erlauben

![](https://raw.githubusercontent.com/MareSeestern/VineLeafDisease/master/res/AppTutorial.gif?token=AK7DBRSCY4MBEIMQZ6RQ62C7NHMIA)

## Features
## Usage (Optional)
## Documentation (Optional)
## Tests (Optional)

- Going into more detail on code and technologies used
- I utilized this nifty <a href="https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet" target="_blank">Markdown Cheatsheet</a> for this sample `README`.

---

## Contributing

> To get started...

### Step 1

- **Option 1**
    - 🍴 Fork this repo!

- **Option 2**
    - 👯 Clone this repo to your local machine using `https://github.com/joanaz/HireDot2.git`

### Step 2

- **HACK AWAY!** 🔨🔨🔨

### Step 3

- 🔃 Create a new pull request using <a href="https://github.com/joanaz/HireDot2/compare/" target="_blank">`https://github.com/joanaz/HireDot2/compare/`</a>.

---

## Team

> Or Contributors/People

| <a href="http://fvcproductions.com" target="_blank">**FVCproductions**</a> | <a href="http://fvcproductions.com" target="_blank">**FVCproductions**</a> | <a href="http://fvcproductions.com" target="_blank">**FVCproductions**</a> |
| :---: |:---:| :---:|
| [![FVCproductions](https://avatars1.githubusercontent.com/u/4284691?v=3&s=200)](http://fvcproductions.com)    | [![FVCproductions](https://avatars1.githubusercontent.com/u/4284691?v=3&s=200)](http://fvcproductions.com) | [![FVCproductions](https://avatars1.githubusercontent.com/u/4284691?v=3&s=200)](http://fvcproductions.com)  |
| <a href="http://github.com/fvcproductions" target="_blank">`github.com/fvcproductions`</a> | <a href="http://github.com/fvcproductions" target="_blank">`github.com/fvcproductions`</a> | <a href="http://github.com/fvcproductions" target="_blank">`github.com/fvcproductions`</a> |

- You can just grab their GitHub profile image URL
- You should probably resize their picture using `?s=200` at the end of the image URL.

---

## FAQ

- **How do I do *specifically* so and so?**
    - No problem! Just do this.

---

## Support

Reach out to me at one of the following places!

- Website at <a href="http://fvcproductions.com" target="_blank">`fvcproductions.com`</a>
- Twitter at <a href="http://twitter.com/fvcproductions" target="_blank">`@fvcproductions`</a>
- Insert more social links here.

---

## Donations (Optional)

- You could include a <a href="https://cdn.rawgit.com/gratipay/gratipay-badge/2.3.0/dist/gratipay.png" target="_blank">Gratipay</a> link as well.

[![Support via Gratipay](https://cdn.rawgit.com/gratipay/gratipay-badge/2.3.0/dist/gratipay.png)](https://gratipay.com/fvcproductions/)


---

## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
- Copyright 2015 © <a href="http://fvcproductions.com" target="_blank">FVCproductions</a>.
