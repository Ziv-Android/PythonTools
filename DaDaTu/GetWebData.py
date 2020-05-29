#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_GetWebData.py
@author:    ziv
@time:      2020/5/22
@version:   v1.0.0
@desc:      脚本功能描述
"""

import requests
from bs4 import BeautifulSoup

headers = {
    "User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36"
}

RULE_HREF = '/@href'
RULE_TEXT = '/@text'
RULE_SRC = '/@src'
RULE_ACTION = '/@action'

HOST = "https://www.jlszyy.cc"
# 导航分类
RULE_NAV = '//div//h2//a'
# 搜索
RULE_SEARCH = '//*[@id="search"]'
# 今日更新
# NEW = "https://www.jlszyy.cc/new.html"
RULE_SUGGEST_1 = '//*[@id="con_latest_1"]//li/a'
# 海报
RULE_SUGGEST_1 = '//*[@id="con_latest_1"]//li/a/img' + RULE_SRC
# 主演
RULE_SUGGEST_1 = '//*[@id="con_latest_1"]//li/p'
# 节目
RULE_SUGGEST_1 = '//*[@id="con_latest_1"]//li/h4'

RULE_SUGGEST_2 = '//*[@id="con_latest_2"]//li/a'
RULE_SUGGEST_3 = '//*[@id="con_latest_3"]//li/a'
RULE_SUGGEST_4 = '//*[@id="con_latest_4"]//li/a'
RULE_SUGGEST_5 = '//*[@id="con_latest_5"]//li/a'


# HOST = "https://m.jlszyy.cc"
# HOST = "https://v.dadatutv.com"
# HOST = "https://vip.smtu.cc"
# HOST = "https://vip2.smtu.cc"


def request_web_data():
    result = requests.get(HOST, headers=headers)
    file_name = "%s_HomePage.html" % HOST
    file_name = file_name.split("https://")[1]
    print(file_name)
    with open(file_name, "w") as wf:
        page = result.content.decode("utf-8")
        print(page)
        wf.write(page)


def parse_local_data(file_name):
    soup = BeautifulSoup(open(file_name), "html.parser")
    # print(soup.title)
    # print(soup.div.find_all('a'))
    print(soup.find_all())


if __name__ == "__main__":
    # request_web_data()
    parse_local_data("HomePage.html")
