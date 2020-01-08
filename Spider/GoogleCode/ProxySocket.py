#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_ProxySocket.py
@author:    ziv
@time:      2019/9/17
@version:   v1.0.0
@desc:      脚本功能描述
"""

import urllib.request as request
from sockshandler import SocksiPyHandler
import socks # $ pip install PySocks
import requests
from scrapy import Request
import socket

host = '192.168.6.5'
port = 1080
proxy = host + ':' + str(port)

proxies_http = {
    'https': 'http://' + proxy,
    'http': 'http://' + proxy
}

proxies_socks5 = {
    'https': 'socks5://' + proxy,
    'http': 'socks5://' + proxy
}

headers = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36'
}

youtube_url = "http://www.youtube.com/"
HOST = "https://android.googlesource.com"
scripts_url = HOST + "/platform/development/+/master/scripts/"

URLLIB_SOCKS5 = True
REQUESTS_SOCKS5 = True
SCRAPY_HTTP = True
PYSOCKS_SOCKS5 = True
# 请求失败的策略
URLLIB_HTTP = False
REQUESTS_HTTP = False

if URLLIB_HTTP:
    print('--------使用urllib-ProxyHandler- HTTP代理-----')
    try:
        opener = request.build_opener(request.ProxyHandler(proxies_http))
        request.install_opener(opener)

        req = request.Request(youtube_url, headers=headers)
        response = request.urlopen(req, timeout=20)

        print(response.read().decode())
    except Exception as e:
        print('-------使用urllib-ProxyHandler-Failed-------')
        print(e)

if URLLIB_SOCKS5:
    print('-------使用urllib-SocksiPyHandler-socks5代理-----')
    try:
        opener = request.build_opener(SocksiPyHandler(socks.SOCKS5, host, port))
        request.install_opener(opener)

        req = request.Request(youtube_url, headers=headers)
        response = request.urlopen(req, timeout=20)

        print(response.read().decode())
    except Exception as e:
        print('-------使用urllib-SocksiPyHandler-Failed-------')
        print(e)

if REQUESTS_HTTP:
    print('--------使用requests-HTTP代理-------')
    try:
        result = requests.get("http://www.youtube.com/", proxies=proxies_http, verify=False, timeout=20)
        print(result.text)
    except Exception as e:
        print('-------使用requests-HTTP-Failed-------')
        print(e)

if REQUESTS_SOCKS5:
    print('--------使用requests-socks5代理-------')
    try:
        result = requests.get("http://www.youtube.com/", proxies=proxies_socks5, verify=False, timeout=20)
        print(result.text)
    except Exception as e:
        print('-------使用requests-socks5-Failed-------')
        print(e)

if SCRAPY_HTTP:
    print('--------使用Scrapy-http代理-------')
    try:
        r = Request(youtube_url, meta={'proxy': proxies_http['http']})
        # fetch(r)
    except Exception as e:
        print('-------使用Scrapy-http-Failed-------')
        print(e)

if PYSOCKS_SOCKS5:
    print('--------使用PySocks-socks5代理-------')
    try:
        socks.set_default_proxy(socks.SOCKS5, host, port=port)
        socket.socket = socks.socksocket

        response = request.urlopen(youtube_url, timeout=20)
        print(response.read().decode('utf-8'))
    except Exception as e:
        print('-------使用PySocks-socks5-Failed-------')
        print(e)
