<style>
/* 搜索框样式 */
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
#searchFrame2 {
  position:fixed;
  top: 0;
  z-index: 999;
  height: 60px;
  width: 100vw;
  background-color: black;
}
.searchimg {
  position:absolute;
  top: 15px;
  left: 20px;
  padding-left: 8px;
  width: 30px;
  height: 30px;
  z-index: 2;
  border-radius: 10px;
}
.searchtext {
  position:absolute;
  top: 7px;
  left: 20px;
  width: calc(100vw - 140px);
  height: 40px;
  z-index: 1;
  border-radius: 10px;
  padding-left: 40px;
}
.searchbtn {
  position:absolute;
  top: 15px;
  right: 0vw;
  width: 60px;
  height: 40px;
  border-radius: 10px;
  font-size: 20px;
  color: #81c16a;
}
.antistop{
  display: block;
  margin: 10px 10px;
  float: left;
  background-color:#F0F8FF;
  color: #81c16a;
}
/* 排序选项卡 */
.sort{
  position:fixed;
  background-color:beige;
  top: 60px;
  z-index: 10;
  height: 10vw;
  width: 100vw;
}
.sort ul {
  width: 100%;
  display: flex;
  list-style: none;
  padding: 0;
  margin: 0;
  color: #717181;
  font-size: 4vw;
  line-height: 10vw;
}
.sort ul li {
  flex: 1;
  text-align: center;
  cursor: pointer;
}
/* 商品列表 */
.commodityList{
  position: relative;
  width: 100vw;
}
.commodity{
  position: relative;
  width: 100vw;
  height: 30vw;
  background:cornsilk;
}
.commodity img{
  position: absolute;
  left: 2vw;
  top: 2vw;
  width: 25vw;
  height: 25vw;
}
.commodityText{
  position: absolute;
  width: 68vw;
  height: 8vw;
  top: 3vw;
  left: 30vw;
  font-size: 4vw;
  line-height: 4.3vw;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  overflow:hidden;
  letter-spacing:0.3vw;
}
.commodityPrice{
  position: absolute;
  left: 32vw;
  top: 22vw;
  font-size: 4vw;
  float: left;
}
.commodityOriginalPrice {
  display: inline;
  font-size: 4vw;
  color: gray;
  text-decoration: line-through;
}
/* 填补空缺 */
#vacancy {
  position: relative;
}
</style>

<template>
  <div id="Commodity">
    <div id="vacancy" style="height: calc(60px + 10vw)"></div>
    <div id="searchFrame2">
      <img class="searchimg" src="../../static/icon/search.png" />
      <input type="text" class="searchtext" />
      <router-link :to="{path: '/Home'}">
        <div class="searchbtn">取消</div>
      </router-link>
    </div>
    <div class="sort">
      <ul>
        <li>销量多</li>
        <li>价格低</li>
        <li>价格高</li>
      </ul>
    </div>
    <div class="commodityList">
      <div class="commodity" v-for="(commodity,i) in commodityList" >
        <img :src="commodity.commodityUrl"/>
        <div class="commodityText">{{commodity.commodityText}}</div>
        <div class="commodityPrice">
          ￥{{commodity.commodityPrice}}
          <div class="commodityOriginalPrice">{{commodity.commodityOriginalPrice}}</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      commodityList:[
        {
          commodityUrl:"../static/c.jpg",
          commodityText:"这是个商品这是品",
          commodityPrice:"99",
          commodityOriginalPrice: "500",
        },
        {
          commodityUrl:"../static/b.jpg",
          commodityText:"这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品",
          commodityPrice:"97",
          commodityOriginalPrice: "500",
        },
        {
          commodityUrl:"../static/b.jpg",
          commodityText:"这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品",
          commodityPrice:"90",
          commodityOriginalPrice: "500",
        },
        {
          commodityUrl:"../static/c.jpg",
          commodityText:"这是个商品这是品",
          commodityPrice:"99",
          commodityOriginalPrice: "500",
        },
        {
          commodityUrl:"../static/b.jpg",
          commodityText:"这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品",
          commodityPrice:"97",
          commodityOriginalPrice: "500",
        },
        {
          commodityUrl:"../static/b.jpg",
          commodityText:"这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品这是个商品",
          commodityPrice:"90",
          commodityOriginalPrice: "500",
        },
      ]
    };
  }
};
</script>