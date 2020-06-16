<style>
* {
  margin: 0px;
  padding: 0px;
}
body {
  background-color: #f6f6f6;
}
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
      <input type="text" v-model="commodityName" class="searchtext"  @keyup.enter="searchAntistop(commodityName)" />
      <router-link :to="{path: '/Home'}">
        <div class="searchbtn">取消</div>
      </router-link>
    </div>
    <p v-for="(antistop,i) in antistops" class="antistop" @click="searchAntistop(antistop)">
      {{antistop}}
    </p>
    {{commodityName}}
  </div>
</template>

<script>
export default {
  data() {
    return {
      commodityName:"",
      antistops:{
        one:"手机投影仪",
        two:"容声 BCD-432WD12FPA",
        three:"傲风电竞椅",
        four:"蓝牙耳机",
        five:"真皮男士钱包",
        six:"a"
      }
    };
  },
  methods:{
    searchAntistop(commodityName){
      this.$router.push({name:"Commodity",params:{commodityName:commodityName}});
    }
  }
};
</script>