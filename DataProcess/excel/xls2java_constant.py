#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_xls2java_constant.py
@author:    ziv
@time:      2019/11/19
@version:   v1.0.0
@desc:      脚本功能描述
"""


import xlrd
import xlwt
import re
from xlutils.copy import copy
from Translate import translate
import time

fileName = r"TV错误码和错误提示语20170602.xls"
tableName = r"播放"
tableIndex = r"播放"

read_data = xlrd.open_workbook(fileName)
read_table = read_data.sheet_by_name(tableName)
write_data = copy(read_data)
write_table = write_data.get_sheet(tableIndex)


def translateString():
    translateFile = open("translate.txt", "a+")
    try:
        for row_index in range(1, read_table.nrows):
            error_reason_ch = read_table.cell(row_index, index_reason_ch).value
            error_reason_en = translate(error_reason_ch)
            translateFile.write("%s->%s\n" % (error_reason_ch, error_reason_en))
    finally:
        translateFile.close()


def translateData(src_ch, des_en, title=None):
    """
    翻译错误原因, 写回表格
    """
    try:
        if title is not None:
            print("Costume title:", title)
            write_table.write(0, des_en, title)
        else:
            write_table.write(0, des_en, "翻译")

        for row_index in range(1, read_table.nrows):
            error_reason_ch = read_table.cell(row_index, src_ch).value
            error_reason_en = translate(error_reason_ch)
            write_table.write(row_index, des_en, error_reason_en)
    finally:
        write_data.save(fileName)
        print("翻译 写入数据成功！")


def analysisHint(src_ch, show_des_ch, solve_des_ch, show_title=None, solve_title=None):
    try:
        if show_title is not None:
            print("Costume show_title:", show_title)
            write_table.write(0, show_des_ch, show_title)
        else:
            write_table.write(0, show_des_ch, "错误展示")

        if solve_title is not None:
            print("Costume solve_title:", solve_title)
            write_table.write(0, solve_des_ch, solve_title)
        else:
            write_table.write(0, solve_des_ch, "解决方式")

        for row_index in range(1, read_table.nrows):
            error_solve_ch = read_table.cell(row_index, src_ch).value

            error_solve_ch = re.sub(r"(\(|（)x(,|，)x） *S*", "S", error_solve_ch)

            error_solve = error_solve_ch.split("S")
            if len(error_solve) == 1:
                error_solve.append('请到“我的-意见反馈”反馈给我们')
            else:
                if len(error_solve[1]) == 0:
                    error_solve[1] = '请到“我的-意见反馈”反馈给我们'

            # print(error_solve)
            show_msg = error_solve[0].strip("T")
            solve_msg = error_solve[1]
            print(show_msg, solve_msg)

            write_table.write(row_index, show_des_ch, show_msg)
            write_table.write(row_index, solve_des_ch, solve_msg)
    finally:
        write_data.save(fileName)
        print("提示语 分析写入数据成功！")


def createVariableName(src, up, low):
    """
    处理类中变量和资源名
    """
    try:
        write_table.write(0, up, "Java")
        write_table.write(0, low, "Xml")
        for row_index in range(1, read_table.nrows):
            error_reason = read_table.cell(row_index, src).value.strip()
            error_reason = re.sub(r"\W+", "_", error_reason).strip('_')
            print(error_reason)
            error_reason_upper = error_reason.upper()
            error_reason_lower = error_reason.lower()
            write_table.write(row_index, up, error_reason_upper)
            write_table.write(row_index, low, error_reason_lower)
    finally:
        write_data.save(fileName)
        print("创建变量 写入数据成功！")


case_code = '''case VideoErrorCode.%s:
    // %s
    
    reasonMsgId = R.string.%s;
    solveMsgId = R.string.%s;
    showMsgId = R.string.%s;
    break;
'''


def createOutputFile():
    """
    一共5个文件: 常量, case, 原因xml, 用户展示xml, 解决方法xml
    """
    constantFile = open("constantFile.java", "a+")
    caseFile = open("caseFile.java", "a+")
    reasonXmlFile = open("reasonXmlFile.xml", "a+")
    showXmlFile = open("showXmlFile.xml", "a+")
    solveXmlFile = open("solveXmlFile.xml", "a+")
    try:
        for row_index in range(1, read_table.nrows):
            # 错误码
            error_code = read_table.cell(row_index, index_error_code).value
            # 模块名
            model_name_ch = read_table.cell(row_index, index_child_model_ch).value
            model_name_en_upper = read_table.cell(row_index, index_child_model_en_upper).value
            model_name_en_lower = read_table.cell(row_index, index_child_model_en_lower).value
            # java条件常量(switch...case...)
            constant_java_case = read_table.cell(row_index, index_reason_en_upper).value
            # xml错误原因(key)
            error_reason_key = read_table.cell(row_index, index_reason_en_lower).value
            # xml错误原因(value)
            error_reason_value = read_table.cell(row_index, index_reason_ch).value
            # xml展示信息(key)
            error_show_key = read_table.cell(row_index, index_notice_show_en_lower).value
            # xml展示信息(value)
            error_show_value = read_table.cell(row_index, index_notice_show_ch).value
            # xml解决方式(key)
            error_solve_key = read_table.cell(row_index, index_notice_solve_en_lower).value
            # xml解决方式(value)
            error_solve_value = read_table.cell(row_index, index_notice_solve_ch).value

            print("error_code:", error_code, "model_name_ch:", model_name_ch, "error_reason_value:", error_reason_value, "error_solve_value", error_solve_value)
            print("java_upper_case:", constant_java_case, "error_show_key:", error_show_key)

            # // error_reason
            # psfi constant_java_case = error_code;
            constantFile.write("// %s\n" % error_reason_value)
            if type(error_code) == str:
                error_code_array = error_code.split("~\n")
                error_code_min = int(error_code_array[0])
                error_code_max = int(error_code_array[len(error_code_array) - 1])
                # 手动处理多个error_code现象
                constantFile.write("public static final int %s = %d;\n" % (constant_java_case, error_code_min))
                constantFile.write("public static final int %s_MIN = %d;\n" % (constant_java_case, error_code_min))
                constantFile.write("public static final int %s_MAX = %d;\n" % (constant_java_case, error_code_max))
            else:
                constant_java_case = str("%s_%d" % (constant_java_case, error_code))
                constantFile.write("public static final int %s = %d;\n" % (constant_java_case, error_code))
            # case constant_java_case_model_name_en_upper:
            # // error_reason
            caseFile.write(case_code % (constant_java_case, error_reason_value, error_reason_key, error_solve_key, error_show_key))
            # <string name="error_reason_key">error_reason_ch</string>
            # R.string.error_reason_key
            reasonXmlFile.write('<string name="%s">%s</string>\n' % (error_reason_key, error_reason_value))
            # <string name="error_solve_key">error_solve_ch</string>
            # R.string.error_solve_key
            solveXmlFile.write('<string name="%s">%s</string>\n' % (error_solve_key, error_solve_value))
            # <string name="error_show_key">error_show_ch</string>
            # R.string.error_reason_key
            showXmlFile.write('<string name="%s">%s</string>\n' % (error_show_key, error_show_value))
    finally:
        constantFile.close()
        caseFile.close()
        reasonXmlFile.close()
        showXmlFile.close()
        solveXmlFile.close()


def test(row):
    error_code = read_table.cell(row, 2).value
    error_reason = read_table.cell(row, 3).value
    error_solve = read_table.cell(row, 4).value
    print("error_code:", error_code, "error_reason:", error_reason, "error_solve:", error_solve)
    print(type(error_code))
    error_code_array = error_code.split("~\n")
    print(error_code_array)
    print(type(error_code_array[1]))
    print(len(error_code_array))
    print(error_code_array[1])

    # print(table.nrows)
    # line_list = table.row(1)[2:][1]
    # print(line_list.value)
    # print(table.ncols)
    # print(table.col(2))
    # error_code = table.row(1)[2:][0].value
    # error_reason = table.row(1)[2:][1].value
    # error_solve = table.row(1)[2:][2].value
    # print(int(table.cell(2, 3)))


def test_regex():
    result = re.sub(r"\W+", "_", r"Download component startonlineorofflineplay return - 1")
    print(result)


# 模块(model)
index_model = 0
# 子模块(child_model_ch)
index_child_model_ch = 1
# 错误码(error_code)
index_error_code = 2
# 原因(reason_ch)
index_reason_ch = 3
# 提示语(notice_original_ch)
index_notice_original_ch = 4

# 子模块(child_model_en)
index_child_model_en = 5
# 原因(reason_en)
index_reason_en = 6
# 提示语(notice_show_ch)
index_notice_show_ch = 7
# 提示语(notice_show_en)
index_notice_show_en = 8
# 提示语(notice_solve_ch)
index_notice_solve_ch = 9
# 提示语(notice_solve_en)
index_notice_solve_en = 10

# 子模块(child_model_en_upper)
index_child_model_en_upper = 11
# 子模块(child_model_en_lower)
index_child_model_en_lower = 12
# 原因(reason_en_upper)
index_reason_en_upper = 13
# 原因(reason_en_lower)
index_reason_en_lower = 14
# 提示语(notice_show_en_upper)
index_notice_show_en_upper = 15
# 提示语(notice_show_en_lower)
index_notice_show_en_lower = 16
# 提示语(notice_solve_en_upper)
index_notice_solve_en_upper = 17
# 提示语(notice_solve_en_lower)
index_notice_solve_en_lower = 18


if __name__ == "__main__":
    # # 提示语分析
    # analysisHint(index_notice_original_ch, index_notice_show_ch, index_notice_solve_ch)
    # # 子模块翻译
    # translateData(index_child_model_ch, index_child_model_en)
    # # 错误原因翻译
    # translateData(index_reason_ch, index_reason_en)
    # # 提示语 - show
    # translateData(index_notice_show_ch, index_notice_show_en)
    # # 提示语 - solve
    # translateData(index_notice_solve_ch, index_notice_solve_en)
    #
    # # 创建变量名
    # createVariableName(index_child_model_en, index_child_model_en_upper, index_child_model_en_lower)
    # createVariableName(index_reason_en, index_reason_en_upper, index_reason_en_lower)
    # createVariableName(index_notice_show_en, index_notice_show_en_upper, index_notice_show_en_lower)
    # createVariableName(index_notice_solve_en, index_notice_solve_en_upper, index_notice_solve_en_lower)

    # 输出文件
    createOutputFile()

    # test(398)
    # print(translate("哈哈"))
    # translateString()
    # test_regex()
