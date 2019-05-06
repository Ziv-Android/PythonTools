#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_NumpyDemo.py
@author:    ziv
@time:      19-1-3
@version:   v1.0.0
@desc:      脚本功能描述
"""


import numpy as np

# 列表转换为矩阵
narray = np.array([[1, 2, 3], [4, 5, 6]])
print(narray)

print("维度: " + str(narray.ndim))
print("行列数: " + str(narray.shape))
print("元素个数: " + str(narray.size))
