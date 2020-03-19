package cn.swzl.test;

import cn.swzl.service.LiuYanService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhangxw
 * @date 20/2/17 - 15:40
 */
public class testSpring {

    @Test
    public void run1(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        // 获取对象
        LiuYanService as = (LiuYanService) ac.getBean("accountService");
        // 调用方法
       // as.findAll();
    }
}
