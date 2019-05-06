#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_TimeUtil.py
@author:    ziv
@time:      18-12-27
@version:   v1.0.0
@desc:      脚本功能描述
"""


import time
import datetime


def time_format(timestamp):
    """
    时间戳格式化 1479264792
    2016-11-16 10:53:12
    """
    convert = time.localtime(timestamp)
    return time.strftime('%Y-%m-%d %H:%M:%S', convert)


def get_time_stamp():
    return int(time.time() * 1000)
