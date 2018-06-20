#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@file:      NumPyLibrary.py
@author:    ziv-peng
@time:      18-6-20
@desc:      
"""

from PIL import Image
from pylab import *

from matplotlib.font_manager import FontProperties
font = FontProperties(fname=r"/usr/share/fonts/opentype/noto/NotoSansCJK-Medium.ttc", size=14)

# 将图像转为数组信息
im = array(Image.open("../data/876794893.jpg"))
print(im.shape, im.dtype)
im = array(Image.open("../data/876794893.jpg").convert("L"), "f")
print(im.shape, im.dtype)

figure()

# 灰度变化
print(int(im.min()), int(im.max()))
im2 = 255 - im
print(int(im2.min()), int(im2.max()))
subplot(131)
gray()
contour(im2, origin='image')
title(r'$f(x)=255-x$', fontproperties=font)
axis("off")

im3 = (100.0/255) * im + 100
subplot(132)
print(int(im3.min()), int(im3.max()))
contour(im3, origin='image')
title(r'$f(x)=\frac{100}{255}x+100$', fontproperties=font)
axis("off")

im4 = 255.0 * (im/255.0)**2
print(int(im4.min()), int(im4.max()))
subplot(133)
contour(im4, origin='image')
title(r"$f(x)=255(\frac{x}{255})^2$", fontproperties=font)
axis("off")

show()
