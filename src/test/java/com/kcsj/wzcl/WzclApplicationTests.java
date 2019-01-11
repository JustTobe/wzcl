package com.kcsj.wzcl;

import com.kcsj.wzcl.bean.Message;
import com.kcsj.wzcl.utils.EmailSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WzclApplicationTests {
    @Autowired
    private EmailSender emailSender;
    @Test
    public void contextLoads() {


        emailSender.sendEmail("2786846885@qq.com",new Message());
    }


}
