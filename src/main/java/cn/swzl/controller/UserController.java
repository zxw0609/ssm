package cn.swzl.controller;

import cn.swzl.domain.User;
import cn.swzl.service.InforService;
import cn.swzl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author zhangxw
 * @date 20/2/20 - 20:38
 */
@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private InforService inforService;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("controller:查询所有用户");
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "UserList";
    }

    @RequestMapping("/save")
    public String saveUser(User user ,String repassword, HttpSession session,HttpServletRequest request, MultipartFile upload){
        if(userService.findOne(user.getUsername())!=null){
            session.setAttribute("error", "用户名被占用,换一个吧,建议使用学号");
            return "redirect:/jsp/reg.jsp";
        }
        if(!repassword.equals(user.getPassword())){
            session.setAttribute("error", "两次密码输入不一致哦!");
            return "redirect:/jsp/reg.jsp";
        }
        System.out.println("controller:保存用户信息");
        System.out.println("springmvc文件上传...");

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
                filename="1.jpg";
            }
            System.out.println(filename);
            user.setHeadPortrait(filename);
        } catch (IOException e) {
            session.setAttribute("error", "头像上传失败!");
            return "redirect:/jsp/reg.jsp";
        }

        userService.saveUser(user);
        session.setAttribute("error", "注册成功,赶快登陆试试吧");

        return "redirect:/jsp/login.jsp";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        System.out.println("controller:用户登录验证");
        //先通过username查询用户
        if(session.getAttribute("user")!=null){
            session.setAttribute("error", "您已登陆");
            return "redirect:/jsp/index.jsp";
        }
        User user = userService.findOne(username);
        if (user!=null){
            if(password.equals(user.getPassword())){
                session.setAttribute("user",user);
                return "redirect:/jsp/index.jsp";
            }else{
                session.setAttribute("error", "密码错误");
                return "redirect:/jsp/login.jsp";
            }
        }else {
            session.setAttribute("error", "用户名不存在");
            return "redirect:/jsp/login.jsp";
        }
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session){
        if(session.getAttribute("user")==null){
            session.setAttribute("error", "您还没登录呢");
            return "redirect:/jsp/login.jsp";
        }
        System.out.println("controller:退出登录");
        session.removeAttribute("user");
        return "redirect:/jsp/login.jsp";
    }

    @RequestMapping("/update")
    public String update(User user , HttpSession session,HttpServletRequest request, MultipartFile upload){

        System.out.println("controller:修改用户信息");
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
        User user1 = (User) session.getAttribute("user");
        try {
            // 说明上传文件项
            // 获取上传文件的名称
            if(!upload.getOriginalFilename().isEmpty()){
                //如果不是默认头像就要删除原头像图片
                if (!"1.jpg".equals(user1.getHeadPortrait())){
                    File file1=new File(path,user1.getHeadPortrait());
                    file1.delete();
                }
                filename = upload.getOriginalFilename();
                // 把文件的名称设置唯一值，uuid
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid+"_"+filename;
                // 完成文件上传
                upload.transferTo(new File(path,filename));
            }else{
                filename=user1.getHeadPortrait();
            }
        } catch (IOException e) {
            session.setAttribute("error", "头像上传失败!");
            return "redirect:/jsp/reg.jsp";
        }
        user.setHeadPortrait(filename);
        user.setUsername(user1.getUsername());
        userService.update(user);
        inforService.updateHeadPortrait(user1.getUsername(),filename);
        session.setAttribute("error", "修改成功");
        session.setAttribute("user",user);
        return "redirect:/jsp/login.jsp";
    }

    @RequestMapping("/updatePas")
    public String updatePas(String ypassword, String password, String repassword, HttpSession session){
        if(!password.equals(repassword)){
            session.setAttribute("error", "两次输入的密码不一致哦");
            return "redirect:/jsp/updatePas.jsp";
        }
        if(ypassword.equals(password)){
            session.setAttribute("error", "原密码不能与新密码相同哦");
            return "redirect:/jsp/updatePas.jsp";
        }
        User user = (User) session.getAttribute("user");
        if(!user.getPassword().equals(ypassword)){
            session.setAttribute("error", "原密码错误,修改失败");
            return "redirect:/jsp/updatePas.jsp";
        }
        System.out.println("controller:修改用户密码");
        userService.updatePas(password,user.getUsername());
        session.setAttribute("error", "修改成功");
        session.removeAttribute("user");
        return "redirect:/jsp/login.jsp";
    }

    /**
     * SpringMVC文件上传
     * @return
     */
    @RequestMapping("/fileupload2")
    public String fileuoload2(HttpServletRequest request,String filename) throws Exception {
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file=new File(path,filename);
        file.delete();
        return "UserList";
    }
}
