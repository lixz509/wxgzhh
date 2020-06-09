<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
.headPortrait {
  position:relative;
  top: 0;
  margin-top: 0px;
  height: 25vw;
  width: 100vw;
  background-image: linear-gradient(#f9957f, #f2f5d0);
}
.headPortrait img {
  position: absolute;
  height: 16vw;
  width: 16vw;
  left: 42vw;
  top: 2vw;
  border-radius: 16vw;
}
.name {
  position: absolute;
  font-size: 6vw;
  top: 18vw;
  left: 50%;
  height: 5vw;
  transform: translate(-50%);
}
.order {
  position:relative;
  text-align: center;
  top: 3vw;
  height: 32vw;
  width: 100vw;
  z-index: 2;
  background-color: #fff;
  border-radius: 10px;
}
.orderP {
  position: absolute;
  left: 10vw;
  top: 2vw;
  font-size: 6vw;
  font-weight: bolder;
}
.orderSpan {
  position: absolute;
  right: 10vw;
  top: 2vw;
  font-size: 2.8vw;
  color: #999;
}
.order img {
  position: relative;
  widows: 10vw;
  height: 10vw;
  top: 13vw;
  margin: 0vw 3vw;
}
.order li {
  margin: 15vw 2vw 0vw;
  width: 16vw;
  text-align: center;
  list-style: none;
  float: left;
  font-size: 3vw;
}
.task {
  position:relative;
  top: 5vw;
  height: 40vw;
  width: 100vw;
  border-radius: 10px;
  background-color: #fff;
}
.task li {
  text-indent: 2vw;
  list-style: none;
  font-size: 4vw;
  height: 8vw;
  margin-top: 2vw;
  width: 98vw;
  text-align: left;
}
.task img {
  margin-top: 1vw;
  width: 4vw;
  height: 4vw;
}
.information {
  position:relative;
  top: 5vw;
  height: 30vw;
  width: 100vw;
  border-radius: 10px;
  background-color: #fff;
}
.information li,
.aboutUs li {
  text-indent: 2vw;
  list-style: none;
  font-size: 4vw;
  height: 8vw;
  margin-top: 2vw;
  width: 98vw;
  text-align: left;
}
.information img,
.aboutUs img {
  margin-top: 1vw;
  width: 4vw;
  height: 4vw;
}
.aboutUs {
  position:relative;
  top: 5vw;
  height: 13vw;
  width: 100vw;
  border-radius: 10px;
  background-color: #fff;
}
</style>

<template>
  <div id="my">
    <div class="headPortrait">
      <img :src="user.headPortrait" />
      <div class="name">{{user.Name}}</div>
    </div>
    <div class="order">
      <div class="orderP">我的订单</div>
      <div class="orderSpan">查看全部订单&gt;</div>
      <img src="../../static/icon/payment.png" />
      <img src="../../static/icon/shipments.png" />
      <img src="../../static/icon/Receiving.png" />
      <img src="../../static/icon/evaluate.png" />
      <img src="../../static/icon/aftermarket.png" />
      <ul>
        <li>&ensp;待付款</li>
        <li>&ensp;待发货</li>
        <li>待收货</li>
        <li>待评价&ensp;</li>
        <li>退款/售后</li>
      </ul>
    </div>
    <div class="task">
      <ul>
        <li>
          <img src="../../static/icon/balance.png" />&ensp;余额
        </li>
        <li>
          <img src="../../static/icon/task.png" />&ensp;任务中心
        </li>
        <li>
          <img src="../../static/icon/favorite.png" />&ensp;收藏夹
        </li>
        <li>
          <img src="../../static/icon/shoppingc.png" />&ensp;购物车
        </li>
      </ul>
    </div>
    <div class="information">
      <ul>
        <li>
          <img src="../../static/icon/location.png" />&ensp;收货地址
        </li>
        <li>
          <img src="../../static/icon/security.png" />&ensp;账号与安全
        </li>
        <li>
          <img src="../../static/icon/information.png" />&ensp;个人信息
        </li>
      </ul>
    </div>
    <div class="aboutUs">
      <ul>
        <li>
          <img src="../../static/icon/aboutUs.png" />&ensp;关于我们
        </li>
      </ul>
    </div>
    <Footer :imagesUrl="imagesUrl"></Footer>
  </div>
</template>

<script>
import Footer from "@/components/FooterButton";
export default {
  data() {
    return {
      imagesUrl: {
        home: "../static/icon/homea.png",
        message: "../static/icon/messagea.png",
        shopping: "../static/icon/shoppinga.png",
        my: "../static/icon/myb.png"
      },
      user: {
        headPortrait: "../static/a.jpg",
        Name: "lpj"
      }
    };
  },
  components: {
    Footer
  },
};
</script>