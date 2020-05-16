<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #2c3e50;
}
/* 头部 */
.shoppingHead {
  position: fixed;
  z-index: 5;
  top: 0vw;
  height: 60px;
  width: 100vw;
  background-color: antiquewhite;
  font-size: 24px;
  font-weight: bolder;
}
/* 商品列表 */
.productList{
  position: relative;
  width: 100vw;
}
.product{
  position: relative;
  width: 100vw;
  height: 30vw;
  background:yellow;
}
.checkboxa{
  position: absolute;
  /* background-color: blue; */
  width: 10vw;
  height: 30vw;
}
.product img{
  position: absolute;
  left: 12vw;
  top: 3vw;
  width: 20vw;
  height: 20vw;
}
.productText{
  position: absolute;
  width: 64vw;
  height: 8vw;
  top: 3vw;
  left: 34vw;
  font-size: 3.5vw;
  line-height: 4vw;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  overflow:hidden;
  letter-spacing:0.3vw;
}
.productPrice{
  position: absolute;
  left: 36vw;
  top: 20vw;
  font-size: 3.5vw;
}
.productCancel{
  position: absolute;
  right: 8vw;
  top: 10vw;
}
.commoditNum{
  position: absolute;
  top: 20vw;
  right: 5vw;
  font-size: 3.5vw;
}
/* 结算 */
.settlement{
  position: fixed;
  width: 100vw;
  height: 60px;
  bottom: 60px;
  background-color: aqua;
}
.checkboxb{
  position: absolute;
  /* background-color: blue; */
  width: 10vw;
  height: 60px;
}
.settlementP{
  position: absolute;
  left: 12vw;
  top: calc((60px - 7vw)/2);
  font-size: 5vw;
}
.settlementBtn{
  position: absolute;
  right: 5vw;
  top: calc((60px - 7vw)/2);
  width: 12vw;
  font-size: 5vw;
}
.settlementPrice{
  position: absolute;
  top: calc((60px - 6vw)/2);
  right: 19vw;
  font-size: 4vw;
}
/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
</style>

<template>
  <div id="shopping">
    <div id="vacancy"></div>
    <div class="shoppingHead">
      <p style="text-align: center;padding-top: 15px">购物车</p>
    </div>
    <div class="productList">
      <div class="product" v-for="(product,i) in productList" >
        <div class="checkboxa"></div>
        <img :src="product.productUrl"/>
        <div class="productText">{{product.productText}}</div>
        <div class="productPrice">{{product.productPrice}}</div>
        <div class="productCancel">-</div>
        <div class="commoditNum">{{product.commoditNum}}</div>
      </div>
    </div>
    <div class="settlement">
      <div class="checkboxb"></div>
      <div class="settlementP">全选</div>
      <div class="settlementPrice">合计:9998888</div>
      <input type="button" class="settlementBtn" value="结算" />
    </div>
    <div id="vacancy"></div>
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
        shopping: "../static/icon/shoppingb.png",
        my: "../static/icon/mya.png"
      },
      productList:[
        {
          productUrl:"../static/c.jpg",
          productText:"这是个商品这是品",
          productPrice:"99",
          commoditNum:"1"
        },
        {
          productUrl:"../static/b.jpg",
          productText:"这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品",
          productPrice:"97",
          commoditNum:"2"
        },
        {
          productUrl:"../static/b.jpg",
          productText:"这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品",
          productPrice:"90",
          commoditNum:"4"
        },
        {
          productUrl:"../static/c.jpg",
          productText:"这是个商品这是品",
          productPrice:"99",
          commoditNum:"1"
        },
        {
          productUrl:"../static/b.jpg",
          productText:"这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品",
          productPrice:"97",
          commoditNum:"2"
        },
        {
          productUrl:"../static/b.jpg",
          productText:"这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品",
          productPrice:"90",
          commoditNum:"4"
        },
      ]
    };
  },
  name: "Shopping",
  components: {
    Footer
  }
};
</script>