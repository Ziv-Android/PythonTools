#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_SoftmaxDemo.py
@author:    ziv
@time:      19-1-7
@version:   v1.0.0
@desc:      手写数字识别MNIST
"""


from tensorflow.examples.tutorials.mnist import input_data
import tensorflow as tf

# 训练数据
mnist = input_data.read_data_sets("./input_data", one_hot=True)

# 占位符 placeholder,第二个参数 None 表示此张量的第一个维度可以是任何长度
x = tf.placeholder(tf.float32, [None, 784])
# Variable 代表一个可修改的张量, 一般用于计算输入值, 表示模型参数
w = tf.Variable(tf.zeros([784, 10]))
b = tf.Variable(tf.zeros([10]))
# 模型实现
y = tf.nn.softmax(tf.matmul(x, w) + b)

# loss函数——交叉熵
y_ = tf.placeholder(tf.float32, [None, 10])
cross_entropy = -tf.reduce_sum(y_*tf.log(y))

# 训练模型, Tensorflow自动实现反向传播算法, 从而优化算法达到loss最小
# GradientDescent: 梯度下降算法
train_step = tf.train.GradientDescentOptimizer(0.01).minimize(cross_entropy)

# 初始化变量
init = tf.global_variables_initializer()

# 启动模型
sess = tf.Session()
sess.run(init)

# 开始训练模型
for i in range(1000):
    batch_xs, batch_ys = mnist.train.next_batch(100)
    sess.run(train_step, feed_dict={x: batch_xs, y_:  batch_ys})

saver = tf.train.Saver()
save_path = saver.save(sess, "./temp/model.ckpt")
print("Model saved in path: %s" % save_path)

# 模型评估
correct_prediction = tf.equal(tf.argmax(y, 1), tf.argmax(y_, 1))
print(correct_prediction)
accuracy = tf.reduce_mean(tf.cast(correct_prediction, "float"))
print(sess.run(accuracy, feed_dict={x: mnist.test.images, y_: mnist.test.labels}))
