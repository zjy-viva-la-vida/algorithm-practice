

**1、找到ip所属区域**

http.log：用户访问网站所产生的日志。日志格式为：时间戳、IP地址、访问网址、访问数据、浏览器信息等

ip.dat：ip段数据，记录着一些ip段范围对应的位置

文件位置：data/http.log、data/ip.dat

~~~
# http.log样例数据。格式：时间戳、IP地址、访问网址、访问数据、浏览器信息
20090121000132095572000|125.213.100.123|show.51.com|/shoplist.php?phpfile=shoplist2.php&style=1&sex=137|Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Mozilla/4.0(Compatible Mozilla/4.0(Compatible-EmbeddedWB 14.59 http://bsalsa.com/ EmbeddedWB- 14.59  from: http://bsalsa.com/ )|http://show.51.com/main.php|

# ip.dat样例数据
122.228.96.0|122.228.96.255|2061787136|2061787391|亚洲|中国|浙江|温州||电信|330300|China|CN|120.672111|28.000575
~~~

要求：将 http.log 文件中的 ip 转换为地址。如将 122.228.96.111 转为 温州，并统计各城市的总访问量



**2、日志分析**

日志格式：IP	命中率(Hit/Miss)	响应时间	请求时间	请求方法	请求URL	请求协议	状态码	响应大小referer 用户代理

日志文件位置：data/cdn.txt

~~~
100.79.121.48 HIT 33 [15/Feb/2017:00:00:46 +0800] "GET http://cdn.v.abc.com.cn/videojs/video.js HTTP/1.1" 200 174055 "http://www.abc.com.cn/" "Mozilla/4.0+(compatible;+MSIE+6.0;+Windows+NT+5.1;+Trident/4.0;)"
~~~

术语解释：

PV(page view)，即页面浏览量；衡量网站或单一网页的指标

uv(unique visitor)，指访问某个站点或点击某条新闻的不同IP地址的人数

任务：

2.1、计算独立IP数

2.2、统计每个视频独立IP数（视频的标志：在日志文件的某些可以找到 *.mp4，代表一个视频文件）

2.3、统计一天中每个小时的流量



**3、Spark面试题**

假设点击日志文件(click.log)中每行记录格式如下：

~~~
INFO 2019-09-01 00:29:53 requestURI:/click?app=1&p=1&adid=18005472&industry=469&adid=31
INFO 2019-09-01 00:30:31 requestURI:/click?app=2&p=1&adid=18005472&industry=469&adid=31
INFO 2019-09-01 00:31:03 requestURI:/click?app=1&p=1&adid=18005472&industry=469&adid=32
INFO 2019-09-01 00:31:51 requestURI:/click?app=1&p=1&adid=18005472&industry=469&adid=33
~~~

另有曝光日志(imp.log)格式如下：

~~~
INFO 2019-09-01 00:29:53 requestURI:/imp?app=1&p=1&adid=18005472&industry=469&adid=31
INFO 2019-09-01 00:29:53 requestURI:/imp?app=1&p=1&adid=18005472&industry=469&adid=31
INFO 2019-09-01 00:29:53 requestURI:/imp?app=1&p=1&adid=18005472&industry=469&adid=34
~~~

3.1、用Spark-Core实现统计每个adid的曝光数与点击数，将结果输出到hdfs文件；

输出文件结构为adid、曝光数、点击数。注意：数据不能有丢失（存在某些adid有imp，没有clk；或有clk没有imp）

3.2、你的代码有多少个shuffle，是否能减少？

（提示：仅有1次shuffle是最优的）



**4、使用鸢尾花数据集实现KNN算法**



**5、使用鸢尾花数据集实现KMeans算法**

备注：

- 4、5的详细说明请参考视频说明
- 文件位置：data/Iris.csv
- 请按视频说明在原始数据集的基础上组织文件



6、A表有三个字段：ID、startdate、enddate，有3条数据：

~~~
1 2019-03-04 2020-02-03
2 2020-04-05 2020-08-04
3 2019-10-09 2020-06-11
~~~

写SQL（需要SQL和DSL）将以上数据变化为：

~~~
2019-03-04	2019-10-09
2019-10-09	2020-02-03
2020-02-03	2020-04-05
2020-04-05	2020-06-11
2020-06-11	2020-08-04
2020-08-04	2020-08-04
~~~

