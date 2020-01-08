#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_Download.py
@author:    ziv
@time:      2019/12/20
@version:   v1.0.0
@desc:      视频文件下载
"""

import m3u8
import datetime
import requests

# https://youku.cdn4-okzy.com/20191219/3450_c47f76f5/index.m3u8
base_url = "https://youku.cdn1-okzy.com/20191219/10651_d484578e/index.m3u8"


def download_task(start_url, filename):
    start_time = datetime.datetime.now().replace(microsecond=0)
    result = m3u8.load(start_url, verify_ssl=False)
    # print(result.data)
    next_url = '%s%s' % (result.base_uri, result.data['playlists'][0]['uri'])
    result = m3u8.load(next_url, verify_ssl=False)
    temp_time = datetime.datetime.now().replace(microsecond=0)
    print("%s 解析耗时：%s" % (filename, (temp_time - start_time)))
    # print(result.data)
    total = len(result.data['segments']) + 1
    index = 0

    with open('QingYuNian/' + filename, 'ab+') as wf:
        for segment in result.data['segments']:
            index = index + 1
            ts_name = segment['uri']
            ts_url = '%s%s' % (result.base_uri, ts_name)
            print(ts_url)
            ts_start_time = datetime.datetime.now().replace(microsecond=0)
            try:
                response = requests.get(ts_url, stream=True, verify=False)
            except Exception as e:
                print("请求异常：%s" % e.args)
                continue

            for chunk in response.iter_content(chunk_size=1024):
                if chunk:
                    wf.write(chunk)

            ts_end_time = datetime.datetime.now().replace(microsecond=0)
            print("(%d/%d)耗时：%s" % (index, total, (ts_end_time - ts_start_time)))

    end_time = datetime.datetime.now().replace(microsecond=0)
    print("%s 下载耗时：%s" % (filename, (end_time - start_time)))


if __name__ == "__main__":
    with open('url_src.txt', 'r') as rf:
        lines = rf.readlines()
        for i in range(45, len(lines)):
            src_list = lines[i].split('\t')
            title = src_list[0].strip()
            url = src_list[1].strip()
            src = src_list[2].strip()
            print(title, src)
            download_task(src, title + ".ts")
