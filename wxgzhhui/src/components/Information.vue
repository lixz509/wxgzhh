<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
/* 个人信息头部 */
.informationHeader {
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
.MyUserName,
.MyLocation{
  position: relative;
  width: 95vw;
  height: 10vw;
  margin-top: 5vw;
  margin-left: 5vw;
  font-size: 5vw;
}
.MyUserName textarea,
.MyLocation textarea{
  float:right;
  margin-right: 14vw;
  height: 6vw;
  width: 60vw;
  border:none;
  background-color: #f6f6f6;
  font-size: 4vw;
}
.informationBtn{
  position: absolute;
  height: 10vw;
  width: 96vw;
  top: calc(60px + 40vw);
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
  <div id="information">
    <div id="vacancy"></div>
    <div class="informationHeader">
      <img class="retreat" @click="retreat" src="../../static/icon/retreat.png" />
      <p style="text-align: center;padding-top: 15px;">我的信息</p>
    </div>
    <div class="MyUserName">
      昵称:<textarea v-model="userName" clos="10" rows="1" warp="virtual"  maxlength="11"></textarea>
    </div>
    <div class="MyLocation">
      所在地:<textarea v-model="location" clos="10" rows="2" warp="virtual" maxlength="100"></textarea>
    </div>
    <input class="informationBtn" type="button" value="保存" @click="updateUsernameAndLocation()"  >
  </div>
</template>

<script>
export default {
  data() {
    return {
      userName:"",
      location:""
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
        this.userName = result.data.userName;
        this.location = result.data.location;
      })
      .catch(e => {});
  },
  methods: {
    // 修改昵称，所在地
    updateUsernameAndLocation(){
      if(this.userName.length !=0){
        if(this.location.length !=0){
          this.$http
            .post(
              "http://47.100.137.237:8093/store/my/updateUsername?userid=user2&userName="+this.userName+"&location="+this.location,
              {},
              { emulateJSON: true }
            )
            .then(result => {
              this.$router.push({name:"My"});
            })
            .catch(e => {});
        }else{
          alert("请输入地址")
        }
      }else{
          alert("请输入昵称")
        }
    },
    // 返回上一页
    retreat() {
      this.$router.go(-1);
    }
  }
};
</script>