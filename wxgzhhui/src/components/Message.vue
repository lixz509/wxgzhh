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
    <div class="dialogueList">
      <div class="dialogue" v-for="(dialogue,i) in dialogueList">
        <router-link :to="{path: '/ChatRoom'}">
          <div class="dialogueName">{{dialogue.dialogueName}}</div>
          <div class="dialogueMessage">
            [{{dialogue.unreadNum}}条]{{dialogue.MessageText}}
            <div class="MessageTime">{{dialogue.MessageTime}}</div>
          </div>
        </router-link>
      </div>
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
      dialogueList: [
        {
          dialogueName: "小店客服",
          unreadNum: "3条",
          MessageText: "最后一条消息内容",
          MessageTime: "12:00"
        }
      ]
    };
  },
  name: "Message",
  components: {
    Footer
  }
};
</script>