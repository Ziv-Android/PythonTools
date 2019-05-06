#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_SimpleOperation.py
@author:    ziv
@time:      19-1-9
@version:   v1.0.0
@desc:      脚本功能描述
"""


import tensorflow as tf

# 1*2常量矩阵op
matrix1 = tf.constant([[3., 3.]])
# 2*1常量矩阵op
matrix2 = tf.constant([[2.], [2.]])

# matmul矩阵乘法op
product = tf.matmul(matrix1, matrix2)

# 会话session启动
sess = tf.Session(config=tf.ConfigProto(log_device_placement=True))
result = sess.run(product)
print(result)

# 任务完成关闭会话
sess.close()
