#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_Lines.py
@author:    ziv
@time:      2019-06-27
@version:   v1.0.0
@desc:      逐行翻译
"""

# https://translate.google.cn/#view=home&op=translate&sl=en&tl=zh-CN&text=admin

import urllib.request
import ssl

headers = {"user_agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36"}
url = "https://translate.google.cn/#view=home&op=translate&sl=en&tl=zh-CN&text=admin"

ssl._create_default_https_context = ssl._create_unverified_context
req = urllib.request.Request(url=url, headers=headers)

ans = urllib.request.urlopen(req).read()

print(ans)
