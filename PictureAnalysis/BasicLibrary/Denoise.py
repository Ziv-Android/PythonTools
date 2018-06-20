#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@file:      Denoise.py
@author:    ziv-peng
@time:      18-6-20
@desc:      
"""

from pylab import *
from numpy import *
from scipy.ndimage import filters

from matplotlib.font_manager import FontProperties
font = FontProperties(fname=r"/usr/share/fonts/opentype/noto/NotoSansCJK-Medium.ttc", size=14)
figure()


def deniose(im, U_init, tolerance=0.1, tau=0.125, tv_weight=100):
    """使用A. Chambolle（2005）在公式（11）中的计算步骤实现Rudin-Osher-Fatemi（ROF）去噪模型
    输入：含有噪声的输入图像（灰度图像）、U 的初始值、TV 正则项权值、步长、停业条件
    输出：去噪和去除纹理后的图像、纹理残留"""
    # 噪声图像大小
    m, n = im.shape
    # 初始化
    U = U_init
    # 对偶域x,y分量
    Px = im
    Py = im
    error = 1
    while(error > tolerance):
        Uold = U
        # 原始变量的梯度
        GradUx = roll(U, -1, axis=1) - U
        GradUy = roll(U, -1, axis=0) - U
        # 更新对偶变量
        PxNew = Px + (tau/tv_weight) * GradUx
        PyNew = Py + (tau/tv_weight) * GradUy
        NormNew = maximum(1, sqrt(PxNew**2 + PyNew**2))
        Px = PxNew/NormNew
        Py = PyNew/NormNew
        # 更新原始变量
        RxPx = roll(Px, 1, axis=1)
        RyPy = roll(Py, 1, axis=0)
        # 对偶域散度
        DivP = (Px - RxPx) + (Py - RyPy)
        U = im + tv_weight * DivP
        # 更新误差
        error = linalg.norm(U - Uold)/sqrt(n * m)
    # 返回去噪后的图像和纹理残余
    return U, im - U


im = zeros((500, 500))
im[100:400, 100:400] = 128
im[200:300, 200:300] = 255
im = im + 30*random.standard_normal((500, 500))

U, T = deniose(im, im)
G = filters.gaussian_filter(im, 10)

gray()

subplot(131)
imshow(im)
axis("off")
title(u'原噪声', fontproperties=font)

subplot(132)
imshow(G)
axis("off")
title(u'高斯模糊', fontproperties=font)

subplot(133)
imshow(U)
axis("off")
title(u'ROF降噪', fontproperties=font)

show()
