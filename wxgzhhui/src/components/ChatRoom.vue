<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #2c3e50;
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
  position:relative;
  width: 100vw;
  display:inline-block; 
}
.message {
  position: relative;
  width: 100vw;
  margin-top: 2vw;
  float:right;
}
.message img {
  position: absolute;
  z-index: 3;
  width: 10vw;
  height: 10vw;
}
.messageContent {
  position:relative;
  background: white;
  max-width: 72vw;
  line-height: 10vw;
  border-radius: 2vw;
  letter-spacing:0.3vw;
  font-size: 4.8vw;
  display:inline-block; 
}
/* 输入框 */
.inputField {
  position: fixed;
  bottom: 0;
  z-index: 999;
  height: 60px;
  width: 100vw;
  background-color:lavender;
}
.inputBox{
  margin-top: 8px;
  margin-left: 7vw;
  height: 40px;
  width: 72vw;
  line-height: 40px;
  font-size: 4.8vw;
}
.seadText{
 position: absolute;
 top:8px;
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
      <router-link :to="{path: '/Message'}">
        <img class="retreat" src="../../static/icon/retreat.png" />
      </router-link>
      <p style="text-align: center;padding-top: 15px">小店客服</p>
      <img class="opposite" src="../../static/icon/opposite.png" />
    </div>
    <div class="messageList">
      <div class="message"  v-for="(message,i) in MessageList" >
        <img :src="message.sead=='客服'?'../../static/a.jpg':'../../static/b.jpg'" :style="message.sead=='客服'?'left:2vw':'right:2vw'" />
        <div class="messageContent" :style="message.sead=='客服'?'float:left;left:14vw':'float:right;right:14vw'" >{{message.content}}</div>
      </div>
    </div>
    <div id="vacancy"></div>
    <div class="inputField">
      <input type="text" class="inputBox"/>
      <input type="button" class="seadText" value="发送"/>
    </div>
  </div>
</template>

<script>
import Footer from "@/components/FooterButton";
export default {
  data() {
    return {
      MessageList: [
        {
          sead: "客服",
          receive: "我",
          content: "你好你好你好你好你好"
        },
        {
          sead: "客服",
          receive: "我",
          content: "你好"
        },
        {
          sead: "客服",
          receive: "我",
          content: "你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好"
        },
        {
          sead: "我",
          receive: "客服",
          content: "你好你好你好你好你好"
        },
        {
          sead: "我",
          receive: "客服",
          content: "你好"
        },
        {
          sead: "我",
          receive: "客服",
          content: "你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好"
        }
      ]
    };
  },
  name: "App",
  components: {
    Footer
  }
};
</script>