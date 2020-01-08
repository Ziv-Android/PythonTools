#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_TurtleDemo.py
@author:    ziv
@time:      2019/7/5
@version:   v1.0.0
@desc:      脚本功能描述
"""

import turtle

turtle.pensize(4)
turtle.pencolor('red')
for i in range(10):
    turtle.forward(100)
    turtle.right(90)

turtle.mainloop()
