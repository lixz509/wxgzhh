<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
/* 头部 */
.loginHead {
  position: fixed;
  z-index: 5;
  top: 0vw;
  height: 60px;
  width: 100vw;
  background-color: antiquewhite;
  font-size: 24px;
  font-weight: bolder;
}
/* 用户名密码 */
.loginUserName {
  position: absolute;
  width: 90vw;
  line-height: 10vw;
  top: calc(60px + 50vw);
  left: 5vw;
  font-size: 6vw;
}
.loginPassword {
  position: absolute;
  width: 90vw;
  line-height: 10vw;
  top: calc(60px + 70vw);
  left: 5vw;
  font-size: 6vw;
}
/* 输入框 */
.userNameBox {
  position: absolute;
  width: 62vw;
  height: 9vw;
  right: 3vw;
}
.passwordBox {
  position: absolute;
  width: 62vw;
  height: 9vw;
  right: 3vw;
}
.loginMessage {
  position: absolute;
  width: 80vw;
  line-height: 10vw;
  top: calc(60px + 85vw);
  left: 10vw;
  font-size: 4vw;
  color: red;
}
/* 提交按钮 */
.loginBtn {
  position: absolute;
  height: 10vw;
  width: 96vw;
  top: calc(60px + 100vw);
  left: 2vw;
  background-color: #fff;
  border: #708090 solid 1px;
  font-size: 3vw;
}
/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
</style>

<template>
  <div id="Login">
    <div id="vacancy"></div>
    <div class="loginHead">
      <p style="text-align: center;padding-top: 15px">登录</p>
    </div>
    <div class="loginUserName">
      用户名:
      <input type="text" class="userNameBox" v-model="userid" />
    </div>
    <div class="loginPassword">
      密码：
      <input type="password" class="passwordBox" v-model="password" />
    </div>
    <div class="loginMessage">{{errorMsg}}</div>
    <input class="loginBtn" type="button" value="登录" @click="login()" />
  </div>
</template>
<script>
export default {
  data() {
    return {
      paperlist: [],
      userid: "user2",
      password: "123456",
      errorMsg: ""
    };
  },
  created() {},
  methods: {
    // 提交登录信息
    login() {
      this.$http
        .post(
          "http://47.100.137.237:8093/store/login?userid=" +
            this.userid +
            "&password=" +
            this.password,
          {},
          { emulateJSON: true }
        )
        .then(result => {
          var date = new Date().getTime();
          this.paperlist = result.data;
          if (this.paperlist == "ok") {
            window.localStorage.setItem("token", "123", date + 1000);
            this.$router.push({ name: "Home" });
          } else {
            this.errorMsg="用户名或密码错误";
          }
        })
        .catch(e => {});
    }
  }
};
</script>