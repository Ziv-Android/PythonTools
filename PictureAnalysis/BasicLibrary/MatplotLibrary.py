#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@file:      MatplotLibrary.py
@author:    ziv-peng
@time:      18-6-20
@desc:      
"""

from PIL import Image
from pylab import *

from matplotlib.font_manager import FontProperties
font = FontProperties(fname=r"/usr/share/fonts/opentype/noto/NotoSansCJK-Medium.ttc", size=14)

im = Image.open("../data/876794893.jpg")
figure()

subplot(331)
imshow(im)
x = [100, 100, 400, 400]
y = [200, 500, 200, 500]
plot(x, y, "r*")
plot(x[:2], y[:2])
title(u'绘图："876794893.jpg"', fontproperties=font)

# 不显示坐标轴
subplot(333)
imshow(im)
x = [100, 100, 400, 400]
y = [200, 500, 200, 500]
plot(x, y, 'r*')
plot(x[:2], y[:2])
axis('off')  # 显示坐标轴
title(u'绘图: "876794893.jpg"', fontproperties=font)

im = array(Image.open('../data/876794893.jpg').convert('L'))  # 打开图像，并转成灰度图像
subplot(334)
gray()
contour(im, origin='image')
axis('off')
title(u'图像轮廓', fontproperties=font)

subplot(336)
hist(im.flatten(), 128)
title(u'图像直方图', fontproperties=font)
plt.xlim([0, 260])
plt.ylim([0, 11000])

# 交互
im = array(Image.open('../data/876794893.jpg'))
subplot(338)
imshow(im)
print('Please click 3 points')
x = ginput(3)
print('You clicked:', x)

show()
