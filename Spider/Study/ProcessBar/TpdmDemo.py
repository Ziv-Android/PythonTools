#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@file:      TpdmDemo.py
@author:    ziv-peng
@time:      18-8-7
@desc:      
"""
import time

from tqdm import trange, tqdm

# pbar = tqdm(total=100)
# # 自动控制运行
# for i in trange(100):
#     time.sleep(0.01)
# pbar.close()
#
# text = ""
# for char in tqdm(["a", "b", "c", "d"]):
#     text = text + char
#     time.sleep(0.5)
#
# pbar = tqdm(["a", "b", "c", "d"])
# for char in pbar:
#     pbar.set_description("Processing %s" % char)

text = ""
for char in tqdm(["a", "b", "c", "d"]):
    time.sleep(1)
    text = text + char

# 手动控制运行
# tqdm.update()方法用于手动更新进度条
# with tqdm(total=100) as pbar:
#     for i in range(10):
#         pbar.update(6)

# pbar = tqdm(total=100)
# for i in range(10):
#     pbar.update(10)
# pbar.close()
