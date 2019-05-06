#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_OpencvTest.py
@author:    ziv
@time:      2019/5/5
@version:   v1.0.0
@desc:      OpenCV功能测试
"""


import cv2
import numpy as np


def read_file():
    img = cv2.imread("../data/2018061301.jpg")
    img = cv2.resize(img, (400, 200), interpolation=cv2.INTER_CUBIC)
    # img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    # img = cv2.cvtColor(img, cv2.COLOR_GRAY2BGRA)
    return img


def write_file():
    cv2.imwrite("test.png", read_file())


def create_custom_img():
    res = read_file()
    img = np.zeros((400, 400, 4), np.uint8)
    for i in range(200):
        for j in range(0, 400, 2):
            for k in range(3):
                res.itemset((i, j, k), 0)

    # for i in range(1, 200, 2):
    #     for j in range(1, 400, 2):
    #         for k in range(3):
    #             res.itemset((i, j, k), 255)

    # res[:, :, 3] = res[:, :, 1] - 100
    # img[:, :, 3] = 255
    print(res)
    cv2.imshow("img", res)


def salt_value():
    res = read_file()
    print(res.size)
    print(len(res))
    # for k in range(len(res)):


if __name__ == "__main__":
    # salt_value()
    create_custom_img()
    cv2.waitKey(0)
