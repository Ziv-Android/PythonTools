#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_DetailPage.py
@author:    ziv
@time:      2020/4/1
@version:   v1.0.0
@desc:      脚本功能描述
"""

import requests
from lxml import etree

host = 'https://www.hkstp.org'

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36'
}

rule_detail_info_type = '//div[@class="info-list"]/span/text()'
rule_detail_info_value = '//div[@class="info-list"]/p/text()|//div[@class="info-list"]/p/a/text()'

excel_titles = ['机构名称-中文', '机构名称-英文', '所属园区', '行业分类', '行业二级分类', '简介', '产品', '网址', '地址', '资助/融资情况', '联系人', '联系电话', '电子邮件', '关键人姓名']
excel_detail_line = 0

title_url = host + '/zh-cn/directory-list/Details/acaderma-asia-limited'

response = requests.get(url=title_url, headers=headers)
result = response.content.decode(response.encoding)
root = etree.HTML(result)
detail_type_list = root.xpath(rule_detail_info_type)
# print(detail_type_list)
detail_value_list = root.xpath(rule_detail_info_value)
# print(detail_value_list)
for i in range(len(detail_value_list)):
    print(detail_type_list[i], ''.join(detail_value_list[i].split()))
#     print(detail_type_list[i], ''.join(detail_value_list[i].split()))
# detail_dict = dict(zip(detail_type_list, detail_value_list))
# print(detail_dict)
# for detail in range(len(detail_dict)):
#     # print(detail)
#     if detail_type_list[detail] not in excel_titles:
#         excel_titles.append(detail_type_list[detail])
#     detail_index = excel_titles.index(detail_type_list[detail])
#     print(excel_detail_line, detail_index, detail_value_list[detail])
