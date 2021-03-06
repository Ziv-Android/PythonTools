#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_ListAnalysis.py
@author:    ziv
@time:      2020/5/18
@version:   v1.0.0
@desc:      集合操作分析演示
"""


source_list = [
    {"tech": "先进制造技术／工序开发", "startUp": "3DK Tech Limited", "filePath": "TSSSU/HKUST/TSSSU_HKUST_18_01_1.pdf",
     "approvedAmount": "650000", "uCode": "HKUST", "taCode": "1"},
    {"tech": "生物科技", "startUp": "六捷生物科技(香港)有限公司 ", "filePath": "TSSSU/CITYU/TSSSU_CityU_18_04_2.pdf",
     "approvedAmount": "1566667", "uCode": "CITYU", "taCode": "2"},
    {"tech": "生物科技", "startUp": "香港易生物技术股份有限公司", "filePath": "TSSSU/CUHK/TSSSU_CUHK_17_01_3.pdf",
     "approvedAmount": "800000", "uCode": "CUHK", "taCode": "2"},
    {"tech": "电子", "startUp": "精组科技有限公司", "filePath": "TSSSU/CUHK/TSSSU_CUHK_16_05_3.pdf", "approvedAmount": "800000",
     "uCode": "CUHK", "taCode": "4"},
    {"tech": "其他", "startUp": "艾斯数码有限公司", "filePath": "TSSSU/CUHK/TSSSU_CUHK_16_08_3.pdf", "approvedAmount": "550000",
     "uCode": "CUHK", "taCode": "99"},
    {"tech": "纳米及材料科学", "startUp": "静音科技有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_14_01_1_C.pdf",
     "approvedAmount": "1100000", "uCode": "HKUST", "taCode": "9"},
    {"tech": "环境保护", "startUp": "创新声学有限公司 ", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15_019_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "6"},
    {"tech": "物流及供应链管理", "startUp": "Acquaintance Enterprises Ltd", "filePath": "TSSSU/POLYU/TSSSU_PolyU_17_07_2.pdf",
     "approvedAmount": "1000000", "uCode": "POLYU", "taCode": "8"},
    {"tech": "纳米及材料科学", "startUp": "先进激元科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_19_01_1.pdf",
     "approvedAmount": "600000", "uCode": "CUHK", "taCode": "9"},
    {"tech": "资讯及通讯科技", "startUp": "腾浪科技有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15(2)_004_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "电子", "startUp": "AI Motion Sports Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_19_01_1.pdf",
     "approvedAmount": "400000", "uCode": "CITYU", "taCode": "4"},
    {"tech": "资讯及通讯科技", "startUp": "智城科技控股有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_19_07_1.pdf",
     "approvedAmount": "460000", "uCode": "HKU", "taCode": "7"},
    {"tech": "生物科技", "startUp": "艾伊津生物科技有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_16_01_1.pdf",
     "approvedAmount": "500000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "电子", "startUp": "Air Button Technology Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_15_06_3.pdf",
     "approvedAmount": "1170207", "uCode": "CITYU", "taCode": "4"},
    {"tech": "资讯及通讯科技", "startUp": "AlikeAudience (Hong Kong) Limited",
     "filePath": "TSSSU/POLYU/TSSSU_PolyU_16_14_2.pdf", "approvedAmount": "1000000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "其他", "startUp": "阿尔卑斯科技有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_16_026_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "99"},
    {"tech": "能源", "startUp": "大锌能源有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_19_02_1.pdf", "approvedAmount": "820000",
     "uCode": "CITYU", "taCode": "5"},
    {"tech": "资讯及通讯科技", "startUp": "Amazing Trace Technologies Limited",
     "filePath": "TSSSU/POLYU/TSSSU_PolyU_15(2)_025_C.pdf", "approvedAmount": "100000", "uCode": "POLYU",
     "taCode": "7"},
    {"tech": "检测和认证", "startUp": "安娜艺术品科学分析有限公司", "filePath": "TSSSU/HKBU/TSSSU_HKBU_14_04_1_C.pdf",
     "approvedAmount": "2490000", "uCode": "HKBU", "taCode": "10"},
    {"tech": "资讯及通讯科技", "startUp": "云滔科技有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_14_06_1_C.pdf",
     "approvedAmount": "450000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "Animae Technologies Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_14_02_1_C.pdf",
     "approvedAmount": "484000", "uCode": "CITYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "Appedu (Holding) Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_14_05_1_C.pdf",
     "approvedAmount": "300000", "uCode": "HKU", "taCode": "7"},
    {"tech": "环境保护", "startUp": "朝创科有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_17_01_3.pdf",
     "approvedAmount": "1100000", "uCode": "POLYU", "taCode": "6"},
    {"tech": "资讯及通讯科技", "startUp": "Asiabots Limited", "filePath": "TSSSU/POLYU/TSSSU_PolyU_18_01_1.pdf",
     "approvedAmount": "730000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "电子", "startUp": "Atspin Limited", "filePath": "TSSSU/CUHK/TSSSU_CUHK_14_04_1_C.pdf",
     "approvedAmount": "505997", "uCode": "CUHK", "taCode": "4"},
    {"tech": "生物科技", "startUp": "不适用", "filePath": "TSSSU/HKUST/TSSSU_HKUST_19_01_1.pdf", "approvedAmount": "600000",
     "uCode": "HKUST", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "包公资讯科技有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_19_03_1.pdf",
     "approvedAmount": "200000", "uCode": "CITYU", "taCode": "7"},
    {"tech": "先进制造技术／工序开发", "startUp": "倍捷锐科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_19_02_1.pdf",
     "approvedAmount": "700000", "uCode": "CUHK", "taCode": "1"},
    {"tech": "资讯及通讯科技", "startUp": "beNovelty Limited", "filePath": "TSSSU/HKUST/TSSSU_HKUST_16_02_1_C.pdf",
     "approvedAmount": "200000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "电子", "startUp": "Beon Ad Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_19_04_1.pdf",
     "approvedAmount": "350000", "uCode": "CITYU", "taCode": "4"},
    {"tech": "资讯及通讯科技", "startUp": "BeVoid Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_15_07_1_C.pdf",
     "approvedAmount": "249600", "uCode": "CITYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "极视科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_18_01_2.pdf",
     "approvedAmount": "900000", "uCode": "CUHK", "taCode": "7"},
    {"tech": "生物科技", "startUp": "生物捷锐有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_17_01_1.pdf",
     "approvedAmount": "500000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "环境保护", "startUp": "蔚蓝环保有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_17_02_1.pdf",
     "approvedAmount": "650000", "uCode": "HKUST", "taCode": "6"},
    {"tech": "生物科技", "startUp": "步固有限公司", "filePath": "TSSSU/HKBU/TSSSU_HKBU_16_01_2.pdf", "approvedAmount": "1830000",
     "uCode": "HKBU", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "Bootstrap HK Limited (formerly known as RegCourse Limited) ",
     "filePath": "TSSSU/CUHK/TSSSU_CUHK_16_04_1_C.pdf", "approvedAmount": "400000", "uCode": "CUHK", "taCode": "7"},
    {"tech": "生物科技", "startUp": "BP InnoMed Limited", "filePath": "TSSSU/HKBU/TSSSU_HKBU_19_01_1.pdf",
     "approvedAmount": "1060000", "uCode": "HKBU", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "Brain Investing Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_18_01_2.pdf",
     "approvedAmount": "402500", "uCode": "HKU", "taCode": "7"},
    {"tech": "生物科技", "startUp": "博脑医疗科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_15_06_3.pdf",
     "approvedAmount": "500000", "uCode": "CUHK", "taCode": "2"},
    {"tech": "其他", "startUp": "B-Route Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_17_01_1.pdf",
     "approvedAmount": "233000", "uCode": "CITYU", "taCode": "99"},
    {"tech": "资讯及通讯科技", "startUp": "C4Cat Entertainment Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_14_05_1_C.pdf",
     "approvedAmount": "179000", "uCode": "CITYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "C4Cat Entertainment Limited", "filePath": "TSSSU/CUHK/TSSSU_CUHK_15_05_1_C.pdf",
     "approvedAmount": "500000", "uCode": "CUHK", "taCode": "7"},
    {"tech": "纳米及材料科学", "startUp": "国泰光电有限公司", "filePath": "TSSSU/HKBU/TSSSU_HKBU_14_05_1_C.pdf",
     "approvedAmount": "3240000", "uCode": "HKBU", "taCode": "9"},
    {"tech": "生物科技", "startUp": "干科技有限公司 ", "filePath": "TSSSU/HKBU/TSSSU_HKBU_19_02_1.pdf",
     "approvedAmount": "1060000", "uCode": "HKBU", "taCode": "2"},
    {"tech": "生物科技", "startUp": "晶准生物医药集团有限公司 ", "filePath": "TSSSU/CITYU/TSSSU_CityU_19_05_1.pdf",
     "approvedAmount": "820000", "uCode": "CITYU", "taCode": "2"},
    {"tech": "纳米及材料科学", "startUp": "千忆科技有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_14_04_1_C.pdf",
     "approvedAmount": "1234482", "uCode": "CITYU", "taCode": "9"},
    {"tech": "资讯及通讯科技", "startUp": "CISC Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_16_07_3.pdf",
     "approvedAmount": "1160000", "uCode": "HKU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "Clothclip International Limited",
     "filePath": "TSSSU/CITYU/TSSSU_CityU_14_09_1_C.pdf", "approvedAmount": "600000", "uCode": "CITYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "CocoRobo Limited", "filePath": "TSSSU/CUHK/TSSSU_CUHK_17_02_2.pdf",
     "approvedAmount": "800000", "uCode": "CUHK", "taCode": "7"},
    {"tech": "生物科技", "startUp": "高德基因有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_14_07_1_C.pdf",
     "approvedAmount": "1000000", "uCode": "CUHK", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "Cognix Limited", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15_029_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "电子", "startUp": "线易科技有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_16_03_2.pdf", "approvedAmount": "900000",
     "uCode": "HKUST", "taCode": "4"},
    {"tech": "资讯及通讯科技", "startUp": "逗号科技有限公司", "filePath": "TSSSU/HKU/TSSSU_HKU_14_02_1_C.pdf",
     "approvedAmount": "500000", "uCode": "HKU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "随赏科技有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_16_04_1_C.pdf",
     "approvedAmount": "400000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "电子", "startUp": "易控智能科技有限公司 ", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15(2)_026_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "4"},
    {"tech": "生物科技", "startUp": "Conzeb Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_16_06_3.pdf",
     "approvedAmount": "1100000", "uCode": "HKU", "taCode": "2"},
    {"tech": "其他", "startUp": "Corvidae Technology Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_18_02_1.pdf",
     "approvedAmount": "150000", "uCode": "HKU", "taCode": "99"},
    {"tech": "资讯及通讯科技", "startUp": "创意志有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15_15_1_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "其他", "startUp": "宏视科技有限公司 ", "filePath": "TSSSU/HKBU/TSSSU_HKBU_19_03_1.pdf", "approvedAmount": "1060000",
     "uCode": "HKBU", "taCode": "99"},
    {"tech": "资讯及通讯科技", "startUp": "电子复康科技有限公司", "filePath": "TSSSU/CUHK/TSSSU_CUHK_16_06_1_C.pdf",
     "approvedAmount": "400000", "uCode": "CUHK", "taCode": "7"},
    {"tech": "先进制造技术／工序开发", "startUp": "骏创科技有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_19_14_1.pdf",
     "approvedAmount": "360000", "uCode": "HKU", "taCode": "1"},
    {"tech": "生物科技", "startUp": "微系统生技有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_17_03_1.pdf",
     "approvedAmount": "300000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "集智坊有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_18_03_2.pdf",
     "approvedAmount": "402500", "uCode": "HKU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "不适用", "filePath": "TSSSU/HKUST/TSSSU_HKUST_19_02_1.pdf", "approvedAmount": "400000",
     "uCode": "HKUST", "taCode": "7"},
    {"tech": "电子", "startUp": "DecaSense Technology Limited", "filePath": "TSSSU/CUHK/TSSSU_CUHK_16_03_3.pdf",
     "approvedAmount": "700000", "uCode": "CUHK", "taCode": "4"},
    {"tech": "资讯及通讯科技", "startUp": "迪哲(香港)教育咨询有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_18_02_2.pdf",
     "approvedAmount": "1000000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "电子", "startUp": "道创智能科技有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_16_05_1_C.pdf",
     "approvedAmount": "500000", "uCode": "HKUST", "taCode": "4"},
    {"tech": "资讯及通讯科技", "startUp": "诚镌科技有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_19_03_1.pdf",
     "approvedAmount": "400000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "顺景创意科技有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_16_024_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "电子", "startUp": "DG Care Limited", "filePath": "TSSSU/CUHK/TSSSU_CUHK_16_07_1_C.pdf",
     "approvedAmount": "300000", "uCode": "CUHK", "taCode": "4"},
    {"tech": "资讯及通讯科技", "startUp": "DigiDent AI Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_19_11_1.pdf",
     "approvedAmount": "260000", "uCode": "HKU", "taCode": "7"},
    {"tech": "先进制造技术／工序开发", "startUp": "本末科技有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_19_04_1.pdf",
     "approvedAmount": "600000", "uCode": "HKUST", "taCode": "1"},
    {"tech": "资讯及通讯科技", "startUp": "高博士教育科技有限公司 ", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15(2)_006_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "龙迅科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_18_02_2.pdf",
     "approvedAmount": "900000", "uCode": "CUHK", "taCode": "7"},
    {"tech": "生物科技", "startUp": "达普生物科技有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_18_02_1.pdf",
     "approvedAmount": "450000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "先进制造技术／工序开发", "startUp": "Eafe Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_18_01_1.pdf",
     "approvedAmount": "140000", "uCode": "CITYU", "taCode": "1"},
    {"tech": "资讯及通讯科技", "startUp": "Easiread Limited", "filePath": "TSSSU/POLYU/TSSSU_PolyU_17_05_1.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "生物科技", "startUp": "菲声科技有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_19_09_1.pdf", "approvedAmount": "110000",
     "uCode": "HKU", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "先河教商科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_15_02_1_C.pdf",
     "approvedAmount": "100000", "uCode": "CUHK", "taCode": "7"},
    {"tech": "纳米及材料科学", "startUp": "不适用", "filePath": "TSSSU/HKUST/TSSSU_HKUST_19_05_1.pdf", "approvedAmount": "800000",
     "uCode": "HKUST", "taCode": "9"},
    {"tech": "纳米及材料科学", "startUp": "EN Technology Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_16_05_3.pdf",
     "approvedAmount": "1150000", "uCode": "HKU", "taCode": "9"},
    {"tech": "生物科技", "startUp": "安迪生物科技有限公司", "filePath": "TSSSU/HKU/TSSSU_HKU_17_01_1.pdf", "approvedAmount": "450000",
     "uCode": "HKU", "taCode": "2"},
    {"tech": "生物科技", "startUp": "易恒创新科技有限公司", "filePath": "TSSSU/HKU/TSSSU_HKU_16_04_2.pdf", "approvedAmount": "400000",
     "uCode": "HKU", "taCode": "2"},
    {"tech": "先进制造技术／工序开发", "startUp": "易视智瞳科技有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_17_02_1.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "1"},
    {"tech": "生物科技", "startUp": "亿恒(香港)有限公司 ", "filePath": "TSSSU/POLYU/TSSSU_PolyU_18_03_2.pdf",
     "approvedAmount": "970000", "uCode": "POLYU", "taCode": "2"},
    {"tech": "物流及供应链管理", "startUp": "不适用", "filePath": "TSSSU/HKUST/TSSSU_HKUST_19_06_1.pdf",
     "approvedAmount": "400000", "uCode": "HKUST", "taCode": "8"},
    {"tech": "先进制造技术／工序开发", "startUp": "亿创电子材料(香港)有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_15_02_1_C.pdf",
     "approvedAmount": "700000", "uCode": "HKUST", "taCode": "1"},
    {"tech": "资讯及通讯科技", "startUp": "珠峰创新科技有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_14_02_1_C.pdf",
     "approvedAmount": "900000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "有光集团有限公司 (前称孔明有限公司)", "filePath": "TSSSU/HKU/TSSSU_HKU_15_03_3.pdf",
     "approvedAmount": "1000000", "uCode": "HKU", "taCode": "7"},
    {"tech": "其他", "startUp": "Farmacy HK Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_19_18_1.pdf",
     "approvedAmount": "252500", "uCode": "HKU", "taCode": "99"},
    {"tech": "纳米及材料科学", "startUp": "杰峰导电膜技术有限公司", "filePath": "TSSSU/HKU/TSSSU_HKU_16_08_1_C.pdf",
     "approvedAmount": "250000", "uCode": "HKU", "taCode": "9"},
    {"tech": "环境保护", "startUp": "Flow Imaging Technology Limited", "filePath": "TSSSU/HKBU/TSSSU_HKBU_14_02_1_C.pdf",
     "approvedAmount": "1000000", "uCode": "HKBU", "taCode": "6"},
    {"tech": "生物科技", "startUp": "科进语言及学习方案有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_18_03_2.pdf",
     "approvedAmount": "800000", "uCode": "CUHK", "taCode": "2"},
    {"tech": "能源", "startUp": "扬帆科技有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_15_04_1_C.pdf",
     "approvedAmount": "200000", "uCode": "HKUST", "taCode": "5"},
    {"tech": "资讯及通讯科技", "startUp": "Freedrop Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_19_06_1.pdf",
     "approvedAmount": "350000", "uCode": "CITYU", "taCode": "7"},
    {"tech": "生物科技", "startUp": "基琳健康有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_14_06_1_C.pdf",
     "approvedAmount": "834800", "uCode": "CUHK", "taCode": "2"},
    {"tech": "电子", "startUp": "灵陆科技有限公司 ", "filePath": "TSSSU/CITYU/TSSSU_CityU_19_11_1.pdf",
     "approvedAmount": "500000", "uCode": "CITYU", "taCode": "4"},
    {"tech": "生物科技", "startUp": "尖思科研有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_18_03_2.pdf",
     "approvedAmount": "650000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "生物科技", "startUp": "基训生物科技有限公司", "filePath": "TSSSU/HKBU/TSSSU_HKBU_17_01_3.pdf",
     "approvedAmount": "2820000", "uCode": "HKBU", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "环野国际有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_14_08_1_C.pdf",
     "approvedAmount": "389000", "uCode": "CITYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "Gnetwork Limited", "filePath": "TSSSU/CUHK/TSSSU_CUHK_18_04_2.pdf",
     "approvedAmount": "600000", "uCode": "CUHK", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "Hactis Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_16_01_3.pdf",
     "approvedAmount": "850000", "uCode": "HKU", "taCode": "7"},
    {"tech": "生物科技", "startUp": "联手生命科技有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_16_01_3.pdf",
     "approvedAmount": "2426666", "uCode": "CITYU", "taCode": "2"},
    {"tech": "物流及供应链管理", "startUp": "鹰眼系统有限公司", "filePath": "TSSSU/CUHK/TSSSU_CUHK_16_01_2.pdf",
     "approvedAmount": "400000", "uCode": "CUHK", "taCode": "8"},
    {"tech": "生物科技", "startUp": "康讯生物分析有限公司", "filePath": "TSSSU/CUHK/TSSSU_CUHK_15_07_3.pdf",
     "approvedAmount": "500000", "uCode": "CUHK", "taCode": "2"},
    {"tech": "能源", "startUp": "海柏斯股份有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_18_04_2.pdf", "approvedAmount": "1175000",
     "uCode": "HKU", "taCode": "5"},
    {"tech": "生物科技", "startUp": "希图科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_14_01_1_C.pdf",
     "approvedAmount": "804954", "uCode": "CUHK", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "好师傅科技有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_16_11_2.pdf",
     "approvedAmount": "1000000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "可路米奴有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15_021_C.pdf",
     "approvedAmount": "600000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "其他", "startUp": "香港艾廷思健康科技有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_18_02_1.pdf",
     "approvedAmount": "400000", "uCode": "CITYU", "taCode": "99"},
    {"tech": "检测和认证", "startUp": "香港铁皮石斛检定中心有限公司", "filePath": "TSSSU/HKBU/TSSSU_HKBU_17_02_3.pdf",
     "approvedAmount": "2910000", "uCode": "HKBU", "taCode": "10"},
    {"tech": "资讯及通讯科技", "startUp": "香港双语学习与翻译研究会有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_14_03_1_C.pdf",
     "approvedAmount": "227800", "uCode": "CITYU", "taCode": "7"},
    {"tech": "纳米及材料科学", "startUp": "香港创新显示科技有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_14_03_1_C.pdf",
     "approvedAmount": "600000", "uCode": "HKUST", "taCode": "9"},
    {"tech": "资讯及通讯科技", "startUp": "一域出版有限公司", "filePath": "TSSSU/HKU/TSSSU_HKU_14_06_1_C.pdf",
     "approvedAmount": "650000", "uCode": "HKU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "香港绿州蔚来技术开发有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_19_07_1.pdf",
     "approvedAmount": "400000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "生物科技", "startUp": "博琦生物科技有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_19_08_1.pdf",
     "approvedAmount": "800000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "生物科技", "startUp": "海山基因科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_14_08_1_C.pdf",
     "approvedAmount": "807255", "uCode": "CUHK", "taCode": "2"},
    {"tech": "电子", "startUp": "海洋丁丁科技有限公司 ", "filePath": "TSSSU/CITYU/TSSSU_CityU_19_07_1.pdf",
     "approvedAmount": "200000", "uCode": "CITYU", "taCode": "4"},
    {"tech": "资讯及通讯科技", "startUp": "海灵有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_14_05_1_C.pdf",
     "approvedAmount": "490167", "uCode": "CUHK", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "联宠互动科技(香港)有限公司 ", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15_001_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "生物科技", "startUp": "Immuno Cure Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_15_02_1_C.pdf",
     "approvedAmount": "800000", "uCode": "HKU", "taCode": "2"},
    {"tech": "生物科技", "startUp": "英诺诊断有限公司", "filePath": "TSSSU/HKU/TSSSU_HKU_16_02_3.pdf", "approvedAmount": "1465000",
     "uCode": "HKU", "taCode": "2"},
    {"tech": "生物科技", "startUp": "视见医疗科技有限公司", "filePath": "TSSSU/CUHK/TSSSU_CUHK_17_03_3.pdf",
     "approvedAmount": "1000000", "uCode": "CUHK", "taCode": "2"},
    {"tech": "电子", "startUp": "音科有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_17_04_1.pdf", "approvedAmount": "650000",
     "uCode": "HKUST", "taCode": "4"},
    {"tech": "生物科技", "startUp": "康至科研有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_18_04_2.pdf",
     "approvedAmount": "600000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "Initial Innovation Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_17_02_2.pdf",
     "approvedAmount": "374000", "uCode": "CITYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "灵窗有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15_10_1_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "电子", "startUp": "玩加创新有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_17_08_1.pdf", "approvedAmount": "500000",
     "uCode": "POLYU", "taCode": "4"},
    {"tech": "环境保护", "startUp": "一诺水务有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_18_05_1.pdf",
     "approvedAmount": "450000", "uCode": "HKUST", "taCode": "6"},
    {"tech": "资讯及通讯科技", "startUp": "InReader Limited", "filePath": "TSSSU/POLYU/TSSSU_PolyU_16_03_01_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "电子", "startUp": "智感科技有限公司", "filePath": "TSSSU/CUHK/TSSSU_CUHK_17_04_3.pdf", "approvedAmount": "1000000",
     "uCode": "CUHK", "taCode": "4"},
    {"tech": "先进制造技术／工序开发", "startUp": "InterLitho Technology Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_19_10_1.pdf",
     "approvedAmount": "725000", "uCode": "HKU", "taCode": "1"},
    {"tech": "资讯及通讯科技", "startUp": "图方科技(香港)有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_18_06_1.pdf",
     "approvedAmount": "450000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "iSTEM Limited", "filePath": "TSSSU/HKUST/TSSSU_HKUST_18_07_1.pdf",
     "approvedAmount": "200000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "电子", "startUp": "知音科技有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_14_04_1_C.pdf",
     "approvedAmount": "400000", "uCode": "HKUST", "taCode": "4"},
    {"tech": "其他", "startUp": "J&K Brassiere Co., Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_17_03_3.pdf",
     "approvedAmount": "1425000", "uCode": "CITYU", "taCode": "99"},
    {"tech": "其他", "startUp": "JabJabX Limited", "filePath": "TSSSU/POLYU/TSSSU_PolyU_17_03_1.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "99"},
    {"tech": "电子", "startUp": "积奇仪器有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_15_04_3.pdf",
     "approvedAmount": "1786986", "uCode": "CITYU", "taCode": "4"},
    {"tech": "电子", "startUp": "捷通科技有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_15_03_1_C.pdf",
     "approvedAmount": "450000", "uCode": "HKUST", "taCode": "4"},
    {"tech": "资讯及通讯科技", "startUp": "职到有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15_20_1_C.pdf",
     "approvedAmount": "1500000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "电子", "startUp": "家健科技有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_19_12_1.pdf", "approvedAmount": "110000",
     "uCode": "HKU", "taCode": "4"},
    {"tech": "先进制造技术／工序开发", "startUp": "香港库宝科技有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_17_09_1.pdf",
     "approvedAmount": "700000", "uCode": "POLYU", "taCode": "1"},
    {"tech": "资讯及通讯科技", "startUp": "功夫动态有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_14_06_01_C.pdf",
     "approvedAmount": "1459337", "uCode": "CITYU", "taCode": "7"},
    {"tech": "先进制造技术／工序开发", "startUp": "不适用", "filePath": "TSSSU/HKUST/TSSSU_HKUST_19_09_1.pdf",
     "approvedAmount": "800000", "uCode": "HKUST", "taCode": "1"},
    {"tech": "生物科技", "startUp": "Lifespans Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_17_02_3.pdf",
     "approvedAmount": "1790000", "uCode": "HKU", "taCode": "2"},
    {"tech": "生物科技", "startUp": "光原创新科技有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_17_05_1.pdf",
     "approvedAmount": "500000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "纺织 /成衣 /鞋履", "startUp": "Lione Limited", "filePath": "TSSSU/CUHK/TSSSU_CUHK_15_04_1_C.pdf",
     "approvedAmount": "100000", "uCode": "CUHK", "taCode": "11"},
    {"tech": "先进制造技术／工序开发", "startUp": "光寻科技有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_19_10_1.pdf",
     "approvedAmount": "300000", "uCode": "HKUST", "taCode": "1"},
    {"tech": "生物科技", "startUp": "生命组织科技有限公司", "filePath": "TSSSU/HKU/TSSSU_HKU_14_03_1_C.pdf",
     "approvedAmount": "1720000", "uCode": "HKU", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "乐刻国际有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_16_04_1_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "乐普体育科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_19_03_1.pdf",
     "approvedAmount": "300000", "uCode": "CUHK", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "Marketeer Limited", "filePath": "TSSSU/POLYU/TSSSU_PolyU_17_04_1.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "纳米及材料科学", "startUp": "迈踏生物科技有限公司 ", "filePath": "TSSSU/HKBU/TSSSU_HKBU_18_01_2.pdf",
     "approvedAmount": "1810000", "uCode": "HKBU", "taCode": "9"},
    {"tech": "资讯及通讯科技", "startUp": "动中文方案有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_18_05_1.pdf",
     "approvedAmount": "150000", "uCode": "HKU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "MCTIPSS Limited", "filePath": "TSSSU/POLYU/TSSSU_PolyU_16_022_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "先进制造技术／工序开发", "startUp": "迈微思智造有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_19_04_1.pdf",
     "approvedAmount": "500000", "uCode": "CUHK", "taCode": "1"},
    {"tech": "纳米及材料科学", "startUp": "迈迪生物科技有限公司 ", "filePath": "TSSSU/CITYU/TSSSU_CityU_19_12_1.pdf",
     "approvedAmount": "720000", "uCode": "CITYU", "taCode": "9"},
    {"tech": "检测和认证", "startUp": "美加慧教育有限公司", "filePath": "TSSSU/HKU/TSSSU_HKU_19_03_1.pdf", "approvedAmount": "110000",
     "uCode": "HKU", "taCode": "10"},
    {"tech": "先进制造技术／工序开发", "startUp": "微动力发展有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_16_001_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "1"},
    {"tech": "生物科技", "startUp": "迈思科科技有限公司 ", "filePath": "TSSSU/HKBU/TSSSU_HKBU_19_04_1.pdf",
     "approvedAmount": "1060000", "uCode": "HKBU", "taCode": "2"},
    {"tech": "电子", "startUp": "MindAmp Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_19_13_1.pdf",
     "approvedAmount": "450000", "uCode": "CITYU", "taCode": "4"},
    {"tech": "资讯及通讯科技", "startUp": "MindLayer Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_16_02_3.pdf",
     "approvedAmount": "1325000", "uCode": "CITYU", "taCode": "7"},
    {"tech": "生物科技", "startUp": "智活研发有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_16_06_1_C.pdf",
     "approvedAmount": "200000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "美科思有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_16_018_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "走吧有限公司", "filePath": "TSSSU/HKU/TSSSU_HKU_16_09_1_C.pdf",
     "approvedAmount": "100000", "uCode": "HKU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "多媒体大数据分析有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_16_07_1_C.pdf",
     "approvedAmount": "200000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "生物科技", "startUp": "不适用", "filePath": "TSSSU/CUHK/TSSSU_CUHK_19_06_1.pdf", "approvedAmount": "400000",
     "uCode": "CUHK", "taCode": "2"},
    {"tech": "生物科技", "startUp": "纳观生物有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_14_07_1_C.pdf",
     "approvedAmount": "1100000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "鹦鹉螺软件技术有限公司 ", "filePath": "TSSSU/CITYU/TSSSU_CityU_18_03_1.pdf",
     "approvedAmount": "746667", "uCode": "CITYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "Nearko Limited", "filePath": "TSSSU/POLYU/TSSSU_PolyU_16_08_1_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "生物科技", "startUp": "新生命医药科技有限公司", "filePath": "TSSSU/HKBU/TSSSU_HKBU_17_03_3.pdf",
     "approvedAmount": "2950000", "uCode": "HKBU", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "新益科技有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_15_02_1_C.pdf",
     "approvedAmount": "360000", "uCode": "CITYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "相信保险科技有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_19_15_1.pdf",
     "approvedAmount": "252500", "uCode": "HKU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "微蜂创联科技有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_16_12_2.pdf",
     "approvedAmount": "1000000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "弩飞科技有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_15_01_1_C.pdf",
     "approvedAmount": "1014482", "uCode": "CITYU", "taCode": "7"},
    {"tech": "生物科技", "startUp": "Novel Sonics Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_18_06_2.pdf",
     "approvedAmount": "910000", "uCode": "HKU", "taCode": "2"},
    {"tech": "生物科技", "startUp": "再心生物科技有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_14_08_2.pdf",
     "approvedAmount": "1150000", "uCode": "HKU", "taCode": "2"},
    {"tech": "生物科技", "startUp": "海科生物科技有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_19_11_1.pdf",
     "approvedAmount": "200000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "生物科技", "startUp": "安高生命医学有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_14_01_1_C.pdf",
     "approvedAmount": "950000", "uCode": "HKU", "taCode": "2"},
    {"tech": "生物科技", "startUp": "荟新科技有限公司", "filePath": "TSSSU/HKBU/TSSSU_HKBU_14_03_1_C.pdf",
     "approvedAmount": "3280000", "uCode": "HKBU", "taCode": "2"},
    {"tech": "生物科技", "startUp": "宏声医疗科技(香港)有限公司(前称宏声医疗科技有限公司)", "filePath": "TSSSU/HKUST/TSSSU_HKUST_15_01_1_C.pdf",
     "approvedAmount": "700000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "评论网有限公司", "filePath": "TSSSU/CUHK/TSSSU_CUHK_16_02_1_C.pdf",
     "approvedAmount": "300000", "uCode": "CUHK", "taCode": "7"},
    {"tech": "生物科技", "startUp": "OrthoSmart Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_14_04_1_C.pdf",
     "approvedAmount": "1077500", "uCode": "HKU", "taCode": "2"},
    {"tech": "生物科技", "startUp": "奥斐纳科技有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_19_04_1.pdf", "approvedAmount": "110000",
     "uCode": "HKU", "taCode": "2"},
    {"tech": "电子", "startUp": "Oxpecker Labs Limited", "filePath": "TSSSU/HKUST/TSSSU_HKUST_17_06_2.pdf",
     "approvedAmount": "800000", "uCode": "HKUST", "taCode": "4"},
    {"tech": "资讯及通讯科技", "startUp": "Parallax Technologies Limited",
     "filePath": "TSSSU/POLYU/TSSSU_PolyU_15(2)_023_C.pdf", "approvedAmount": "100000", "uCode": "POLYU",
     "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "Passber Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_14_07_1_C.pdf",
     "approvedAmount": "400000", "uCode": "HKU", "taCode": "7"},
    {"tech": "生物科技", "startUp": "光声科技有限公司 ", "filePath": "TSSSU/CITYU/TSSSU_CityU_19_08_1.pdf",
     "approvedAmount": "450000", "uCode": "CITYU", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "酥梨有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_16_09_1_C.pdf",
     "approvedAmount": "500000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "溢菱资讯(香港)有限公司 ", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15(2)_012_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "生物科技", "startUp": "Phrmasec Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_19_06_1.pdf",
     "approvedAmount": "260000", "uCode": "HKU", "taCode": "2"},
    {"tech": "生物科技", "startUp": "飞赛光学有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_19_01_1.pdf", "approvedAmount": "460000",
     "uCode": "HKU", "taCode": "2"},
    {"tech": "生物科技", "startUp": "超新星生物科技有限公司 (前称NovaMatrix Limited)",
     "filePath": "TSSSU/HKUST/TSSSU_HKUST_16_08_1_C.pdf", "approvedAmount": "500000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "益维科技有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15_04_1_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "Pokeguide Limited", "filePath": "TSSSU/POLYU/TSSSU_PolyU_17_10_2.pdf",
     "approvedAmount": "1000000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "纳米及材料科学", "startUp": "宝特拉实时检测有限公司 ", "filePath": "TSSSU/CITYU/TSSSU_CityU_19_09_1.pdf",
     "approvedAmount": "710000", "uCode": "CITYU", "taCode": "9"},
    {"tech": "生物科技", "startUp": "派光科技有限公司", "filePath": "TSSSU/CUHK/TSSSU_CUHK_14_02_1_C.pdf",
     "approvedAmount": "1032000", "uCode": "CUHK", "taCode": "2"},
    {"tech": "电子", "startUp": "Printact Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_15_01_1_C.pdf",
     "approvedAmount": "350000", "uCode": "HKU", "taCode": "4"},
    {"tech": "资讯及通讯科技", "startUp": "ProHub Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_15_05_1_C.pdf",
     "approvedAmount": "338958", "uCode": "CITYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "P-Sense Limited", "filePath": "TSSSU/HKUST/TSSSU_HKUST_18_08_1.pdf",
     "approvedAmount": "300000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "起动科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_18_05_1.pdf",
     "approvedAmount": "250000", "uCode": "CUHK", "taCode": "7"},
    {"tech": "电子", "startUp": "量子虚拟工厂有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_18_07_2.pdf", "approvedAmount": "975000",
     "uCode": "HKU", "taCode": "4"},
    {"tech": "生物科技", "startUp": "R&P Technology Limited", "filePath": "TSSSU/HKBU/TSSSU_HKBU_14_01_1_C.pdf",
     "approvedAmount": "1190000", "uCode": "HKBU", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "Regtics Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_19_02_1.pdf",
     "approvedAmount": "110000", "uCode": "HKU", "taCode": "7"},
    {"tech": "电子", "startUp": "守护者科技有限公司 ", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15_19_1_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "4"},
    {"tech": "其他", "startUp": "守护者科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_17_07_2.pdf", "approvedAmount": "200000",
     "uCode": "CUHK", "taCode": "99"},
    {"tech": "其他", "startUp": "速达(科技)有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_17_04_2.pdf",
     "approvedAmount": "490000", "uCode": "CITYU", "taCode": "99"},
    {"tech": "生物科技", "startUp": "绿色海洋有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_16_10_1_C.pdf",
     "approvedAmount": "500000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "生物科技", "startUp": "思研生物科研有限公司", "filePath": "TSSSU/HKU/TSSSU_HKU_19_08_1.pdf", "approvedAmount": "490000",
     "uCode": "HKU", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "启航创投有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_17_07_2.pdf",
     "approvedAmount": "400000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "电子", "startUp": "功信科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_15_01_1_C.pdf",
     "approvedAmount": "300000", "uCode": "CUHK", "taCode": "4"},
    {"tech": "环境保护", "startUp": "汉元生物科技有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_19_12_1.pdf",
     "approvedAmount": "500000", "uCode": "HKUST", "taCode": "6"},
    {"tech": "生物科技", "startUp": "SkinData Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_16_03_3.pdf",
     "approvedAmount": "960000", "uCode": "HKU", "taCode": "2"},
    {"tech": "先进制造技术／工序开发", "startUp": "慧视科技有限公司", "filePath": "TSSSU/CUHK/TSSSU_CUHK_17_05_3.pdf",
     "approvedAmount": "800000", "uCode": "CUHK", "taCode": "1"},
    {"tech": "资讯及通讯科技", "startUp": "笑妙科技有限公司", "filePath": "TSSSU/HKBU/TSSSU_HKBU_19_05_1.pdf",
     "approvedAmount": "240000", "uCode": "HKBU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "源伞科技股份有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_18_09_1.pdf",
     "approvedAmount": "250000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "生物科技", "startUp": "赛百思科技有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_19_13_1.pdf",
     "approvedAmount": "800000", "uCode": "HKUST", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "螺旋资本有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_19_17_1.pdf",
     "approvedAmount": "110000", "uCode": "HKU", "taCode": "7"},
    {"tech": "电子", "startUp": "块涂互动有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_14_07_1_C.pdf",
     "approvedAmount": "571000", "uCode": "CITYU", "taCode": "4"},
    {"tech": "生物科技", "startUp": "Stapworks Stem Cell Limited", "filePath": "TSSSU/CUHK/TSSSU_CUHK_15_08_3.pdf",
     "approvedAmount": "500000", "uCode": "CUHK", "taCode": "2"},
    {"tech": "生物科技", "startUp": "术康医疗国际有限公司(前称锋沿医疗科技有限公司) ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_15_09_1_C.pdf",
     "approvedAmount": "400000", "uCode": "CUHK", "taCode": "2"},
    {"tech": "能源", "startUp": "科日发展有限公司", "filePath": "TSSSU/HKUST/TSSSU_HKUST_17_08_1.pdf", "approvedAmount": "300000",
     "uCode": "HKUST", "taCode": "5"},
    {"tech": "资讯及通讯科技", "startUp": "超光速科技有限公司 ", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15(2)_001_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "聚锋科技顾问有限公司 ", "filePath": "TSSSU/HKU/TSSSU_HKU_19_05_1.pdf",
     "approvedAmount": "110000", "uCode": "HKU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "Tale Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_19_13_1.pdf",
     "approvedAmount": "360000", "uCode": "HKU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "Techlabs Holdings Limited", "filePath": "TSSSU/POLYU/TSSSU_PolyU_16_13_1_C.pdf",
     "approvedAmount": "500000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "Teorema Limited", "filePath": "TSSSU/CITYU/TSSSU_CityU_15_03_1_C.pdf",
     "approvedAmount": "357948", "uCode": "CITYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "环博优才国际语言学习有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_14_01_1_C.pdf",
     "approvedAmount": "880000", "uCode": "CITYU", "taCode": "7"},
    {"tech": "纳米及材料科学", "startUp": "钛研科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_18_06_1.pdf",
     "approvedAmount": "500000", "uCode": "CUHK", "taCode": "9"},
    {"tech": "资讯及通讯科技", "startUp": "Ultimate Sports Hub Limited", "filePath": "TSSSU/POLYU/TSSSU_PolyU_16_10_1_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "其他", "startUp": "香港元远建筑科技发展有限公司", "filePath": "TSSSU/CUHK/TSSSU_CUHK_16_09_3.pdf",
     "approvedAmount": "700000", "uCode": "CUHK", "taCode": "99"},
    {"tech": "资讯及通讯科技", "startUp": "互动虚拟现实实验室有限公司", "filePath": "TSSSU/CITYU/TSSSU_CityU_16_03_3.pdf",
     "approvedAmount": "890000", "uCode": "CITYU", "taCode": "7"},
    {"tech": "生物科技", "startUp": "视觉科技有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_16_09_3.pdf",
     "approvedAmount": "1100000", "uCode": "POLYU", "taCode": "2"},
    {"tech": "先进制造技术／工序开发", "startUp": "未来机器人有限公司", "filePath": "TSSSU/CUHK/TSSSU_CUHK_15_03_1_C.pdf",
     "approvedAmount": "400000", "uCode": "CUHK", "taCode": "1"},
    {"tech": "资讯及通讯科技", "startUp": "Vox Technology Limited", "filePath": "TSSSU/POLYU/TSSSU_PolyU_17_06_1.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "Weavatools Limited", "filePath": "TSSSU/HKU/TSSSU_HKU_18_08_2.pdf",
     "approvedAmount": "610000", "uCode": "HKU", "taCode": "7"},
    {"tech": "电子", "startUp": "WEXTECH HK LIMITED", "filePath": "TSSSU/HKUST/TSSSU_HKUST_18_11_1.pdf",
     "approvedAmount": "350000", "uCode": "HKUST", "taCode": "4"},
    {"tech": "资讯及通讯科技", "startUp": "WIT Enterprises Limited", "filePath": "TSSSU/CUHK/TSSSU_CUHK_17_06_3.pdf",
     "approvedAmount": "1200000", "uCode": "CUHK", "taCode": "7"},
    {"tech": "资讯及通讯科技", "startUp": "科和有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_18_10_1.pdf",
     "approvedAmount": "150000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "生物科技", "startUp": "小默生物科技有限公司 ", "filePath": "TSSSU/CITYU/TSSSU_CityU_19_10_1.pdf",
     "approvedAmount": "710000", "uCode": "CITYU", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "维快软件有限公司 ", "filePath": "TSSSU/HKUST/TSSSU_HKUST_14_05_1_C.pdf",
     "approvedAmount": "900000", "uCode": "HKUST", "taCode": "7"},
    {"tech": "电子", "startUp": "顶尖头脑有限公司", "filePath": "TSSSU/POLYU/TSSSU_PolyU_15_031_C.pdf",
     "approvedAmount": "100000", "uCode": "POLYU", "taCode": "4"},
    {"tech": "先进制造技术／工序开发", "startUp": "形驱科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_19_08_1.pdf",
     "approvedAmount": "700000", "uCode": "CUHK", "taCode": "1"},
    {"tech": "生物科技", "startUp": "镁天健康生物科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_19_05_1.pdf",
     "approvedAmount": "500000", "uCode": "CUHK", "taCode": "2"},
    {"tech": "资讯及通讯科技", "startUp": "安眺科技有限公司 ", "filePath": "TSSSU/CUHK/TSSSU_CUHK_19_07_1.pdf",
     "approvedAmount": "700000", "uCode": "CUHK", "taCode": "7"},
    {"tech": "生物科技", "startUp": "凯狮复康科技有限公司 ", "filePath": "TSSSU/POLYU/TSSSU_PolyU_19_01_1.pdf",
     "approvedAmount": "1000000", "uCode": "POLYU", "taCode": "2"},
    {"tech": "其他", "startUp": "不适用", "filePath": "TSSSU/POLYU/TSSSU_PolyU_19_02_1.pdf", "approvedAmount": "1000000",
     "uCode": "POLYU", "taCode": "99"},
    {"tech": "电子", "startUp": "源木教育科技(香港)有限公司 ", "filePath": "TSSSU/POLYU/TSSSU_PolyU_19_03_1.pdf",
     "approvedAmount": "1000000", "uCode": "POLYU", "taCode": "4"},
    {"tech": "电子", "startUp": "银发优质生活（香港）有限公司 ", "filePath": "TSSSU/POLYU/TSSSU_PolyU_19_04_1.pdf",
     "approvedAmount": "1000000", "uCode": "POLYU", "taCode": "4"},
    {"tech": "先进制造技术／工序开发", "startUp": "图郅创新科技有限公司 ", "filePath": "TSSSU/POLYU/TSSSU_PolyU_19_05_1.pdf",
     "approvedAmount": "1000000", "uCode": "POLYU", "taCode": "1"},
    {"tech": "其他", "startUp": "不适用", "filePath": "TSSSU/POLYU/TSSSU_PolyU_19_06_1.pdf", "approvedAmount": "1000000",
     "uCode": "POLYU", "taCode": "99"},
]

# 序列分解, 解压可迭代对象
print(len(source_list))
head, *tail, end = source_list
print(head)
print(len(tail))

# 保留最后N个元素
from collections import deque

q = deque()
q.append(1)
q.appendleft(2)
q.append(3)
q.append(4)
print(q)
q.pop()
q.popleft()
print(q)


def search(pattern, history=5):
    previous_lines = deque(maxlen=history)
    for data in source_list:
        if pattern in data:
            # yield生成器
            yield data, previous_lines
        previous_lines.append(data)

# 获取最大/最小N个元素
nums = [1, 8, 2, 23, 7, -4, 18, 23, 42, 37, 2]

import heapq

print(heapq.nlargest(1, nums))
print(heapq.nsmallest(2, nums))

portfolio = [
    {'name': 'IBM', 'shares': 100, 'price': 91.1},
    {'name': 'AAPL', 'shares': 50, 'price': 543.22},
    {'name': 'FB', 'shares': 200, 'price': 21.09},
    {'name': 'HPQ', 'shares': 35, 'price': 31.75},
    {'name': 'YHOO', 'shares': 45, 'price': 16.35},
    {'name': 'ACME', 'shares': 75, 'price': 115.65}
]
cheap = heapq.nsmallest(3, portfolio, key=lambda s: s['price'])
expensive = heapq.nlargest(3, portfolio, key=lambda s: s['price'])
print(cheap, expensive)


class PriorityQueue:
    # 优先级队列
    def __init__(self):
        self._queue = []
        self._index = 0

    def push(self, item, priority):
        heapq.heappush(self._queue, (-priority, self._index, item))
        self._index += 1

    def pop(self):
        return heapq.heappop(self._queue)[-1]


q = PriorityQueue()
q.push("第1个,优先级低", 1)
q.push("第2个,优先级低", 1)
q.push("第3个,优先级高", 3)

print(q.pop())

# 一个键对应多个值(记录归类)
# 将这多个值放到另外的容器中， 比如列表或者集合， 保持元素的插入顺序就应该使用列表， 如果想去掉重复元素就使用集合（并且不关心元素的顺序问题）。
from collections import defaultdict
d = defaultdict(list)
d['a'].append(1)
d['a'].append(2)
d['b'].append(2)
print(d)
d = defaultdict(set)
d['a'].add(1)
d['a'].add(2)
d['b'].add(2)
print(d)
# defaultdict 会自动为将要访问的键（就算目前字典中并不存在这样的键）创建映射实体。

# 有序字典
# 精确控制以 JSON 编码后字段的顺序
from collections import OrderedDict
import json

d = OrderedDict()
d['foo'] = 1
d['spam'] = 3
d['bar'] = 2
d['grok'] = 4
print(json.dumps(d))

# 字典运算(如求最小值、最大值、排序等)
prices = {
    'ACME': 45.23,
    'AAPL': 612.78,
    'IBM': 205.55,
    'HPQ': 37.20,
    'FB': 10.75
}
min_price = min(zip(prices.values(), prices.keys()))
max_price = max(zip(prices.values(), prices.keys()))
# zip() 函数创建的是一个只能访问一次的迭代器, 重复使用会报以下错误
# ValueError: max() arg is an empty sequence

# 对比两个list的异同
a = {'x': 1, 'y': 2, 'z': 3}
b = {'w': 10, 'x': 11, 'y': 2}
# common key
c = a.keys() & b.keys()
print(c)
# key in a not in b
d = a.keys() - b.keys()
print(d)
# common key and common value
e = a.items() & b.items()
print(e)


# 删除相同元素并保持顺序
def dedupe(items, key=None):
    seen = set()
    for item in items:
        val = item if key is None else key(item)
        if val not in seen:
            yield item
            seen.add(val)

a = [1, 5, 2, 1, 9, 1, 5, 10]
b = [{'x': 1, 'y': 2}, {'x': 1, 'y': 3}, {'x': 1, 'y': 2}, {'x': 2, 'y': 4}]
c = list(dedupe(b, key=lambda d: (d['x'], d['y'])))
print(c)
c = list(dedupe(b, key=lambda d: (d['x'])))
print(c)
c = list(dedupe(a))
print(c)

# 硬编码切片
record = '....................100 .......513.25 ..........'
cost = int(record[20:23]) * float(record[31:37])
print(cost)
SHARES = slice(20, 23)
PRICE = slice(31, 37)
cost = int(record[SHARES]) * float(record[PRICE])
print(cost)

a = slice(5, 50, 2)
s = "HelloWorld"
print(a.start, a.stop, a.step)
for i in range(*a.indices(len(s))):
    print(s[i])

words = [
    'look', 'into', 'my', 'eyes', 'look', 'into', 'my', 'eyes',
    'the', 'eyes', 'the', 'eyes', 'the', 'eyes', 'not', 'around', 'the',
    'eyes', "don't", 'look', 'around', 'the', 'eyes', 'look', 'into',
    'my', 'eyes', "you're", 'under'
]
morewords = ['why', 'are', 'you', 'not', 'looking', 'in', 'my', 'eyes']

from collections import Counter
word_counts = Counter(words)
more_counts = Counter(morewords)
# 出现频率最高的3个单词
top_three = word_counts.most_common(3)
print(top_three)
counts = word_counts + more_counts
print(counts)

# 关键字**排序**一个字典列表
# operator 模块的 itemgetter 函数
rows = [
    {'first_name': 'Brian', 'last_name': 'Jones', 'uid': 1003},
    {'first_name': 'David', 'last_name': 'Beazley', 'uid': 1002},
    {'first_name': 'John', 'last_name': 'Cleese', 'uid': 1001},
    {'first_name': 'Big', 'last_name': 'Jones', 'uid': 1004}
]
from operator import itemgetter
from operator import attrgetter

rows_by_name = sorted(rows, key=itemgetter('last_name', 'first_name'))
print(rows_by_name)
# 如果被排序对象rows有属性last_name, 也可以使用以下方式针对属性排序
# by_name = sorted(rows, key=attrgetter('last_name'))
# print(by_name)

# **分组** group by
rows = [
    {'address': '5412 N CLARK', 'date': '07/01/2012'},
    {'address': '5148 N CLARK', 'date': '07/04/2012'},
    {'address': '5800 E 58TH', 'date': '07/02/2012'},
    {'address': '2122 N CLARK', 'date': '07/03/2012'},
    {'address': '5645 N RAVENSWOOD', 'date': '07/02/2012'},
    {'address': '1060 W ADDISON', 'date': '07/02/2012'},
    {'address': '4801 N BROADWAY', 'date': '07/01/2012'},
    {'address': '1039 W GRANVILLE', 'date': '07/04/2012'},
]

from itertools import groupby
# 分组前先排序
rows.sort(key=itemgetter('address'))
# Iterate in groups
for date, items in groupby(rows, key=itemgetter('date')):
    print(date)
    for i in items:
        print(' ', i)

# 过滤序列元素
# 列表推导: 缺点-占用大量内存
# list() 来将迭代器结果转换为列表类型
mylist = [1, 4, -5, 10, -7, 2, 3, -1]
my = [n for n in mylist if n > 0]
print(my)
# 生成器表达式
pos = list(n for n in mylist if n < 0)
print(pos)
# filter() 函数

def is_int(val):
    try:
        x = int(val)
        return True
    except ValueError:
        return False


ival = list(filter(is_int, mylist))
print(ival)

from itertools import compress
more5 = [n > 2 for n in mylist]
res = list(compress(rows, more5))
print(res)

# 从字典中提取子集
# 和列表一样, 可以使用字典推导, 比 dict() 函数方式快近一倍
prices = {
    'ACME': 45.23,
    'AAPL': 612.78,
    'IBM': 205.55,
    'HPQ': 37.20,
    'FB': 10.75
}
# Make a dictionary of all prices over 200
p1 = {key: value for key, value in prices.items() if value > 200}
print(p1)
# Make a dictionary of tech stocks
tech_names = {'AAPL', 'IBM', 'HPQ', 'MSFT'}
p2 = {key: value for key, value in prices.items() if key in tech_names}
print(p2)

# 命名元组
from collections import namedtuple
Stock = namedtuple('Stock', ['name', 'age', 'price'])
s = Stock('Alice', 18, 2000.0)
print(s.name)
print(s.price)
# 改变命名元组属性的值，需要使用命名元组实例的 _replace() 方法
# 如果是需要定义一个需要更新很多实例属性的高效数据结构，那么一个包含 __slots__ 方法的类才是最佳选择

# 转换并同时计算数据(生成器表达式参数, 相比先创建一个临时列表再创建会更节省内存)
# 生成器表达式创建的列表为临时列表
import os
files = os.listdir('..')
if any(name.endswith('.py') for name in files):
    print('find python file')
else:
    print('no file')

nums = [1, 2, 3, 4, 5]
s = sum([x * x for x in nums])
# Original: Returns 20
min_shares = min(s['shares'] for s in portfolio)
print(min_shares)
# Alternative: Returns {'name': 'AOL', 'shares': 20}
min_shares = min(portfolio, key=lambda s: s['shares'])
print(min_shares)

# 合并字典(ChainMap)
from collections import ChainMap

a = {'x': 1, 'z': 3}
b = {'y': 2, 'z': 4}

c = ChainMap(a, b)
print(c)
d = dict(b)
d.update(a)
print(d)
