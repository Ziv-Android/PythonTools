#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@file:      start.py.py
@author:    ziv-peng
@time:      18-7-24
@desc:      ScrapyDemo启动文件
"""

from scrapy import cmdline

cmdline.execute('scrapy crawl DemoSpider'.split())
