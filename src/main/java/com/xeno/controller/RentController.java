package com.xeno.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xeno.domain.Objects;
import com.xeno.domain.Rent;
import com.xeno.domain.User;
import com.xeno.service.ObjectsService;
import com.xeno.service.RentService;
import com.xeno.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/rents")
public class RentController {

    @Autowired
    private RentService rentService;
    @Autowired
    private ObjectsService objectsService;
    @Autowired
    private UserService userService;

    @GetMapping("/{currentPage}/{pageSize}/{user_id}")
    public Result selectByPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize,@PathVariable Integer user_id){
        IPage<Rent> iPage = rentService.selectRentByPage(currentPage,pageSize,user_id);
        Integer code = iPage != null ? Code.selectSuccess : Code.selectError;
        return new Result(code,iPage);
    }

    @GetMapping("/{currentPage}/{pageSize}/{user_id}/{objects_name}")
    public Result selectByPageAndName(@PathVariable Integer currentPage, @PathVariable Integer pageSize,@PathVariable Integer user_id,@PathVariable String objects_name){
        IPage<Rent> iPage = rentService.selectRentByPageAndName(currentPage,pageSize,user_id,objects_name);
        Integer code = iPage != null ? Code.selectSuccess : Code.selectError;
        return new Result(code,iPage);
    }

    @GetMapping("/{id}")
    public Result selectOne(@PathVariable Integer id){
        Rent rent = rentService.selectOneById(id);
        return new Result(Code.selectSuccess,rent);
    }

    @GetMapping()
    public Result getOverTimeNum(HttpServletRequest request){
        Integer user_id = (Integer) request.getSession().getAttribute("userId");
        Integer num = rentService.selectOverTimeNum(user_id);
        return new Result(Code.updateSuccess,num);
    }

    @PutMapping("/{id}/{objects_id}/{num}")
    public Result returnObjects(@PathVariable Integer id,@PathVariable Integer objects_id,@PathVariable Integer num){
        boolean flag1 = rentService.updateStatusById(id);
        Objects objects = objectsService.selectById(objects_id);
        boolean flag2 = objectsService.updateStockById(objects.getStock() + num,objects_id);
        boolean flag = flag1&&flag2;
        return new Result(flag?Code.updateSuccess : Code.updateError,flag);
    }

    @PutMapping("/{id}/{days}/{user_id}/{value}")
    public Result reRent(@PathVariable Integer id,@PathVariable Integer days,@PathVariable Integer user_id,@PathVariable float value){
        User user = userService.selectById(user_id);
        if(user.getMoney() < value){
            return new Result(Code.updateError,"余额不足");
        }else {
            userService.updateMoneyById(user_id, -value);
            rentService.updateReturnTimeById(id,days);
            rentService.updateValueById(id,value);
            rentService.updateDaysById(id,days);
            return new Result(Code.updateSuccess, "成功");
        }
    }
}
