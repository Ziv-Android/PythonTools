#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_InternetDailyNews.py
@author:    ziv
@time:      2019/5/16
@version:   v1.0.0
@desc:      互联网每日纪实
"""

import requests
from bs4 import BeautifulSoup
from lxml import etree
import time


def parser_xpath(html):
    root = etree.HTML(html.content)
    return root.xpath("//h3[@class]/a/text()")


def parser_bf(html):
    bf = BeautifulSoup(html.text, "html.parser")
    return bf.find_all()


def filter_rule(tag):
    # return tag.has_attr('href') and not tag.has_attr('id')
    return tag.has_attr('href')


if __name__ == "__main__":
    host = "http://tech.163.com/internet/"
    headers = {
        'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36'}
    response = requests.get(url=host, headers=headers)
    # a = parser_bf(response)
    a = parser_xpath(response)
    print(time.strftime("%Y年%m月%d日 %A"))
    print("60s看互联网圈内发生了什么?")
    print("------------------------")
    # for i in range(len(a)):
    for i in range(len(a)):
        print(str(i + 1), ":", a[i])

    print("整理: ziv")
    print("------------------------")
