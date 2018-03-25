package vast.selfmanagementweb.login;

import vast.selfmanagementweb.model.User;
import vast.selfmanagementweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/loginIn")
    public String index() {
        return "login";
    }

    @RequestMapping("/loginInSave")
    public String loginIn(HttpServletRequest request,ModelMap model) {
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        try{
            user = userService.selectUserByUserNameAndPassword(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        if(null == user ||  null == user.getUserId() || "".equals(user.getUserId())){
            return  "error";
        }
        HttpSession session = request.getSession();
        session.setAttribute("user",user);
        model.addAttribute("userName",userName);
        model.addAttribute("password",password);
//        ModelAndView mav = new ModelAndView("success");
//        mav.addObject("content", user);
//        mav.addObject("userName", userName);

        return "success";
    }


}
