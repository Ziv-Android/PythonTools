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
import time


def translate(keyword):
    appid = '20190628000311366'
    secretKey = 'lIwbdyC2EUNLfRRQbc6n'
    host = 'http://api.fanyi.baidu.com'
    myurl = '/api/trans/vip/translate'
    # q = r'未知错误'
    q = keyword
    fromLang = 'zh'
    toLang = 'en'
    salt = random.randint(32768, 65536)

    sign = appid + q + str(salt) + secretKey
    sign = hashlib.md5(sign.encode('utf-8')).hexdigest()

    myurl = myurl + '?appid=' + appid + '&q=' + urllib.parse.quote(
        q) + '&from=' + fromLang + '&to=' + toLang + '&salt=' + str(salt) + '&sign=' + sign

    request_url = host + myurl
    print("translate_url:", request_url)
    response = requests.get(request_url)
    print(response.text)

    # json_msg = r'{"from":"en","to":"zh","trans_result":[{"src":"apple","dst":"\u82f9\u679c"}]}'
    # result = json.loads(json_msg)

    result = json.loads(response.text)
    print(result['trans_result'][0]['dst'])
    # 54003 调用频率过高
    time.sleep(0.5)
    return result['trans_result'][0]['dst']

