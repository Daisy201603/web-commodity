/*
5.5.29 MySQL Community Server : Database - gdatabase
Author gdx
*********************************************************************


/*Data for the table `items` */

insert  into items(`id`,`name`,`price`,`detail`,`pic`,`createtime`) values (1,'显示器',3000.0,'无边框',NULL,'2017-03-22 13:22:53'),(2,'处理器',6000.0,'四核心四线程',NULL,'2017-03-22 13:22:57'),(3,'主板',200.0,'接口丰富',NULL,'2015-02-06 13:23:02'),(4,'显卡',200.0,'征服各大主流单机游戏',NULL,'2015-02-06 13:23:02');

/*Data for the table `orderdetail` */

/*insert  into `orderdetail`(`id`,`orders_id`,`items_id`,`items_num`) values (1,3,1,1),(2,3,2,3),(3,4,3,4),(4,4,2,3);*/

/*Data for the table `orders` */

/*insert  into `orders`(`id`,`user_id`,`number`,`createtime`,`note`) values (3,1,'1000010','2015-02-04 13:22:35',NULL),(4,1,'1000011','2015-02-03 13:22:41',NULL),(5,10,'1000012','2015-02-12 16:13:23',NULL);*/

/*Data for the table `user` */

/*insert  into `user`(`id`,`username`,`birthday`,`sex`,`address`) values (1,'王五',NULL,'2',NULL),
                                                                       (10,'张三','2014-07-10','1','北京市'),
                                                                       (16,'张小明',NULL,'1','河南郑州'),
                                                                       (22,'陈小明',NULL,'1','河南郑州'),
                                                                       (24,'张三丰',NULL,'1','河南郑州'),
                                                                       (25,'陈小明',NULL,'1','河南郑州'),
                                                                       (26,'王五',NULL,NULL,NULL);*/
SELECT * FROM items;


