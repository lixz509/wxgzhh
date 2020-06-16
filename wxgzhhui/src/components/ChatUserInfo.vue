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
/* 商家信息 */
.chatUserPortrait{
  position: absolute;
  width: 25vw;
  height: 25vw;
  top: calc(60px + 5vw);
  left: 3vw;
}
.chatUserName{
  position: absolute;
  height: 4vw;
  width: 65vw;
  top: calc(60px + 7vw);
  left: 32vw;
  font-size: 4vw;
  overflow: hidden;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 1;
}
.chatUserLocation{
  position: absolute;
  height: 4vw;
  width: 65vw;
  top: calc(60px + 16.5vw);
  left: 32vw;
  font-size: 4vw;
  overflow: hidden;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 1;
}
.chatUserPhone{
  position: absolute;
  height: 4vw;
  width: 65vw;
  top: calc(60px + 26vw);
  left: 32vw;
  font-size: 4vw;
}
.chatSendBtn{
  position: absolute;
  height: 10vw;
  width: 96vw;
  background-color: #fff;
  top: calc(60px + 35vw);
  left: 2vw;
  font-size: 5vw;
  letter-spacing:2vw;
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
    <img class="chatUserPortrait" :src="paperlist.portrait"/>
    <div class="chatUserName">
      商家名称：{{paperlist.userName}} 
    </div>
    <div class="chatUserLocation">
      所在地区：{{paperlist.location}}
    </div>
    <div class="chatUserPhone">
      手机号：{{paperlist.phone}}
    </div>
    <router-link :to="{path: '/ChatRoom',query:{dialogueUserId:dialogueUserId}}">
      <input class="chatSendBtn" type="button" value="发消息" />
    </router-link>
    <div>
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