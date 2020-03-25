package cn.swzl.controller;

import cn.swzl.domain.Infor;
import cn.swzl.domain.LiuYan;
import cn.swzl.domain.User;
import cn.swzl.service.InforService;
import cn.swzl.service.LiuYanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zhangxw
 * @date 20/2/17 - 12:14
 */
@Controller
@RequestMapping("/LiuYan")
public class LiuYanController {

    @Autowired //该注解为自动类型注入
    private LiuYanService liuYanService;
    @Autowired //该注解为自动类型注入
    private InforService inforService;

    @RequestMapping("/find")
    public String findAll(int InforId, HttpSession session){
        if (session.getAttribute("user")==null||session.getAttribute("user")==""){
            session.setAttribute("error", "请先登录");
            return "redirect:/jsp/login.jsp";
        }
        System.out.println("表现层:查询物品留言...");
        //调用service的方法
        List<LiuYan> liuYanList = liuYanService.find(InforId);
        Infor infor = inforService.findOne(InforId);
        session.setAttribute("infor", infor);
        session.setAttribute("liuYanList", liuYanList);
        return "redirect:/jsp/message.jsp";
    }

    @RequestMapping("/saveLiuYan")
    public String saveLiuYan (int InforId,LiuYan liuYan, HttpSession session , ModelMap model ){
        System.out.println("表现层:保存留言信息...");
        User user = (User) session.getAttribute("user");
        liuYan.setUsername(user.getUsername());
        liuYan.setInforId(InforId);
        liuYan.setHeadPortrait(user.getHeadPortrait());
        liuYanService.saveLiuYan(liuYan);
        return "forward:/LiuYan/find?InforId="+InforId;
    }
}
