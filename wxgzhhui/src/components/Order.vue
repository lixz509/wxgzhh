<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
/* 顶部搜索框 */
.orderHeader {
  position: fixed;
  z-index: 10;
  top: 0vw;
  height: 60px;
  width: 100vw;
}
.retreat {
  position: absolute;
  top: 15px;
  left: 15px;
  width: 30px;
  height: 30px;
}
.orderText {
  position: absolute;
  top: 8px;
  left: 60px;
  width: calc(100vw - 170px);
  height: 40px;
  z-index: 1;
  border-radius: 10px;
  padding-left: 20px;
  border:black solid 1px;
  font-size: 3vw;
}
.orderSearch{
  position: absolute;
  top: 8px;
  right: 15px;
  width: 60px;
  height: 40px;
  background-color: #F0F8FF;
  border:black solid 1px;
  font-size: 20px;
  border-radius: 10px;
}
/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
/* 订单选项卡 */
.orderType{
  position:fixed;
  top: 60px;
  z-index: 10;
  height: 10vw;
  width: 100vw;
}
.orderType ul {
  width: 100%;
  display: flex;
  list-style: none;
  padding: 0;
  margin: 0;
  font-size: 4vw;
  line-height: 10vw;
}
.orderType ul li {
  flex: 1;
  margin: 0 1vw;
  text-align: center;
  cursor: pointer;
}
/* 订单列表 */
.orderList{
  position: relative;
  width: 100vw;
  /* background-color: bisque; */
}
.myOrder{
  position: relative;
  width: 100vw;
  height: 30vw;
  margin: 1vw 0vw;
  background-color: #fff;
  border-radius: 5vw;
}
.myOrder img{
  position: absolute;
  top: 2vw;
  left: 2vw;
  width: 20vw;
  height: 20vw;
}
.myOrderName{
  position: absolute;
  top: 8vw;
  left: 24vw;
  width: 74vw;
  font-size: 3vw;
  display: -webkit-box;
  overflow: hidden;
  height: 7vw;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
}
.myOrderState{
  position: absolute;
  top: 2vw;
  right: 6vw;
  font-size: 2.7vw;
}
.myOrderNum{
  position: absolute;
  top: 16vw;
  right: 6vw;
  font-size: 3vw;
}
.myOrderBtn{
  position: absolute;
  top: 20vw;
  left: 24vw;
  height: 5vw;
  width: 15vw;
  background-color: #fff;
  border:#2E8B57 solid 1px;
  border-radius: 5vw;
}
/* 订单价格 */
.orderSellingPrice{
  position: absolute;
  left: 65vw;
  top: 16vw;
  width: 20vw;
  font-size: 3vw;
}
.orderOriginalPrice{
  display: inline-block;
  color: gray;
  font-size: 2.7vw;
  text-decoration: line-through;
}
.myOrderPrice{
  position: absolute;
  left: 76vw;
  top: 22vw;
  font-size: 4vw;
}
</style>

<template>
  <div id="order">
    <div id="vacancy" style="height: calc(60px + 10vw)"></div>
    <div class="orderHeader">
      <img class="retreat" @click="retreat" src="../../static/icon/retreat.png" />
      <input type="text" class="orderText"  placeholder="搜索我的订单" />
      <input type="button" class="orderSearch" value="搜索"/>
    </div>
    <div class="orderType">
      <ul>
        <li style="border-bottom: #FF0000 2px solid;">全部</li>
        <li>待付款</li>
        <li>待发货</li>
        <li>待收货</li>
        <li>待评价</li>
      </ul>
    </div>
    <div class="orderList">
      <div class="myOrder" >
        <img src="../../static/a.jpg">
        <div class="myOrderState">交易完成</div>
        <div class="myOrderName">这是商品的名字这是商品的名字这是商品的名字这是商品的名字这是商品的名字
          这是商品的名字这是商品的名字这是商品的名字这是商品的名字这是商品的名字
        </div>
        <div class="orderSellingPrice">￥666
          <div class="orderOriginalPrice">￥999</div>
        </div>
        <div class="myOrderNum" >×1</div>
        <div class="myOrderPrice">￥1999</div>
        <input type="button" class="myOrderBtn" value="追评" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },
  methods: {
    // 返回上一页
    retreat() {
      this.$router.go(-1);
    }
  }
};
</script>