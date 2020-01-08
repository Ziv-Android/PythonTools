#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_Demo.py
@author:    ziv
@time:      2020/1/8
@version:   v1.0.0
@desc:      脚本功能描述
"""

import json

with open('api_config.json', 'r') as f:
    print(type(f))
    data = json.load(f)
    print(type(data))
    items = data.items()
    print(type(items))
    for key, value in items:
        if "hosts" == key:
            print(type(value))
            for value_item in value:
                print(type(value_item))
    #             host = json.loads(value_item)
    #             print(host)

# def json_load(data):
#     if isinstance(data, f)
#
# def json_parse():



'''
json.dumps: 对数据进行编码
json.loads(json_data): 对数据进行解码
json.load(f)
'''