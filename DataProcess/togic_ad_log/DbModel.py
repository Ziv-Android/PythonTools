#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_DbModel.py
@author:    ziv
@time:      2019/8/15
@version:   v1.0.0
@desc:      mongoDb模块
"""

import pymongo

client = pymongo.MongoClient(host='localhost', port=27017)
db = client['ad_analysis']

