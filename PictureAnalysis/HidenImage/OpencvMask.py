#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_OpencvMask.py
@author:    ziv
@time:      19-4-30
@version:   v1.0.0
@desc:      使用OpenCV实现隐藏图片功能
"""


import cv2
import numpy as np


class OpenCVMask():
    def __init__(self):
        self.img_width = 500
        self.img_height = 250
        # read img
        __tmp = cv2.imread("../data/2018061301.jpg")
        self.img_show = cv2.resize(__tmp, (self.img_width, self.img_height), interpolation=cv2.INTER_CUBIC)
        __tmp = cv2.imread("../data/2018061302.jpg")
        self.img_hide = cv2.resize(__tmp, (self.img_width, self.img_height), interpolation=cv2.INTER_CUBIC)
        print("1. 加载图片 -> finished")

    def image_bgr2gray(self):
        # Y = 0.299R + 0.587G + 0.114B
        self.img_show = cv2.cvtColor(self.img_show, cv2.COLOR_BGR2GRAY)
        self.img_hide = cv2.cvtColor(self.img_hide, cv2.COLOR_BGR2GRAY)
        print("2. 灰度处理 -> finished")
        # print(self.img_show)
        # cv2.namedWindow("src", cv2.WINDOW_NORMAL)
        # cv2.imshow("src", gray_img)
        # return gray_img

    def separate_value(self):
        self.img_show = self.img_show
        print("2.1 隔值处理 -> finished")

    def conv(self):
        round(self.img_hide)

    def add_mask(self):
        self.img_show = cv2.cvtColor(self.img_show, cv2.COLOR_GRAY2BGRA)
        self.img_hide = cv2.cvtColor(self.img_hide, cv2.COLOR_GRAY2BGRA)
        self.img_show[:, :, 3] = 255 - self.img_show[:, :, 1]
        self.img_hide[:, :, 3] = self.img_hide[:, :, 1]
        print(self.img_show)
        print("3. 覆盖蒙板 -> finished")

    def light_down(self):
        dark_img = np.uint8(np.clip((1.0 * self.img_hide - 50.0), 0, 255))
        # print(dark_img)
        tmp = np.hstack((self.img_hide, dark_img))
        cv2.namedWindow("light_down", cv2.WINDOW_NORMAL)
        cv2.imshow("light_down", tmp)
        print("4.1 白隐,显示图亮度减弱 -> finished")
        return dark_img

    def light_up(self):
        light_img = np.uint8(np.clip((1.3 * self.img_show + 0.0), 0, 255))
        # print(light_img)
        tmp = np.hstack((self.img_show, light_img))
        cv2.namedWindow("light_up", cv2.WINDOW_NORMAL)
        cv2.imshow("light_up", tmp)
        print("4.2 白隐,隐藏图亮度增强 -> finished")
        return light_img

    def overlap_img(self):
        visable = self.light_up()
        invisable = self.light_down()
        overlapping = cv2.addWeighted(visable, 1.0, invisable, 1.0, 0)
        overlapping[:, :, 3] = invisable[:, :, 3]
        # print(overlapping)
        # cv2.namedWindow("overlap_img", cv2.WINDOW_NORMAL)
        # cv2.imshow("overlap_img", overlapping)
        print("5. 图片合成 -> finished")
        return overlapping

    def file_out(self, img):
        cv2.imwrite("overlapping.png", img)
        print("6. 文件输出 -> finished.")

    def run(self):
        self.image_bgr2gray()
        # self.separate_value()
        self.add_mask()
        result = self.overlap_img()
        self.file_out(result)
        cv2.waitKey(0)
        cv2.destroyAllWindows()


if __name__ == "__main__":
    try:
        test = OpenCVMask()
        test.run()
    except Exception as e:
        print(e)
