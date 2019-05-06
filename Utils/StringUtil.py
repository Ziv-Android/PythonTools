#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_StringUtil.py
@author:    ziv
@time:      18-12-18
@version:   v1.0.0
@desc:      字符串处理工具类
"""

import re


RULE_ONLY_CHINESE = r"[\u4e00-\u9fa5]"
RULE_REMOVE_NUMBER = r"[^0-9]"
RULE_REMOVE_LETTER = r"[^a-zA-Z]"


def remove_number(line):
    """
    使用正则表达式, 去除字符串中的字符, 此处正则逻辑为保留字母和汉字
    数字: 0-9
    汉字： \u4e00-\u9fa5
    字母： a-zA-Z
    其他特殊符号
    """
    rule = re.compile(r"[^a-zA-Z\u4e00-\u9fa5]+")
    line = rule.sub("", line)
    return line


def remove_letter(line):
    rule = re.compile(r"[a-zA-Z]+")
    line = rule.sub("", line)
    return line
