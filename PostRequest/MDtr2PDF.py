#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_MDtr2PDF.py
@author:    ziv
@time:      18-12-27
@version:   v1.0.0
@desc:      MarkDown文件转PDF
"""


from urllib import parse
import requests
import Utils.TimeUtil as timeu
import Utils.FileUtil as fileu
import os


headers = {
    'Referer': 'http://www.mdtr2pdf.com/index.html',
    'Content-Length': '',
    'Content-Type': 'multipart/form-data',
    'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36'
}


HOST = "http://www.mdtr2pdf.com/upload?"
values = {'d': str(timeu.get_time_stamp()), 'm': '1'}
data = parse.urlencode(values)
url = HOST + data
print(url)
request = requests.post(url, headers=headers)
# print(request.)
# fsize = fileu.get_file_size("README.md")
# fsize = os.path.getsize("README.md")
# print(fsize)
print(round(3.64))
