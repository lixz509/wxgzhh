<style>
    #bottomNavigationFullScreen {
        position: fixed;
        bottom: 0;
        z-index: 9999;
        height: 60px;
        width: 100%;
        -webkit-box-shadow: 0 1px 6px rgba(0,0,0,.117647), 0 1px 4px rgba(0,0,0,.117647);
        box-shadow: 0 1px 6px rgba(0,0,0,.117647), 0 1px 4px rgba(0,0,0,.117647);
        background-color: #fff;
    }
    /* .bottomNavigation_content {
    } */
 
    .bottomNavigation_li_content {
        height: 60px;
        display: flex;
        justify-content:center;
        align-items: center;
        text-align: center;
    }
 
    .bottomNavigation_li_public_content {
        flex: 1;
        height: 45px;
        /* margin-left: 3px;
        background-color: #ccc; */
    }
    .bottomNavigation_li_public_content img {
        height: 24px;
        width: 24px;
    }
    .bottomNavigation_li_public_content div {
        position: relative;
        bottom: 3px;
    }
 
    .no_select {
        font-size: 12px;
        color: #222;
    }
 
    @keyframes select {
      0% {
        font-size: 12px;
      }
      50% {
        font-size: 13px;
      }
      100% {
        font-size: 14px;
      }
    }
    .select {
        animation: select 0.6s;
        font-size: 14px;
        color: #2196f3;
    }
</style>
<template>
    <div id="bottomNavigationFullScreen">
      <div class="bottomNavigation_content">
        <div class="bottomNavigation_li_content">
            <div class="bottomNavigation_li_public_content"  @click="publicClick('/')">
                <img :src="imagesUrl.homeIcon" alt="">
                <div :class="imagesUrl.homeIcon.indexOf('click_home') === -1 ? 'no_select' : 'select' ">首页</div>
            </div>
            <div class="bottomNavigation_li_public_content" @click="publicClick('/recharge')">
                <img :src="imagesUrl.rechargeIcon" alt="">
                <div :class="imagesUrl.rechargeIcon.indexOf('click_recharge') === -1 ? 'no_select' : 'select' ">充值</div>
            </div>
            <div class="bottomNavigation_li_public_content" @click="publicClick('/more')">
                <img :src="imagesUrl.moreIcon" alt="">
                <div :class="imagesUrl.moreIcon.indexOf('click_more') === -1 ? 'no_select' : 'select' ">更多</div>
            </div>
            <div class="bottomNavigation_li_public_content" @click="publicClick('/my')">
                <img :src="imagesUrl.myIcon" alt="">
                <div :class="imagesUrl.myIcon.indexOf('click_my') === -1 ? 'no_select' : 'select' ">我的</div>
            </div>
        </div>
      </div>
    </div>
</template>
<script>
    export default {
        name: 'bottomNavigation',
        data() {
            return {
                imagesUrl: { // 排版图片使用懒加载
                    homeIcon: './static/img/home/navigation/home.png', // 首页
                    rechargeIcon: './static/img/home/navigation/recharge.png', // 充值
                    moreIcon: './static/img/home/navigation/more.png', // 更多
                    myIcon: './static/img/home/navigation/my.png' // 我的
                }
            }
        },
        activated() {
            if (typeof this.$route.path === 'string') {
                let val = this.$route.path
                // let val = this.$route.path.substring(1, this.$route.path.length)
                // console.log(val)
                switch (val) {
                    case '/':
                        this.imagesUrl.homeIcon = './static/img/home/navigation/click_home.png' // 首页
                        this.imagesUrl.rechargeIcon = './static/img/home/navigation/recharge.png' // 充值
                        this.imagesUrl.moreIcon = './static/img/home/navigation/more.png' // 更多
                        this.imagesUrl.myIcon = './static/img/home/navigation/my.png' // 我的
                        break
                    case '/recharge':
                        this.imagesUrl.homeIcon = './static/img/home/navigation/home.png' // 首页
                        this.imagesUrl.rechargeIcon = './static/img/home/navigation/click_recharge.png' // 充值
                        this.imagesUrl.moreIcon = './static/img/home/navigation/more.png' // 更多
                        this.imagesUrl.myIcon = './static/img/home/navigation/my.png' // 我的
                        break
                    case '/more':
                        this.imagesUrl.homeIcon = './static/img/home/navigation/home.png' // 首页
                        this.imagesUrl.rechargeIcon = './static/img/home/navigation/recharge.png' // 充值
                        this.imagesUrl.moreIcon = './static/img/home/navigation/click_more.png' // 更多
                        this.imagesUrl.myIcon = './static/img/home/navigation/my.png' // 我的
                        break
                    case '/my':
                        this.imagesUrl.homeIcon = './static/img/home/navigation/home.png' // 首页
                        this.imagesUrl.rechargeIcon = './static/img/home/navigation/recharge.png' // 充值
                        this.imagesUrl.moreIcon = './static/img/home/navigation/more.png' // 更多
                        this.imagesUrl.myIcon = './static/img/home/navigation/click_my.png' // 我的
                        break
                }
            } else {
                console.log('不合法参数')
            }
        },
        methods: {
            // 点击切换函数
            clickChang(val) {
                // console.log('点击切换函数' + val)
                if (typeof val === 'string') {
                    switch (val) {
                        case '/':
                            this.imagesUrl.homeIcon = './static/img/home/navigation/click_home.png' // 首页
                            this.imagesUrl.rechargeIcon = './static/img/home/navigation/recharge.png' // 充值
                            this.imagesUrl.moreIcon = './static/img/home/navigation/more.png' // 更多
                            this.imagesUrl.myIcon = './static/img/home/navigation/my.png' // 我的
                            this.$router.push({ path: '/' })
                            // console.log(this.imagesUrl)
                            break
                        case '/recharge':
                            this.imagesUrl.homeIcon = './static/img/home/navigation/home.png' // 首页
                            this.imagesUrl.rechargeIcon = './static/img/home/navigation/click_recharge.png' // 充值
                            this.imagesUrl.moreIcon = './static/img/home/navigation/more.png' // 更多
                            this.imagesUrl.myIcon = './static/img/home/navigation/my.png' // 我的
                            this.$router.push({ path: '/recharge' })
                            // console.log(this.imagesUrl)
                            break
                        case '/more':
                            this.imagesUrl.homeIcon = './static/img/home/navigation/home.png' // 首页
                            this.imagesUrl.rechargeIcon = './static/img/home/navigation/recharge.png' // 充值
                            this.imagesUrl.moreIcon = './static/img/home/navigation/click_more.png' // 更多
                            this.imagesUrl.myIcon = './static/img/home/navigation/my.png' // 我的
                            this.$router.push({ path: '/more' })
                            // console.log(this.imagesUrl)
                            break
                        case '/my':
                            this.imagesUrl.homeIcon = './static/img/home/navigation/home.png' // 首页
                            this.imagesUrl.rechargeIcon = './static/img/home/navigation/recharge.png' // 充值
                            this.imagesUrl.moreIcon = './static/img/home/navigation/more.png' // 更多
                            this.imagesUrl.myIcon = './static/img/home/navigation/click_my.png' // 我的
                            this.$router.push({ path: '/my' })
                            // console.log(this.imagesUrl)
                            break
                    }
                } else {
                    console.log('不合法的传值')
                }
            },
            // 点击导航栏事件
            publicClick(val) {
                // console.log('点击导航栏事件' + val)
                if (typeof val === 'string') {
                    switch (val) {
                        case '/':
                            this.clickChang(val)
                            // this.$router.push({ path: '/' })
                            break
                        case '/recharge':
                            this.clickChang(val)
                            // this.$router.push({ path: '/recharge' })
                            break
                        case '/more':
                            this.clickChang(val)
                            // this.$router.push({ path: '/more' })
                            break
                        case '/my':
                            this.clickChang(val)
                            // this.$router.push({ path: '/my' })
                            break
                    }
                } else {
                    console.log('不合法的传值')
                }
            }
        }
    }
</script>
