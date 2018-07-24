# -*- coding: utf-8 -*-
import scrapy


class DemospiderSpider(scrapy.Spider):
    # 爬虫名，与项目名不能重复
    name = 'DemoSpider'
    # 允许的域名
    allowed_domains = ['movie.douban.com']
    # 入口Url，提供调度器传递给下载器使用
    start_urls = ['https://movie.douban.com/top250']

    # 数据解析
    def parse(self, response):
        print(response.text)
