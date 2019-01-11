package com.kcsj.wzcl.utils;

import com.kcsj.wzcl.bean.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

    @Autowired
    private JavaMailSenderImpl mailSender;

    public EmailSender() {
    }

    @Value("${spring.mail.username}")
    private  String Sender; //读取配置文件中的参数
    public  void sendEmail(String sendTo, Message message){
        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom(Sender);
        mailMessage.setTo(sendTo);
        mailMessage.setSubject("电子科技大学车辆违章提醒");
       // String content =combineContent(message);
        mailMessage.setText("11");
        mailSender.send(mailMessage);

    }

    /*
亲爱的（张虎宇）（老师）：
    您好，
    您于（2016年10-10）在（区域）发生（酒驾程度）违章行为，您的车牌号为（111）。本次违章为您的第（1）违章。
    违章历史纪录（无/xxxx），请您遵守校园行车规定。（您已禁止进入电子科技大学校园内。）
                                                                                      电子科技大学车辆管理中心
 */


    private String combineContent(Message message) {
        String str =null;
        if(message.isBan()){
            str ="请您遵守校园行车规定。";
        }else {
            str ="您已禁止进入电子科技大学校园内。";
        }
        String content ="尊敬的"+message.getName()+message.getIndentity()+":"
                +"\n\t\t"+"您好，"
                +"\n\t\t"+"您于"+message.getDate()+"在"+message.getArea()+"发生"+message.getType()+"违章行为。"
                +"\n\t\t"+"本次违章为您的"+message.getCount()+"次违章，违章历史记录为"+message.getHistory()+","
                +"\n\t\t"+str
                +"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t"+"电子科技大学车辆管理中心";
        return content;
    }


}
