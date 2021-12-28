# Docker安装Typecho

## #缘起

前几天看到甲骨文服务器白嫖的活动，再加上之前注册的域名备案过期了，想着直接甲骨文境外的服务器搭建博客。之前用过typecho ,再加上为了博客的迁移，决定博客的搭建全部.使用docker进行部署。

## #安装docker

参照docker的官方文档:https://docs docker. com/engine/install/选择合适的平台进行安装，若服务器在国内，将docker的镜像修改为国内镜像,修改/ect/ docker/daemon. json文件加上如下键值:

```json
{
  "registry-mirrors": ["https://registry.docker-cn.com"]
}
```

## #安装docker-compose

因为typecho需要ng inx (或者apache, caddy等webserver),php和mysq1才能运行，因此我们需要至少3个镜像，为了方便管理，我们这里用docker - compose来进行管理，官方安装教程见https://docs.docker.com/compose/install/

## #构建php镜像

由于官方的php镜像中没有安装pdo_ msyq|扩展，因此需要因此我们需要自行构建一个带有pdo_ mysql的PHP镜像，使用Dockerfile如下进行构建:

```dockerfile
`FROM php:7 .2.3- fpm`
`MAINTANER scofield<mail@pjf . name>`
`RUN apt-get update`
`RUN docker-php-ext-install pdo_ mysql`
```

执行命令`docker build -t himenma/php:7.2. 3- fpm`进行构建，构建完毕后执行`docker images Igrephimenma/php:7.2.3- fpm`如果不为空即为构建成功

## #部署和运行typecho

新建一个app文件夹,在此文件夹中准备以下文件:

```txt
app文件夹下
-docker-compose . yml
-mysq1 (mysq1文件夹，用来存放mysq1数据， 方便
-mysq1. env (mysq1镜像的环境)
-typecho. conf (nginx配置文件)
-typecho(typecho的安装文件，github下 下载即
```

其中mysq1. env文件内容为:

```mysql
# MySQL的root用户默认密码，这里自行更改
MYSQL_ROOT_PASSWORD=xxx
# MySQL镜像创建时自动创建的数据库名称
MYSQL_DATABASE=xxx
# MySQL镜像创建时自动创建的用户名
MYSQL_USER=xxx
# MySQL镜像创建时自动创建的用户密码
MYSQL_PASSWORD=xxx
```

其中typecho. conf的内容为:

```nginx
server {
    listen 0.0.0.0:80;
    server_name blog.himenma.top;
    root /app;
    index index.php;

    access_log  /var/log/nginx/typecho_access.log  main;
    if (!-e $request_filename){
        rewrite ^(.*)$ /index.php$1 last;
    }

    location ~ .*\.php(\/.*)*$ {
       include        fastcgi_params;
       fastcgi_param  PATH_INFO $fastcgi_path_info;
       fastcgi_param  PATH_TRANSLATED $document_root$fastcgi_path_info;
       fastcgi_param  SCRIPT_NAME        $fastcgi_script_name;
       fastcgi_param  SCRIPT_FILENAME    $document_root$fastcgi_script_name;
       fastcgi_index  index.php;
       fastcgi_split_path_info ^(.+?.php)(/.*)$; 
       fastcgi_pass   php-fpm:9000;
    }
}
```

其中docker -compose . yml的内容为:

```yaml
version: '2'
services:
  nginx:
    image: nginx:latest
    ports:
      - "80:80"
    restart: always
    volumes:
      - ./typecho:/app
      - ./typecho.conf:/etc/nginx/conf.d/default.conf
      - logs:/var/log/nginx
    links:
      - php-fpm
    depends_on:
      - php-fpm
  php-fpm:
    image: himenma/phpforblog:7.2.3-fpm
    restart: always
    volumes:
      - ./typecho:/app
    links:
      - db
    depends_on:
      - db
  db:
    image: mysql:5.7.21
    restart: always
    ports:
      - 0.0.0.0:13306:3306
    volumes:
      - ./mysql:/var/lib/mysql
      - logs:/var/logs/mysql
    env_file:
      - mysql.env
volumes:
  logs:
```

然后执行docker-compose up -d,然后浏览器输入域名或者服务器IP即可进行访问

## #其他

- 若要迁移，直接将整个app打包迁移到新的服务器，解压后在重新构建php镜像和使用docerk-compose up - a部署docker服务即可

- 若出现出现服务部署失败，则重启整个docker服务: systemctl restart docker

- nginx镜像本来用的是nginx:alpine,但是总是炸掉，日志还没有显示，改成nginx:latest，虽然体积大了一点。