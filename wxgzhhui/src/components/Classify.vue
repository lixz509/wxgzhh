<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
/* 关于我们头部 */
.classifyHeader {
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
/* 排序选项卡 */
.sort {
  position: fixed;
  background-color: beige;
  top: 60px;
  z-index: 10;
  height: 10vw;
  width: 100vw;
}
.sort ul {
  width: 100%;
  display: flex;
  list-style: none;
  padding: 0;
  margin: 0;
  color: #717181;
  font-size: 4vw;
  line-height: 10vw;
}
.sort ul li {
  flex: 1;
  text-align: center;
  cursor: pointer;
}
/* 商品列表 */
.commodityList {
  position: relative;
  width: 100vw;
}
.commodity {
  position: relative;
  width: 100vw;
  height: 30vw;
  background: cornsilk;
}
.commodity img {
  position: absolute;
  left: 2vw;
  top: 2vw;
  width: 25vw;
  height: 25vw;
}
.commodityText {
  position: absolute;
  width: 68vw;
  height: 8vw;
  top: 3vw;
  left: 30vw;
  font-size: 4vw;
  line-height: 4.3vw;
  text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  overflow: hidden;
  letter-spacing: 0.3vw;
}
.commodityPrice {
  position: absolute;
  left: 32vw;
  top: 22vw;
  font-size: 4vw;
  float: left;
}
.commodityOriginalPrice {
  display: inline;
  font-size: 4vw;
  color: gray;
  text-decoration: line-through;
}
/* 查询没有该分类 */
.classifyNull {
  width: 100vw;
  text-align: center;
  font-size: 3.5vw;
  margin-top: 20vw;
}
/* 填补空缺 */
#vacancy {
  height: 60px;
  position: relative;
}
</style>

<template>
  <div id="classify">
    <div id="vacancy" style="height: calc(60px + 10vw)"></div>
    <div class="classifyHeader">
      <img class="retreat" @click="retreat" src="../../static/icon/retreat.png" />
      <p style="text-align: center;padding-top: 15px;">{{classifyName}}</p>
    </div>
    <div class="sort">
      <ul>
        <li @click="searchClassify(1)">销量多</li>
        <li @click="searchClassify(2)">价格低</li>
        <li @click="searchClassify(3)">价格高</li>
      </ul>
    </div>
    <div class="commodityList">
      <div class="commodity" v-for="(commodity,i) in paperlist">
        <img :src="commodity.showUrl" />
        <div class="commodityText">{{commodity.commodityName}}</div>
        <div class="commodityPrice">
          ￥{{commodity.price}}
          <div class="commodityOriginalPrice">{{commodity.originalPrice}}</div>
        </div>
      </div>
    </div>
    <div class="classifyNull" v-show="paperlist.length == 0">暂时没有该类商品</div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      paperlist: [],
      classifyId: "",
      classifyName: ""
    };
  },
  created() {
    this.classifyId = this.$route.params.classifyId;
    this.classifyName = this.$route.params.classifyName;
    // 根据分类id查询该分类商品
    this.$http
      .post(
        "http://47.100.137.237:8093/store/home/classify?classifyId=" +
          this.classifyId +
          "&sort=1",
        {},
        { emulateJSON: true }
      )
      .then(result => {
        this.paperlist = result.data;
      })
      .catch(e => {});
  },
  methods: {
    // 返回上一页
    retreat() {
      this.$router.go(-1);
    },
    // 重新排序
    searchClassify(sort) {
      this.$http
        .post(
          "http://47.100.137.237:8093/store/home/classify?classifyId=" +
            this.classifyId +
            "&sort=" +
            sort,
          {},
          { emulateJSON: true }
        )
        .then(result => {
          this.paperlist = result.data;
        })
        .catch(e => {});
    }
  }
};
</script>