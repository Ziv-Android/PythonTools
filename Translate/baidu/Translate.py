#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_Translate.py
@author:    ziv
@time:      2019-06-28
@version:   v1.0.0
@desc:      使用百度翻译API翻译文本
"""

import requests
import hashlib
import urllib.parse
import random
import json

appid = '20190628000311366'
secretKey = 'lIwbdyC2EUNLfRRQbc6n'
host = 'http://api.fanyi.baidu.com'
myurl = '/api/trans/vip/translate'
q = 'frequent'
fromLang = 'en'
toLang = 'zh'
salt = random.randint(32768, 65536)

sign = appid + q + str(salt) + secretKey
sign = hashlib.md5(sign.encode('utf-8')).hexdigest()

myurl = myurl + '?appid=' + appid + '&q=' + urllib.parse.quote(q) + '&from=' + fromLang + '&to=' + toLang + '&salt=' + str(salt) + '&sign=' + sign


response = requests.get(host + myurl)
print(response.text)

# json_msg = r'{"from":"en","to":"zh","trans_result":[{"src":"apple","dst":"\u82f9\u679c"}]}'
# result = json.loads(json_msg)

result = json.loads(response.text)
print(result['trans_result'][0]['dst'])
