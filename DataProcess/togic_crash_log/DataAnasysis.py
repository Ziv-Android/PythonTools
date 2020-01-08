#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_DataAnasysis.py
@author:    ziv
@time:      2019/10/28
@version:   v1.0.0
@desc:      脚本功能描述
"""

with open("data/19480") as f:
    data = f.readlines()
    print(data[0])
    # for line in data:
    for line_index in range(100):
        print(data[line_index])
        line = data[line_index]
        line.find("ActivityManager")
