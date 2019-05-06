#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@file:      start.py
@author:    ziv-peng
@time:      18-8-3
@desc:      
"""

from scrapy import cmdline

cmdline.execute('scrapy crawl zhipinSpider -o zhiwei.json'.split())
# cmdline.execute('scrapy crawl zhipinSpider'.split())
