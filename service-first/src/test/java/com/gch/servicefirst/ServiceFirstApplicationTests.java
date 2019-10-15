package com.gch.servicefirst;

import com.gch.servicefirst.meta.po.User;
import com.gch.servicefirst.meta.vo.UserVo;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceFirstApplicationTests {

    @Autowired
    private Mapper dozerMapper;

    @Test
    public void contextLoads() {
        User user = new User(1,"kk");
        UserVo userVo = dozerMapper.map(user, UserVo.class);
//        userVo.setEmail("ggg");
        System.out.println("userVo:"+ userVo);
    }

}
