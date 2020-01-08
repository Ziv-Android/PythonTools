## 什么是爬虫
网络爬虫又称网页蜘蛛，网络机器人，网页追逐者，是一种按照一定的规则，自动的抓取网络信息的程序。

### Requests实现第一个爬虫
API | 说明
--- | ---
requests.requset() | 构造基本请求对象
requests.get() | 按GET请求获取HTML网页内容
requests.head() | 获取HTML网页HEAD头信息
requests.post() | 按POST提交表单至HTML
requests.put() | 按PUT方法请求HTML
requests.patch() | 向HTML网页提交局部修改请求
requests.delete() | 向HTML提交删除请求

### BeautifulSoup4
```python
from bs4 import BeautifulSoup
html_doc = ""
soup = BeautifulSoup(html_doc, 'html.parser')
soup = BeautifulSoup(open("index.html"))
```

#### 常用的第三方解析器
解析器 | 使用方法 | 优势 | 劣势
--- | --- | --- | ---
Python标准库 | BeautifulSoup(markup, "html.parser") | 1.Python的内置标准库 2.执行速度适中 3.文档容错能力强 | Python2.7.3 or 3.2.2前的版本中文档容错能力差
lxml HTML 解析器 | BeautifulSoup(markup, "lxml") | 1.速度快 2.文档容错能力强 | 需要安装C语言库
lxml XML 解析器 | BeautifulSoup(markup, ["lxml-xml"]) BeautifulSoup(markup, "xml") | 1.速度快 2.唯一支持XML的解析器 | 需要安装C语言库
html5lib | BeautifulSoup(markup, "html5lib") | 1.最好的容错性 2.以浏览器的方式解析文档 3.生成HTML5格式的文档 | 1.速度慢 2.不依赖外部扩展

#### BeautifulSoup对象
##### Tag
name
attributes

##### NavigableString
##### BeautifulSoup
##### Comment