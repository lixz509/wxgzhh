<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
/* 余额头部 */
.chatUserHeader {
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
  <div id="chatUserInfo">
    <div id="vacancy"></div>
    <div class="chatUserHeader">
      <img class="retreat" @click="retreat" src="../../static/icon/retreat.png" />
      <p style="text-align: center;padding-top: 15px;">商家信息</p>
    </div>
    <div>
      {{dialogueUserId}}
      {{paperlist}}
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogueUserId: "",
      paperlist: [],
    };
  },
  created() {
    this.dialogueUserId = this.$route.query.dialogueUserId;
    this.$http
      .post(
        "http://47.100.137.237:8093/store/my/info?userid="+this.dialogueUserId,
        {},
        { emulateJSON: true }
      )
      .then(result => {
        this.paperlist = result.data;
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