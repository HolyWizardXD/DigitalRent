package com.xeno.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xeno.domain.Objects;
import com.xeno.domain.Rate;
import com.xeno.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rates")
public class RateController {

    @Autowired
    private RateService rateService;

    @GetMapping()
    public Result getAll(){
        List<Rate> rateList = rateService.selectAll();
        return new Result(Code.selectSuccess,rateList);
    }

    @GetMapping("/{user_id}")
    public Result getRate(@PathVariable Integer user_id){
        return new Result(Code.selectSuccess,rateService.selectByUserId(user_id));
    }

    @PostMapping("/rate")
    public Result rate(Rate rate){
        if(rateService.selectByUserId(rate.getUser_id()) == null){
            rateService.addRate(rate);
            return new Result(Code.addSuccess,"");
        }else {
            rateService.updateRate(rate);
            return new Result(Code.updateSuccess, "");
        }
    }

    @GetMapping("/id/{currentPage}/{pageSize}")
    public Result sortById(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        IPage<Objects> iPage = rateService.PageOrderById(currentPage,pageSize);
        Integer code = iPage != null ? Code.selectSuccess : Code.selectError;
        return new Result(code,iPage);
    }

    @GetMapping("/evaluate/{currentPage}/{pageSize}")
    public Result sortByEvaluate(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        IPage<Objects> iPage = rateService.PageOrderByEvaluate(currentPage,pageSize);
        Integer code = iPage != null ? Code.selectSuccess : Code.selectError;
        return new Result(code,iPage);
    }

    @GetMapping("/time/{currentPage}/{pageSize}")
    public Result sortByTime(@PathVariable Integer currentPage,@PathVariable Integer pageSize){
        IPage<Objects> iPage = rateService.PageOrderByTime(currentPage,pageSize);
        Integer code = iPage != null ? Code.selectSuccess : Code.selectError;
        return new Result(code,iPage);
    }
}
