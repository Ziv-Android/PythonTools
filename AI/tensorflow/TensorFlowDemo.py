#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_TensorFlowDemo.py
@author:    ziv
@time:      19-1-7
@version:   v1.0.0
@desc:      TensorFlow环境测试
"""


import tensorflow as tf
import numpy as np

# 随机生成100个点的模拟数据
x_data = np.float32(np.random.rand(2, 100))
y_data = np.dot([0.100, 0.200], x_data) + 0.300

# 构造一个线性模型
b = tf.Variable(tf.zeros([1]))
w = tf.Variable(tf.random_uniform([1, 2], -1.0, 1.0))
y = tf.matmul(w, x_data) + b

# 最小化方差
loss = tf.reduce_mean(tf.square(y - y_data))
optimizer = tf.train.GradientDescentOptimizer(0.5)
train = optimizer.minimize(loss)

# 初始化变量
init = tf.global_variables_initializer()

# 启动图
sess = tf.Session()
# sess = tf.InteractiveSession()
sess.run(init)

# 拟合平面
for step in range(0, 201):
    sess.run(train)
    if step % 20 == 0:
        print(step, sess.run(w), sess.run(b))

# 得到最佳拟合结果 w: [[0.100, 0.200]], b: [0.300]
# 准备数据 -> 设置模型 -> 设置损失函数loss和优化方式 -> 真实训练运算(训练集) -> 验证结果(测试集)
