# CPT202_Group_6
XJTLU Year 3 Software Engineering Group Project CPT202 Project.

# Group Members:

# Currenct Overview
原始骨架依据于视频“From PBI to Coding”，项目与视频进度同步到了1：00：25：model，repository，controller均已创建并通过Postman的GET测试代码及配置可行性：Request Status 200

# TODO
1. Fork项目的main branch到自己的repo，使用git或github desktop克隆到本地，再使用IDE打开克隆的文件夹
2. 本地测试代码是否可用（测试本地数据库，jdk等）：
  1. 先打开本地数据库（Mac与视频里一致，Win可在任务管理器的服务中找到MySql并启动）
  2. 同视频中创建新scheme：命名为sport_centre
  3. 编辑项目中的application.properties中的password为自己数据库的密码
  4. 启动项目
  5. 使用postman或类似软件GET：http://localhost:8080/api/test 如果返回200则配置成功

# Need to know
* application.properties中需要复制的Spring boot配置文件并未复制完，还差ppt中的后面4条
