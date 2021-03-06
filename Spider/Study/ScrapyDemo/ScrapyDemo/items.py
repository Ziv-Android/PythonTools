# -*- coding: utf-8 -*-

# Define here the models for your scraped items
# 明确抓取目标
#
# See documentation in:
# https://doc.scrapy.org/en/latest/topics/items.html

import scrapy


class ScrapyDemoItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    # 序号
    serial_number = scrapy.Field()
    # 名称
    movie_name = scrapy.Field()
    # 介绍
    introduce = scrapy.Field()
    # 星级
    star_level = scrapy.Field()
    # 评论数
    evaluate = scrapy.Field()
    # 描述
    describe = scrapy.Field()
    # 封面图
    cover_picture = scrapy.Field()
