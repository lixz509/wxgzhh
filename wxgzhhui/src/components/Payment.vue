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
.paymentHead {
  position: fixed;
  z-index: 5;
  top: 0vw;
  height: 60px;
  width: 100vw;
  background-color: antiquewhite;
  font-size: 24px;
  font-weight: bolder;
}
/* 支付 */
.confirm {
  position: relative;
  width: 100vw;
}
.paymentAmount {
  position: relative;
  width: 100vw;
  height: 6vw;
  text-align: center;
  font-size: 4vw;
}
.balance {
  position: relative;
  width: 100vw;
  height: 6vw;
  text-align: center;
  font-size: 4vw;
}
.confirmBtn {
  position: relative;
  width: 96vw;
  height: 6vw;
  margin-top: 2vw;
  left: 2vw;
  font-size: 4vw;
}
/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
</style>

<template>
  <div id="payment">
    <div id="vacancy"></div>
    <div class="paymentHead">
      <p style="text-align: center;padding-top: 15px">支付</p>
    </div>
    <div class="confirm">
      <div class="balance">余额：￥{{balance}}</div>
      <div class="paymentAmount">订单总金额：￥{{price}}</div>
      <input
        class="confirmBtn"
        style="background-color:orange;color: white;"
        type="button"
        value="确认支付"
        @click="confirm()"
      />
      <router-link :to="{path: '/Home'}">
        <input class="confirmBtn" type="button" value="取消" />
      </router-link>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      balance: 0,
      price: 0,
      orderId: []
    };
  },
  created() {
    // 获取订单id
    this.orderId = this.$route.params.orderId;
    // 获取余额
    this.$http
      .post(
        "http://47.100.137.237:8093/store/my/info?userid=user2",
        {},
        { emulateJSON: true }
      )
      .then(result => {
        this.balance = result.data.balance;
        // 查询订单金额
        for (var i = 0; i < this.orderId.length; i++) {
          this.$http
            .post(
              "http://47.100.137.237:8093/store/order/price?orderId=" +
                this.orderId[i],
              {},
              { emulateJSON: true }
            )
            .then(result => {
              this.price = parseInt(result.data) + this.price;
            })
            .catch(e => {});
        }
      })
      .catch(e => {});
  },
  methods: {
    confirm(){
      if(this.balance>this.price){
        for (var i = 0; i < this.orderId.length; i++) {
          this.$http
            .post(
              "http://47.100.137.237:8093/store/order/shipments?userid=user2&orderId=" +
                this.orderId[i],
              {},
              { emulateJSON: true }
            )
            .then(result => {
            })
            .catch(e => {});
            this.$router.push({name:"Home"});
        }
      }else{
        alert("余额不足");
        this.$router.push({name:"Home"});
      }
    }
  }
};
</script>