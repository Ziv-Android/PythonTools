#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_LogAnasysis.py
@author:    ziv
@time:      2019/6/17
@version:   v1.0.0
@desc:      脚本功能描述
"""

import pymongo
from collections import Counter
# result = Counter(ip_list)

test_code = 0

item = {}

if test_code:
    line = r'112.38.201.46 - - - [17/Jun/2019:14:26:45 +0800]  "GET /api/api_config?package=com_togic_livevideo&version_code=118&version_name=4.1.7.2&model=HIMEDIA+HD600AII&os=4.2.2&mobile=false&vip_type=0&board=bigfish&device=HD600AII&product=HD600AII&brand=HIMEDIA&channel=togic&province=%E5%B1%B1%E4%B8%9C&city=%E8%81%8A%E5%9F%8E&isp=%E7%A7%BB%E5%8A%A8&device_id=4174000000920e009e460066ce015b7a0000000000000000 HTTP/1.1" 2461 "-" "-" 200 - 0.000s'
    msg = line.split(" ")
    print(msg[0], msg[8])
    item['ip'] = msg[0]
    url = msg[8].replace("?", "&")
    msg = url.split("&")
    for j in range(1, len(msg)):
        one = msg[j].split("=")
        if len(one) >= 2:
            print(one[0], one[1])
            item[one[0]] = one[1]
    print(item)
else:
    # client = MongoClient('mongodb://localhost:27017/')
    client = pymongo.MongoClient(host='localhost', port=27017)
    db = client['request']
    api_config = db['api_config']
    online_parameters = db['online_parameters']
    other = db['other']

    for line in open("data/access-out.log"):
        item.clear()
        print(line)
        msg = line.split(" ")
        item['ip'] = msg[0]
        url = msg[8].replace("?", "&")
        msg = url.split("&")
        for i in range(1, len(msg)):
            one = msg[i].split("=")
            if len(one) >= 2:
                item[one[0]] = one[1]

        print(item)
        if msg[0].endswith("api_config"):
            api_config.insert_one(item)
        elif msg[0].endswith("online_parameters"):
            online_parameters.insert_one(item)
        else:
            other.insert_one(item)
