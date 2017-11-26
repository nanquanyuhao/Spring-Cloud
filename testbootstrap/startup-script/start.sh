# 在安装docker工具的主机上运行svn容器即可
docker run --name some-svn-server \
           --detach \
           --volume /home/nanquanyuhao/docker/svn/data:/var/opt/svn \
           --publish 3690:3690 \
           garethflowers/svn-server
# 创建测试的文件仓库
docker exec -it some-svn-server svnadmin create config-project
# 进入对应仓库目录下调整相关文件至，参考目录中其他文件，最终即可正常使用
docker exec -it some-svn-server sh
cd /var/opt/svn/config-project/conf