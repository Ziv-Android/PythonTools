#!/usr/bin/env python3
# coding:utf-8

import urllib.request
import re
import os

targetDir = r"pic"


def destFile(path):
    if not os.path.isdir(targetDir):
        os.mkdir(targetDir)
    path = path.replace('/', '_')
    t = os.path.join(targetDir, path)
    print("fileName =", t+".jpg")
    return t+".jpg"


if __name__ == "__main__":
#    cmd_clear_log = "adb logcat -c"
#    cmd_catch_msg = 'adb logcat | grep -i "image" > jiguang.log'
#    cmd_zip_file = 'zip -r pic.zip pic/'
#    os.system(cmd_clear_log)
#    p = os.system(cmd_catch_msg)
#    print(p)
    try:
        f = open('jiguang.log', 'r')
        for link, t in set(re.findall(r"(http://\w+.qpic.cn/([\w /]*))", str(f.read()))):
            print(link)
            link_test = str(link).replace('408230', '854480')
            print("replace", link_test)
            try:
                # destFile(t)
                urllib.request.urlretrieve(link_test, destFile(t))
            except:
                print('Error:', link)
 
    finally:
        if f:
            f.close()
