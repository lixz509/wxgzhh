// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
// 按需导入muti-ui中的组件
import { Swipe, SwipeItem } from 'mint-ui';

// 引入 http.js 文件
import axios from './http/http';
Vue.prototype.axios = axios

// 引入请求插件
import  VueResource  from 'vue-resource'
Vue.use(VueResource) 

// 注册组件
Vue.component(Swipe.name, Swipe);
Vue.component(SwipeItem.name, SwipeItem);


Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})

// 解决跳转报错
import Router from 'vue-router'
const routerPush = Router.prototype.push
Router.prototype.push = function push(location) {
  return routerPush.call(this, location).catch(error=> error)
}

