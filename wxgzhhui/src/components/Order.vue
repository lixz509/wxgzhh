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
  background-color: #f6f6f6;
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
  border: black solid 1px;
  font-size: 3vw;
}
.orderSearch {
  position: absolute;
  top: 8px;
  right: 15px;
  width: 60px;
  height: 40px;
  background-color: #f0f8ff;
  border: black solid 1px;
  font-size: 20px;
  border-radius: 10px;
}
/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
/* 订单选项卡 */
.orderType {
  position: fixed;
  top: 60px;
  z-index: 10;
  background-color: #f6f6f6;
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
.orderList {
  position: relative;
  width: 100vw;
}
.myOrder {
  position: relative;
  width: 100vw;
  height: 30vw;
  margin: 1vw 0vw;
  background-color: #fff;
  border-radius: 5vw;
}
.myOrder img {
  position: absolute;
  top: 2vw;
  left: 2vw;
  width: 20vw;
  height: 20vw;
}
.myOrderName {
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
.myOrderState {
  position: absolute;
  top: 2vw;
  right: 6vw;
  font-size: 2.7vw;
}
.myOrderNum {
  position: absolute;
  top: 16vw;
  right: 6vw;
  font-size: 3vw;
}
.myOrderBtn {
  position: absolute;
  top: 20vw;
  left: 24vw;
  height: 5vw;
  width: 15vw;
  background-color: #fff;
  border: #2e8b57 solid 1px;
  border-radius: 5vw;
}
/* 订单价格 */
.orderSellingPrice {
  position: absolute;
  left: 65vw;
  top: 16vw;
  width: 20vw;
  font-size: 3vw;
}
.orderOriginalPrice {
  display: inline-block;
  color: gray;
  font-size: 2.7vw;
  text-decoration: line-through;
}
.myOrderPrice {
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
      <input type="text" class="orderText" placeholder="搜索我的订单" v-model="orderName" @keyup.enter="searchOrder()" />
      <input type="button" class="orderSearch" @click="searchOrder()" value="搜索" />
    </div>
    <div class="orderType">
      <ul>
        <li @click="updateSort('all')" :style="{'border-bottom':(sort=='all'?'#FF0000 2px solid':'')}" >全部</li>
        <li @click="updateSort('IS_PAYMENT')" :style="{'border-bottom':(sort=='IS_PAYMENT'?'#FF0000 2px solid':'')}">待付款</li>
        <li @click="updateSort('IS_SHIPMENTS')" :style="{'border-bottom':(sort=='IS_SHIPMENTS'?'#FF0000 2px solid':'')}">待发货</li>
        <li @click="updateSort('IS_RECEIVING')" :style="{'border-bottom':(sort=='IS_RECEIVING'?'#FF0000 2px solid':'')}">待收货</li>
        <li @click="updateSort('IS_EVALUATE')" :style="{'border-bottom':(sort=='IS_EVALUATE'?'#FF0000 2px solid':'')}">待评价</li>
      </ul>
    </div>
    <div class="orderList">
      <div class="myOrder" v-for="(order,i) in paperlist" @click="jumpCommodityDetails(order.storeCommodity.commodityId)">
        <img :src="order.storeCommodity.showUrl" />
        <div
          class="myOrderState"
          v-show="order.storeOrder.orderState == 'IS_EVALUATE' 
        || order.storeOrder.orderState == 'IS_AFTERMARKET' "
        >交易完成</div>
        <div class="myOrderState" v-show="order.storeOrder.orderState == 'IS_PAYMENT' ">待付款</div>
        <div class="myOrderState" v-show="order.storeOrder.orderState == 'IS_SHIPMENTS' ">待发货</div>
        <div class="myOrderState" v-show="order.storeOrder.orderState == 'IS_RECEIVING' ">待收货</div>
        <div class="myOrderName">{{order.storeCommodity.commodityName}}</div>
        <div class="orderSellingPrice">
          ￥{{order.storeCommodity.price}}
          <div class="orderOriginalPrice">￥{{order.storeCommodity.originalPrice}}</div>
        </div>
        <div class="myOrderNum">×{{order.storeOrder.purchaseQuantity}}</div>
        <div class="myOrderPrice">￥{{order.storeOrder.totalPrice}}</div>
        <input type="button" class="myOrderBtn" @click="jumpPayment(order.storeOrder.orderId)" 
        value="去付款" v-show="order.storeOrder.orderState == 'IS_PAYMENT'" />
        <input type="button" class="myOrderBtn" value="已支付" v-show="order.storeOrder.orderState == 'IS_SHIPMENTS'" />
        <input type="button" class="myOrderBtn" value="确认收货" v-show="order.storeOrder.orderState == 'IS_RECEIVING'" />
        <input type="button" class="myOrderBtn" value="评价" v-show="order.storeOrder.orderState == 'IS_EVALUATE'" />
        <input type="button" class="myOrderBtn" value="已评价" v-show="order.storeOrder.orderState == 'IS_AFTERMARKET'"/>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      paperlist: [],
      sort:"all",
      orderId:[],
      orderName:""
    };
  },
  created() {
    this.sort = this.$route.params.sort;
    this.$http
      .post(
        "http://47.100.137.237:8093/store/order?userid=user2&sort="+this.sort,
        {},
        { emulateJSON: true }
      )
      .then(result => {
        this.paperlist = result.data;
      })
      .catch(e => {});
  },
  methods: {
    // 跳转到其他状态
    updateSort(sort){
      this.sort=sort;
      this.$http
        .post(
          "http://47.100.137.237:8093/store/order?userid=user2&sort="+this.sort,
          {},
          { emulateJSON: true }
        )
        .then(result => {
          this.paperlist = result.data;
        })
        .catch(e => {});
    },
    // 跳转去支付
    jumpPayment(orderId){
      this.orderId[0]=orderId;
      this.$router.push({name:"Payment",params:{orderId:this.orderId}});
    },
    // 跳转到商品详情
    jumpCommodityDetails(commodityId){
      this.$router.push({name:"CommodityDetails",params:{commodityId:commodityId}});
    },
    // 搜索订单
    searchOrder(){
      this.$http
        .post(
          "http://47.100.137.237:8093/store/order/search?userid=user2&commodityName="+this.orderName,
          {},
          { emulateJSON: true }
        )
        .then(result => {
          this.paperlist = result.data;
          this.sort="all";
        })
        .catch(e => {});
    },
    // 返回上一页
    retreat() {
      this.$router.go(-1);
    }
  }
};
</script>