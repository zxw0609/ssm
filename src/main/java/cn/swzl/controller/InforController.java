package cn.swzl.controller;

import cn.swzl.domain.Infor;
import cn.swzl.domain.User;
import cn.swzl.service.InforService;
import cn.swzl.service.LiuYanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author zhangxw
 * @date 20/2/20 - 22:37
 */
@Controller
@RequestMapping("/Infor")
public class InforController {
    @Autowired
    private InforService inforService;
    @Autowired
    private LiuYanService liuYanService;

    @RequestMapping("/findAll")
    public String findAll(HttpSession session) {
        System.out.println("controller:查询所有物品信息");
        List<Infor> inforList = inforService.findAll();
        session.setAttribute("inforList", inforList);
        session.setAttribute("act1", "1");
        return "redirect:/jsp/index.jsp";
    }

    @RequestMapping("/save")
    public String saveInfor(Infor infor, HttpSession session, HttpServletRequest request, MultipartFile upload){
        System.out.println("controller:保存物品信息");
        if (session.getAttribute("user")==null||session.getAttribute("user")==""){
            session.setAttribute("error", "请先登录");
            return "redirect:/jsp/login.jsp";
        }
        Date date=new Date();
        DateFormat df2 = DateFormat.getDateTimeInstance();//可以精确到时分秒
        String stape=df2.format(date);
        infor.setStape(stape);
        User user = (User) session.getAttribute("user");
        infor.setUsername(user.getUsername());
        infor.setHeadPortrait(user.getHeadPortrait());

        // 使用fileupload组件完成文件上传
        // 上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断，该路径是否存在
        File file = new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }
        String filename;
        try {
            // 说明上传文件项
            // 获取上传文件的名称
            if(!upload.getOriginalFilename().isEmpty()){
                filename = upload.getOriginalFilename();
                // 把文件的名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid+"_"+filename;
                // 完成文件上传
                upload.transferTo(new File(path,filename));
            }else{
                filename="";
            }
            System.out.println(filename);
            infor.setImage(filename);
        } catch (IOException e) {
            session.setAttribute("error", "图片上传失败!");
            return "redirect:/jsp/informationPublish.jsp";
        }
        inforService.saveInfor(infor);
        return "redirect:/Infor/findAll";
    }

    @RequestMapping("/find")
    public String find(String xinxi , HttpSession session){
        System.out.println("controller:模糊查询物品信息");
        List<Infor> inforList =inforService.find(xinxi);
        session.setAttribute("inforList", inforList);
        session.setAttribute("act1", "1");
        return "redirect:/jsp/index.jsp";
    }

    @RequestMapping("/findOne")
    public String findOne(int id , HttpSession session){
        if (session.getAttribute("user")==null||session.getAttribute("user")==""){
            session.setAttribute("error", "请先登录");
            return "redirect:/jsp/login.jsp";
        }
        System.out.println("controller:查询指定id的物品信息");
        Infor infor = inforService.findOne(id);
        session.setAttribute("infor",infor);
        return "redirect:/jsp/update.jsp";
    }

    @RequestMapping("/userFind")
    public String userFind(HttpSession session){
        if (session.getAttribute("user")==null||session.getAttribute("user")==""){
            session.setAttribute("error", "请先登录");
            return "redirect:/jsp/login.jsp";
        }
        User user = (User) session.getAttribute("user");
        System.out.println("controller:查询指定用户的物品信息");
        List<Infor>userInforList = inforService.userFind(user.getUsername());
        session.setAttribute("userInforList",userInforList);
        return "redirect:/jsp/userInfor.jsp";
    }

    @RequestMapping("/update")
    public String update(HttpSession session,Infor infor){
        if (session.getAttribute("user")==null||session.getAttribute("user")==""){
            session.setAttribute("error", "请先登录");
            return "redirect:/jsp/login.jsp";
        }
        System.out.println("controller:更新物品信息");
        inforService.update(infor);
        session.setAttribute("error", "更新成功");
        return "redirect:/Infor/userFind";
    }

    @RequestMapping("/delete")
    public String delete(HttpSession session,int id){
        if (session.getAttribute("user")==null||session.getAttribute("user")==""){
            session.setAttribute("error", "请先登录");
            return "redirect:/jsp/login.jsp";
        }
        System.out.println("controller:删除物品信息");
        inforService.delete(id);
        liuYanService.delete(id);
        session.setAttribute("error", "删除成功");
        return "redirect:/Infor/userFind";
    }
}
