#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_CompanyDirectory.py
@author:    ziv
@time:      2020/3/31
@version:   v1.0.0
@desc:      脚本功能描述
"""

from selenium import webdriver
import requests
from requests.adapters import HTTPAdapter
from lxml import etree
import re
import xlwt
import time
import json
import random

host = 'https://www.hkstp.org'

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36',
    'Connection': 'close'
}

rule_title = '//*[@id="companyList"]//a[@class="title"]/text()'
rule_title_url = '//*[@id="companyList"]//a[@class="title"]/@href'
rule_detail_title = '//h1/text()'
rule_detail_info_type = '//div[@class="info-list"]/span/text()'
rule_detail_info_value = '//div[@class="info-list"]/p/text()|//div[@class="info-list"]/p/a/text()'
# chrome插件下可以使用以下规则
rule_next_url = '//*[@id="company_pagination"]//*[@class="next disabled"]/a/@href'
rule_last_url = '//*[@id="company_pagination"]//*[@class="last disabled"]/a/@href'

index_t = ''
index_c = -1
index_s = -1
page = 1

workbook = xlwt.Workbook(encoding='utf-8')
worksheet = workbook.add_sheet("hkstp")

excel_titles = ['详情页链接', '机构名称-中文', '机构名称-英文', '所属园区', '行业分类', '行业二级分类', '简介', '产品', '网址', '地址', '资助/融资情况', '联系人', '联系电话', '电子邮件', '关键人姓名']
excel_index_detail_link = 0
excel_index_title_zh = 1
excel_index_title_en = 2
excel_index_company_type = 3
excel_index_company_category = 4
excel_index_company_category_sub = 5
excel_start_line = 0

# 代理服务器
proxyHost = "http-dyn.abuyun.com"
proxyPort = "9020"

# 代理隧道验证信息
proxyUser = "H8122T73528C247D"
proxyPass = "A83D8B8E36702396"

proxyMeta = "http://%(user)s:%(pass)s@%(host)s:%(port)s" % {
    "host": proxyHost,
    "port": proxyPort,
    "user": proxyUser,
    "pass": proxyPass,
}

proxies = {
    "http": proxyMeta,
    "https": proxyMeta,
}


# chrome_options = webdriver.ChromeOptions()
# chrome_prefs = {"profile.managed_default_content_settings.images": 2}
# chrome_options.add_experimental_option("prefs", chrome_prefs)
# chrome_options.add_argument("--headless")
# chrome_options.add_argument('--disable-gpu')
# chrome_options.add_argument('--no-sandbox')
# browser = webdriver.Chrome(executable_path='../ChromeDriver/chromedriver_mac_79.0.3945', options=chrome_options)


def depart_chinese_english(s):
    regex = r'(.*)\s([\u4e00-\u9fa5]*)'
    match = re.match(regex, s)
    s_en = match.group(1)
    s_zh = match.group(2)
    return s_zh, s_en


def init_excel_title():
    # 行，列，值
    for excel_title_index in range(len(excel_titles)):
        worksheet.write(excel_start_line, excel_title_index, excel_titles[excel_title_index])


def safety_request_get(url):
    result = None
    except_exception = False
    while True:
        try:
            if except_exception:
                print('After exception, retry url:', url)
                except_exception = False
            request_session = requests.Session()
            result = request_session.get(url=url, headers=headers, timeout=10)
            request_session.close()
        except Exception as e:
            except_exception = True
            time_sleep = random.randint(30, 60)
            print('RequestException', e, 'url', url, 'time sleep', time_sleep, 's.')
            time.sleep(time_sleep)
        if not except_exception:
            break
    return result


def get_company_list(url, comp_name, comp_cate_name, comp_sub_cate_name):
    response = safety_request_get(url)
    print('响应结果', response.status_code)
    result = response.content.decode(response.encoding)
    # browser.get(directory_url)
    # result = browser.page_source
    root = etree.HTML(result)
    title_list = root.xpath(rule_title)
    title_url_list = root.xpath(rule_title_url)
    print('title_list', len(title_list), 'title_url_list', len(title_url_list))
    excel_title_line = excel_start_line
    for i in range(len(title_list)):
        title_zh, title_en = depart_chinese_english(title_list[i])
        print(title_zh, title_en)
        # save
        excel_title_line = excel_title_line + 1
        worksheet.write(excel_title_line, excel_index_title_zh, title_zh)
        worksheet.write(excel_title_line, excel_index_title_en, title_en)
        worksheet.write(excel_title_line, excel_index_company_type, comp_name)
        worksheet.write(excel_title_line, excel_index_company_category, comp_cate_name)
        worksheet.write(excel_title_line, excel_index_company_category_sub, comp_sub_cate_name)
        worksheet.write(excel_title_line, excel_index_detail_link, host + title_url_list[i])
    return title_url_list


def get_company_detail(url_list):
    excel_detail_line = excel_start_line
    for title_url in url_list:
        title_url = host + title_url
        print("获取详情内容并填写表格", title_url)

        response = safety_request_get(title_url)
        result = response.content.decode(response.encoding)
        # browser.get(title_url)
        # result = browser.page_source
        root = etree.HTML(result)
        detail_title = root.xpath(rule_detail_title)
        detail_type_list = root.xpath(rule_detail_info_type)
        detail_value_list = root.xpath(rule_detail_info_value)
        detail_dict = dict(zip(detail_type_list, detail_value_list))
        excel_detail_line = excel_detail_line + 1
        for detail in range(len(detail_dict)):
            # print(detail)
            add_excel_title = False
            if detail_type_list[detail] not in excel_titles:
                add_excel_title = True
                excel_titles.append(detail_type_list[detail])
            detail_index = excel_titles.index(detail_type_list[detail])
            if add_excel_title:
                worksheet.write(0, detail_index, ''.join(detail_type_list[detail].split()))
            worksheet.write(excel_detail_line, detail_index, ''.join(detail_value_list[detail].split()))
        sleep_time = random.randint(1, 3)
        print(detail_title, "finish, time sleep", sleep_time, "s")
        time.sleep(sleep_time)


if __name__ == '__main__':
    init_excel_title()
    print("获取分类信息")
    with open('filterData.json', 'r') as rf:
        data = json.load(rf)
        # company_list -> category_list -> sub_category_map
        # print(data)
        for company in data:
            # company_list
            company_type_key = company['CompanyTypeKey']
            company_type_name = company['CompanyTypeName']
            print("company_type:", company_type_key, company_type_name)
            index_c = -1
            company_categories = company['Categories']
            for company_category in company_categories:
                company_category_key = company_category['Key']
                company_category_name = company_category['Name']
                index_s = -1
                index_c = index_c + 1
                print("company_category:", company_category_key, company_category_name)
                company_category_sub_categories = company_category['SubCategories']
                for company_category_sub_category in company_category_sub_categories:
                    company_category_sub_category_key = company_category_sub_category['Key']
                    company_category_sub_category_name = company_category_sub_category['Name']
                    company_category_sub_category_SubCategories = company_category_sub_category['SubCategories']
                    index_s = index_s + 1
                    print("company_category_sub_category:", company_category_sub_category_key, company_category_sub_category_name, company_category_sub_category_SubCategories)

                    while True:
                        print(company_type_key, index_c, index_s)
                        directory_url = host + '/zh-cn/reach-us/company-directory/?' + 'i=&t=' + company_type_key + '&c=' + str(index_c) + '&s=' + str(index_s) + '&k=&page=' + str(page)
                        directory_url = requests.utils.requote_uri(directory_url)
                        print("获取公司列表及详情url", directory_url)

                        company_list = get_company_list(directory_url, company_type_name, company_category_name, company_category_sub_category_name)
                        if len(company_list) <= 0:
                            page = 1
                            break
                        else:
                            page = page + 1
                        get_company_detail(company_list)

                        excel_start_line = excel_start_line + len(company_list)
                        print('Excel_start_line', excel_start_line)

                        print(company_type_name, company_category_name, company_category_sub_category_name, page, '...finish.')
                    print(company_type_name, company_category_name, company_category_sub_category_name, '...finish.')
                    workbook.save("Companies.xls")
                print(company_type_name, company_category_name, '...finish.')
            print(company_type_name, '...finish.')
        print('filterData.json file close.')
    # browser.close()
    print('save data')
