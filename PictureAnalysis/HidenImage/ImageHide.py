#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_ImageHide.py
@author:    ziv
@time:      19-4-30
@version:   v1.0.0
@desc:      使用OpenCV实现隐藏图片功能
"""


import cv2
import numpy as np


class OpenCVMask():
    def __init__(self):
        # read img 图像大小(width, height)
        self.img_show = cv2.resize(cv2.imread("../data/2018061301.jpg"), (500, 250), interpolation=cv2.INTER_CUBIC)
        self.img_hide = cv2.resize(cv2.imread("../data/2018061302.jpg"), (500, 250), interpolation=cv2.INTER_CUBIC)
        print("1. 加载图片.")

    def image_bgr2gray(self):
        self.img_show = cv2.cvtColor(self.img_show, cv2.COLOR_BGR2GRAY)
        self.img_hide = cv2.cvtColor(self.img_hide, cv2.COLOR_BGR2GRAY)
        print("2. 灰度处理.")

    def add_mask(self):
        self.img_show = cv2.cvtColor(self.img_show, cv2.COLOR_GRAY2BGRA)
        self.img_hide = cv2.cvtColor(self.img_hide, cv2.COLOR_GRAY2BGRA)
        self.img_hide[:, :, 3] = self.img_hide[:, :, 1]
        print("3. 白隐,覆盖蒙板.")

    def light_change(self, img, value):
        tmp = np.uint8(np.clip((1.0 * img + int(value)), 0, 255))
        print("4. 图片亮度修正 -> " + value)
        return tmp

    def overlap_img(self):
        visable = self.light_change(self.img_show, "-55")
        invisable = self.light_change(self.img_hide, "-55")
        overlapping = cv2.addWeighted(visable, 1.0, invisable, 1.0, 0)
        overlapping[:, :, 3] = invisable[:, :, 3]
        print("5. 图片合成.")
        return overlapping

    def file_out(self, img):
        cv2.imwrite("overlapping.png", img)
        print("6. 文件输出.")

    def run(self):
        self.image_bgr2gray()
        self.add_mask()
        result = self.overlap_img()
        self.file_out(result)


if __name__ == "__main__":
    try:
        test = OpenCVMask()
        test.run()
    except Exception as e:
        print(e)
