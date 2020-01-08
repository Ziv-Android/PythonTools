#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_VideoInfo.py
@author:    ziv
@time:      2019/12/21
@version:   v1.0.0
@desc:      视频文件信息
"""

import requests
from lxml import etree

# HOST = "https://www.dadatutu.com/gc/qingyunian/play-0-33.html"
HOST = "https://www.dadatutu.com/"
RULE_PAGE = '//div[@id="playlist"][1]//div[1]//a/@href'
RULE_TITLE = '//div[@id="playlist"][1]//div[1]//a/text()'
RULE_SRC = '//td[@id="playleft"]//iframe/@src'

headers = {
    "User-Agent":"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36"
}

start_url = HOST + "gc/qingyunian/play-0-36.html"

response = requests.get(start_url, headers=headers)
response.encoding = "utf-8"
# print(response.text)
html = etree.HTML(response.text)
page_url = html.xpath(RULE_PAGE)
title = html.xpath(RULE_TITLE)
# print(title, page_url)

# assert len(title) == len(page_url)

with open("url_list.txt", "w+") as file:
    for index in range(len(title)):
        item = "%s\t%s\n" % (title[index], HOST + page_url[index])
        print(item)
        file.write(item)
