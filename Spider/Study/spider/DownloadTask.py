#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_DownloadTask.py
@author:    ziv
@time:      18-12-12
@version:   v1.0.0
@desc:      脚本功能描述
"""

import threading
import queue

threadList = ["Thread-1", "Thread-2", "Thread-3"]
queueLock = threading.Lock()
workQueue = queue.Queue(10)
threads = []

exitFlag = 0


def downloadTask(taskList):
    threadID = 1

    # 创建新线程
    for threadName in threadList:
        thread = DownloadThread(threadID, threadName, workQueue)
        thread.start()
        threads.append(thread)
        threadID += 1

    # 填充队列
    queueLock.acquire()
    for word in taskList:
        workQueue.put(word)
    queueLock.release()

    # 等待队列清空
    while not workQueue.empty():
        pass

    # 通知线程是时候退出
    exitFlag = 1

    # 等待所有线程完成
    for t in threads:
        t.join()


class DownloadThread(threading.Thread):
    def __init__(self, thread_id, thread_name, thread_q):
        threading.Thread.__init__(self)
        self.thread_id = thread_id
        self.thread_name = thread_name
        self.thread_q = thread_q

    def run(self):
        print("开启线程：" + self.name)
        process_data(self.name, self.q)
        print("退出线程：" + self.name)


def process_data(threadName, q):
    while not exitFlag:
        queueLock.acquire()
        if not workQueue.empty():
            data = q.get()
            queueLock.release()
            print("%s processing %s" % (threadName, data))

        else:
            queueLock.release()
