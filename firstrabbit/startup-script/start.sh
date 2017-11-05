# 在安装docker工具的主机上运行RabbitMq工具即可
docker run -d --hostname my-rabbit --name some-rabbit -p 4369:4369 -p 15671:15671 -p 25672:25672 -p 15672:15672 -p 5671:5671 -p 5672:5672 rabbitmq:3-management