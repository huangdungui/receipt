package com.zhichenkeji.domain;

import java.io.Serializable;

/**
 * @Author huangdungui
 * @Date 2019-12-14 18:47
 */
public class Receipt implements Serializable {
    private int id;
    private String time;
    private String money;
    private String bigMoney;
    private String name;
    private String createTime;

    public Receipt(int id, String time, String money, String bigMoney, String name, String createTime) {
        this.id = id;
        this.time = time;
        this.money = money;
        this.bigMoney = bigMoney;
        this.name = name;
        this.createTime = createTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Receipt() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getBigmoney() {
        return bigMoney;
    }

    public void setBigmoney(String bigMoney) {
        this.bigMoney = bigMoney;
    }

    public String getBigMoney() {
        return bigMoney;
    }

    public void setBigMoney(String bigMoney) {
        this.bigMoney = bigMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", money='" + money + '\'' +
                ", bigMoney='" + bigMoney + '\'' +
                ", name='" + name + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
