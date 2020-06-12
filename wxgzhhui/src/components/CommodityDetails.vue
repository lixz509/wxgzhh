<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
/* 顶部搜索框 */
.detailsHeader {
  position: fixed;
  background-color: #f0f8ff;
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
.opposite {
  position: absolute;
  top: 15px;
  right: 15px;
  width: 30px;
  height: 30px;
}
.detailsText {
  position: absolute;
  top: 7px;
  left: 60px;
  width: calc(100vw - 190px);
  height: 40px;
  z-index: 1;
  border-radius: 10px;
  padding-left: 40px;
}
.collect {
  position: absolute;
  width: 30px;
  height: 30px;
  top: 15px;
  right: 47px;
}
.cart {
  position: absolute;
  width: 30px;
  height: 30px;
  top: 15px;
  right: 10px;
}
/* 轮播图样式 */
#slideshow {
  position: relative;
  background-color: rgb(252, 174, 174);
  width: 100vw;
  height: 50vw;
  overflow: hidden;
}
.leftarrows {
  position: absolute;
  top: calc(20vw);
  left: 5vw;
  width: 10vw;
  z-index: 3;
  height: 10vw;
}
.rigtharrows {
  position: absolute;
  top: calc(20vw);
  right: 5vw;
  width: 10vw;
  z-index: 3;
  height: 10vw;
}
#carousel {
  position: absolute;
  width: 500vw;
}
.carouselImg {
  position: relative;
  float: left;
  background-color: rgb(252, 174, 174);
  width: 100vw;
  height: 50vw;
}
#ball {
  position: absolute;
  z-index: 3;
  width: 25vw;
  height: 5vw;
  left: 37.5vw;
  top: 40vw;
}
#ball img {
  top: 0;
  width: 5vw;
  height: 5vw;
  border-radius: 5vw;
}
/* 商品名称*/
.commodityName {
  position: relative;
  background-color: #fff;
  line-height: 6vw;
  font-size: 4vw;
  letter-spacing: 0.4vw;
  padding: 0 2vw;
  width: 96vw;
  font-weight: 300;
}
/* 售价 */
.sellingPrice {
  margin: 2vw 0vw;
  text-indent: 8vw;
  height: 8vw;
  background-color: #fff;
  font-size: 5vw;
}
.sellingPrice span {
  font-size: 3.5vw;
  text-decoration: line-through;
}
/* 商品简介 */
.commoditySynopsis {
  position: relative;
  background-color: #fff;
  width: 96vw;
  margin: 2vw 0vw;
  height: 4.5vw;
  font-size: 3vw;
  padding: 0 2vw;
}
/* 商品评价 */
.evaluate{
  position: relative;
  width: 100vw;
  height: 25vw;
  margin: 2vw 0vw;
  background-color: #fff;
}
.evaluateP{
  position: relative;
  width: 100vw;
  font-size: 5vw;
}
.evaluateUserImg{
  position: absolute;
  top: 7vw;
  width: 12vw;
  height: 12vw;
  border-radius:10vw;
}
.evaluateText{
  position: absolute;
  left: 13vw;
  top: 15vw;
  width: 86vw;
  font-size: 3vw;
  text-indent: 2vw;
  overflow: hidden;
  height: 7vw;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
}
.evaluateStars{
  position: absolute;
  top: 7vw;
  left: 20vw;
  width: 25vw;
  height: 5vw;
}
.evaluateUserName{
  position: absolute;
  top: 20vw;
  width: 12vw;
  font-size: 2vw;
  text-align: center;
}
/* 商品详情 */
.particulars {
  width: 100vw;
}
/* 尾部 */
.detailsFooter {
  position: fixed;
  background-color: white;
  height: 60px;
  width: 100vw;
  bottom: 0;
  z-index: 5;
}
.support {
  position: absolute;
  width: 30px;
  height: 30px;
  top: 10px;
  left: 5vw;
}
.collect2 {
  position: absolute;
  width: 30px;
  height: 30px;
  top: 10px;
  left: 20vw;
}
.supportText {
  position: absolute;
  top: 40px;
  left: 5vw;
  width: 30px;
  font-size: 2vw;
}
.collect2Text {
  position: absolute;
  top: 40px;
  left: 20vw;
  font-size: 2vw;
}
.shoppingCart {
  position: absolute;
  width: 30vw;
  height: 40px;
  top: 10px;
  left: 35vw;
  background-color: #32cd32;
  border-top-left-radius: 20px;
  border-bottom-left-radius: 20px;
  font-size: 4vw;
}
.buy {
  position: absolute;
  width: 30vw;
  height: 40px;
  top: 10px;
  left: 65vw;
  background-color: #32cd32;
  border-top-right-radius: 20px;
  border-bottom-right-radius: 20px;
  font-size: 4vw;
}
/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
</style>

<template>
  <div id="commodityDetails">
    <div id="vacancy"></div>
    <div class="detailsHeader">
      <img class="retreat" @click="retreat" src="../../static/icon/retreat.png" />
      <router-link :to="{path: '/Search'}">
        <input type="text" class="detailsText" />
      </router-link>
      <img
        class="collect"
        :src="[1==1?'../../static/icon/collecta.png':'../../static/icon/collectb.png']"
      />
      <img
        class="cart"
        :src="[1==1?'../../static/icon/shoppingc.png':'../../static/icon/shoppingd.png']"
      />
    </div>
    <div id="slideshow">
      <img class="leftarrows" src="../../static/icon/left.png" @click="leftarrows" />
      <img class="rigtharrows" src="../../static/icon/right.png" @click="rigtharrows" />
      <div id="ball">
        <img
          v-for="(ball,i) in balls"
          :src="[balls[i].night?'../../static/icon/balla.jpg':'../../static/icon/ballb.jpg']"
          @click="balla(i)"
        />
      </div>
      <div
        id="carousel"
        :style="{left:leftshift+'vw'}"
        @touchstart="touchStart"
        @touchend="touchEnd"
      >
        <img class="carouselImg" v-for="(slideshow,i) in slideshowUrl" :src="slideshow" />
      </div>
    </div>
    <div class="sellingPrice">
      2700
      <span>9999</span>
    </div>
    <div class="commodityName">2020新款手机投影仪一体机家用小型迷你wifi微型无线3D家庭影院投墙上超便携式高清4K激光看电影掌上电视宿舍</div>
    <div class="commoditySynopsis">核处理器 3G大运行内存 万元配置</div>
    <div class="evaluate">
      <div class="evaluateP">评价</div>
      <img class="evaluateUserImg" src="../../static/icon/evaluateUser.png" /> 
      <img class="evaluateStars" src="../../static/icon/fiveStars.png">
      <div class="evaluateUserName">用户3333</div>
      <div class="evaluateText">这是一个多字的好评，这是一个多字的好评这是一个多字的好评这是一个多字的好评这是一个多字的好评这是一个多字
        的好评这是一个多字的好评这是一个多字的好评这是一个多字的好评</div>
    </div>

    <img class="particulars" v-for="(slideshow,i) in slideshowUrl" :src="slideshow" />

    <div id="vacancy"></div>
    <div class="detailsFooter">
      <img class="support" :src="'../../static/icon/support.png'" />
      <img
        class="collect2"
        :src="[1==1?'../../static/icon/collecta.png':'../../static/icon/collectb.png']"
      />
      <div class="supportText">&ensp;客服</div>
      <div class="collect2Text">收藏</div>
      <input class="shoppingCart" type="button" value="加入购物车" />
      <input class="buy" type="button" value="立即购买" />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      slideshowUrl: {
        one: "../static/a.jpg",
        two: "../static/b.jpg",
        three: "../static/c.jpg",
        four: "../static/d.jpg",
        five: "../static/e.jpg"
      },
      leftshift: 0, //左移动的偏移量
      intervalId: "", //计时器
      startX: 0, //开始触摸的位置
      endX: 0, //结束触摸的位置
      balls: [
        // 设置小球队列，nigth为true则高亮
        { night: true },
        { night: false },
        { night: false },
        { night: false },
        { night: false }
      ]
    };
  },
  methods: {
    // 自动轮播事件
    carousel() {
      // 通过控制左移位置控制图片移动
      if (this.leftshift > -400) {
        this.balls[this.leftshift / -100].night = false;
        this.leftshift -= 100;
        this.balls[this.leftshift / -100].night = true;
      } else {
        this.leftshift = 0;
        this.balls[0].night = true;
        this.balls[4].night = false;
      }
    },
    // 左箭头点击事件
    leftarrows() {
      clearInterval(this.intervalId);
      if (this.leftshift < 0) {
        this.balls[this.leftshift / -100].night = false;
        this.leftshift += 100;
        this.balls[this.leftshift / -100].night = true;
      } else {
        this.leftshift = -400;
        this.balls[0].night = false;
        this.balls[4].night = true;
      }
      this.intervalId = setInterval(this.carousel, 3000);
    },
    // 右箭头点击事件
    rigtharrows() {
      clearInterval(this.intervalId);
      if (this.leftshift > -400) {
        this.balls[this.leftshift / -100].night = false;
        this.leftshift -= 100;
        this.balls[this.leftshift / -100].night = true;
      } else {
        this.leftshift = 0;
        this.balls[0].night = true;
        this.balls[4].night = false;
      }
      this.intervalId = setInterval(this.carousel, 3000);
    },
    // 小球点击事件
    balla(i) {
      clearInterval(this.intervalId);
      this.leftshift = i * -100;
      for (var j = 0; j < this.balls.length; j++) {
        this.balls[j].night = false;
      }
      this.balls[i].night = true;
      // console.log(leftshift);
      this.intervalId = setInterval(this.carousel, 3000);
    },
    // 开始触摸事件
    touchStart(ev) {
      ev = ev || event;
      // ev.preventDefault();
      // console.log(ev.targetTouches);
      // console.log(ev.changedTouches);
      clearInterval(this.intervalId);
      if (ev.touches.length == 1) {
        //tounches类数组，等于1时表示此时有只有一只手指在触摸屏幕
        this.startX = ev.touches[0].clientX; // 记录开始位置
        // console.log(this.startX);
      }
    },
    // 结束触摸事件
    touchEnd(ev) {
      ev = ev || event;
      // ev.preventDefault();
      if (ev.changedTouches.length == 1) {
        //tounches类数组，等于1时表示此时有只有一只手指在触摸屏幕
        this.endX = ev.changedTouches[0].clientX; // 记录开始位置
        if (this.endX - this.startX > 0) {
          // 右划
          // console.log("右滑");
          if (this.leftshift < 0) {
            this.balls[this.leftshift / -100].night = false;
            this.leftshift += 100;
            this.balls[this.leftshift / -100].night = true;
          } else {
            this.leftshift = -400;
            this.balls[0].night = false;
            this.balls[4].night = true;
          }
        } else {
          // 左滑
          // console.log("左滑");
          if (this.leftshift > -400) {
            this.balls[this.leftshift / -100].night = false;
            this.leftshift -= 100;
            this.balls[this.leftshift / -100].night = true;
          } else {
            this.leftshift = 0;
            this.balls[0].night = true;
            this.balls[4].night = false;
          }
        }
        this.intervalId = setInterval(this.carousel, 3000);
        // console.log(this.endX);
      }
    },
    // 返回上一页
    retreat() {
      this.$router.go(-1);
    }
  },
  mounted() {
    this.intervalId = setInterval(this.carousel, 3000);
  }
};
</script>