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
  line-height: 4.5vw;
  font-size: 3vw;
  padding: 0 2vw;
}
/* 商品评价 */
.evaluate {
  position: relative;
  width: 100vw;
  height: 25vw;
  margin: 2vw 0vw;
  background-color: #fff;
}
.evaluateP {
  position: relative;
  width: 100vw;
  font-size: 5vw;
}
.evaluateUserImg {
  position: absolute;
  top: 7vw;
  width: 12vw;
  height: 12vw;
  border-radius: 10vw;
}
.evaluateText {
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
.evaluateStars {
  position: absolute;
  top: 7vw;
  left: 20vw;
  width: 25vw;
  height: 5vw;
}
.evaluateUserName {
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
.evaluateNull {
  position: absolute;
  top: 8vw;
  left: 2vw;
  font-size: 3.5vw;
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
        :src="[collect=='no'?'../../static/icon/collecta.png':'../../static/icon/collectb.png']"
        @click="collectUpdate()"
      />
      <router-link :to="{path: '/Shopping'}">
      <img
        class="cart"
        :src="[shoppingTrolley=='no'?'../../static/icon/shoppingc.png':'../../static/icon/shoppingd.png']"
      />
      </router-link>
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
        <img class="carouselImg" v-for="(slideshow,i) in paperlist.slideshowUrl" :src="slideshow" />
      </div>
    </div>
    <div class="sellingPrice">
      {{paperlist.price}}
      <span>{{paperlist.originalPrice}}</span>
    </div>
    <div class="commodityName">{{paperlist.commodityName}}</div>
    <div class="commoditySynopsis">{{paperlist.commodityIntro}}</div>
    <div class="evaluate">
      <div class="evaluateP">评价</div>
      <img
        class="evaluateUserImg"
        v-if="paperlist.storeEvaluate"
        src="../../static/icon/evaluateUser.png"
      />
      <img class="evaluateStars" v-if="paperlist.storeEvaluate" :src="rating" />
      <div
        class="evaluateUserName"
        v-if="paperlist.storeEvaluate"
      >{{paperlist.storeEvaluate.userName}}</div>
      <div
        class="evaluateText"
        v-if="paperlist.storeEvaluate"
      >{{paperlist.storeEvaluate.evaluateText}}</div>
      <div class="evaluateNull" v-show="evaluateNull == 0">该商品暂无评价</div>
    </div>
    <img class="particulars" v-for="(slideshow,i) in paperlist.particularsUrl" :src="slideshow" />
    <div id="vacancy"></div>
    <div class="detailsFooter">
      <router-link :to="{path: '/ChatRoom',query:{dialogueUserId:'user1'}}">
        <img class="support" :src="'../../static/icon/support.png'" />
        <div class="supportText">&ensp;客服</div>
      </router-link>
      <img
        class="collect2"
        :src="[collect=='no'?'../../static/icon/collecta.png':'../../static/icon/collectb.png']"
        @click="collectUpdate()"
      />
      <div class="collect2Text">收藏</div>
      <input class="shoppingCart" type="button" value="加入购物车" @click="addShoppingTrolley()" />
      <input class="buy" type="button" value="立即购买" @click="buy()" />
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      paperlist: [],
      commodityId: "",
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
      ],
      rating: "",
      evaluateNull: 0,
      collect: "n",
      shoppingTrolley: "n",
      orderId:[]
    };
  },
  created() {
    this.commodityId = this.$route.params.commodityId;
    this.$http
      .post(
        "http://47.100.137.237:8093/store/commodity?userid=user2&commodityId=" +
          this.commodityId,
        {},
        { emulateJSON: true }
      )
      .then(result => {
        this.paperlist = result.data;
        this.collect = result.data.collect;
        this.shoppingTrolley = result.data.shoppingTrolley;
        if (this.collect == "yes") {
          document.getElementsByClassName("collect2Text")[0].innerHTML =
            "已收藏";
        }
        if (this.shoppingTrolley == "yes") {
          document.getElementsByClassName("shoppingCart")[0].value =
            "已加入购物车";
        }
        // 需放最后，否则会有写小问题
        this.rating =
          "../static/icon/stars" + result.data.storeEvaluate.rating + ".png";
        this.evaluateNull = result.data.storeEvaluate.length;
      })
      .catch(e => {});
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
    // 添加，取消收藏
    collectUpdate() {
      switch (this.collect) {
        case "yes":
          this.$http
            .post(
              "http://47.100.137.237:8093/store/commodity/deleteCollect?userid=user2&commodityId=" +
                this.commodityId,
              {},
              { emulateJSON: true }
            )
            .then(result => {})
            .catch(e => {});
          this.collect = "no";
          document.getElementsByClassName("collect2Text")[0].innerHTML = "收藏";
          break;
        case "no":
          this.$http
            .post(
              "http://47.100.137.237:8093/store/commodity/addCollect?userid=user2&commodityId=" +
                this.commodityId,
              {},
              { emulateJSON: true }
            )
            .then(result => {})
            .catch(e => {});
          this.collect = "yes";
          document.getElementsByClassName("collect2Text")[0].innerHTML =
            "已收藏";
          break;
      }
    },
    // 将商品加入购物车
    addShoppingTrolley() {
      if (this.shoppingTrolley == "no") {
        this.$http
          .post(
            "http://47.100.137.237:8093/store/commodity/addShoppingTrolley?userid=user2&commodityId=" +
              this.commodityId,
            {},
            { emulateJSON: true }
          )
          .then(result => {})
          .catch(e => {});
        this.shoppingTrolley = "yes";
        document.getElementsByClassName("shoppingCart")[0].value =
          "已加入购物车";
      }
    },
    // 购买商品
    buy(){
      this.$http
          .post(
            "http://47.100.137.237:8093/store/commodity/addOrder?userid=user2&commodityId=" +
              this.commodityId,
            {},
            { emulateJSON: true }
          )
          .then(result => {
            this.orderId[0]=result.data;
            this.$router.push({name:"Payment",params:{orderId:this.orderId}});
          })
          .catch(e => {});
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