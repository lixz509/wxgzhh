import Vue from 'vue'
import Router from 'vue-router'
import Footer from '@/components/FooterButton'
import Home from '@/components/Home'
import Message from '@/components/Message'
import Shopping from '@/components/Shopping'
import My from '@/components/My'
import Search from "@/components/Search"
import ChatRoom from "@/components/ChatRoom"
import Commodity from "@/components/Commodity"
import CommodityDetails from "@/components/CommodityDetails"
import Payment from "@/components/Payment"
import Order from "@/components/Order"
import Balance from "@/components/Balance"
import Task from "@/components/Task"
import Favorite from "@/components/Favorite"
import Address from "@/components/Address"
import Security from "@/components/Security"
import Information from "@/components/Information"
import AboutUs from "@/components/AboutUs"
import ChatUserInfo from "@/components/ChatUserInfo"
import Classify from "@/components/Classify"
import Login from "@/components/Login"

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/Footer',
      name: 'Footer',
      component: Footer
    },
    {
      path: '/Search',
      name: 'Search',
      component: Search
    },
    {
      path: '/Home',
      name: 'Home',
      component: Home
    },
    {
      path: '/Message',
      name: 'Message',
      component: Message
    },
    {
      path: '/Shopping',
      name: 'Shopping',
      component: Shopping
    },
    {
      path: '/My',
      name: 'My',
      component: My
    },
    {
      path: '/ChatRoom',
      name: 'ChatRoom',
      component: ChatRoom
    },
    {
      path: '/Commodity/:commodityName',
      name: 'Commodity',
      component: Commodity
    },
    {
      path: '/CommodityDetails/:commodityId',
      name: 'CommodityDetails',
      component: CommodityDetails
    },
    {
      path: '/Payment/:orderId[]',
      name: 'Payment',
      component: Payment
    },
    {
      path: '/Order/:sort',
      name: 'Order',
      component: Order
    },
    {
      path: '/Balance',
      name: 'Balance',
      component: Balance
    },
    {
      path: '/Task',
      name: 'Task',
      component: Task
    },
    {
      path: '/Favorite',
      name: 'Favorite',
      component: Favorite
    },
    {
      path: '/Address',
      name: 'Address',
      component: Address
    },
    {
      path: '/Security',
      name: 'Security',
      component: Security
    },
    {
      path: '/Information',
      name: 'Information',
      component: Information
    },
    {
      path: '/AboutUs',
      name: 'AboutUs',
      component: AboutUs
    },
    {
      path: '/ChatUserInfo',
      name: 'ChatUserInfo',
      component: ChatUserInfo
    },
    {
      path: '/Classify/:classifyName/:classifyId',
      name: 'Classify',
      component: Classify
    },
    {
      path: '/Login',
      name: 'Login',
      component: Login
    },
  ]
})
router.beforeEach((to, from, next) => {
  // 1. 判断是不是登录页面
  // 是登录页面
  if(to.path === '/login') {
    next(
      
    )
  } else {
    // 不是登录页面
    
    // 2. 判断 是否登录过
    let token = localStorage.getItem('token')
    token ? next() : next('/login')
  }
})

export default router