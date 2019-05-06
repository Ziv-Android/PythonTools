#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_ThreadUtil.py
@author:    ziv
@time:      18-12-18
@version:   v1.0.0
@desc:      脚本功能描述
"""


import threading


class ThreadUtil(threading.Thread):
    def __init__(self, thread_id, thread_name, task_queue):
        threading.Thread.__init__(self)
        self.thread_id = thread_id
        self.thread_name = thread_name
        self.task_queue = task_queue

    def run(self):
        print("开启线程：" + self.thread_name)
        process_data(self.thread_name, self.task_queue)
        print("退出线程：" + self.thread_name)


def process_data(thread_name, task_queue):
    print("执行线程任务")
