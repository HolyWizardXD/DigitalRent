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
import java.util.List;

@RestController
@RequestMapping("/objects")
public class ObjectsController {

    @Autowired
    private ObjectsService objectsService;
    @Autowired
    private UserService userService;
    @Autowired
    private RentService rentService;

    @GetMapping
    public Result selectAll(){
        List<Objects> objectsList = objectsService.selectAll();
        Integer code = objectsList != null ? Code.selectSuccess : Code.selectError;
        String msg = objectsList != null ? "" : "数据查询失败,请重试!";
        return new Result(code,objectsList,msg);
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Objects objects = objectsService.selectById(id);
        Integer code = objects != null ? Code.selectSuccess : Code.selectError;
        String msg = objects != null ? "" : "数据查询失败,请重试!";
        return new Result(code,objects,msg);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id){
        boolean flag = objectsService.deleteObject(id);
        return new Result(flag ? Code.deleteSuccess : Code.deleteError,flag);
    }

    @PutMapping()
    public Result updateObject(@RequestBody Objects objects){
        boolean flag = objectsService.updateObject(objects);
        rentService.updateNameById(objects.getId(), objects.getName());
        return new Result(flag ? Code.updateSuccess : Code.updateError,flag);
    }

    @PutMapping("/{num}/{days}")
    public Result rentById(HttpServletRequest request,@PathVariable Integer num, @PathVariable Integer days,@RequestBody Objects objects){
        objects.setStock(objects.getStock() - num);
        float totalMoney = num * days * objects.getValue();
        Integer user_id = (Integer) request.getSession().getAttribute("userId");
        User user = userService.selectById(user_id);
        if(user.getMoney() < totalMoney){
            return new Result(Code.userMoneyError,null,"用户余额不足");
        }
        user.setMoney(user.getMoney() - totalMoney);
        userService.rentById(user);
        Rent rent = new Rent(user_id,objects.getId(),objects.getName(),num,totalMoney,days);
        rentService.insertRent(rent);
        boolean flag = objectsService.updateObject(objects);
        return new Result(flag ? Code.updateSuccess : Code.updateError,flag);
    }

    @PostMapping
    public Result addObject(Objects objects){
        boolean flag = objectsService.addObject(objects);
        return new Result(flag ? Code.addSuccess : Code.addError,flag);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public Result selectByPage(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        IPage<Objects> iPage = objectsService.selectByPage(currentPage,pageSize);
        Integer code = iPage != null ? Code.selectSuccess : Code.selectError;
        return new Result(code,iPage);
    }

    @GetMapping("/{currentPage}/{pageSize}/brand/{brand}")
    public Result selectByBrand(@PathVariable Integer currentPage,@PathVariable Integer pageSize,@PathVariable String brand){
        IPage<Objects> iPage = objectsService.selectByBrand(currentPage,pageSize,brand);
        Integer code = iPage != null ? Code.selectSuccess : Code.selectError;
        return new Result(code,iPage);
    }

    @GetMapping("/{currentPage}/{pageSize}/name/{name}")
    public Result selectByName(@PathVariable Integer currentPage,@PathVariable Integer pageSize,@PathVariable String name){
        IPage<Objects> iPage = objectsService.selectByName(currentPage,pageSize,name);
        Integer code = iPage != null ? Code.selectSuccess : Code.selectError;
        return new Result(code,iPage);
    }

    @GetMapping("/{currentPage}/{pageSize}/type/{type}")
    public Result selectByType(@PathVariable Integer currentPage, @PathVariable Integer pageSize, @PathVariable String type){
        IPage<Objects> iPage = objectsService.selectByType(currentPage,pageSize,type);
        Integer code = iPage != null ? Code.selectSuccess : Code.selectError;
        return new Result(code,iPage);
    }

    @GetMapping("/{currentPage}/{pageSize}/Type&Brand/{type}/{brand}")
    public Result selectByTypeAndBrand(@PathVariable Integer currentPage, @PathVariable Integer pageSize, @PathVariable String type, @PathVariable String brand){
        IPage<Objects> iPage = objectsService.selectByBrandAndType(currentPage,pageSize,type,brand);
        Integer code = iPage != null ? Code.selectSuccess : Code.selectError;
        return new Result(code,iPage);
    }

}
