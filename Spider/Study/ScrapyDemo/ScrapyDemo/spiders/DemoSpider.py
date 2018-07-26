# -*- coding: utf-8 -*-
import scrapy
from Spider.Study.ScrapyDemo.ScrapyDemo.items import ScrapyDemoItem


class DemospiderSpider(scrapy.Spider):
    # 爬虫名，与项目名不能重复
    name = 'DemoSpider'
    # 允许的域名
    allowed_domains = ['movie.douban.com']
    # 入口Url，提供调度器传递给下载器使用
    start_urls = ['https://movie.douban.com/top250']

    # 默认数据解析方法
    def parse(self, response):
        # print(response.text)
        movie_list = response.xpath("//div[@class='article']//ol[@class='grid_view']//li")
        for i_item in movie_list:
            douban_item = ScrapyDemoItem()
            douban_item['serial_number'] = i_item.xpath(".//div[@class='item']//em/text()").extract_first()
            douban_item['movie_name'] = i_item.xpath(".//div[@class='hd']//a//span[1]/text()").extract_first()
            introduce_content = i_item.xpath(".//div[@class='bd']/p[1]/text()").extract()
            # print(introduce_content)
            # 多行数据处理
            for i_content in introduce_content:
                content_s = "".join(i_content.split())
                douban_item["introduce"] = content_s

            douban_item["star_level"] = i_item.xpath(".//div[@class='star']//span[@class='rating_num']//text()").extract_first()
            douban_item["evaluate"] = i_item.xpath(".//div[@class='star']//span[4]//text()").extract_first()
            douban_item["describe"] = i_item.xpath(".//p[@class='quote']//span//text()").extract_first()
            douban_item["cover_picture"] = i_item.xpath(".//img/@src").extract()
            # print(douban_item)
            # 数据提交pipelines,数据清洗或存储等
            yield douban_item

        # 下一页地址数据
        next_link = response.xpath("//span[@class='next']/link/@href").extract()
        if next_link:
            next_link = next_link[0]
            yield scrapy.Request("https://movie.douban.com/top250" + next_link)
