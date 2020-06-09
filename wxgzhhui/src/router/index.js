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

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Home0',
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
      path: '/Commodity',
      name: 'Commodity',
      component: Commodity
    },
    {
      path: '/CommodityDetails',
      name: 'CommodityDetails',
      component: CommodityDetails
    },
    {
      path: '/Payment/:orderId',
      name: 'Payment',
      component: Payment
    },
  ]
})
