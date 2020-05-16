<style>
.footerButton_content {
  position:fixed;
  bottom: 0;
  z-index: 999;
  height: 60px;
  width: 100vw;
  background-color: black;
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
}
.footerButton_content_li {
  flex: 1;
  height: 45px;
}
.footerButton_content_li img {
  width: 30px;
}
.router-link-active{
  text-decoration:none;
  color: #fff;
}
.router-link{
  color: #fff;
}
/* 填补空缺 */
#vacancy{
  height: 60px;
  position: relative;
}
</style>
<template>
  <div id="footerButton">
    <div class="footerButton_content">
      <div class="footerButton_content_li">
        <router-link :to="{path: '/Home'}">
          <img :src="imagesUrl.home" />
          <div class="router-link">首页</div>
        </router-link>
      </div>
      <div class="footerButton_content_li">
        <router-link :to="{path: '/Message'}">
          <img :src="imagesUrl.message" />
          <div class="router-link">消息</div>
        </router-link>
      </div>
      <div class="footerButton_content_li">
        <router-link :to="{path: '/Shopping'}">
          <img :src="imagesUrl.shopping" />
          <div class="router-link">购物车</div>
        </router-link>
      </div>
      <div class="footerButton_content_li">
        <router-link :to="{path: '/My'}">
          <img :src="imagesUrl.my" />
          <div class="router-link">我的</div>
        </router-link>
      </div>
    </div>
    <div id="vacancy"></div>
  </div>
</template>

<script>
export default {
  data() {
    return {
    };
  },
  props: ['imagesUrl']
};
</script>