<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
  /* background-color: #2c3e50; */
}
/* 头部 */
.messageHead {
  position: fixed;
  z-index: 5;
  top: 0vw;
  height: 60px;
  width: 100vw;
  background-color: antiquewhite;
  font-size: 24px;
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
/* 消息列表 */
.messageList {
  position: relative;
  width: 100vw;
  display: inline-block;
}
.message {
  position: relative;
  width: 100vw;
  margin-top: 2vw;
  float: right;
}
.message img {
  position: absolute;
  z-index: 3;
  width: 10vw;
  height: 10vw;
}
.messageContent {
  position: relative;
  background: white;
  max-width: 72vw;
  line-height: 10vw;
  border-radius: 2vw;
  letter-spacing: 0.3vw;
  font-size: 4.8vw;
  display: inline-block;
}
/* 输入框 */
.inputField {
  position: fixed;
  bottom: 0;
  z-index: 999;
  height: 60px;
  width: 100vw;
  background-color: lavender;
}
.inputBox {
  margin-top: 8px;
  margin-left: 7vw;
  height: 40px;
  width: 72vw;
  line-height: 40px;
  font-size: 4.8vw;
}
.seadText {
  position: absolute;
  top: 8px;
  height: 40px;
  background: yellowgreen;
  color: white;
  right: 2vw;
  font-size: 4vw;
  width: 16vw;
}
/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
</style>

<template>
  <div id="ChatRoom">
    <div id="vacancy"></div>
    <div class="messageHead">
      <img class="retreat" @click="retreat" src="../../static/icon/retreat.png" />
      <p style="text-align: center;padding-top: 15px">{{dialogueUser.userName}}</p>
      <router-link :to="{path: '/ChatUserInfo',query:{dialogueUserId:dialogueUserId}}">
        <img class="opposite" src="../../static/icon/opposite.png" />
      </router-link>
    </div>
    <div class="messageList">
      <div class="message" v-for="(message,i) in paperlist">
        <img
          :src="message.sendId==dialogueUser.userId?dialogueUser.portrait:'../../static/b.jpg'"
          :style="message.sendId==dialogueUser.userId?'left:2vw':'right:2vw'"
        />
        <div
          class="messageContent"
          :style="message.sendId==dialogueUser.userId?'float:left;left:14vw':'float:right;right:14vw'"
        >{{message.dialogueText}}</div>
      </div>
    </div>
    <div id="vacancy"></div>
    <div class="inputField">
      <input type="text" v-model="sendText" class="inputBox" @keyup.enter="addDialogue" />
      <input type="button" class="seadText" value="发送" @click="addDialogue" />
    </div>
  </div>
</template>

<script>
import Footer from "@/components/FooterButton";
export default {
  data() {
    return {
      // 对话另一方id
      dialogueUserId: "",
      dialogueUser: [],
      sendText: "",
      intervalId: "", //计时器
      paperlist: []
    };
  },
  name: "ChatRoom",
  created() {
    // 获取对话另一方id
    this.dialogueUserId = this.$route.query.dialogueUserId;
    this.$http
      .post(
        "http://47.100.137.237:8093/store/chat/dialogue?userid=user2&dialogueUserId=" +
          this.dialogueUserId,
        {},
        { emulateJSON: true }
      )
      .then(result => {
        this.paperlist = result.data;
      })
      .catch(e => {});
    this.$http
      .post(
        "http://47.100.137.237:8093/store/my/info?userid=" +
          this.dialogueUserId,
        {},
        { emulateJSON: true }
      )
      .then(result => {
        this.dialogueUser = result.data;
        this.diaImage = this.dialogueUser.portrait;
      })
      .catch(e => {});
  },
  methods: {
    addDialogue() {
      if (this.sendText != "") {
        this.$http
          .post(
            "http://47.100.137.237:8093/store/chat/add?userid=user2&receptionid=" +
              this.dialogueUserId +
              "&text=" +
              this.sendText,
            {},
            { emulateJSON: true }
          )
          .then(result => {})
          .catch(e => {});
        this.sendText = "";
      } else {
        alert("a");
      }
    },
    refresh() {
      this.$http
        .post(
          "http://47.100.137.237:8093/store/chat/dialogue?userid=user2&dialogueUserId=" +
            this.dialogueUserId,
          {},
          { emulateJSON: true }
        )
        .then(result => {
          this.paperlist = result.data;
        })
        .catch(e => {});
    },
    // 返回上一页
    retreat() {
      this.$router.go(-1);
    },
  },
  mounted() {
    this.intervalId = setInterval(this.refresh, 1000);
  },
  beforeDestroy() {
    // 销毁定时器
    this.intervalId = "";
  },
  components: {
    Footer
  }
};
</script>