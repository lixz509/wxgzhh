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
.shoppingHead {
  position: fixed;
  z-index: 5;
  top: 0vw;
  height: 60px;
  width: 100vw;
  background-color: antiquewhite;
  font-size: 24px;
  font-weight: bolder;
}
/* 商品列表 */
.productList {
  position: relative;
  width: 100vw;
}
.product {
  position: relative;
  width: 100vw;
  height: 30vw;
  background-color: white;
}
.checkboxa {
  position: absolute;
  /* background-color: blue; */
  left: 4vw;
  top: 10vw;
  width: 5vw;
  height: 5vw;
}
.product img {
  position: absolute;
  left: 12vw;
  top: 3vw;
  width: 20vw;
  height: 20vw;
}
.productText {
  position: absolute;
  width: 64vw;
  height: 8vw;
  top: 3vw;
  left: 34vw;
  font-size: 3.5vw;
  line-height: 4vw;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  overflow: hidden;
  letter-spacing: 0.3vw;
}
.productPrice {
  position: absolute;
  left: 36vw;
  top: 20vw;
  font-size: 3.5vw;
}
.productSubtract {
  position: relative;
  background-color: #b0c4de;
  display: inline-block;
  width: 3vw;
  text-align: center;
}
.productAdd {
  position: relative;
  background-color: #b0c4de;
  display: inline-block;
  width: 3vw;
  text-align: center;
}
.deleteShoppingTrolley{
  position: absolute;
  background-color: #fff;
  width: 8vw;
  top: 13vw;
  right: 9vw;
}
.commoditNum {
  position: absolute;
  width: 15vw;
  height: 5vw;
  top: 20vw;
  right: 5vw;
  font-size: 3.5vw;
}
/* 结算 */
.settlement {
  position: fixed;
  z-index: 5;
  width: 100vw;
  height: 60px;
  bottom: 60px;
  background-color: aqua;
}
.checkboxb {
  position: absolute;
  /* background-color: blue; */
  left: 4vw;
  top: calc((60px - 7vw) / 2);
  width: 5vw;
  height: 5vw;
}
.settlementP {
  position: absolute;
  left: 12vw;
  top: calc((60px - 7vw) / 2);
  font-size: 5vw;
}
.settlementBtn {
  position: absolute;
  right: 5vw;
  top: calc((60px - 7vw) / 2);
  width: 12vw;
  font-size: 5vw;
}
.settlementPrice {
  position: absolute;
  top: calc((60px - 6vw) / 2);
  right: 19vw;
  font-size: 4vw;
}

/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
</style>

<template>
  <div id="shopping">
    <div id="vacancy"></div>
    <div class="shoppingHead">
      <p style="text-align: center;padding-top: 15px">购物车</p>
    </div>
    <div class="productList">
      <div class="product" v-for="(product,i) in paperlist">
        <input
          class="checkboxa"
          type="checkbox"
          v-model="settlement"
          :value="product.shoppingTrolleyId"
        />
        <img :src="product.showUrl" />
        <div class="productText">{{product.commodityName}}</div>
        <div class="productPrice">{{product.price}}</div>
        <input class="deleteShoppingTrolley" @click="deleteShopping(product.shoppingTrolleyId)" type="button" value="删除" />
        <div class="commoditNum">
          <div
            class="productSubtract"
            @click="reviseNum(product.shoppingTrolleyId,parseInt(product.quantity)-1,i)"
          >-</div>
          {{product.quantity}}
          <div
            class="productAdd"
            @click="reviseNum(product.shoppingTrolleyId,parseInt(product.quantity)+1,i)"
          >+</div>
        </div>
      </div>
    </div>
    <div class="settlement" >
      <input class="checkboxb" @click="checkboxAll()" type="checkbox" v-model="checked" />
      <div class="settlementP">全选</div>
      <div class="settlementPrice">合计:{{paymentAmount}}</div>
      <input type="button" class="settlementBtn" @click="settlementAccounts()" value="结算" />
    </div>
    <div id="vacancy"></div>
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
        message: "../static/icon/messagea.png",
        shopping: "../static/icon/shoppingb.png",
        my: "../static/icon/mya.png"
      },
      paperlist: [],
      intervalId: "", //计时器
      paymentAmount: 0,
      checked: false, //设置全选按钮默认布尔值
      settlement: [],
      orderId:[]
    };
  },
  name: "Shopping",
  components: {
    Footer
  },
  created() {
    this.$http
      .post(
        "http://127.0.0.1:8093/store/shopping?userid=user2",
        {},
        { emulateJSON: true }
      )
      .then(result => {
        this.paperlist = result.data;
      })
      .catch(e => {});
  },
  methods: {
    reviseNum(shoppingTrolleyId, num, i) {
      if (num > 0) {
        this.$http
          .post(
            "http://127.0.0.1:8093/store/shopping/number?shoppingTrolleyId=" +
              shoppingTrolleyId +
              "&num=" +
              num,
            {},
            { emulateJSON: true }
          )
          .then(result => {})
          .catch(e => {});
      }
    },
    checkboxAll() {
      if (this.checked) {
        this.settlement = [];
      } else {
        this.settlement = [];
        for (var i = 0; i < this.paperlist.length; i++) {
          this.settlement[i] = this.paperlist[i].shoppingTrolleyId;
        }
      }
    },
    settlementAccounts() {
      if (this.settlement.length != 0) {
        for (var i = 0; i < this.settlement.length; i++) {
          this.$http
            .post(
              "http://127.0.0.1:8093/store/shopping/order?shoppingTrolleyId=" +
                this.settlement[i],
              {},
              { emulateJSON: true }
            )
            .then(result => {
              this.orderId.push(result.data);
              if(i = this.settlement.length){
                // 需在此阶段传，否则会出奇怪的错误
                // alert("跳转前"+this.orderId);
                this.$router.push({name:"Payment",params:{orderId:this.orderId}});
              }
            })
            .catch(e => {});
        }  
      };
    },
    // 删除购物车
    deleteShopping(shoppingTrolleyId){
        if(confirm('确定要删除吗')==true){
          this.$http
            .post(
              "http://127.0.0.1:8093/store/shopping/deleteShoppingTrolley?shoppingTrolleyId="+shoppingTrolleyId,
              {},
              { emulateJSON: true }
            )
            .then(result => {
              this.refresh();
            })
            .catch(e => {});
        }
    },
    refresh() {
      this.paymentAmount = 0;
      for (var i = 0; i < this.paperlist.length; i++) {
        if (
          this.settlement.indexOf(this.paperlist[i].shoppingTrolleyId) != -1
        ) {
          this.paymentAmount =
            this.paymentAmount +
            this.paperlist[i].quantity * this.paperlist[i].price;
        }
      }
      this.$http
        .post(
          "http://127.0.0.1:8093/store/shopping?userid=user2",
          {},
          { emulateJSON: true }
        )
        .then(result => {
          this.paperlist = result.data;
        })
        .catch(e => {});
    }
  },
  mounted() {
    // this.intervalId = setInterval(this.refresh, 1000);
  },
  beforeDestroy() {
    // 销毁定时器
    this.intervalId = "";
  }
};
</script>