package com.xeno.controller;


import com.xeno.domain.User;
import com.xeno.service.RateService;
import com.xeno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static com.xeno.controller.Code.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment environment;
    @Autowired
    private UserService userService;
    @Autowired
    private RateService rateService;

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id) {
        User user = userService.selectById(id);
        Integer code = user != null ? Code.selectSuccess : Code.selectError;
        String msg = user != null ? "" : "数据查询失败,请重试!";
        return new Result(code,user,msg);
    }

    @GetMapping("/userContain/{username}")
    public Result containUsername(@PathVariable String username) {
        User user = userService.selectByName(username);
        boolean flag = user != null;
        return new Result(Code.selectSuccess,flag);
    }

    @GetMapping("/login")
    public Result Login(HttpServletRequest request, User user){
        Result result = new Result();
        User containUser = userService.selectByName(user.getUsername());
        if(containUser == null){
            result.setCode(Code.loginUserNull);
            result.setMsg("该用户不存在!");
            return result;
        }else if(!containUser.getPassword().equals(user.getPassword())){
            result.setCode(Code.loginUserPasswordError);
            result.setMsg("密码错误!");
            return result;
        }else{
            result.setCode(Code.loginUserSuccess);
            result.setData(containUser);
            result.setMsg("登陆成功!");
            request.getSession().setAttribute("userId",containUser.getId());
            return result;
        }
    }

    @GetMapping("/logout")
    public Result Logout(HttpServletRequest request){
        request.getSession().removeAttribute("userId");
        return new Result(Code.logoutSuccess,null,"退出成功!");
    }

    @GetMapping("/session")
    public Result refreshSession(HttpServletRequest request,User user){
        request.getSession().setAttribute("userId",user.getId());
        return new Result();
    }

    @PostMapping("/register")
    public Result register(User user){
        if((userService.selectByName(user.getUsername())) != null){
            return new Result(Code.registerContains,null,"用户已经存在");
        }
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setAddress("");
        newUser.setPhone("");
        newUser.setPermission(1);
        boolean flag = userService.addNewUser(newUser);
        return new Result(flag ? Code.registerSuccess : Code.registerError,null);
    }

    @GetMapping("/flush/{id}")
    public Result flushMoney(@PathVariable Integer id){
        User user = userService.selectById(id);
        return new Result(Code.selectSuccess,user);
    }

    @PutMapping("/recharge")
    public Result rechargeMoney(Integer user_id,Float chargeMoney){
        userService.updateMoneyById(user_id,chargeMoney);
        return new Result(Code.updateSuccess,"");
    }

    @PutMapping("/editUser")
    public Result editUser(Integer user_id,String username,String password,String phone,String address){
        String name = userService.selectById(user_id).getUsername();
        if(name.equals(username)){
            userService.updateUserById(user_id, username,password, phone, address);
            return new Result(Code.updateSuccess, "");
        }
        if(userService.selectByName(username) != null){
            return new Result(Code.updateError,"");
        }else {
            userService.updateUserById(user_id, username,password, phone, address);
            rateService.updateNameById(user_id,username);
            return new Result(Code.updateSuccess, "");
        }
    }

}
