#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_FileUtil.py
@author:    ziv
@time:      18-12-18
@version:   v1.0.0
@desc:      文件操作相关示例
"""


import os
import Utils.TimeUtil as timeu


def read_file(file_name):
    """
    r读文件
    """
    content = open(file_name, "r").read()
    return content


def write_file(file_name, line):
    """
    写文件操作
    w覆盖写
    a追加写
    """
    open(file_name, "a+").write(line)


def get_file_size(path):
    """
    获取文件大小，结果保留两位小数，单位MB
    """
    f = os.path.getsize(path)
    f = f/float(1024 * 1024)
    return round(f, 2)


def get_file_create_time(path):
    """
    获取文件创建时间
    """
    t = os.path.getctime(path)
    return timeu.time_format(t)


def get_file_modify_time(path):
    """
    获取文件修改时间
    """
    t = os.path.getmtime(path)
    return timeu.time_format(t)
