<style>
#searchFrame {
  position:relative;
  top: 0;
  z-index: 999;
  height: 60px;
  width: 100vw;
  background-color: black;
}
.searchimg {
  position:absolute;
  top: 15px;
  left: 20px;
  padding-left: 8px;
  width: 30px;
  height: 30px;
  z-index: 2;
  border-radius: 10px;
}
.searchtext {
  position:absolute;
  top: 7px;
  left: 20px;
  width: calc(100vw - 140px);
  height: 40px;
  z-index: 1;
  border-radius: 10px;
  padding-left: 40px;
}
.searchbtn {
  position:absolute;
  top: 15px;
  right: 0vw;
  width: 60px;
  height: 40px;
  border-radius: 10px;
  font-size: 20px;
  color: #81c16a;
}
.antistop{
  display: block;
  margin: 10px 10px;
  float: left;
  background-color:#F0F8FF;
  color: #81c16a;
}
</style>
<template>
  <div id="search">
    <div id="searchFrame">
      <img class="searchimg" src="../../static/icon/search.png" />
      <input type="text" class="searchtext" />
      <router-link :to="{path: '/Home'}">
        <div class="searchbtn">取消</div>
      </router-link>
    </div>
    <p v-for="(antistop,i) in antistops" class="antistop" @click="searchAntistop(antistop)">
      <router-link :to="{path: '/Commodity'}">
      {{antistop}}
      </router-link>
    </p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      antistops:{
        one:"第一个关键词",
        two:"第二个关键词",
        three:"第三个关键词",
        four:"第四个关键词",
        five:"第五个关键词",
      }
    };
  },
  methods:{
    searchAntistop(val){
      //之后写搜索方法
      alert(val);
    }
  }
};
</script>