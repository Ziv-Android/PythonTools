#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_start.py
@author:    ziv
@time:      2020/5/26
@version:   v1.0.0
@desc:      汉字转拼音Demo
"""

import pypinyin
from pyhanlp import *

res = pypinyin.pinyin("下雨天", style=pypinyin.Style.FIRST_LETTER)
print(res)
res = pypinyin.lazy_pinyin("下雨天", style=pypinyin.Style.FIRST_LETTER)
print(res)
pys = pypinyin.pinyin("的的的", heteronym=True, style=pypinyin.NORMAL)
print(pys)
pys = pypinyin.pinyin("略", heteronym=True, style=pypinyin.NORMAL)
print(pys)
pys = pypinyin.pinyin("银行行长", heteronym=True, style=pypinyin.NORMAL)
print(pys)
# with open("large_pinyin.txt", "r") as rf:
#     for pinyin in rf.readlines():
#         print(pinyin)

large_pinyin = {"行长": [["hang"], ["zhang"]]}
pypinyin.load_phrases_dict(large_pinyin)
pys = pypinyin.pinyin("银行行长", heteronym=True, style=pypinyin.NORMAL)
print(pys)


# 中文转拼音
def chiness2pinyin(text):
    """
    :param text: 中文
    :return: 中文转拼音
    """
    pinyinList = HanLP.convertToPinyinList(text)
    pin = []
    for each in pinyinList:
        pin.append(each.getPinyinWithoutTone())

    res = ' '.join(pin)
    res = str(res).replace('none', ' ')

    return res


print(chiness2pinyin("银行行长"))
