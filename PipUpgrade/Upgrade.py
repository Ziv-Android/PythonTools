#!/usr/bin/env python3
# -*- coding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@file:      Upgrade.py
@author:    ziv-peng
@time:      18-10-15
@desc:      升级更新python通过pip安装的模块
@version:   0.2
"""

import os

p = os.popen("sudo pip3 list --outdated")
x = p.read()
print(x)
