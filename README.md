# HOW TO USE

## 1 数据库初始化

```sql
create space basketballplayer(partition_num=10,replica_factor=1,vid_type=fixed_string(32));
CREATE TAG IF NOT EXISTS player(name string, age int);
CREATE EDGE IF NOT EXISTS follow(degree int);
create tag index player_index_0 on player();
create tag index player_index_1 on player(name(20));
```


## 2 修改配置文件

修改nebula链接，用户，密码

# ATTENTION

目前驱动支持nebula 2.5.0版本

支持mybatis xml (resultType|resultMap)，sql语句return (v|e)

demo提供基础点边操作以及路径查询

mybatis返回结果不支持包含多tag


# dao代码生成插件

https://plugins.jetbrains.com/plugin/18026-nebula-generator


