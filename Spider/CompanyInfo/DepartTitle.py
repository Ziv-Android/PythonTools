#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_DepartTitle.py
@author:    ziv
@time:      2020/4/2
@version:   v1.0.0
@desc:      脚本功能描述
"""

import re

s = 'Beth Bioinformatics Co., Limited 貝思生物科技有限公司'

regex = r'(.*)\s([\u4e00-\u9fa5]*)'
match = re.match(regex, s)
s_all = match.group(0)
s_en = match.group(1)
s_zh = match.group(2)

print(s_all)
print(s_en)
print(s_zh)
