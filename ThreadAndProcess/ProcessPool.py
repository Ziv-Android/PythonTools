#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_ProcessPool.py
@author:    ziv
@time:      2020/5/15
@version:   v1.0.0
@desc:      多进程试用, 进程池实现, 适用与提升CPU密集型任务性能, 如科学计算, 机器学习
"""

from multiprocessing import Process, Queue, Pipe, Pool
import time


def show(name):
    print("Process name is", name)


class MyProcess(Process):
    def __init__(self, name, queue):
        super(MyProcess, self).__init__()
        self.name = name
        self.queue = queue

    def run(self):
        show(self.name)
        time.sleep(1)
        result = "Queue", self.name, time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())
        self.queue.put(result)


if __name__ == "__main__":
    my_queue = Queue()
    proc = Process(target=show, args=('ziv', ))
    proc.start()
    # 在当前位置阻塞主进程，等待执行join()的进程结束后再继续执行主进程
    proc.join()
    for i in range(3):
        p = MyProcess(str(i), my_queue)
        p.start()

    for i in range(3):
        print(my_queue.get())

    pool = Pool(processes=2)
    for i in range(6):
        # 维持执行的进程总数为processes，当一个进程执行完毕后会添加新的进程进去
        pool.apply_async(show, args=(i, ))
    print('======  apply_async  ======')
    pool.close()
    # 调用join之前，先调用close函数，否则会出错。执行完close后不会有新的进程加入到pool,join函数等待所有子进程结束
    pool.join()

