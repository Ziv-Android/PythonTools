#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@file:      StatisticAnalysis.py
@author:    ziv-peng
@time:      18-6-19
@desc:      
"""

import requests
import re
import csv

base_url = "http://logcat1.video.51togic.com/logs/"
separator_url = "/"
search_url = "?search="
d = {}


def url_maker(start_url, *params):
    """创建组合需要请求的Url"""
    end_url = ""
    for p in params:
        end_url = end_url + p
        print(p)

    if len(params) < 2:
        end_url = end_url + search_url

    return start_url + end_url


def get_page_info(page_url):
    """获取Url内容信息"""
    response = requests.get(page_url).content
    response = response.decode("utf-8")
    return re.findall(r'"(.*?)"', response, re.S)


def save_data(data):
    csvfile = open("data.csv", "w")
    writer = csv.writer(csvfile)
    writer.writerows(data)
    csvfile.close()


if __name__ == "__main__":
    url = url_maker(base_url)
    day_list = sorted(get_page_info(url))
    for day_url in day_list:
        day_url = url_maker(base_url, day_url)
        file_list = get_page_info(day_url)
        for file_name in file_list:
            model = file_name.split("~")[0]
            if model.endswith(".txt"):
                fault_tolerant = re.split(r'(.*?)([\_,\?*?,\s*?]\w*?\.\d\.*?\d*?[\_,\-,\s*?])', model, re.S)
                if not len(fault_tolerant) <= 1:
                    model = fault_tolerant[1]
            d[model] = d.get(model, 0) + 1

    date = sorted(d.items(), key=lambda item: item[1])
    print(date)
    save_data(date)
