# Scrapy实践
`start.py`为爬虫执行脚本

## 项目创建
执行`scrapy startproject ScrapyDemo`获得新工程模板
进入spiders目录后执行`scrapy genspider DemoSpider movie.douban.com`创建脚本模板

## 定义item对象
item是保存爬取到的数据的容器

## 编写spider并提取item
执行scrapy脚本DemoSpider, `scrapy crawl DemoSpider`

## 保存提取后的数据
