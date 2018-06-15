#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@file:      BasicLibraryDemo.py
@author:    ziv-peng
@time:      18-6-13
@desc:      基础库测试使用
"""

# PIL(Python Imaging Library)
from PIL import Image
from pylab import *

# 中文字体支持
# Linux： 使用命令`locate *.ttc`获取字体文件所在路径
# Windows： r"c:\windows\fonts\SimSun.ttc"
from matplotlib.font_manager import FontProperties
font = FontProperties(fname=r"/usr/share/fonts/opentype/noto/NotoSansCJK-Medium.ttc", size=14)
figure()

pil_im = Image.open("data/876794893.jpg")
gray()
subplot(331)
title(u"原图", fontproperties=font)
axis("off")
imshow(pil_im)

pil_gray = pil_im.convert("L")
subplot(332)
title(u"灰度图", fontproperties=font)
axis("off")
imshow(pil_gray)

show()
