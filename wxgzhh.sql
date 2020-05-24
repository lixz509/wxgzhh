-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: wxgzhh
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `store_classify`
--

DROP TABLE IF EXISTS `store_classify`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_classify` (
  `classify_id` varchar(36) NOT NULL,
  `classify_name` varchar(255) DEFAULT NULL,
  `classify_image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`classify_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_classify`
--

LOCK TABLES `store_classify` WRITE;
/*!40000 ALTER TABLE `store_classify` DISABLE KEYS */;
INSERT INTO `store_classify` VALUES ('classify1','女装','http://127.0.0.1:8090/store/classify/classify1.jpg'),('classify2','男装','http://127.0.0.1:8090/store/classify/classify2.jpg'),('classify3','手机数码','http://127.0.0.1:8090/store/classify/classify3.jpg'),('classify4','生鲜水果','http://127.0.0.1:8090/store/classify/classify4.jpg'),('classify5','家具建材','http://127.0.0.1:8090/store/classify/classify5.jpg'),('classify6','医疗保健','http://127.0.0.1:8090/store/classify/classify6.jpg'),('classify7','零食茶酒','http://127.0.0.1:8090/store/classify/classify7.jpg'),('classify8','图书音像','http://127.0.0.1:8090/store/classify/classify8.jpg');
/*!40000 ALTER TABLE `store_classify` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_commodity`
--

DROP TABLE IF EXISTS `store_commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_commodity` (
  `commodity_id` varchar(36) NOT NULL,
  `monthly_sales` varchar(255) DEFAULT NULL,
  `classify_id` varchar(36) DEFAULT NULL,
  `commodity_intro` varchar(255) DEFAULT NULL,
  `commodity_name` varchar(255) DEFAULT NULL,
  `commodity_num` varchar(255) DEFAULT NULL,
  `commodity_state` varchar(255) DEFAULT NULL,
  `commodity_surplus` varchar(255) DEFAULT NULL,
  `discount` varchar(255) DEFAULT NULL,
  `original_price` varchar(255) DEFAULT NULL,
  `particulars_url` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `show_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`commodity_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_commodity`
--

LOCK TABLES `store_commodity` WRITE;
/*!40000 ALTER TABLE `store_commodity` DISABLE KEYS */;
INSERT INTO `store_commodity` VALUES ('commodity1','10','classify8','24核处理器 3G大运行内存 万元配置','2020新款手机投影仪一体机家用小型迷你wifi微型无线3D家庭影院投墙上超便携式高清4K激光看电影掌上电视宿舍','1000','IS_NORMAL','555','7','8888','http://127.0.0.1:8090/store/a.jpg;','2998.00',NULL),('commodity2','15','classify5','食全十美 分区精储 99.99%抗菌 一级能效','容声 BCD-432WD12FPA十字四门对开官方家用冰箱一级节能变频无霜','1300','IS_NORMAL','737','6','7979','http://127.0.0.1:8090/store/b.jpg;','4599.00',NULL),('commodity3','17','classify5','座面耐用10年 旋转耐用10年 欧盟环保标准','AutoFull傲风电竞椅游戏椅家用舒适座椅老板椅升降椅子靠背电脑椅','1100','IS_NORMAL','659','2','6669','http://127.0.0.1:8090/store/c.jpg;','1048.00',NULL),('commodity4','35','classify3','运动有范 无惧汗水','B&O Beoplay H5 蓝牙耳机 无线蓝牙挂脖式bo苹果运动耳机入耳式','1200','IS_NORMAL','998','1','9998','http://127.0.0.1:8090/store/d.jpg;','998.00 ',NULL),('commodity5','6','classify2','牛皮材质，防盗刷，多卡位，大容量','真皮男士钱包防消磁多卡位大容量长款卡包男多功能防盗刷钱夹皮夹','900','IS_NORMAL','830','5','460','http://127.0.0.1:8090/store/e.jpg;','229.00',NULL);
/*!40000 ALTER TABLE `store_commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_dialogue`
--

DROP TABLE IF EXISTS `store_dialogue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_dialogue` (
  `dialogue_id` varchar(36) NOT NULL,
  `dialogue_text` varchar(255) DEFAULT NULL,
  `dialogue_time` datetime DEFAULT NULL,
  `reception_id` varchar(36) DEFAULT NULL,
  `send_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`dialogue_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_dialogue`
--

LOCK TABLES `store_dialogue` WRITE;
/*!40000 ALTER TABLE `store_dialogue` DISABLE KEYS */;
INSERT INTO `store_dialogue` VALUES ('dialogue1','你好啊',NULL,'user1','user2'),('dialogue2','你就是客服吗',NULL,'user1','user2'),('dialogue3','你好',NULL,'user2','user1'),('dialogue4','是的',NULL,'user2','user1'),('dialogue5','我测试下打多点字试试啊，啊啊啊啊啊啊啊啊啊啊啊啊啊',NULL,'user1','user2'),('dialogue6','好的，没问题',NULL,'user2','user1'),('dialogue7','这边打多些字的效果。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。',NULL,'user2','user1');
/*!40000 ALTER TABLE `store_dialogue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_hot_sale`
--

DROP TABLE IF EXISTS `store_hot_sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_hot_sale` (
  `hot_sale_id` varchar(36) NOT NULL,
  `commodity_id` varchar(36) DEFAULT NULL,
  `hot_sale_state` varchar(255) DEFAULT NULL,
  `hot_sale_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`hot_sale_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_hot_sale`
--

LOCK TABLES `store_hot_sale` WRITE;
/*!40000 ALTER TABLE `store_hot_sale` DISABLE KEYS */;
INSERT INTO `store_hot_sale` VALUES ('hotsale1','commodity1','IS_SLIDESHOW','7'),('hotsale2','commodity2','IS_SLIDESHOW','7'),('hotsale3','commodity3','IS_SLIDESHOW','7'),('hotsale4','commodity4','IS_SLIDESHOW','7'),('hotsale5','commodity5','IS_SLIDESHOW','7'),('hotsale6','commodity1','IS_HOTSALE','7'),('hotsale7','commodity2','IS_HOTSALE','7'),('hotsale8','commodity3','IS_HOTSALE','7'),('hotsale9','commodity4','IS_HOTSALE','7');
/*!40000 ALTER TABLE `store_hot_sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_logistics`
--

DROP TABLE IF EXISTS `store_logistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_logistics` (
  `logistics_id` varchar(36) NOT NULL,
  `consignee_id` varchar(36) DEFAULT NULL,
  `consigner_id` varchar(36) DEFAULT NULL,
  `logistics_status` varchar(255) DEFAULT NULL,
  `ship_address` varchar(255) DEFAULT NULL,
  `ship_time` datetime DEFAULT NULL,
  `shipping_address` varchar(255) DEFAULT NULL,
  `shipping_time` datetime DEFAULT NULL,
  `order_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`logistics_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_logistics`
--

LOCK TABLES `store_logistics` WRITE;
/*!40000 ALTER TABLE `store_logistics` DISABLE KEYS */;
INSERT INTO `store_logistics` VALUES ('logistics1','user2','user1','IS_UNRECEIPTED','广东',NULL,'广西',NULL,'order1'),('logistics2','user2','user1','IS_RECEIPTED','广东',NULL,'广西',NULL,'order2');
/*!40000 ALTER TABLE `store_logistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_order`
--

DROP TABLE IF EXISTS `store_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_order` (
  `order_id` varchar(36) NOT NULL,
  `commodity_id` varchar(36) DEFAULT NULL,
  `order_status` varchar(255) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `total_price` varchar(255) DEFAULT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_order`
--

LOCK TABLES `store_order` WRITE;
/*!40000 ALTER TABLE `store_order` DISABLE KEYS */;
INSERT INTO `store_order` VALUES ('order1','commodity1','IS_RECEIVING',NULL,'2998.00','user2'),('order2','commodity2','IS_RECEIVING',NULL,'4599.00','user2'),('order3','commodity3','IS_PAYMENT',NULL,'1048.00','user2'),('order4','commodity4','IS_SHIPMENTS',NULL,'998.00 ','user2'),('order5','commodity5','IS_EVALUATE',NULL,'229.00','user2');
/*!40000 ALTER TABLE `store_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_shopping_trolley`
--

DROP TABLE IF EXISTS `store_shopping_trolley`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_shopping_trolley` (
  `shopping_trolley_id` varchar(36) NOT NULL,
  `commodity_id` varchar(36) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `purchase_quantity` varchar(255) DEFAULT NULL,
  `user_id` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`shopping_trolley_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_shopping_trolley`
--

LOCK TABLES `store_shopping_trolley` WRITE;
/*!40000 ALTER TABLE `store_shopping_trolley` DISABLE KEYS */;
INSERT INTO `store_shopping_trolley` VALUES ('shoppingtrolley1','commodity1','2998.00','1','user2'),('shoppingtrolley2','commodity2','4599.00','1','user2');
/*!40000 ALTER TABLE `store_shopping_trolley` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `store_user`
--

DROP TABLE IF EXISTS `store_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `store_user` (
  `user_id` varchar(36) NOT NULL,
  `balance` varchar(255) DEFAULT NULL,
  `id` varchar(36) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `portrait` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `store_user`
--

LOCK TABLES `store_user` WRITE;
/*!40000 ALTER TABLE `store_user` DISABLE KEYS */;
INSERT INTO `store_user` VALUES ('user1','0','1','广东','123456','http://127.0.0.1:8090/store/portrait/1.jpg;','用户1','IS_NORMAL'),('user2','50','379af817-e4f2-40d3-86ab-908e59626342','广西','123456','http://127.0.0.1:8090/store/portrait/2.jpg;','用户2','IS_NORMAL');
/*!40000 ALTER TABLE `store_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wx_user`
--

DROP TABLE IF EXISTS `wx_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wx_user` (
  `id` varchar(36) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `group_id` varchar(255) DEFAULT NULL,
  `headimgurl` varchar(255) DEFAULT NULL,
  `language` varchar(255) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `open_id` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `qr_scene` varchar(255) DEFAULT NULL,
  `qr_scene_str` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `sub_time` datetime DEFAULT NULL,
  `subscribe` varchar(255) DEFAULT NULL,
  `subscribe_scene` varchar(255) DEFAULT NULL,
  `subscribe_time` bigint(20) NOT NULL,
  `union_id` varchar(255) DEFAULT NULL,
  `unsub_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wx_user`
--

LOCK TABLES `wx_user` WRITE;
/*!40000 ALTER TABLE `wx_user` DISABLE KEYS */;
INSERT INTO `wx_user` VALUES ('379af817-e4f2-40d3-86ab-908e59626342','','Bermuda','0','http://thirdwx.qlogo.cn/mmopen/kFE8YXLLLicxFqsIPWQSEn16bpsXeSFORbHLBFUCHhsApoN1A1tCqeqeG4RCNIgk8WELaZ7nWbQQ1eOCpPyggCSHIPuAeqp5x/132','zh_CN',' ','ol4v51f4fm5YZTOyhbuZs36Fgxw4','','0','','','1','IS_SUBSCRIBE',NULL,'1','ADD_SCENE_PROFILE_CARD',1577436474,NULL,NULL);
/*!40000 ALTER TABLE `wx_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'wxgzhh'
--

--
-- Dumping routines for database 'wxgzhh'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-24 18:33:33
