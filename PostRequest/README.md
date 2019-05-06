# 泰捷视频客户端
## 项目结构
泰捷视频app大致由TogicBase和TogicVedeo两部分组成，其中TogicBase是当时为了实现插件方案抽离出来的一部分基础组件。功能大致包含一套兼容不同UI的基础控件（com.togic.ui），DNS（com.togic.util.dnscache），
 在线参数（com.togic.critical.params），api_config（com.togic.critical.urlparams），播放器抽象（com.togic.mediacenter），软解（tv.danmaku.ijk.media.player）以及其他工具类（com.togic.base）。
 TogicVideo包含泰捷视频的主体业务逻辑，主要组件包含两个后台服务BackendService（独立进程:backend）和PluginService（独立进程:plugin），首页模块（MainActivity），列表页（ProgramListActivity），
  详情页（ProgramInfoActivity），腾讯sdk（com.togic.media）。
 BackendService提供检查节目更新（CheckVideoUpdateManager），日志上报（LogcatManager），统计（DataStatisticsManager），微信推送（WeixinManager），儿童锁（EyeProtectManager）等服务。
 PluginService主要提供插件的下载服务。
## 主要包结构
TogicBase目录主要代码结构：

     com.togic.base.cache             网络请求结果缓存以及淘汰算法
     com.togic.base.setting            app设置相关代码，具体使用场景可参看LiveProgramSettingActivity.java,LiveTvSettingActivity.java,LiveVideoSettingActivity.java
     com.togic.base.util                  各种工具类，如字符串处理，MD5，json处理等
     com.togic.common                  一些杂七杂八的功能，目前这个包里的功能已经慢慢边缘化了，可以考虑整合设计
     com.togic.critical.http              自己封装的网络请求框架，使用比较复杂可以考虑使用第三个框架替换
     com.togic.critical.params        在线参数，这个模块属于app的核心功能相当重要。app所有动态参数都由这个模块提供，所以改动的时候要特别小心
     com.togic.critical.urlparams    api_config模块，核心功能。app所有网络接口都由这个模块提供和管理，如果这个模块出问题可能导致app无法使用。改动要特别小心
     com.togic.mediacenter            播放器类的抽象，腾讯sdk会调用这个包里的接口创建具体的播放器。
     com.togic.module.proxy          TogicBase和TogicVideo通信的代理模块，TogicBase通过TogicVideo设置的代理类和TogicVideo交互
     com.togic.ui                                一套兼容各种分别率的控件，在布局文件中用这个包里的控件替换LinearLayout等相应的控件。
     com.togic.util.dnscache            dns服务，网络请求的时候这个服务会获取对应域名的ip。然后替换掉域名执行网络请求避免域名劫持。
     tv.danmaku.ijk.media.player     软解播放器映射类

 TogicVideo目录主要代码结构：

     src.cibn                                        cibn版本差异部分，主要差异包括请求域名，splash欢迎图片。由编译脚本自动区分打包
     src.plugins                                   插件具体实现代码，可参看plugins.gradle脚本
     src.togic                                       默认版本的欢迎页
     src.znds                                       当贝版本差异部分，主要区别在开机广告（splash）
     com.togic.account                     账号中心，用户登录，会员信息管理
     com.togic.backend                    后台服务组件，主要包括统计上传，日志收集，检查追剧更新，微信推送消息接收，app下载等。
     com.togic.common                    杂七杂八的功能,功能比较乱可以考虑重构
     com.togic.database                  app各模块数据库读写类
     com.togic.datacenter.statistic            app部分统计事件的生成逻辑
     com.togic.eyeprotect                护眼锁
     com.togic.launcher                    首页更新，加载，以及部分功能入口
     com.togic.liveprogram              实时节目
     com.togic.livetv                          轮播（直播）
     com.togic.livevideo                    点播等app主要功能
     com.togic.media                        sdk接入层，目前只封装了腾讯sdk
     com.togic.plugincenter              各插件的客户端抽象
     com.togic.pluginservice            插件下载组件
     com.togic.upgrade                     app升级组件，核心功能。改动要特别小心
     com.togic.weixin                        微信相册

## 插件相关
### 基本流程

    getCleanConfig -> doClean -> getUpdaterConfig -> downloadUpdater -> getPluginSuperConfig -> getPluginConfig -> downloadPlugins

### getCleanConfig
clean指清理任务，主要用于用户数据出现异常时用于清理特定文件。有两种操作方式，一种比较简单，可以根据要求删除指定文件或目录；另一种情况用于处理比较复杂的情况，需要下发插件。配置文件地址为 ${domin}/clean_config.json ，格式如下：
```json
{
   "togic_clean_task": [
       {
           "task_id": "0x000001",
           "path": "/itemData/itemData/com.togic.livevideo/files/aaa.txt",
           "md5": "",
           "last_modify": "",
           "modify_start_time": "",
           "modify_end_time": "",
           "min_client_version": 64,
           "max_client_version": 0
       }
   ],
   "togic_clean_plugin": {}
}
```

### doClean
clear_file_list项中会删除"path"对应的文件或目录，并且需要md5/last_modify/client_version等选项完全匹配才会执行。"task_id"用于指定一个任务id，同一个id的任务只会执行一次，如果需要重复执行请重复配置。

togic_clean_plugin对应配置项与普通插件相同，后面会介绍。写这个插件时需要继承AbstractCleaner类并实现其clean方法，具体逻辑写到clean方法中。
### getUpdaterConfig
### downloadUpdater
请求PluginUpdater和BtDownloader插件的请求文件，目前Bt下载已经废弃，PluginUpdater也不再需要动态更新，所以不需要关注。
### getPluginSuperConfig
请求插件配置的列表文件，注意这个文件中并不配置具体的插件，而是一个配置文件列表，列表中的每个文件才是具体的插件配置。请求地址为${domain}/plugin_super_config.json ，格式如下：
```json
[
   {
       "name": "plugin_so_config",
       "url": "plugin_so_config.json",
       "file_save_dir": "so",
       "priority": 4
   },
   {
       "name": "plugin_player_config",
       "url": "plugin_player_config.json",
       "file_save_dir": "video",
       "priority": 1
   },
   {
       "name": "tv_parsers_config",
       "url": "tv_parsers_config.json",
       "file_save_dir": "parsers",
       "priority": 2
   },
   {
       "name": "plugin_common_config",
       "url": "plugin_common_config.json",
       "file_save_dir": "common",
       "priority": 3
   }
]
```
name表示配置文件名称，url为该文件请求地址，例如上面第一个文件的地址为${domain}/plugin_so_config.json 。file_save_dir表示插件文件的保存路径，例如第一项中所有插件会保存的/itemData/itemData/com.togic.livevideo/app_so这个目录下。priority表示下载优先级，越小越优先下载，配置项数量较少的情况下可以忽略。

### getPluginConfig
根据前面plugin_super_config.json中的配置项去分别请求每个配置文件，格式如下：
```json
[
   {
       "name": "carousel_root_parser",
       "priority": 2,
       "properties": {
           "class_name": "com.togic.plugincenter.parsers.plugins.CarouselRootParser",
           "plugin_file_name": "carousel_root_parser.jar",
           "update_directly": 0,
           "version": 9
       },
       "file_list": [
           {
               "name": "carousel_root_parser.jar",
               "version": 7,
               "min_client_version": 94,
               "md5": "ba21883a395855f47b0a5620d379ecea",
               "cpu": "all",
               "url": "http://down.51togic.com/plugin/plugin_cloud/carousel_root_parser_v1_20151104.jar",
               "magnet": ""
           },
           {
               "name": "carousel_root_parser.jar",
               "version": 9,
               "min_client_version": 95,
               "md5": "4345914bcf0ba30899c7f73ca12532a6",
               "cpu": "all",
               "url": "http://down.51togic.com/plugin/plugin_cloud/carousel_root_parser_v2_20151129.jar",
               "magnet": ""
           }
       ]
   }
]
```
这个文件是一个JsonArray，这里只是为了说明一下格式，所以只有一个插件，下面说明各个配置项的作用。

name用来唯一标识一项插件配置；priority表示下载优先级；properties对应一个map，其中的属性可以自定义，用户在加载插件时可能需要获取其中的一些信息，相当于一个extra选项，可以为空；file_list表示当前插件对应的文件列表，其中所有的文件客户端都会检查，如果出现重名文件，就根据版本号、cpu等选项选择最合适的，如果cpu或者version等条件不符合当前客户端的情况，则不需要下载。

### downloadPlugins
当file_list中所有符合条件的文件都下载完成后，任务完成，当前插件相关的配置会写到名为plugin_info的shared_preference中，客户端会根据这个配置文件去加载。目前所有的下载任务都是通过Http方式，使用HttpDownloader进行多线程下载，由于Bt下载已经停用，所以配置文件中的magnet配置项已经不需要了。Http下载插件的位置为/sdcard/com.togic.livevideo/http/${md5}之下，下载完成并md5校验通过后会将其拷贝到最终目录。

### 插件测试配置
可以通过将plugin_config.json文件放到/sdcard/Debug目录下开启插件测试模式，格式如下，update_domain为指定的测试服务域名，通过本机搭建服务器并配置对应的配置文件完成测试。
```json
{
   "update_domain": "http://192.168.6.252/"
}
```

## 主界面相关
### 配置文件格式说明
```json
{
   "background": "http://cdn.video.51togic.com/metro/background_2/201510/1444796762835.png",
   "metro_background": "http://cdn.video.51togic.com/metro/background/1486957314893.png",
   "tabs": [
       {
           "id": "565450e913eecb802dce1f5b",
           "label": "影视",
           "focus": "1",
           "recommend_type": "",
           "cells": [
               {
                   "id": "56544d0e5d8d0eb524f600e2",
                   "location": {
                       "w": 1,
                       "h": 1,
                       "y": 1,
                       "x": 1
                   },
                   "url":"id=565456fb13eecb802dce1f65",
                   "content": {
                       "background": "http://cdn.video.51togic.com/metro/background/1511007966964.png",
                       "label": "观看历史",
                       "label_status": -1,
                       "action": "togic.intent.action.LIVE_VIDEO_PROGRAM_MY_FAVOR",
                       "type": "history",
                       "itemData": {},
                       "id": "e1c9a7895c0ce98f9655e3018e17aea2"
                   }
               }
           ]
       }
   ],
   "app_bind_config": {
       "page_id": "565450e913eecb802dce1f5b",
       "first_line_insert_position": 2,
       "second_line_insert_position": 3,
       "bind_cell_location": {
           "x": -1,
           "y": 1
       }
   }
}
```
上面是一个简化版的metro配置文件，我们来简要说一下其中各个配置项的含义。

* metro_background
表示主界面背景。

* background
表示应用中的默认背景，注意是一般页面，如观看历史、列表页等页面的背景，非主界面使用。

* tabs
一个JsonArray，每一项代表一个页面。

* app_bind_config
绑定应用功能对应放置新格子的位置参数，请飞哥补充。

下面是tab中的对应项目

* id
当前页面的id，用来唯一标识一个页面。

* label
当前页面显示的标题。

* focus
当前页面是否默认选中页，1表示选中。

* recommend_type
暂时没用到。

* cells
当前页的格子，一个JsonArray。

下面是cell中的配置项

* id
唯一标识。

* location
表示格子的大小和位置，x和y分别表示格子的横纵坐标，左上角为坐标原点，以格子的数量为单位，与其尺寸无关；w和h分别对应格子的宽高，一个方形格子的宽高分别为1。

* url
用于cell_update动态更新的请求地址。

* content
表示格子中显示的内容。

下面是content中的配置项

* id
唯一标识。

* background
格子的背景图片。

* label
格子上展示的文字。

* label_status
格子上是否显示文字。-1不显示，0获得焦点时显示，1常显示。注意背景图片加载失败时也会显示label中的文字。

* type
类型，某些特殊的格子用来做些特殊的用途，例如观看历史的展示“新”提示。

* action
点击格子后跳转的action。注意如果action中包含"/"就会解析成前后包名和组件名，使用显示Intent跳转，否则使用隐式跳转。另外对于访问详情页的Action会有些特殊的操作用来适配之前的代码。详见MetroUtil的jumpTo方法。

* itemData
点击格子后跳转生成Intent的bundle中的参数。

### 格子排布规则
这里需要注意以下几点：

1. x表示横坐标，从左到右递增；y表示纵坐标，从上到下递增；横纵坐标的取值不是按照距离计算，而是按照数量。
2. 宽高取值n表示当前的格子宽度/高度为单位尺寸的n倍，单位尺寸为屏幕高度的一半，也即一个小方格的边长。高度只能取1或者2，表示占屏幕一半或者全占，宽度可以取浮点数。
3. 高度为2的格子的y值为1，但是它同样要在第二行占一个位置，例如格子2的x值为1，格子5的x值为3，是因为中间的格子3占用了一个位置。
4. 如果要考虑格子中的间隔的话，很多位置是无法对齐的，例如格子4的宽度为2，而格子5和6的宽度都为1，那么5和6再加上它们之间的间隔将导致4,5,6这三个格子无法对齐。我们的处理方式是算出了格子4的宽度和格子5,6的宽度和相等，那么就给格子4的自动增加一个间隔的宽度，这样就能保证对齐了。由于我们是使用centerCrop的方式裁剪图片，这样对图片的影响微乎其微。这些细节的代码实现在MetroUtils类中的getPageLayoutParams方法中实现，平时开发中不需要关注。

### 主界面加载基本流程
TogicApplication中调用MetroController的init操作。
1. 启动异步线程，加载shared_preference中之前缓存的metro配置文件，并开始预加载图片。如果没有缓存的文件，就使用apk中assets目录下的metro.json文件。
2. 应用进入splash界面，此时MetroController中已经在后台发起网络请求，拉取最新Metro的配置文件。
3. 拉到Metro最新配置后，后台线程去预加载主界面焦点页的图片，加载完成后通知SplashActivity。如果网络状况不佳无法拉取到新的配置文件，就使用2中加载的文件。
4. SplashActivity跳转到MainActivity，此时预加载图片已经完成，按照配置文件解析出主界面的格子排布位置，数据上屏。
5. 如果新的配置文件上屏过程中未出现异常，就把这个配置文件写入到shared_preference中。
6. 启动后台轮询，隔一段时间去拉取一下是否有新的配置文件，保证用户能及时更新。

## 界面适配注意事项
注意我们的应用是按照屏幕尺寸等比缩放的，意味着同一个控件在所有的屏幕上对应的比例是相等的。要做到这个效果需要遵守以下规则：
1. 尽量使用com.togic.ui.widget包下面的控件代替原生控件
2. 如果使用com.togic.ui.widget控件时并且重写onFinishInflate方法，一定要调用super.onFinishInflate()
3. 使用ImageView时，要指定其尺寸或使用match_parent，不要使用wrap_content，并且视情况将scale_type设置为centerCrop或fitXY
4. 所有图片资源放到drawable-hdpi中，xml格式的drawable放到drawable目录中
5. 如果需要动态加载view，某些情况下由于onFinishInflate()方法不能调到，所以此时需要手动去做scale操作，例如调用 LayoutParamsManager.scaleViewByWidthOrHeight(itemView)
6. 使用美工给的UI标注时，注意对方使用的1920×1080的分辨率，而我们使用的是1280×720的分辨率，所以所有的尺寸值需要除以1.5

## api_config
api_config是泰捷视频中所有请求接口地址的配置文件，由于不同的版本、渠道、model等不同，他们对应的api请求地址可能会不同。应用进入时会第一时间去请求类似下面这个地址，服务端会根据请求中的参数返回配置文件。这个请求失败或者参数尚未返回内容，就读取之前缓存的内容，即/itemData/itemData/com.togic.livevideo/files/V${version}_url_paramters.json 。如果没有找到这个文件，就直接使用apk中的assets目录下的url_paramters.json这个文件。
`http://config.video.51togic.com/api/api_config?package=com_togic_livevideo&version_code=112&version_name=4.1.4-debug&model=we30&os=5.1.1&mobile=false&vip_type=0&board=webox&device=we30&product=we30&brand=Android&channel=togic&province=&city=&isp=&device_id=593e7f8ecab48f5244bd8922ccb7bfcae51b5745fdabbb47&first_sign_time=1498212264`

## 在线参数
在线参数用来设置一些简单的在线配置选项，用于控制开关、动态设置轮询时间、设置首选项之类的场景。缓存策略与上面的api_config相同，对应的缓存文件为/itemData/itemData/com.togic.livevideo/files/paramters.xml，客户端中内置的配置文件为assets目录下的paramters.json。
`http://config.video.51togic.com/api/v1/online_parameters?package=com_togic_livevideo&version_code=112&version_name=4.1.4-debug&model=we30&os=5.1.1&mobile=false&vip_type=0&board=webox&device=we30&product=we30&brand=Android&channel=togic&province=&city=&isp=&device_id=593e7f8ecab48f5244bd8922ccb7bfcae51b5745fdabbb47`

## 发版前更新APK中的配置文件
1. 进入应用，同时使用`adb logcat -v time |grep HttpUtil`命令获取在线参数、api_config以及主界面布局配置的地址，并继续以下步骤。
2. 获取在线参数地址，如 http://config.video.51togic.com/api/v1/online_parameters （以log中出现的为准），请求地址并把对应的json复制，替换掉项目中assets目录下的paramters.json文件即可。
3. 获取api_config地址，如 http://config.video.51togic.com/api/api_config （后面要包含完整的参数列表），请求地址并把对应的json替换掉项目中assets目录下的url_paramters.json文件即可。
4. 获取metro配置文件地址，如 http://cdn.video.51togic.com/v1/layouts/5a783a01e2adcbb36fe606b9?resolution=1080 ，复制这个地址，打开项目中的update_metro.sh文件，替换掉第三行中的地址，保存后运行这个文件。注意这个脚本目前还有些小问题没有完善，需要手工操作一下：
把新的metro.json文件格式化，把background和metro_background这两项对应的url替换为类似 file:///android_asset/image/metro/1486957299411.png 这种assets文件地址，并且要确保这两种图片放到了assets/image/metro目录中。
这部分完成后最好做 pm clear 并断网测试，看看主界面是否正常。

## 编译与渠道包相关
打渠道包使用了github上开源的packer-ng-plugin打包工具，项目地址 https://github.com/mcxiaoke/packer-ng-plugin 。 使用方式比较简单，已经写好了运行脚本，对应的渠道、channels配置文件以及生成apk目录如下：

| 脚本名称 | 渠道 | channels配置文件 | 生成apk目录 |
| --- | --- | --- | --- |
| apk.sh | 普通渠道 | channels/channels.txt | build/apks/ |
| dbapk.sh | 当贝渠道 | channels/db_channels.txt | build/dbapks/ |
| cibnapk.sh | cibn渠道 | channels/cibn_channels.txt | build/cibnapks/ |

## 编译运营布局验证包
客户端的布局请求文件`MetroApi:requestMetroConfig()`中的URL用代码替换成测试用的URL： "http://cdn.video.51togic.com/v1/test_layouts/589a9232d6ff7ca3789d7021?resolution=1080"

## Leanback库的使用
Leanback官方参考示例：
https://github.com/googlesamples/androidtv-Leanback
https://github.com/googlesamples/leanback-showcase

使用教程可以参考下面这个博客系列：
http://corochann.com/android-tv-application-hands-on-tutorial-1-45.html
由于Leanback只能兼容到5.0之后的版本，而我们的应用最低要支持到4.0，所以原始的Leanback-17-support库是不能直接拿来用的。为此我们做了一个向前兼容的版本，基本功能可用

https://github.com/fengdianzhang/V14-Leanback

## 关于图片库
图片库统一使用Glide V4.0.0。由于项目特殊需求，对Glide库进行了定制。如果要对Glide库升级，需要修改以下定制的地方：

GifDrawable中增加了一个GifPlayListener，用于监听动画最后一帧是否播放完毕。
按crtl+H, 搜索 modify by huanglin。一共有4处修改。升级Glide时需要把对应的地方也修改。

## 关于信鸽
接入信鸽主要用于：格子更新和主界面布局更新。所有推送的代码都在com.togic.common.XGPush包下面。由于信鸽sdk之前会出现设备收不到推送消息的问题，就没上。如果要重新接入，可以：

参考信鸽官网接入流程。所有代码都已经调通测试过，只需要更换sdk和更新Manifest文件。
格子更新和布局更新实现的地方可以去找XGMsgDispatcher的OnXGMessageReceivedListener的实现类。

## 关于统计
统计上传的格式如下：
```json
{   
    "version_name": "4.1.6",  // 版本
    "stat_id": "56373f05a3107987ddb6764f",  //统计id，服务端通过这个id来存储数据以及计算相应的统计项
    "install_channel": "cibn",    //安装渠道
    "isp": "电信",
    "device_id": "5785e1249887d7e7cf4d443daaeb047ff95e8f717b77a025",   //设备id，通过这个id来区分用户
    "enter_time": 1511265566479,
    "version_code": "115",   //版本号
    "os_version": "4.4.2",    //android版本
    "city": "深圳",
    "device_model": "we20s",  
    "province": "广东",
    "time_stamp": 1511265566479，
    *****  //其他统计字段
}
```
具体流程：

    前端根据不同的业务将需要统计的数据以Map<String,Object>格式生成统计事件，然后将生成好的完整事件通过aidl接口public void onSessionEvent(Map event)传递到BackendService。
    BackendService的DataStatisticsManager服务会将事件缓存到statistic.db并按一定的逻辑上传到服务器（具体逻辑参考StatisticAgent.java）。

## 插件打包与更新
1. 在项目MediaTube执行gradlew buildPlugin打包插件，打包好的插件会保存在MediaTube/TogicVideo/build/outputs/plugins目录(细节参看plugins.gradle)
2. 替换本地对应的插件文件，目前客户端只保留了统计和广告过滤两个插件。替换流程如下

统计插件：
    
    1.拷贝插件文件：cp TogicVideo/build/outputs/plugins/Statistic.jar TogicVideo/src/main/res/raw/statistic.jpg
      2.更改TogicVideo/src/main/assets/plugin_list.json本地配置文件
       {
       "name": "togic_statistic_agent",
       "version": {
           "StatisticAgent.jar": 22    // 一般只需要修改版本号，配置一个比本地配置和服务器发布的版本更大的版本号
       },
       "default": {
           "name": "DefaultStatisticAgent.jar",    //另存为文件名
           "dir": "common",     //保存目录（/itemData/itemData/com.togic.livevideo/app_common）
           "file": "statistic",     //读取文件(assets/statistic.jpg)
           "class": "com.togic.plugincenter.misc.statistic.old.plugin.StatisticAgent"
       }
    }

广告过滤插件：
   
    1.拷贝插件文件：cp TogicVideo/build/outputs/plugins/AdFilter.jar TogicVideo/src/main/res/raw/ad_filter.jpg 
    2..更改TogicVideo/src/main/assets/plugin_list.json本地配置文件
    {
       "name": "ad_filter",
       "version": {
           "AdFilter.jar": 4 //一般只需要修改版本号，配置一个比本地配置和服务器发布的版本更大的版本号
       },
       "default": {
           "name": "AdFilter.jar",
           "dir": "video",
           "file": "ad_filter",
           "class": "com.togic.plugincenter.filter.impl.AdFilter"
       }
    },
    
插件发布参看“插件相关”