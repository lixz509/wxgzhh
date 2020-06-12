<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
/* 余额头部 */
.balanceHeader {
  position: fixed;
  background-color:antiquewhite;
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
.userBalance{
  width: 100vw;
  text-align: center;
  font-size: 5vw;
  margin-top: 20vw;
}
.recharge{
  width: 100vw;
  text-align: center;
  font-size: 4vw;
  margin-top: 5vw;
}
/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
</style>

<template>
  <div id="balance">
    <div id="vacancy"></div>
    <div class="balanceHeader">
      <img class="retreat" @click="retreat" src="../../static/icon/retreat.png" />
      <p style="text-align: center;padding-top: 15px;">余额</p>
    </div>
    <div class="userBalance">
      您当前余额为：{{balance}}
    </div>
    <div class="recharge">
      充值请联系后台人员
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      balance: 0,
    };
  },
  created(){
    this.$http
      .post(
        "http://47.100.137.237:8093/store/my/info?userid=user2",
        {},
        { emulateJSON: true }
      )
      .then(result => { 
        this.balance = result.data.balance;
      })
      .catch(e => {});
  },
  methods: {
    // 返回上一页
    retreat() {
      this.$router.go(-1);
    }
  }
};
</script>