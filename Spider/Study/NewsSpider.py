#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@file:      NewsSpider.py
@author:    ziv-peng
@time:      18-6-14
@desc:      爬取不需要登录的网页信息
"""

import os
import re
import requests
from lxml import etree


def save_string_list(save_path, filename, slist):
    if not os.path.exists(save_path):
        os.makedirs(save_path)
    path = save_path+"/"+filename+".txt"
    with open(path, "w+") as fp:
        for s in slist:
            fp.write("%s\t\t%s\n" % (s[0], s[1]))


def page_info(page):
    """Regex"""
    my_page_info = re.findall(
        r'<div class="titleBar" id=".*?><h2>(.*?)</h2><div class="more"><a href="(.*?)">.*?</a></div></div>',
        page, re.S)
    return my_page_info


def new_page_info(new_page):
    """Regex(slowly) or Xpath(fast)"""
    dom = etree.HTML(new_page)
    new_items = dom.xpath('//tr/td/a/text()')
    new_urls = dom.xpath('//tr/td/a/@href')
    # print("len new_items:", len(new_items))
    # print("len new_urls", len(new_urls))
    assert(len(new_items) == len(new_urls))
    return zip(new_items, new_urls)


def spider(url):
    """网易新闻抓取"""
    i = 0
    print("downloading:", url)
    response = requests.get(url)
    print(response.encoding)
    # decode 解码
    page = response.content.decode(response.encoding)
    page_results = page_info(page)
    print(page_results)
    save_path = u"网易新闻抓取"
    filename = str(i) + "_" + u"新闻排行榜"
    save_string_list(save_path, filename, page_results)
    i += 1
    for item, url in page_results:
        print("downloading:", url)
        new_page = requests.get(url).content.decode(response.encoding)
        new_page_results = new_page_info(new_page)
        filename = str(i) + "_" + item
        save_string_list(save_path, filename, new_page_results)
        i += 1


if __name__ == '__main__':
    print("start")
    start_url = "http://news.163.com/rank/"
    spider(start_url)
    print("end")
    print('°æÈ¨ËùÓÐ 2013 ¶«ÄÏ´óÑ§ÍøÂçÓëÐÅÏ¢ÖÐÐÄ'.encode('latin1').decode('gbk'))
    print(spider.__doc__)

"""
一级网页使用正则匹配，二级网页使用xpath解析

网络请求使用requests需注意
1. 官方中文文档：http://docs.python-requests.org/zh_CN/latest/user/quickstart.html
2. 若response.encoding检测不到正确编码，需要显示指定
3. 原始bytes数据在response.content中

各种流行的编程风格: https://coolshell.cn/articles/2058.html
"""