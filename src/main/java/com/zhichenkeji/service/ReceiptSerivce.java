package com.zhichenkeji.service;


import com.zhichenkeji.dao.ReceiptDao;
import com.zhichenkeji.domain.PageBean;
import com.zhichenkeji.domain.Receipt;
import com.zhichenkeji.idao.IReceiptDao;
import com.zhichenkeji.iservice.IReceiptService;
import com.zhichenkeji.utils.Factory;

import java.util.List;

public class ReceiptSerivce implements IReceiptService {
    public int register(Receipt receipt, String bigMoney, String dateTime){
        ReceiptDao receiptDao = new ReceiptDao();

        receiptDao.register(receipt,bigMoney,dateTime);

        return 1;
    }


    @Override
    public PageBean myFavorite(int pageNumber, int pageSize) {

        IReceiptDao receiptDao = (IReceiptDao) Factory.getBean("receiptDao");
        List<Receipt> list = receiptDao.myFavorite(pageNumber,pageSize);

        //总条数
        int totalCount = receiptDao.Count();
        // 总页数
        int totalPage = 0;
        if (totalCount % pageSize == 0) {
            totalPage = totalCount / pageSize;
        } else {
            totalPage = totalCount / pageSize + 1;
        }

        //封装到PageBean
        PageBean pageBean = new PageBean();
        pageBean.setList(list);
        pageBean.setPageNumber(pageNumber);
        pageBean.setPageSize(pageSize);
        pageBean.setTotalCount(totalCount);
        pageBean.setTotalPage(totalPage);
        return pageBean;
    }


    public Receipt findByReceipt(String id) {



        return null;
    }
}
