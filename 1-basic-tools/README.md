# Basic Tools

## Preparation

- 前置条件

请确保已经安装JDK 7、IntelliJ IDEA，并且IntelliJ IDEA已经安装Scala插件。

- 安装Git

从以下地址下载Git安装包并安装。
http://3ms.huawei.com/hi/group/2032191/file_4844017.html?for_statistic_from=my_group_file

- 安装sbt

从以下地址下载压缩包解压，安装sbt-0.13.8.msi。
http://3ms.huawei.com/hi/group/2032191/file_4843991.html?for_statistic_from=my_group_file

- 配置sbt

因为sbt默认使用公网仓库下载依赖，为了能在内网使用，需要更改sbt的仓库配置。
将上一步解压出来的repositories文件放到%USERPROFILE%\.sbt目录下，%USERPROFILE%为用户HOME目录。比如把repositories文件复制到C:\Users\qwx286961\.sbt
注意，如果没有.sbt目录请新建一个。

- 运行sbt

第一次运行sbt会自动下载sbt需要的JAR文件，如果出现类似下面的提示说明配置成功

```
[info] Set current project to qwx286961 (in build file:/C:/Users/qwx286961/)
>
```
