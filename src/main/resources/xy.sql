create table cj_securityorderlist(
 id varchar(200) PRIMARY KEY comment '主键',
 accountNo varchar(2000) default '' comment '资金账号',
 cjsj datetime comment '成交时间',
 code varchar(2000) default '' comment '证券代码',
 combPositionId varchar(2000) default '' comment '组合持仓编号',
 side varchar(2000) default '' comment '买卖方向',
 cjsl int default 0 comment '成交数量',
 cjjj int default 0 comment '成交均价',
 cjbh varchar(2000) default '' comment '成交编号',
 qsday datetime comment '清算日期',
 exchange varchar(2000) default '' comment '交易所',
 htbh varchar(2000) default '' comment '合同编号',
 stockName varchar(2000) default '' comment '合约名称',
 updateTime datetime comment '修改时间',
 createTime datetime comment '创建时间',
 cjType varchar(2000) default '' comment '成交类型',
 unit int default 0 comment '合约乘数'
)ENGINE=InnoDB DEFAULT CHARSET=utf8