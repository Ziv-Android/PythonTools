# -*- coding: utf-8 -*-
import scrapy


class ZhipinspiderSpider(scrapy.Spider):
    name = 'zhipinSpider'
    allowed_domains = ['www.zhipin.com']
    start_urls = ['https://www.zhipin.com/']

    def parse(self, response):
        print(response.text)
