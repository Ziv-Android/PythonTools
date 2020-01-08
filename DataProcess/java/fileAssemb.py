#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_fileAssemb.py
@author:    ziv
@time:      2019/11/27
@version:   v1.0.0
@desc:      脚本功能描述
"""


fileName = "ErrorCodeUtil.java"
fileName_case = "ErrorCodeUtil_case.java"

f = open(fileName, "r")
f_case = open(fileName_case, "w")

reasonMsgId = ""
solveMsgId = ""
showMsgId = ""

try:
    lines = f.readlines()
    # print(len(lines))
    # print(lines[134])
    for line in lines:
        if line.strip().startswith("case") or line.strip().startswith("//"):
            f_case.write(line)
            # print(line)

        if line.strip().startswith("reasonMsgId"):
            reasonMsgId = line.split(" = ")[1].strip().strip(";")
            # print(reasonMsgId)
    #         f_case.write("msg = buildUpMsg(%s, " % (reasonMsgId))
        elif line.strip().startswith("solveMsgId"):
            solveMsgId = line.split(" = ")[1].strip().strip(";")
    #         f_case.write("%s, " % solveMsgId)
        elif line.strip().startswith("showMsgId"):
            showMsgId = line.split(" = ")[1].strip().strip(";")
    #         f_case.write("%s);" % showMsgId)
        if len(reasonMsgId) != 0 and len(solveMsgId) != 0 and len(showMsgId) != 0:
            print(reasonMsgId, solveMsgId, showMsgId)
            f_case.write("\t\t\t\tmsg = buildUpMsg(%s, %s, %s);\n\t\t\t\tbreak;\n" % (reasonMsgId, solveMsgId, showMsgId))
            reasonMsgId = ""
            solveMsgId = ""
            showMsgId = ""
finally:
    f.close()
    f_case.close()
