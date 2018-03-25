package vast.selfmanagementweb.register.Controller;

import vast.selfmanagementweb.model.User;
import vast.selfmanagementweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/registerSave")
    public String registerSave(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setPhone(phone);
        Integer id = null;
        User userCheck = new User();
        try {
             userCheck = userService.selectUserByUserNameAndPassword(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (null == userCheck || null == userCheck.getUserId() || "".equals(userCheck.getUserId())) {
            id = userService.addUser(user);
        }
        if(null != id){
            return "success";
        }else{
            return "error";
        }
    }
}
