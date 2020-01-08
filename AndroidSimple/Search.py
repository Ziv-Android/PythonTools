#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_Search.py
@author:    ziv
@time:      2019-07-01
@version:   v1.0.0
@desc:      脚本功能描述
"""

from bs4 import BeautifulSoup
from lxml import etree

test = '''
<div class="sample-card card-info">
<div class="section">
<span class="sample-languages googlesamples-filter" filter-name="language">
                      java
                    </span><span class="sample-technologies googlesamples-filter" filter-name="technology">
</span>
</div>
<div class="sample-title-area title">
<span class="sample-title">AppShortcuts</span>
</div>
<div class="sample-description-area">
<p class="text">此示例演示了如何使用 Android 7.1 (API 25) 中引入的启动器快捷方式 API。借助此
                                                        API，应用可以定义一组 intent；当用户长按应用的启动器图标时，系统便会显示这些 intent。我们分别提供了关于在
                                                        XML 中静态注册链接以及在运行时动态注册链接的示例。</p>
</div>
</div>
'''

html_doc = ''
result = {}

f = open('data/samples.html')

html_doc = html_doc.join(f.readlines())

soup = BeautifulSoup(html_doc, 'html.parser')
# print(soup.find_all(class_="card-info"))

for item in soup.find_all(class_="card-featured"):
    html = etree.HTML(item.prettify())
    # html = etree.HTML(item.stripped_strings)
    key = html.xpath('//span[@class="sample-title"]/text()')
    key = key[0].replace('\n', '').replace(' ', '')
    # print(type(key), len(key), key[0].strip())
    value = html.xpath('//div[@class="sample-description-area"]/p/text()')
    value = value[0].replace('\n', '').replace(' ', '')
    # print(type(value), len(value), value[0].replace('\n', '').replace(' ', ''))
    link = html.xpath('//a/@href')
    print(link)
    result[key] = value

print(result)

# print(result['AppRestrictionEnforcer'])

# f = open('result/ans.md')
# ans = open('result/answer.txt', 'w')
#
# for line in f.readlines():
#     # print(line)
#     key = line.replace('#', '').strip()
#
#     try:
#         ans.write(line)
#         if len(key) > 0:
#             txt = result['{}'.format(key)]
#             print(txt)
#             ans.write(txt)
#             ans.write('\n')
#     except:
#         ans.write('查找错误，手动检查')
#         ans.write('\n\n\n')
#         print('error')
#
# ans.flush()
# ans.close()
