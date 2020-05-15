#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_Threads.py
@author:    ziv
@time:      2020/5/15
@version:   v1.0.0
@desc:      多线程演示, 适用与提升IO密集型任务性能, 如爬虫
            多线程和多进程最大的不同在于，多进程中，同一个变量，各自有一份拷贝存在于每个进程中，互不影响，
            而多线程中，所有变量都由所有线程共享，所以，任何一个变量都可以被任何一个线程修改，
            因此，线程之间共享数据最大的危险在于多个线程同时改一个变量，把内容给改乱了。
"""

import threading
from multiprocessing.pool import ThreadPool
from concurrent.futures import ThreadPoolExecutor
import time

lock = threading.Lock()


def show():
    print('thread %s is running...' % threading.current_thread().name)


if __name__ == "__main__":
    show()
    for i in range(10):
        lock.acquire()
        try:
            t = threading.Thread(target=show, name='NewThread')
            t.start()
            t.join()
        finally:
            lock.release()

    # 线程池
    pool = ThreadPool(2)
    ThreadPoolExecutor