<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
/* 关于我们头部 */
.balanceHeader {
  position: fixed;
  background-color: antiquewhite;
  z-index: 10;
  top: 0vw;
  height: 60px;
  width: 100vw;
  font-size: 24px;
  font-weight: bolder;
}
.retreat {
  position: absolute;
  top: 15px;
  left: 15px;
  width: 30px;
  height: 30px;
}
/* 信息 */
.info{
  width: 100vw;
  text-align: center;
  font-size: 5vw;
  margin-top: 20vw;
}
/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
</style>

<template>
  <div id="aboutUs">
    <div id="vacancy"></div>
    <div class="balanceHeader">
      <img class="retreat" @click="retreat" src="../../static/icon/retreat.png" />
      <p style="text-align: center;padding-top: 15px;">关于我们</p>
    </div>
    <div class="info">
      <p>系统制作者：李培金</p>
      <p>微信:15916614452</p>
      <p>手机同号</p>
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