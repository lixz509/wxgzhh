import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Footer from '@/components/FooterButton'
import BottomNavigation from '@/components/BottomNavigation'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/Home',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/Footer',
      name: 'Footer',
      component: Footer
    },
    {
      path: '/BottomNavigation',
      name: 'bottomNavigation',
      component: BottomNavigation
    }
  ]
})
