<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
/* 账号安全头部 */
.securityHeader {
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
.myPassword{
  position: relative;
  width: 92vw;
  height: 10vw;
  left: 4vw;
  top: 6vw;
  font-size: 4vw;
}
.myPassword input{
  width: 60vw;
  height: 4.5vw;
  font-size: 4vw;
}
.securityBtn{
  position: absolute;
  height: 10vw;
  width: 96vw;
  top: calc(60px + 40vw);
  left: 2vw;
  font-size: 3vw;
  background-color: #fff;
  border: #708090 solid 1px;
}
/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
</style>

<template>
  <div id="security">
    <div id="vacancy"></div>
    <div class="securityHeader">
      <img class="retreat" @click="retreat" src="../../static/icon/retreat.png" />
      <p style="text-align: center;padding-top: 15px;">账号与安全</p>
    </div>
    <div class="myPassword">
      请输入原密码: <input type="password" v-model="originalPassword" maxlength="16" />
    </div>
    <div class="myPassword">
      请输入新密码: <input type="password" v-model="newPassword" maxlength="16" />
    </div>
    <div class="myPassword">
      请确认新密码: <input type="password" v-model="confirmPassword" maxlength="16" />
    </div>
    <input class="securityBtn" type="button" value="确认修改密码" @click="updatePassword()"  >
  </div>
</template>

<script>
export default {
  data() {
    return {
      myPassword:"",
      originalPassword:"",
      newPassword:"",
      confirmPassword:""
    };
  },
  created() {
    this.$http
      .post(
        "http://47.100.137.237:8093/store/my/info?userid=user2",
        {},
        { emulateJSON: true }
      )
      .then(result => {
        this.myPassword = result.data.password;
      })
      .catch(e => {});
  },
  methods: {
    // 修改密码
    updatePassword(){
      if(this.myPassword == this.originalPassword){
        if(this.newPassword.length>0 && this.newPassword == this.confirmPassword){
          this.$http
            .post(
              "http://47.100.137.237:8093/store/my/updatePassword?userid=user2&password="+this.newPassword,
              {},
              { emulateJSON: true }
            )
            .then(result => {
              this.$router.push({name:"My"});
            })
            .catch(e => {});
        }else{
          alert("请确认两次密码输入是否一致且不为空");
        }
      }else{
        alert("请输入正确密码");
      }
    },
    // 返回上一页
    retreat() {
      this.$router.go(-1);
    }
  }
};
</script>