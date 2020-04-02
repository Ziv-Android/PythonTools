#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_UseSelenium.py
@author:    ziv
@time:      2019/12/21
@version:   v1.0.0
@desc:      脚本功能描述
"""

from selenium import webdriver
from lxml import etree
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait


url = "https://www.dadatutu.com/gc/qingyunian/play-0-36.html"
# HOST = "https://www.dadatutu.com/gc/qingyunian/play-0-33.html"
HOST = "https://www.dadatutu.com/"
RULE_PAGE = '//div[@id="playlist"][1]//div[1]//a/@href'
RULE_TITLE = '//div[@id="playlist"][1]//div[1]//a/text()'
RULE_SRC = '///td[@id="playleft"]/iframe/@src'

chrome_options = webdriver.ChromeOptions()
chrome_prefs = {"profile.managed_default_content_settings.images": 2}
chrome_options.add_experimental_option("prefs", chrome_prefs)
chrome_options.add_argument("--headless")
browser = webdriver.Chrome(executable_path='../../../ChromeDriver/chromedriver_mac_79.0.3945', options=chrome_options)

with open('url_list.txt', 'r') as rf:
    with open("url_list_src.txt", "w+") as wf:
        urls = rf.readlines()
        for url in urls:
            url_list = url.split('\t')
            title = url_list[0].strip()
            ori = url_list[1].strip()
            print(title, ori)

            browser.get(ori)
            data = browser.page_source
            html = etree.HTML(data)
            src = html.xpath(RULE_SRC)
            src = src[0]

            result = "%s\t%s\t%s\n" % (title, ori, src)
            print(result)
            wf.write(result)

browser.quit()

# WebDriverWait(browser, 15).until(EC.text_to_be_present_in_element(By.XPATH, RULE_SRC), 'm3u8')
