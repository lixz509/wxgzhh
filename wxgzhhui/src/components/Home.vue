<style>
/* 搜索框样式 */
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
#searchFrame {
  position: relative;
  top: 0;
  z-index: 999;
  height: 60px;
  width: 100vw;
  background-color: black;
}
.searchimg {
  position: absolute;
  top: 15px;
  left: 20px;
  padding-left: 8px;
  width: 30px;
  height: 30px;
  z-index: 2;
  border-radius: 10px;
}
.searchtexts {
  position: absolute;
  top: 7px;
  left: 20px;
  width: calc(100vw - 80px);
  height: 40px;
  z-index: 1;
  border-radius: 10px;
  padding-left: 40px;
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
/* 商品分类 */
.classifys {
  position: relative;
  width: 100vw;
  height: 65vw;
  overflow: hidden;
  background-color: #f6f6f6;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}
.classify {
  position: relative;
  float: left;
  width: 23.5vw;
  margin-right: 2vw;
  height: 27.5vw;
  background-color: seashell;
}
.classify img {
  position: relative;
  left: 0.75vw;
  width: 22vw;
  height: 22vw;
  vertical-align: bottom;
}
.classifyText {
  margin-top: 0.75vw;
  width: 22vw;
  font-size: 4vw;
  overflow: hidden;
  text-align: center;
  height: 4vw;
  line-height: 4vw;
}
/* 今日爆款 */
.faddishs {
  position: relative;
  width: 100vw;
  height: 50vw;
  overflow: hidden;
  background-color: #f1fafa;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}
.faddishP,
.classifyP,
.selectionP {
  position: relative;
  width: 100vw;
  height: 10vw;
  background-color: yellow;
  vertical-align: bottom;
}
.faddish {
  position: relative;
  float: left;
  width: 32vw;
  height: 40vw;
  background-color: seashell;
}
.faddish img {
  margin: 2vw 4vw 0vw;
  width: 24vw;
  height: 24vw;
  vertical-align: bottom;
}
.faddishPrice {
  font-size: 6vw;
  line-height: 6vw;
  text-align: center;
  overflow: hidden;
  color: red;
}
.faddishText {
  margin-top: 2vw;
  width: 32vw;
  font-size: 4vw;
  overflow: hidden;
  text-align: center;
  height: 4vw;
  line-height: 4vw;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 1;
}
/* 精选好物 */
.selections {
  position: relative;
  width: 100vw;
  overflow: hidden;
  background-color: blanchedalmond;
  border-top-left-radius: 10px;
  border-top-right-radius: 10px;
}
.selection {
  position: relative;
  width: 100vw;
  height: 30vw;
  background-color: #F5FFFA;
}
.selection img {
  height: 30vw;
  width: 30vw;
}
.selectionText {
  position: absolute;
  left: 35vw;
  top: 5vw;
  width: 63vw;
  font-size: 4vw;
  overflow: hidden;
  text-align: left;
  height: 4vw;
  line-height: 4vw;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 1;
}
.selectionParticulars {
  position: absolute;
  left: 30vw;
  top: 20vw;
  width: 70vw;
  height: 5vw;
  font-size: 5vw;
  overflow: hidden;
}
.selectionDiscount {
  font-size: 5vw;
  background-color: red;
  line-height: 5vw;
  color: white;
  border-radius: 5px;
  margin-left: 5vw;
  float: left;
}
.selectionPrice {
  font-size: 4vw;
  line-height: 4vw;
  margin-left: 2vw;
  float: left;
}
.selectionOriginalPrice {
  font-size: 3vw;
  padding-top: 1vw;
  line-height: 6vw;
  color: gray;
  text-decoration: line-through;
  margin-left: 2vw;
  float: left;
}
.monthlySales {
  position: absolute;
  top: 13vw;
  right: 5vw;
  width: 20vw;
  height: 13vw;
  font-size: 3.8vw;
  background-color: red;
  font-weight: bold;
  text-align: center;
  color: white;
}
.monthlySales p {
  width: 20vw;
  height: 5vw;
  color: black;
  font-size: 3.8vw;
  line-height: 5vw;
  background-color: #d3d3d3;
  margin-bottom: 1vw;
}
</style>

<template>
  <div id="home">
    <div id="searchFrame">
      <router-link :to="{path: '/Search'}">
        <img class="searchimg" src="../../static/icon/search.png" />
        <input type="text" class="searchtexts" />
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
        v-if="paperlist.slideShows"
        :style="{left:leftshift+'vw'}"
        @touchstart="touchStart"
        @touchend="touchEnd"
      >
        <img
          class="carouselImg"
          v-for="(slideshow,i) in paperlist.slideShows"
          :src="slideshow.showUrl"
          @click="jumpCommodityDetails(slideshow.commodityId)"
        />
      </div>
    </div>

    <div class="classifys">
      <img class="classifyP" src="../../static/icon/classify.jpg" />
      <div
        class="classify"
        v-if="paperlist.classify"
        v-for="(classify,i) in paperlist.classify"
        :style="{'margin-right':(i==3||i==7?'0vw':'2vw')}"
        @click="jumpClassify(classify.classifyId,classify.classifyName)"
      >
        <img :src="classify.classifyImage" />
        <div class="classifyText">{{classify.classifyName}}</div>
      </div>
    </div>

    <div class="faddishs">
      <img class="faddishP" src="../../static/icon/faddish.jpg" />
      <div
        class="faddish"
        v-for="(faddish,i) in paperlist.faddish"
        :style="{'margin':(i==1?'0 2vw':'0')}"
        @click="jumpCommodityDetails(faddish.commodityId)"
      >
        <img :src="faddish.showUrl" />
        <div class="faddishPrice">￥{{faddish.price}}</div>
        <div class="faddishText">{{faddish.commodityName}}</div>
      </div>
    </div>
    <div class="selections">
      <img class="selectionP" src="../../static/icon/selection.jpg" />
      <div class="selection" v-for="(selection,i) in paperlist.hotSales" @click="jumpCommodityDetails(selection.commodityId)">
        <img :src="selection.showUrl" />
        <div class="selectionText">{{selection.commodityName}}</div>
        <div class="selectionParticulars">
          <div class="selectionDiscount">{{selection.discount}}折</div>
          <div class="selectionPrice">￥{{selection.price}}</div>
          <div class="selectionOriginalPrice">{{selection.originalPrice}}</div>
        </div>
        <div class="monthlySales">
          <p>已销售</p>
          {{selection.monthlySales}}件
        </div>
      </div>
    </div>
    <Footer :imagesUrl="imagesUrl"></Footer>
  </div>
</template>

<script>
import Footer from "@/components/FooterButton";
import Search from "@/components/Search";
export default {
  data() {
    return {
      paperlist: [],
      // 传递给底部导航栏的图片地址
      imagesUrl: {
        home: "../static/icon/homeb.png",
        message: "../static/icon/messagea.png",
        shopping: "../static/icon/shoppinga.png",
        my: "../static/icon/mya.png"
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
      classifyId:""
    };
  },
  components: {
    Footer
  },
  created() {
    this.$http
      .post(
        "http://47.100.137.237:8093/store/home?userid=user2",
        {},
        { emulateJSON: true }
      )
      .then(result => {
        this.paperlist = result.data;
      })
      .catch(e => {});
  },
  methods: {
    // 自动轮播事件
    carousel() {
      // alert("a");
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
       this.intervalId = setInterval(()=>{this.carousel()},3000);
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
       this.intervalId = setInterval(()=>{this.carousel()},3000);
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
      this.intervalId = setInterval(()=>{this.carousel()},3000);
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
        this.intervalId = setInterval(()=>{this.carousel()},3000);
        // console.log(this.endX);
      }
    },
    jumpClassify(classifyId,classifyName){
      this.$router.push({name:"Classify",params:{classifyId:classifyId,classifyName:classifyName}});
    },
    jumpCommodityDetails(commodityId){
      // alert(commodityId);
      this.$router.push({name:"CommodityDetails",params:{commodityId:commodityId}});
    }
  },
  mounted() {
    this.intervalId = setInterval(()=>{this.carousel()},3000);
  }
};
</script>