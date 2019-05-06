#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_QueueDemo.py
@author:    ziv
@time:      18-12-17
@version:   v1.0.0
@desc:      队列
"""


import queue
import threading

q = queue.Queue


def worker():
    while True:
        item = q.get()
        do_work(item)
        q.task_done()


for i in range(num_worker_thread):
    t = Th