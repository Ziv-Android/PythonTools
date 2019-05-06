#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_InteractiveSessionDemo.py
@author:    ziv
@time:      19-1-10
@version:   v1.0.0
@desc:      交互式使用
"""


import tensorflow as tf

# 交互式会话
my_sess = tf.InteractiveSession()

x = tf.Variable([1.0, 2.0])
a = tf.constant([3.0, 3.0])

# 初始化
x.initializer.run()

add_value = tf.add(x, a)
print(add_value.eval())
update = tf.assign(x, add_value)
print(update.eval())

# 创建一个变量并初始化为标量 0
state = tf.Variable(0, name="counter")

one = tf.constant(1)
new_value = tf.add(state, one)
update = tf.assign(state, new_value)

init = tf.initialize_all_variables()

with tf.Session() as _sess:
    _sess.run(init)
    print(_sess.run(state))
    for _ in range(3):
        _sess.run(update)
        print(_sess.run(state))

input1 = tf.constant(3.0)
input2 = tf.constant(2.0)
input3 = tf.constant(5.0)
intermed = tf.add(input2, input3)
mul = tf.multiply(input1, intermed)

with tf.Session() as sess:
    result = sess.run([mul, intermed])
    print(result)

input4 = tf.placeholder(tf.float32)
input5 = tf.placeholder(tf.float32)

output = tf.add(input4, input5)

with tf.Session() as sess:
    print(sess.run([output], feed_dict={input4: [7.], input5:[2.]}))
