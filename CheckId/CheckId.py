#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_CheckId.py
@author:    ziv
@time:      19-4-30
@version:   v1.0.0
@desc:      id参数查重
"""


from collections import defaultdict
import re

id_repeat = set()
id_list = []
# re.I 表示忽略大小写
pattern = re.compile(r'\d+', re.I)


def count(a):
    l = ([(x, a.count(x)) for x in set(a)])
    l.sort(key=lambda k:k[1], reverse=True)


def list_duplicates(seq):
    tally = defaultdict(list)
    for i, item in enumerate(seq):
        tally[item].append(i)
    return ((key, locs) for key, locs in tally.items() if len(locs) > 1)


def get_id(url):
    m = pattern.findall(url)
    return int(m[0])


def check():
    print(len(id_list))
    id_set = set(id_list)
    print(len(id_set))
    for i in range(0, len(id_list)):
        if id_list[i] in id_list[i + 1:]:
            id_repeat.add(id_list[i])

    print(id_repeat)

    for dup in sorted(list_duplicates(id_list)):
        print(dup)


def open_file():
    # fo = open("5_6_500.txt", "r")
    fo = open("4_28_500.txt", "r")
    for line in fo.readlines():
        line = line.strip()
        id_list.append(get_id(line))
    fo.close()


if __name__ == "__main__":
    open_file()
    check()
