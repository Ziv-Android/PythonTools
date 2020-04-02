#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_ImageResize.py
@author:    ziv
@time:      2020/3/14
@version:   v1.0.0
@desc:      图片尺寸修改
"""
from PIL import Image

source = "news_icon.png"
crop_big_size = (108, 108)
result_big_name = "news_big.png"

crop_small_size = (28, 28)
result_small_name = "news_small.png"

pic = Image.open(source)
pic_big = pic.resize(crop_big_size, Image.ANTIALIAS)
pic_small = pic.resize(crop_small_size, Image.ANTIALIAS)
pic_big.save(result_big_name)
pic_small.save(result_small_name)

