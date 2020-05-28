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

# HOST = "https://www.jlszyy.cc"
# HOST = "https://v.dadatutv.com"
# HOST = "https://vip.smtu.cc"
HOST = "https://vip2.smtu.cc"

headers = {
    "User-Agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36"
}

result = requests.get(HOST, headers=headers)
fileName = "%s_HomePage.html" % HOST
fileName = fileName.split("https://")[1]
print(fileName)
with open(fileName, "w") as wf:
    page = result.content.decode("utf-8")
    print(page)
    wf.write(page)


