#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_DownLoadHLS.py
@author:    ziv
@time:      2019/12/20
@version:   v1.0.0
@desc:      脚本功能描述
"""

import m3u8

result = m3u8.load('https://youku.cdn1-okzy.com/20191219/10651_d484578e/index.m3u8')
next_url = '%s%s' % (result.base_uri, result.data['playlists'][0]['uri'])
print(next_url)
result = m3u8.load(next_url)
print(result.base_uri)
print(result.data)
