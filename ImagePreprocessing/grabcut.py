# -*- coding: utf-8 -*-
"""
Created on Wed Jul  8 16:16:12 2020

@author: Maria-Theresa and Mario
"""
import concurrent.futures
import numpy as np
import cv2
from itertools import repeat
from multiprocessing import cpu_count
import os

def grabcutter(pfad):
  
  bgdModel = np.zeros((1,65),np.float64) # Grundlegende Variablen für Grabcut Algorithmus
  fgdModel = np.zeros((1,65),np.float64)

  
  e1 = cv2.getTickCount()
 
  print("Bild fängt an verarbeitet zu werden. Ergebnis wird in wenigen Minuten im Ordner ImagePreprocessing sein.")
  
  img = cv2.imread(pfad) # Einlesen
  mask = np.zeros(img.shape[:2],np.uint8)
  
  rect = (0,0,img.shape[0],img.shape[1])   # Schätzungen von dem Cascade, wo sich der Vordergrund befindet

  cv2.grabCut(img,mask,rect,bgdModel,fgdModel,5,cv2.GC_INIT_WITH_RECT) # Grabcut Algorithmus
  mask2 = np.where((mask==2)|(mask==0),0,1).astype('uint8') # Maske einfügen
  img = img*mask2[:,:,np.newaxis]  
  cv2.imwrite('exampleGrabCut.jpg',img) # Speichern
  e2 = cv2.getTickCount() # Benötigte Zeit ausrechnen
  print("Benötigte Zeit für Bild: "+ str((e2-e1)/ cv2.getTickFrequency()))


def run():
    
    grabcutter('example.jpg')
    
if __name__ == '__main__':
    run()
