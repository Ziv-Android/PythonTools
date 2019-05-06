#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@file:      requestData.py
@author:    ziv-peng
@time:      18-6-13
@desc:      通过get方法简单获取数据
"""

import requests
import httplib2
import urllib.request
import urllib3
import Utils.FileUtil as filteUtil

url = "https://www.baidu.com/s"
param = {"wd": "python"}
# # Request
# response = requests.get(url=url, params=data)
# content = requests.get(url).content
# print("response headers:", response.headers)
# print("content:", content)
#
# # Httplib2
# http = httplib2.Http()
# response_headers, content2 = http.request(url, "GET")
# print("response headers:", response_headers)
# print("content:", content2)

http = urllib3.PoolManager()
r = http.request('GET', url, fields=param)
date = r.data.decode()
print(date)
print(r.status)
filteUtil.get_file_modify_time()