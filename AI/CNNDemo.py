#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_CNNDemo.py
@author:    ziv
@time:      19-1-23
@version:   v1.0.0
@desc:      CNN卷积神经网络学习Demo
"""

from tensorflow.examples.tutorials.mnist import input_data
import tensorflow as tf


def weight_variable(shape):
    # 产生随机变量
    # truncated_normal：选取位于正态分布均值=0.1附近的随机值，如果随机数偏离均值超过2个标准差，就重新随机
    # random_normal：正态分布
    # random_uniform：平均分布
    # random_gamma：gamma分布
    initial = tf.truncated_normal(shape, stddev=0.1)
    return tf.Variable(initial)


def bias_variable(shape):
    # 偏置项常量定义
    initial = tf.constant(0.1, shape=shape)
    return tf.Variable(initial)


def conv2d(x, W):
    # stride = [1,水平移动步长,竖直移动步长,1]
    # 输入x是图片信息矩阵，W是卷积核的值
    # padding的可选参数为“VALID”和“SAME”
    # VALID不用0来填充边界，新图像尺寸大小 = 原数据尺寸大小-卷积核尺寸大小+1
    # SAME边界补0，新图像尺寸大小 = 原数据尺寸大小
    return tf.nn.conv2d(x, W, strides=[1, 1, 1, 1], padding='SAME')


def max_pool_2x2(x):
    # stride = [1,水平移动步长,竖直移动步长,1]
    return tf.nn.max_pool(x, ksize=[1, 2, 2, 1],
                          strides=[1, 2, 2, 1], padding='SAME')


# 读取MNIST数据集
mnist = input_data.read_data_sets('./input_data', one_hot=True)
sess = tf.InteractiveSession()

# 预定义输入值X、输出真实值Y    placeholder为占位符
# 748 = 28*28
x = tf.placeholder(tf.float32, shape=[None, 784])
y_ = tf.placeholder(tf.float32, shape=[None, 10])
# keep_prob 是为了减小过拟合现象。每次只让部分神经元参与工作使权重得到调整。只有当keep_prob = 1时，才是所有的神经元都参与工作
keep_prob = tf.placeholder(tf.float32)
x_image = tf.reshape(x, [-1, 28, 28, 1])
# print(x_image.shape)  #[n_samples,28,28,1]

# 卷积层1网络结构定义
# 卷积核1：patch=5×5;in size 1;out size 32;激活函数reLU非线性处理
W_conv1 = weight_variable([5, 5, 1, 32])
b_conv1 = bias_variable([32])
# output size 28*28*32
h_conv1 = tf.nn.relu(conv2d(x_image, W_conv1) + b_conv1)
# output size 14*14*32
h_pool1 = max_pool_2x2(h_conv1)

# 卷积层2网络结构定义
# 卷积核2：patch=5×5;in size 32;out size 64;激活函数reLU非线性处理
W_conv2 = weight_variable([5, 5, 32, 64])
b_conv2 = bias_variable([64])
h_conv2 = tf.nn.relu(conv2d(h_pool1, W_conv2) + b_conv2)  # output size 14*14*64
h_pool2 = max_pool_2x2(h_conv2)  # output size 7 *7 *64

# 全连接层1
W_fc1 = weight_variable([7 * 7 * 64, 1024])
b_fc1 = bias_variable([1024])
h_pool2_flat = tf.reshape(h_pool2, [-1, 7 * 7 * 64])  # [n_samples,7,7,64]->>[n_samples,7*7*64]
h_fc1 = tf.nn.relu(tf.matmul(h_pool2_flat, W_fc1) + b_fc1)
h_fc1_drop = tf.nn.dropout(h_fc1, keep_prob)  # 减少计算量dropout

# 全连接层2
# 全连接层2有10个神经元，相当于生成的分类器，预测值存入prediction中
W_fc2 = weight_variable([1024, 10])
b_fc2 = bias_variable([10])
prediction = tf.matmul(h_fc1_drop, W_fc2) + b_fc2
# prediction = tf.nn.softmax(tf.matmul(h_fc1_drop, W_fc2) + b_fc2)

# 二次代价函数:预测值与真实值的误差
loss = tf.reduce_mean(tf.nn.softmax_cross_entropy_with_logits_v2(labels=y_, logits=prediction))
# 梯度下降法:数据太庞大,选用AdamOptimizer优化器
train_step = tf.train.AdamOptimizer(1e-4).minimize(loss)
# 结果存放在一个布尔型列表中
correct_prediction = tf.equal(tf.argmax(prediction, 1), tf.argmax(y_, 1))
# 求准确率
accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))

saver = tf.train.Saver()  # defaults to saving all variables
sess.run(tf.global_variables_initializer())

for i in range(1000):
    batch = mnist.train.next_batch(50)
    if i % 100 == 0:
        train_accuracy = accuracy.eval(feed_dict={x: batch[0], y_: batch[1], keep_prob: 1.0})
        print("step", i, "training accuracy", train_accuracy)
    train_step.run(feed_dict={x: batch[0], y_: batch[1], keep_prob: 0.5})


# 保存模型参数
saver.save(sess, './model.ckpt')
print("test accuracy %g"%accuracy.eval(feed_dict={x: mnist.test.images, y_: mnist.test.labels, keep_prob: 1.0}))
