package com.zhichenkeji.service;


import com.zhichenkeji.dao.ReceiptDao;
import com.zhichenkeji.domain.Receipt;

public class ReceiptSerivce {
    public int register(Receipt receipt, String bigMoney){
        ReceiptDao userDao = new ReceiptDao();

        userDao.register(receipt,bigMoney);

        return 3;
    }

}
