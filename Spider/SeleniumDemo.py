#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_SeleniumDemo.py
@author:    ziv
@time:      18-12-24
@version:   v1.0.0
@desc:      Python通过Selenium操作浏览器
"""


import time
from selenium import webdriver
from bs4 import BeautifulSoup


def get_pic_urls(target_url):
    """
    注：selenium使用
    """
    driver = webdriver.Chrome("./chromedriver")
    driver.get(target_url)
    time.sleep(3)
    driver.find_element_by_xpath('//*[@id="su"]').click()


_headers = {
    "User-agent": "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36",
    "Referer": "",
    "Host": "www.baidu.com"
}


if __name__ == "__main__":
    print("Start.")
    chrome_options = webdriver.ChromeOptions()
    chrome_prefs = {"profile.managed_default_content_settings.images": 2}
    chrome_options.add_experimental_option("prefs", chrome_prefs)
    chrome_options.add_argument("--headless")
    print("Get chrome driver.")
    driver = webdriver.Chrome("./chromedriver", chrome_options=chrome_options)
    print("Load url.")
    driver.get("https://www.baidu.com")
    print("Input msg.")
    input_edit_text = driver.find_element_by_xpath('//input[@id="kw"]')
    input_edit_text.send_keys("Android")
    # time.sleep(1)
    print("Search.")
    search_btn = driver.find_element_by_xpath('//input[@id="su"]')
    search_btn.click()
    time.sleep(2)
    # links = driver.find_elements_by_xpath('//div[@id="content_left"]//div/h3/a')
    # for link in links:
    #     url = link.get_attribute("href")
    #     print(url)
    print("Begin parser html.")
    soup = BeautifulSoup(driver.page_source, "html.parser")
    # print(soup.find_all('a'))
    print(soup.a)
    # print(soup)
    print("End.")
