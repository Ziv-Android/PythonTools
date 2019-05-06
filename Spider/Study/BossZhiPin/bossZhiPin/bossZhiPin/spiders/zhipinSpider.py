# -*- coding: utf-8 -*-
import scrapy
from Spider.Study.BossZhiPin.bossZhiPin.bossZhiPin.items import BosszhipinItem


class ZhipinspiderSpider(scrapy.Spider):
    name = 'zhipinSpider'
    allowed_domains = ['www.zhipin.com']
    start_urls = ['https://www.zhipin.com/c101010100-p100202/?page=1']

    def parse(self, response):
        job = BosszhipinItem()
        job_list = response.xpath('//div[@class="job-list"]/ul/li')
        for job_item in job_list:
            # type_head = type_item.xpath('./h4/text()').extract()
            job["jobName"] = job_item.xpath('.//div[@class="job-title"]/text()').extract_first()
            job["jobSalary"] = job_item.xpath('.//span[@class="red"]/text()').extract_first()
            info_primary = job_item.xpath('.//div[@class="info-primary"]/p/text()').extract()
            job["jobCity"] = info_primary[0]
            job["jobYear"] = info_primary[1]
            job["jobEducation"] = info_primary[2]
            job["companyName"] = job_item.xpath('.//div[@class="company-text"]/h3/a/text()').extract_first()
            info_company = job_item.xpath('.//div[@class="company-text"]/p/text()').extract()
            if len(info_company) == 3:
                job["companyType"] = info_company[0]
                job["companyFinance"] = info_company[1]
                job["companySize"] = info_company[2]
            else:
                job["companyType"] = info_company[0]
                job["companySize"] = info_company[1]

            yield job

        next_link = response.xpath('//div[@class="page"]/a/@href').extract()
        print(next_link[len(next_link) - 1])
        if "page" in next_link[len(next_link) - 1]:
            next_link = "https://www.zhipin.com" + next_link[len(next_link) - 1]
            print(next_link)
            yield scrapy.Request(next_link, callback=self.parse)
