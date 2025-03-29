create table if not exists yupi.user
(
    id           bigint auto_increment comment 'id'
        primary key,
    username     varchar(255)                       null comment '用户昵称',
    userAccount  varchar(255)                       null comment '账号',
    avatarUrl    varchar(1024)                      null comment '头像',
    gender       tinyint                            null comment '性别',
    userPassword varchar(255)                       not null comment '密码',
    phone        varchar(50)                        null comment '手机号',
    email        varchar(255)                       null comment '电子邮箱',
    userStatus   int      default 0                 null comment '用户状态',
    createTime   datetime default CURRENT_TIMESTAMP null comment '创建时间',
    updateTime   datetime default CURRENT_TIMESTAMP null comment '更改时间',
    isDelete     tinyint  default 0                 not null comment '是否删除',
    userRole     int      default 0                 not null comment '用户身份_0-普通用户_1-管理员',
    planetCode   varchar(512)                       null comment '星球编号',
    tags         varchar(1024)                      null comment '标签列表json'
)
    comment '用户';
