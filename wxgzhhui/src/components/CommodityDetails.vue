<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color:#f6f6f6;
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
/* 返回键 */

</style>

<template>
  <div id="CommodityDetails">
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
    <div class="CommodityName">
      这是一个商品的商品名，很长很长很长，这是一个商品的商品名，很长很长很长，这是一个商品的商品名，
      很长很长很长，这是一个商品的商品名，很长很长很长
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
      ],
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
    }
  },
  mounted() {
    this.intervalId = setInterval(this.carousel, 3000);
  }
};
</script>