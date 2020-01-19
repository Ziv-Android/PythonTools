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


class Util:
    def __init__(self):
        self.pos = 0

    def json_parse(self, json_data):
        if isinstance(json_data, dict):
            self.pos += 1
            json_object = json_data.items()
            for key, value in json_object:
                # print(self.pos, key, value)
                self.json_parse(value)
            self.pos -= 1
        elif isinstance(json_data, list):
            self.pos += 1
            for item in json_data:
                # print(self.pos, item)
                self.json_parse(item)
            self.pos -= 1
        else:
            print(self.pos, json_data)
            # self.write_to_file(json_data)

    def write_to_file(self, data):
        key = ""
        if self.pos == 1:
            key = re.findall(r"host:(\w+)", data)[0]
            print(key)
            # 创建目录
            os.makedirs(key, exist_ok=True)
            # 创建文件
        #     if len(key) != 0:
        #         file_name = key.capitalize()
        #         with open(key + "/" + file_name + "Server", "w") as wf:
        #             wf.write("aaa")
        # elif self.pos == 3:
        #     # 读取HostType
        # elif self.pos == 5:
        #     # 添加Host




if __name__ == "__main__":
    with open('api_config.json', 'r') as f:
        file_data = json.load(f)
        util = Util()
        util.json_parse(file_data)


'''
json.dumps: 对数据进行编码
json.loads(json_data): 对数据进行解码
json.load(f)
'''