package com.xeno.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Rent {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer user_id;
    private Integer objects_id;
    private String objects_name;
    private Integer amount;
    private float value;
    private Integer days;
    private String rent_time;
    private String return_time;
    private Integer status;

    public Rent() {
    }

    public Rent(Integer user_id, Integer objects_id, String objects_name, Integer amount, float value, Integer days) {
        this.user_id = user_id;
        this.objects_id = objects_id;
        this.objects_name = objects_name;
        this.amount = amount;
        this.value = value;
        this.days = days;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getObjects_id() {
        return objects_id;
    }

    public void setObjects_id(Integer objects_id) {
        this.objects_id = objects_id;
    }

    public String getObjects_name() {
        return objects_name;
    }

    public void setObjects_name(String objects_name) {
        this.objects_name = objects_name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getRent_time() {
        return rent_time;
    }

    public void setRent_time(String rent_time) {
        this.rent_time = rent_time;
    }

    public String getReturn_time() {
        return return_time;
    }

    public void setReturn_time(String return_time) {
        this.return_time = return_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", objects_id=" + objects_id +
                ", objects_name='" + objects_name + '\'' +
                ", amount=" + amount +
                ", value=" + value +
                ", days=" + days +
                ", rent_time='" + rent_time + '\'' +
                ", return_time='" + return_time + '\'' +
                ", status=" + status +
                '}';
    }
}
