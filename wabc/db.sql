-- 用户地理位置信息记录表
create table user_location(
	id int not null auto_increment primary key,	-- id
	open_id varchar(50) not null,				-- openid
	lng varchar(30) not null,					-- 经度
	lat varchar(30) not null,					-- 纬度
	bd09_lng varchar(30),						-- 转换后的经度
	bd09_lat varchar(30)						-- 转换后的纬度
);

-- 猜数字游戏
-- 游戏信息表
create table game(
	game_id int not null auto_increment primary key comment '游戏id',
	open_id varchar(50) not null comment '用户的openID',
	game_answer varchar(4) not null comment '猜数字游戏的正确答案',
	create_time varchar(20) not null comment '游戏创建时间',
	game_status int not null comment '游戏状态(0:游戏中 1：胜利 2：失败)',
	finish_time varchar(20) comment '游戏完成时间'
) comment='猜数字游戏的每一局';

-- 游戏回合信息表
create table game_round(
	id int not null auto_increment primary key comment '主键id',
	game_id int not null comment '游戏id',
	open_id varchar(50) not null comment '用户的openID',
	guess_number varchar(4) not null comment '用户猜测是数字',
	guess_time varchar(20) not null comment '用户猜测是时间',
	guess_result varchar(4) not null comment '用户猜测的结果,即xAyB',
	FOREIGN KEY(game_id) REFERENCES game(game_id) on delete cascade on update cascade
) comment='猜数字游戏的每一回合';