#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@file:      PythonTools_MaskImage.py
@author:    ziv-peng
@time:      19-5-06
@desc:      隐藏图
"""

from PIL import Image
import sys

size = 512, 512
# dark = Image.open(sys.argv[1], 'r').resize(size).convert('LA').split()[0]
# bright = Image.open(sys.argv[2], 'r').resize(size).convert('LA').split()[0]
dark = Image.open("../data/2018061301.jpg", 'r').resize(size).convert('LA').split()[0]
bright = Image.open("../data/2018061302.jpg", 'r').resize(size).convert('LA').split()[0]


def conv(c1, c2):
    c = round(255 * c1 / (255 + c1 - c2)) if 255 + c1 - c2 != 0 else 0
    alpha = 255 + c1 - c2 if 255 + c1 - c2 <= 255 else 255
    global distortion
    if 255 + c1 - c2 > 255:
        distortion += 1
    return c, alpha


distortion = 0
newdata = list(map(conv, dark.getdata(), bright.getdata()))
print('失真(distortion):%.2f%%' % (distortion / len(newdata) * 100))

img = Image.new('LA', dark.size)
img.putdata(newdata)

# img.save(sys.argv[3], "PNG")
img.save("test.png", "PNG")
