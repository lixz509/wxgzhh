<style>
#footerButton {
    position: fixed;
    bottom: 0;
    z-index: 999;
    height: 60px;
    width: 100%;
}
.footerButton_content{
    height: 60px;
    display: flex;
    justify-content:center;
    align-items: center;
    text-align: center;
}
.footerButton_content_li{
    flex: 1;
    height: 45px;
}
.footerButton_content_li img{
    width: 30px;
}
</style>
<template>
    <div id="footerButton">
        <div class="footerButton_content">
            <div class="footerButton_content_li">
                <img src="../assets/logo.png">
                <div>首页</div>
            </div>
            <div class="footerButton_content_li">
                <div>消息</div>
            </div>
            <div class="footerButton_content_li">
                <div>购物车</div>
            </div>
            <div class="footerButton_content_li">
                <div>我的</div>
            </div>
        </div>
    </div>
</template>