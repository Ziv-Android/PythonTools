# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://doc.scrapy.org/en/latest/topics/items.html

import scrapy


# class JobItem(scrapy.Item):
#     # 职位所属
#     jobPosition = scrapy.Field()
#     # 职位分类
#     jobClassify = scrapy.Field()
#     # 职位名称
#     jobName = scrapy.Field()
#     # 工作所在地
#     jobCity = scrapy.Field()
#     # 工作年限
#     jobYear = scrapy.Field()
#     # 教育水平
#     jobEducation = scrapy.Field()
#     # 薪资
#     jobSalary = scrapy.Field()
#     # 职位要求
#     jobDetail = scrapy.Field()
#
#
# class CompanyItem(scrapy.Item):
#     # 公司名称
#     companyName = scrapy.Field()
#     # 公司类型
#     companyType = scrapy.Field()
#     # 融资阶段
#     companyFinance = scrapy.Field()
#     # 公司规模
#     companySize = scrapy.Field()
#
#
# class HrItem(scrapy.Item):
#     # HR姓名
#     hrName = scrapy.Field()
#     # HR职位
#     hrPosition = scrapy.Field()
#     # 发布时间
#     publicTime = scrapy.Field()


class BosszhipinItem(scrapy.Item):
    # job = JobItem(scrapy.Item)
    # company = CompanyItem(scrapy.Item)
    # Hr = HrItem(scrapy.Item)

    # JobItem
    # 职位所属
    jobPosition = scrapy.Field()
    # 职位分类
    jobClassify = scrapy.Field()
    # 职位名称
    jobName = scrapy.Field()
    # 工作所在地
    jobCity = scrapy.Field()
    # 工作年限
    jobYear = scrapy.Field()
    # 教育水平
    jobEducation = scrapy.Field()
    # 薪资
    jobSalary = scrapy.Field()
    # 职位要求
    jobDetail = scrapy.Field()

    # CompanyItem
    # 公司名称
    companyName = scrapy.Field()
    # 公司类型
    companyType = scrapy.Field()
    # 融资阶段
    companyFinance = scrapy.Field()
    # 公司规模
    companySize = scrapy.Field()

    # HrItem
    # HR姓名
    hrName = scrapy.Field()
    # HR职位
    hrPosition = scrapy.Field()
    # 发布时间
    publicTime = scrapy.Field()
