#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_Manager.py
@author:    ziv
@time:      19-1-4
@version:   v1.0.0
@desc:      使用 Splinter + chrome_driver 模拟浏览器登录12306进行抢票
"""


from splinter import Browser
from selenium import webdriver
import smtplib
from email.mime.text import MIMEText
from email.header import Header


_agent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36"

mail_host = "smtp.qq.com"
mail_user = "346549752"
mail_pass = "wuicyirbdtsbcaba"

sender = "346549752@qq.com"
receivers = ["3600000827@qq.com"]

message = MIMEText("恭喜你成功抢到 xxx -> xxx 的车票，请及时支付并按时乘车，感谢使用…", "plain", "utf-8")
message["From"] = Header("ziv抢票", "utf-8")
message["To"] = Header("3600000827@qq.com", "utf-8")
subject = '抢票结果'
message['Subject'] = Header(subject, 'utf-8')


def do_login():
    print("do_login")


def send_mail():
    print("send_mail")
    try:
        # server = smtplib.SMTP()
        # server.set_debuglevel(1)
        # server.connect(mail_host, 25)
        server = smtplib.SMTP_SSL(mail_host, 465)
        server.login(mail_user, mail_pass)
        server.sendmail(sender, receivers, message.as_string())
        server.quit()
        print("发送邮件成功")
    except smtplib.SMTPException:
        print("Error: 发送失败")


if __name__ == "__main__":
    print("Start")
    do_login()

    # send_mail()

    # chrome_options = webdriver.ChromeOptions()
    # chrome_options.add_argument("--no-sandbox")
    # chrome_options.add_argument("--disable-infobars")
    # chrome_options.add_argument("--disable-setuid-sandbox")
    # chrome_options.add_argument('--user-data-dir=/path')
    # browser = Browser('chrome', executable_path="./chromedriver", user_agent=_agent, options=chrome_options)
    # browser.visit("https://kyfw.12306.cn/otn/resources/login.html")
    # chrome_prefs = {"profile.managed_default_content_settings.images": 2}
    # chrome_options.add_experimental_option("prefs", chrome_prefs)
    # # chrome_options.add_argument("--headless")
    # driver = webdriver.Chrome("./chromedriver", chrome_options=chrome_options)
    # print("Load url.")
    # driver.get("https://www.12306.cn/index/")
    # time.sleep(2)
    # from_station = driver.find_element_by_xpath('//input[@id="fromStationText"]')
    # from_station.click()
    # from_station.send_keys("深圳")
    # to_station = driver.find_element_by_xpath('//input[@id="toStationText"]')
    # to_station.click()
    # to_station.send_keys("成都")
    # train_date = driver.find_element_by_xpath('//input[@id="train_date"]')
    # train_date.send_keys("2019-01-04")
    # search_btn = driver.find_element_by_xpath('//a[@id="search_one"]')
    # search_btn.click()
