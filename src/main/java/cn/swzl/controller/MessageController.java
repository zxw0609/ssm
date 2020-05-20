package cn.swzl.controller;

import cn.swzl.domain.Infor;
import cn.swzl.domain.Message;
import cn.swzl.domain.User;
import cn.swzl.service.InforService;
import cn.swzl.service.MessageService;
import cn.swzl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxw
 * @date 20/2/17 - 12:14
 */
@Controller
@RequestMapping("/Message")
public class MessageController {

    @Autowired //该注解为自动类型注入
    private MessageService messageService;
    @Autowired //该注解为自动类型注入
    private InforService inforService;
    @Autowired
    private UserService userService;

    @RequestMapping("/find")
    public String findAll(int inforId, HttpSession session){
        if (session.getAttribute("user")==null||session.getAttribute("user")==""){
            session.setAttribute("error", "请先登录");
            return "redirect:/jsp/login.jsp";
        }
        System.out.println("表现层:查询物品留言...");
        //调用service的方法
        List<Message> messageList = messageService.find(inforId);
        Infor infor = inforService.findOne(inforId);
        List<User> userList = new ArrayList<>();
        for (Message message:messageList) {
            userList.add(userService.findOneId(message.getUserId()));
        }
        User user = userService.findOneId(infor.getUserId());
        session.setAttribute("userList", userList);
        session.setAttribute("infor", infor);
        session.setAttribute("user", user);
        session.setAttribute("messageList", messageList);
        return "redirect:/jsp/message.jsp";
    }

    @RequestMapping("/saveMessage")
    public String saveMessage (int inforId, Message message, HttpSession session ){
        System.out.println("表现层:保存留言信息...");
        User user = (User) session.getAttribute("user");
        message.setUserId(user.getId());
        message.setInforId(inforId);
        messageService.saveMessage(message);
        return "forward:/Message/find?inforId="+inforId;
    }
}
