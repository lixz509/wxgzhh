<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f1fafa;
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
  font-weight: bolder;
}
/* 对话列表 */
.dialogueList {
  position: relative;
  width: 100vw;
}
.dialogue {
  position: relative;
  width: 100vw;
  height: 20vw;
  background: wheat;
}
.dialogueName {
  position: absolute;
  left: 15px;
  top: 1vw;
  font-size: 5vw;
}
.dialogueMessage {
  position: absolute;
  left: 15px;
  width: calc(100vw - 15px);
  font-size: 4vw;
  bottom: 1vw;
  color: #778899;
}
.MessageTime {
  position: absolute;
  bottom: 0vw;
  right: 15px;
}
/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
</style>

<template>
  <div id="message">
    <div id="vacancy"></div>
    <div class="messageHead">
      <p style="text-align: center;padding-top: 15px">消息</p>
    </div>
    <div class="dialogueList" v-if="paperlist.chatDtos" v-for="(dialogue,i) in paperlist.chatDtos">
      <router-link :to="{path: '/ChatRoom',query:{dialogueUserId:dialogue.dialogueUserId}}">
        <div class="dialogue">
          <div class="dialogueName">{{dialogue.dialogueName}}</div>
          <div class="dialogueMessage">
            [{{dialogue.unreadNum}}条]{{dialogue.lastMessage}}
            <div class="MessageTime">{{dialogue.time}}</div>
          </div>
        </div>
      </router-link>
    </div>
    <Footer :imagesUrl="imagesUrl"></Footer>
  </div>
</template>

<script>
import Footer from "@/components/FooterButton";
export default {
  data() {
    return {
      imagesUrl: {
        home: "../static/icon/homea.png",
        message: "../static/icon/messageb.png",
        shopping: "../static/icon/shoppinga.png",
        my: "../static/icon/mya.png"
      },
      paperlist: []
    };
  },
  name: "Message",
  created() {
    this.$http
      .post(
        "http://47.100.137.237:8093/store/chat?userid=user2",
        {},
        { emulateJSON: true }
      )
      .then(result => {
        this.paperlist = result.data;
      })
      .catch(e => {});
  },
  components: {
    Footer
  }
};
</script>