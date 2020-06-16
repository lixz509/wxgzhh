<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
/* 收货地址头部 */
.addressHeader {
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
.myAddress{
  position: absolute;
  width: 90vw;
  line-height: 10vw;
  top: calc(60px + 5vw);
  left: 5vw;
  font-size: 4vw;
}
.addressText{
  position: absolute;
  left: 25vw;
  top: calc(60px + 6vw);
  width: 65vw;
  font-size: 4vw;
  line-height: 4vw;
  height: 9vw;
}
.addressBtn{
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
  <div id="address">
    <div id="vacancy"></div>
    <div class="addressHeader">
      <img class="retreat" @click="retreat" src="../../static/icon/retreat.png" />
      <p style="text-align: center;padding-top: 15px;">收货地址</p>
    </div>
    <div class="myAddress">
      收货地址：</div>
    <textarea class="addressText" v-model="address"  clos="10" rows="2" warp="virtual" maxlength="100"></textarea>
     <input class="addressBtn" type="button" value="保存" @click="updateAaddress()"  >
  </div>
</template>

<script>
export default {
  data() {
    return {
      address:"",
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
        this.address = result.data.address;
      })
      .catch(e => {});
  },
  methods: {
    // 更改地址
    updateAaddress(){
      if(this.address.length !=0){
        this.$http
          .post(
            "http://47.100.137.237:8093/store/my/updateAddress?userid=user2&address="+this.address,
            {},
            { emulateJSON: true }
          )
          .then(result => {
            this.$router.push({name:"My"});
          })
          .catch(e => {});
      }else{
        alert("请输入地址");
      }
    },
    // 返回上一页
    retreat() {
      this.$router.go(-1);
    }
  }
};
</script>