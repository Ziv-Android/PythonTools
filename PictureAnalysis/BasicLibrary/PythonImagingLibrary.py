#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@file:      PythonImagingLibrary.py
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

# 显示原图
pil_im = Image.open("data/876794893.jpg")
subplot(231)
title(u"原图", fontproperties=font)
axis("off")
imshow(pil_im)

# 显示灰度图
pil_gray = pil_im.convert("L")
gray()
subplot(232)
title(u"灰度图", fontproperties=font)
axis("off")
imshow(pil_gray)

# 拷贝粘贴区域
box = (100, 100, 400, 400)
region = pil_im.crop(box)
region = region.transpose(Image.ROTATE_180)
pil_im.paste(region, box)
subplot(233)
title(u"粘贴拷贝区域", fontproperties=font)
axis("off")
imshow(pil_im)

# 缩略图
pil_im = Image.open("data/876794893.jpg")
size = 128, 128
pil_im.thumbnail(size)
print(pil_im.size)
subplot(234)
title(u"缩略图", fontproperties=font)
axis("off")
imshow(pil_im)
pil_im.save("BasicLibrary/pic/thumbnail.jpg")

# 调整图像尺寸
pil_im = pil_im.resize(size)
print(pil_im.size)
subplot(235)
title(u"图像Resize", fontproperties=font)
axis("off")
imshow(pil_im)

# 图像旋转
pil_im = pil_im.rotate(45)
subplot(236)
title(u"图像旋转", fontproperties=font)
axis("off")
imshow(pil_im)

show()
