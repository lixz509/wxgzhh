<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
/* 收藏夹头部 */
.favoriteHeader {
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
/* 收藏夹列表 */
.favoriteList {
  position: relative;
  width: 100vw;
}
.myFavorite {
  position: relative;
  width: 100vw;
  height: 25vw;
  margin: 1vw 0vw;
  background-color: #fff;
  border-radius: 5vw;
}
.myFavorite img {
  position: absolute;
  top: 2vw;
  left: 2vw;
  width: 20vw;
  height: 20vw;
}
.myFavoriteName {
  position: absolute;
  top: 4vw;
  left: 24vw;
  width: 74vw;
  font-size: 3vw;
  display: -webkit-box;
  overflow: hidden;
  height: 7vw;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
}
.myFavoriteState {
  position: absolute;
  top: 2vw;
  right: 6vw;
  font-size: 2.7vw;
}
.myFavoriteNum {
  position: absolute;
  top: 16vw;
  right: 6vw;
  font-size: 3vw;
}
.favoriteSellingPrice {
  position: absolute;
  left: 65vw;
  top: 16vw;
  width: 35vw;
  font-size: 3.5vw;
}
.favoriteOriginalPrice {
  display: inline-block;
  color: gray;
  font-size: 3.2vw;
  text-decoration: line-through;
}
.deleteFavorite{
  position: absolute;
  background-color: #fff;
  width: 8vw;
  top: 10vw;
  right: 9vw;
  z-index: 6;
}
/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
</style>

<template>
  <div id="favorite">
    <div id="vacancy"></div>
    <div class="favoriteHeader">
      <img class="retreat" @click="retreat" src="../../static/icon/retreat.png" />
      <p style="text-align: center;padding-top: 15px;">收藏夹</p>
    </div>
    <div class="favoriteList">
      <div class="myFavorite" v-for="(favorite,i) in paperlist">
        <div style="width:100vw;height:30vw" @click="jumpCommodityDetails(favorite.storeCommodity.commodityId)">
        <img :src="favorite.storeCommodity.showUrl" @click="jumpCommodityDetails(favorite.storeCommodity.commodityId)" />
        <div class="myFavoriteName" >{{favorite.storeCommodity.commodityName}}</div>
        <div class="favoriteSellingPrice">
          <div class="favoriteOriginalPrice">￥{{favorite.storeCommodity.originalPrice}}</div>
          ￥{{favorite.storeCommodity.price}}
        </div>
        </div>
        <input class="deleteFavorite" @click="deleteFavorite(favorite.storeCommodity.commodityId)" type="button"  value="删除" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      paperlist:[],
    };
  },
  created() {
    this.sort = this.$route.params.sort;
    this.$http
      .post(
        "http://47.100.137.237:8093/store/my/favorite?userid=user2",
        {},
        { emulateJSON: true }
      )
      .then(result => {
        this.paperlist = result.data;
      })
      .catch(e => {});
  },
  methods: {
    // 跳转到商品详情
    jumpCommodityDetails(commodityId){
      this.$router.push({name:"CommodityDetails",params:{commodityId:commodityId}});
    },
    // 删除收藏
    deleteFavorite(commodityId){
        if(confirm('确定要删除吗')==true){
          this.$http
            .post(
              "http://47.100.137.237:8093/store/commodity/deleteCollect?userid=user2&commodityId=" + commodityId,
              {},
              { emulateJSON: true }
            )
            .then(result => {})
            .catch(e => {});
          this.$http
            .post(
              "http://47.100.137.237:8093/store/my/favorite?userid=user2",
              {},
              { emulateJSON: true }
            )
            .then(result => {
              this.paperlist = result.data;
            })
            .catch(e => {});
        }
    },
    // 返回上一页
    retreat() {
      this.$router.go(-1);
    }
  }
};
</script>