#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_UrlCheck.py
@author:    ziv
@time:      2019/8/14
@version:   v1.0.0
@desc:      读取日志文件, 解析JSON, 分析广告Url
"""

import json
import DataProcess.togic_ad_log.GUIModel
import matplotlib.pyplot as plt
import pandas as pd

with open("data/20190814_1710.bj-hadoop-3.25619_1565774160269.log") as f:
    data = f.readlines()
    print(data[0])
    for line in data:
        jsonDict = json.loads(line)

        print(jsonDict["data"]["url"])
