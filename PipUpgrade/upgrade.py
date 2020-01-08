#!/usr/bin/env python3
# -*- coding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@file:      upgrade.py
@author:    ziv-peng
@time:      18-5-31
@desc:      升级更新python通过pip安装的模块
"""

from subprocess import call
from pip._internal.utils.misc import get_installed_distributions

for dist in get_installed_distributions():
    # \033[显示方式;前景色;背景色m + 结尾部分：\033[0m
    print("  \033[1;32;40mStart upgrade:\033[0m " + dist.project_name)
    call("sudo pip install --upgrade -q " + dist.project_name, shell=True)

