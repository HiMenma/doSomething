# OpenCore升级过程

## 一、准备最新的OC安装包

[点击下载]: https://github.com/acidanthera/OpenCorePkg

## 二、解压并对比之前的EFI文件

1.将相应的驱动复制到相应文件夹

![EFI文件格式](https://tva1.sinaimg.cn/large/008eGmZEly1gndqgvx66tj31an0gtdm5.jpg)

注意：
		1.ACPI文件最好使用新OC文件夹里的
		2.Drivers文件夹的文件使用新版本OC里的文件，否则可能报错。
		3.Kexts文件夹的Lilu、VirtualSMC、WhateverGreen使用最新的驱动；没有的直接复制过去。

## 三、使用ProperTree或者OCC编辑config.plist

### 1.下载地址

[ProperTree]: https://github.com/corpnewt/ProperTree
[OCC]: https://mackie100projects.altervista.org/download-opencore-configurator/

### 2.先用ProperTree打开config.plist创建快照

1.点击创建快照

![点击创建快照](https://tva1.sinaimg.cn/large/008eGmZEly1gndqgzir0oj308j0bxdif.jpg)
2.浏览到OC文件夹
![浏览到OC文件夹](https://tva1.sinaimg.cn/large/008eGmZEly1gndqh2bp2oj30kf0b4jst.jpg)

### 3.使用OCC对照旧config编辑新的config

注意：
	1.使用对应版本的OCC编辑相应文件
	2.新版的多出来的选项保持默认，其他和旧文件保持一样(每一项都要核对保持一致)
![image-20210206131333044](https://tva1.sinaimg.cn/large/008eGmZEly1gndqm9h7yzj30zm0icaf4.jpg)

## 四、挂载分区，替换EFI文件

可能出现的问题：
1.OC无法引导：需要进BIOS设置启动顺序
2.

[其他常见问题点击]: http://imacos.top/2021/01/19/0154/

3.参考链接：https://blog.daliansky.net/OpenCore-BootLoader.html