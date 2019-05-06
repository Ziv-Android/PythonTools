#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_JiebaDemo.py
@author:    ziv
@time:      18-12-17
@version:   v1.0.0
@desc:      脚本功能描述
"""


import jieba.analyse
import re
from wordcloud import WordCloud

text = "我爱北京天安门"


def remove_number(line):
    # rule = re.compile(r"[^a-zA-Z\u4e00-\u9fa5]+")
    rule = re.compile(r"[0-9\-_\n]+")
    line = rule.sub("", line)
    return line


result = []
# jieba.enable_parallel(4)
content = open("word.txt", "r").readlines()
for text in content:
    result.append(remove_number(text))

result = list(set(result))
print(result)

result = str(result)
word = jieba.analyse.extract_tags(result, topK=10, withWeight=False)
print(word)
# wordcloud = WordCloud(background_color="white", width=100, height=86)
# words = "/".join(jieba.cut(content))
# print(words)

# result = jieba.cut(text)
# print("/".join(result))
# f = open("word.txt", "r")
# # print(str(f.readlines()))
# for text in f.readlines():
#     print(text)
#     result = jieba.cut(text)
#     print(result)
