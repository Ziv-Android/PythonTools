#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_PlayUrl.py
@author:    ziv
@time:      2019/12/21
@version:   v1.0.0
@desc:      脚本功能描述
"""

with open("url_list_src.txt", 'r') as rf:
    with open("url_src.txt", 'w+') as wf:
        lines = rf.readlines()
        for line in lines:
            line_list = line.split('\t')
            title = line_list[0].strip()
            ori = line_list[1].strip()
            src = line_list[2].strip()

            src_list = src.split('?url=')
            src = src_list[1]
            result = "%s\t%s\t%s\n" % (title, ori, src)
            print(result)
            wf.write(result)
