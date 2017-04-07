package com.zhouchatian.admin.robotdailly;

import java.io.Serializable;

/**
 * Created by  Mr.Robot on 2017/3/26.
 * zhouchatain@gmail.com
 * GitHub:https://github.com/TheSadFrog
 */

public class CostBean implements Serializable{
    public String costTitle;
    public String costDate;
    public String costMoney;

    public String getCostTitle() {
        return costTitle;
    }

    public void setCostTitle(String costTitle) {
        this.costTitle = costTitle;
    }

    public String getCostDate() {
        return costDate;
    }

    public void setCostDate(String costDate) {
        this.costDate = costDate;
    }

    public String getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(String costMoney) {
        this.costMoney = costMoney;
    }

    @Override
    public String toString() {
        return "CostBean{" +
                "costTitle='" + costTitle + '\'' +
                ", costDate='" + costDate + '\'' +
                ", costMoney='" + costMoney + '\'' +
                '}';
    }
}
