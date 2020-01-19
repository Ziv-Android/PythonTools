#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_Demo.py
@author:    ziv
@time:      2020/1/8
@version:   v1.0.0
@desc:      json解析
"""

import json
import re
import os


def json_parse(json_data):
    if isinstance(json_data, dict):
        json_object = json_data.items()
        for key, value in json_object:
            print(key, value)
            json_parse(value)

    elif isinstance(json_data, list):
        for item in json_data:
            print(item)
            json_parse(item)
    else:
        print(json_data)


if __name__ == "__main__":
    with open('api_config.json', 'r') as f:
        file_data = json.load(f)
        json_parse(file_data)

'''
json.dumps: 对数据进行编码
json.loads(json_data): 对数据进行解码
json.load(f)
'''
