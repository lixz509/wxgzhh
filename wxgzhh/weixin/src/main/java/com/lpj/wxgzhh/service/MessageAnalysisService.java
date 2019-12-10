package com.lpj.wxgzhh.service;

import com.lpj.wxgzhh.domain.InMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageAnalysisService {

    private static final Logger LOG = LoggerFactory.getLogger(MessageAnalysisService.class);

    @Autowired
    private MessageAnalysisService MRS;

    //将xml格式文件解析成json格式
    public Map<String, String> parseXml(InputStream is) {
        Map<String, String> map =new HashMap<>();
        SAXReader reader=new SAXReader();
        try {
            //获取输入流，并获取文档对象
            Document document=reader.read(is);
            //根据文档对象获取根节点
            Element root=document.getRootElement();
            //根据跟节点获取所有子节点
            List<Element> elements=root.elements();
            for (Element e:elements){
                map.put(e.getName(),e.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

//    //使用一个Map来记录消息类型和Java类的关系
//    private static final Map<String ,Class> typeMap=new ConcurrentHashMap<>();
//
//    static {
//        typeMap.put("text", TextInMessage.class);
//        typeMap.put("image", ImageInMessage.class);
//    }
//
//    //网上查找的方法，将xml文件转换为java
//    //将xml转换为对应得java对象
    //提供一个静态方法，可以传入XML，将XML转换为java对象
    public InMessage XMLStringToBean(String xml) throws JAXBException {
        String str=xml.substring(0, xml.indexOf("<MsgType><![CDATA["));
        String type=xml.substring(str.length()+18, xml.indexOf("]]></MsgType>"));

            JAXBContext context = JAXBContext.newInstance(InMessage.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            InMessage inMessage= (InMessage) unmarshaller.unmarshal(new StringReader(xml));

        return inMessage;
    }

    //完成对象的序列化
    public byte[] serialize(String xml) throws IOException, JAXBException {
        InMessage inMessage=MRS.XMLStringToBean(xml);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(inMessage);
        // 序列化之后的字节数组bos.toByteArray()
        return bos.toByteArray();
    }

    //将字节流反序列化为InMessage对象
    public static InMessage toInmaesage(byte[] bs) throws ClassNotFoundException, IOException {
        //创建存放二进制数据的API
        ByteArrayInputStream byteArrayInputStream= new ByteArrayInputStream(bs);
        //创建反序列化对象
        ObjectInputStream objectInputStream= new ObjectInputStream(byteArrayInputStream);
        //校验测试
        InMessage inMessage = (InMessage) objectInputStream.readObject();
        objectInputStream.close();
        return inMessage;
    }

}
