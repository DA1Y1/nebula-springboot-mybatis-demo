# HOW TO USE

## 1 数据库初始化

```sql
CREATE TAG IF NOT EXISTS player(name string, age int);

CREATE EDGE IF NOT EXISTS follow(degree int);

```


## 2 修改配置文件

修改nebula链接，用户，密码

# ATTENTION

1.目前驱动支持nebula2.5.0版本

2.支持mybatis（resultType，resultMap）

3.图数据库查询支持点边操作以及路径查询

# dao代码生成插件

https://plugins.jetbrains.com/plugin/18026-nebula-generator


