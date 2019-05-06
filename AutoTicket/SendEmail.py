#!/usr/bin/env python3
# -*- encoding:utf-8 -*-

"""
@license:   (C) Copyright 2013-2017, Node Supply Chain Manager Corporation Limited.
@software:  PyCharm
@file:      PythonTools_SendEmail.py
@author:    ziv
@time:      19-1-7
@version:   v1.0.0
@desc:      发送邮件
"""


import smtplib
from email.mime.text import MIMEText
from email.header import Header

_encode = 'utf-8'

mail_server = "smtp.qq.com"
mail_port = 465
mail_user = "346549752"
mail_pass = "wuicyirbdtsbcaba"

message = "恭喜你成功抢到 xxx -> xxx 的车票，请及时支付并按时乘车，感谢使用…"
sender = "346549752@qq.com"
receivers = ["3600000827@qq.com"]
subject = "抢票结果"

msg = MIMEText(message, 'plain', _encode)
msg['From'] = Header("抢票助手<" + sender + ">", _encode)
msg['To'] = Header(receivers[0], _encode)
msg['Subject'] = Header(subject, _encode)


def _config_email(to_addr):
    # 输入收件人地址
    to_addr = input('To: ')
    # SMTP服务器地址
    if '@qq' in to_addr:
        mail_server = "smtp.qq.com"
        mail_port = 465
    elif '@163' in to_addr:
        mail_server = "smtp.163.com"
        mail_port = 25
    elif '@gmail' in to_addr:
        mail_server = "smtp.gmail.com"
        mail_port = 587
    else:
        mail_server = "smtp.unknown.com"
        mail_port = 25


def send_mail():
    print("send_mail")
    try:
        # server = smtplib.SMTP()
        # server.set_debuglevel(1)
        # SMTP协议默认端口号25
        # server.connect(mail_server, 25)
        server = smtplib.SMTP_SSL(mail_server, mail_port)
        # server.set_debuglevel(1)
        server.login(mail_user, mail_pass)
        server.sendmail(sender, receivers, msg.as_string())
        print("发送邮件成功")
        server.quit()
    except smtplib.SMTPException:
        print("Error: 发送失败")


if __name__ == "__main__":
    send_mail()
