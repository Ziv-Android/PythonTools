#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_PrivateRequest.py
@author:    ziv
@time:      18-11-28
@version:   v1.0.0
@desc:      使用requests爬取数据至video_list.txt文件，接下来使用shell命令wget下载文件
"""

import os
import requests
from lxml import etree
import threading
import queue
import wget
import time
import random
import Utils.FileUtil as fileutil
import Utils.ThreadUtil as myThreads

HOST = "https://www.quxx87.com"
RULE_ITEM = "//li/a[@class='list-tu']/@href"
RULE_VIDEO = "//video/source/@src"
RULE_TITLE = "//div[@class='info-bt']/h1/text()"

headers = {
    "User-Agent":"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36"
}

targetDir = r"video"
exitFlag = 0
threadList = ["Thread-1", "Thread-2", "Thread-3", "Thread-4", "Thread-5"]
queueLock = threading.Lock()
# 创建一个大小不限的队列
workQueue = queue.Queue()
threads = []

# test_url = "http://www.haoxx25.com/?301"
# response = requests.get(test_url, headers=headers)
# response.encoding = "utf-8"
# html = etree.HTML(response.text)
# result = html.xpath(RULE_TITLE)
# print(result)


class myThread(threading.Thread):
    def __init__(self, threadID, name, q):
        threading.Thread.__init__(self)
        self.threadID = threadID
        self.name = name
        self.q = q

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
            # 实际执行下载的命令
            wget.download(data[0], out=destFile(data[1]))
        else:
            queueLock.release()
        st = random.randint(3, 9)
        time.sleep(st)
        print("Sleep time is " + str(st))


def destFile(path):
    if not os.path.isdir(targetDir):
        os.makedirs(targetDir, exist_ok=True)

    t = os.path.join(targetDir, path)
    print("fileName =", t+".mp4")
    return t+".mp4"


def getKeyData(target_url, url_rule, title_rule):
    print("get: " + target_url)
    response = requests.get(target_url, headers=headers)
    response.encoding = "utf-8"
    html = etree.HTML(response.text)
    result = html.xpath(url_rule)
    if title_rule is not None:
        title_result = html.xpath(title_rule)
        result = (result[0], title_result[0])
    return result


def saveToFile(file_name, s):
    with open(file_name, "w+") as fp:
        for content in s:
            fp.write("%s\t%s\n" % (content[0], content[1]))


def downloadFile():
    '''
    使用shell命令wget批量下载文件
    缺陷：无法在下载后就对对应文件重命名
    '''
    os.system("cat video_list_old.txt | awk {'print$1'} > temp.txt")
    os.system("wget -P ./video -nv -i temp.txt")
    # os.system("ffmpeg -i https://1.abolezi.com/blz/100015053/index.m3u8 奶大风骚混血美女.mp4")
    os.system("rm -rf temp.txt")


def pythonDownloadFile(result):
    '''
    基本完成功能，但下载速度很慢，考虑多线程加速
    '''
    for content in result:
        print("get: " + content[0])
        wget.download(content[0], out=content[1]+'.mp4')


def pythonDownloadFileV2(result):
    '''
    下载文件2.0版，加入多线程下载
    '''
    threadID = 1
    # 创建线程
    for tName in threadList:
        thread = myThreads(threadID, tName, workQueue)
        thread.start()
        threads.append(thread)
        threadID += 1

    # 填充队列
    queueLock.acquire()
    for task in result_list:
        print("Put task in queue.")
        workQueue.put(task)
    queueLock.release()

    # 等待队列清空
    while not workQueue.empty():
        pass

    # 通知线程退出
    exitFlag = 1

    # 等待所有线程完成
    for t in threads:
        t.join()


if __name__ == '__main__':
    print("start")
    ftime = fileutil.get_file_modify_time("video_list.txt")
    print(ftime)
    start_url = HOST + "/?301"
    url_list = getKeyData(start_url, RULE_ITEM, None)
    result_list = []

    # # # for url in tqdm(url_list):
    for url in url_list:
        result_list.append(getKeyData(HOST + url, RULE_VIDEO, RULE_TITLE))

    print(result_list)
    saveToFile("video_list.txt", result_list)
    # lines = open("video_list.txt").readlines()
    # print(lines)
    # pythonDownloadFileV2(result_list)
    downloadFile()
    print("end")
