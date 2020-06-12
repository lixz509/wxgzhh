<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
/* 个人信息头部 */
.informationHeader {
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
/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
</style>

<template>
  <div id="information">
    <div id="vacancy"></div>
    <div class="informationHeader">
      <img class="retreat" @click="retreat" src="../../static/icon/retreat.png" />
      <p style="text-align: center;padding-top: 15px;">我的信息</p>
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