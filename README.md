<a href="https://raw.githubusercontent.com/MareSeestern/VineLeafDisease/master/res/IMG_2417.JPG?token=AK7DBRW6IEW2N3ABYX6NDZ27ND43U" title="vine" alt="vine"></a>

---

# Vine Leaf Disease 

> Klassifizieren von Weinblattkrankheiten mit Künstlicher Intelligenz

> Erstellt von: Maria-Theresa Licka und Mario Schweikert

---

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

---

# APP installieren
Dazu scannst du diesen QR-Code mit deinem Smartphone:
![](https://raw.githubusercontent.com/MareSeestern/VineLeafDisease/master/res/AppQR.png?token=AK7DBRV5YTJ3IDPGSTZFSK27NHMRO?s=600)

oder nutzt diesen <a href="https://drive.google.com/file/d/1npnsMtaIsVVsbCF-eiqHoJnudZju3qF-/view?usp=sharing">Link</a> :

Er führt zu einer .apk von Google-Drive. In naher Zukunft veröffentlichen wir unsere App auch im <strong>PlayStore</strong>

- Scannen des QR-Codes
- Auswählen des Google Accounts
- Mit Paket-Installer öffnen
- Installieren (geg. Externe-Quellen erlauben oder ähnliche Warnungen akzeptieren)
- Nach der Installation App öffnen und Zuhriff auf Medien und Dateien erlauben

![](https://raw.githubusercontent.com/MareSeestern/VineLeafDisease/master/res/AppTutorial.gif?token=AK7DBRSCY4MBEIMQZ6RQ62C7NHMIA)

---

## Inhalt

Unser Projekt lässt sich in folgende Parts unterteilen:
- Android Studio Projekt, welche mit dem Modell als '.tflite' die Krankheit klassifiziert
- Python Datei, um Bilder zu formatieren und aus Videos zu exportieren (siehe Ordner PreProcessing)
- Python Notebook, um das Modell zu trainieren und anschließen zu speichern.
- Python Datei, um das Modell zu testen


---

# Clone

- Klone dieses Repository mit Hilfe von GitHub Desktop oder über den Browser auf Deine lokale Maschiene.

# Setup
Wir nutzen als Programme Android Studio (4.0.1) und Anaconda. 


---


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

---

## Testen von dem Modell (Test-Datensatz benötigt)
Der selbsterstellte Test-Datensatz sollte hier heruntergeladen werden und in VineLeafDisease\Testdata eingefügt werden.
> Installieren von den nötigen Bibliotheken in "Anaconda Prompt"

```shell
$ pip install -r requirements.txt
```
```shell
$ cd train
$ python test_model.py
```

---

---

## Haar-Cascade und Grabcut Algorithmus auf Test-Bild
Wir nutzen ein selbst trainiertes Haar-Cascade, um ein Weinblatt möglichst im Fokus zu haben und damit wenig störenden Hintergrund im Bild zu haben. Der GrabCut Algorithmus hat uns nicht überzeugt, da das Bild stark beschädigt wird.

Ursprungsbild:

![](https://raw.githubusercontent.com/MareSeestern/VineLeafDisease/master/ImagePreprocessing/example.jpg?token=AK7DBRVWCELILIR2ZN2ISGC7NH56W)

> Installieren von den nötigen Bibliotheken in "Anaconda Prompt"

### Haar-Cascade

```shell
$ pip install -r requirements.txt
```
```shell
$ cd ImagePreprocessing
$ python cascade.py
```

Ergebniss Haar-Cascade:
![](https://raw.githubusercontent.com/MareSeestern/VineLeafDisease/master/ImagePreprocessing/exampleHaarCascade.jpg?token=AK7DBRSPCSDIZFYK3VG3QPK7NH6AM)


### Grabcut (nicht im Trainingsdatensatz angewendet)

```shell
$ pip install -r requirements.txt
```
```shell
$ cd ImagePreprocessing
$ python grabcut.py
```

Ergebniss Haar-Cascade:
![](https://raw.githubusercontent.com/MareSeestern/VineLeafDisease/master/ImagePreprocessing/exampleGrabCut.jpg?token=AK7DBRVGDLTRDU4I5NR6DIC7NH56U


---
## Builden von der App

Dazu wird das der Ordner App in Android-Studio geöffnet. Man erkennt unter "layouts" die grafischen Oberflächen und unter "MainActivity.java" den grundliegenden Code.
Wir empfehlen folgende Web-Links, um das Projekt selbst zu builden oder man installiert einfach die fertige .apk (siehe <a href="https://github.com/MareSeestern/VineLeafDisease#apk-installieren">APK installieren</a>)

<a href="https://developer.android.com/studio/run/device">Einmalig auf lokalem Handy oder Simulator ausführen</a>

<a href="https://abhiandroid.com/androidstudio/generate-signed-apk-android-studio.html">.apk builden</a>

---

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


---

## Support

Wir sind hier zu finden:

- Website at <a href="google.com" target="_blank">`EINFÜGEN`</a>
- Youtube at <a href="https://www.youtube.com/channel/UCsGZt4UtInZ01tBjM1B-FbQ?view_as=subscriber" target="_blank">`INFOrmAtIc Teens`</a>


---


