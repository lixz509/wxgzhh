package com.lpj.wxgzhh.domain;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@XmlRootElement(name="xml")
@ToString
public class InMessage  implements Serializable {

    private static final long serialVersionUID = 1L;

    //开发者微信号
    private String toUserName;

    //发送方帐号（一个OpenID）
    private String fromUserName;

    //消息创建时间 （整型）
    private String createTime;

    //消息类型，文本为text
    private String msgType;

    //消息id，64位整型
    private String msgId;

    public String getToUserName() {
        return toUserName;
    }

    @XmlElement(name = "ToUserName")
    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    @XmlElement(name = "FromUserName")
    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    @XmlElement(name = "CreateTime")
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    @XmlElement(name = "MsgType")
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMsgId() {
        return msgId;
    }

    @XmlElement(name = "MsgId")
    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    //文本的属性
    //文本消息内容
    private String content;

    public String getContent() {
        return content;
    }

    @XmlElement(name = "Content")
    public void setContent(String content) {
        this.content = content;
    }

    //图片的属性
    //图片链接（由系统生成）
    private String picUrl;

    //图片消息媒体id，可以调用获取临时素材接口拉取数据
    //语音消息媒体id，可以调用获取临时素材接口拉取数据
    //视频消息媒体id，可以调用获取临时素材接口拉取数据
    private String mediaId;

    public String getPicUrl() {
        return picUrl;
    }

    @XmlElement(name = "PicUrl")
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    @XmlElement(name = "MediaId")
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    //语音的属性
    private  String format;

    private  String recognition;

    public String getFormat() {
        return format;
    }

    @XmlElement(name = "Format")
    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    @XmlElement(name = "Recognition")
    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    //视频的属性
    //小视频属性
    //视频消息缩略图的媒体id，可以调用获取临时素材接口拉取数据
    private String thumbMediaId;

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    @XmlElement(name = "ThumbMediaId")
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    private String locationX;

    private String locationY;

    public String getLocationX() {
        return locationX;
    }

    @XmlElement(name = "Location_X")
    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    @XmlElement(name = "Location_Y")
    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    //链接消息
    //消息标题
    private String title;

    //消息描述
    private String description;

    //消息链接
    private String url;

    public String getTitle() {
        return title;
    }

    @XmlElement(name = "Title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement(name = "Description")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    @XmlElement(name = "Url")
    public void setUrl(String url) {
        this.url = url;
    }

    //关注/取消关注事件
    //事件类型
    private String event;

    public String getEvent() {
        return event;
    }

    @XmlElement(name = "Event")
    public void setEvent(String event) {
        this.event = event;
    }

    //扫描带参数二维码事件
    //用户已关注时的事件推送
    //事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
    private String eventKey;

    //二维码的ticket，可用来换取二维码图片
    private String ticket;

    public String getEventKey() {
        return eventKey;
    }

    @XmlElement(name = "EventKey")
    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    @XmlElement(name = "Ticket")
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    //上报地理位置事件
    //地理位置纬度
    private String latitude;

    //地理位置经度
    private String longitude;

    //地理位置精度
    private String precision;

    public String getLatitude() {
        return latitude;
    }

    @XmlElement(name = "Latitude")
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    @XmlElement(name = "Longitude")
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPrecision() {
        return precision;
    }

    @XmlElement(name = "Precision")
    public void setPrecision(String precision) {
        this.precision = precision;
    }

    //自定义菜单事件
    //点击菜单跳转链接时的事件推送
    //与上文相同

}
