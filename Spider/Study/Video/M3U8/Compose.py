#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_Compose.py
@author:    ziv
@time:      2019/12/21
@version:   v1.0.0
@desc:      视频文件合成
"""

import os

for root, dirs, files in os.walk("QingYuNian"):
    with open("第34集.ts", 'wb+') as fw:
        files.sort()
        for file_name in files:
            print("source:", root + '/' + file_name)
            fw.write(open(root + '/' + file_name, 'rb').read())
