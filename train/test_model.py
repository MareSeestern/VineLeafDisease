# -*- coding: utf-8 -*-
"""
@author: Mario und Maria-Theresa
"""

import tensorflow as tf

from sklearn.metrics import confusion_matrix, precision_score,accuracy_score
model= tf.keras.models.load_model(filepath="model.h5")


import matplotlib.pyplot as plt
 

import tensorflow as tf
from tensorflow import keras
import time
import math
from tensorflow.keras.preprocessing.image import ImageDataGenerator
from tensorflow import keras
import pandas as pd
import numpy as np

test_datagen = ImageDataGenerator(rescale=1./255)

test_generator = test_datagen.flow_from_directory(
        "..\data",
        target_size=(180, 180),
        batch_size=50,
        class_mode='categorical',
        shuffle=True
        )

number_of_examples = len(test_generator.filenames)
number_of_generator_calls = math.ceil(number_of_examples / (1.0 * 50)) 

test_labels = []

for i in range(0,int(number_of_generator_calls)):
    test_labels.extend(np.array(test_generator[i][1]))


test_labels=np.argmax(test_labels,axis=1) 



pred=model.predict(test_generator, steps=len(test_generator))
predicted_class_indices=np.argmax(pred,axis=1) 

print(precision_score(test_labels,predicted_class_indices,average=None))
print(accuracy_score(test_labels,predicted_class_indices))

cm=confusion_matrix(test_labels,predicted_class_indices)
print(cm.diagonal()/cm.sum(axis=1))
print(cm)


plt.clf()
plt.imshow(cm, interpolation='nearest', cmap=plt.cm.Wistia)
classNames = ['Echt','Esca','Falsch','Schwarzholz']
plt.title('Confusion Matrix - Test Data')
plt.ylabel('True label')
plt.xlabel('Predicted label')
tick_marks = np.arange(len(classNames))
plt.xticks(tick_marks, classNames, rotation=45)
plt.yticks(tick_marks, classNames)

plt.show()
