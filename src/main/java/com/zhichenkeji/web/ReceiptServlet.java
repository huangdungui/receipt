package com.zhichenkeji.web;

import com.zhichenkeji.domain.PageBean;
import com.zhichenkeji.domain.Receipt;
import com.zhichenkeji.iservice.IReceiptService;
import com.zhichenkeji.service.ReceiptSerivce;
import com.zhichenkeji.utils.Factory;
import com.zhichenkeji.utils.NumberTo;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class ReceiptServlet extends BaseServlet {
    private void register(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        try {

            Map<String, String[]> map = request.getParameterMap();
            Receipt receipt = new Receipt();
            BeanUtils.populate(receipt, map);
            String money = receipt.getMoney();

            Date date = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateTime = format.format(date);

            //转化大写
            BigDecimal numberOfMoney = new BigDecimal(money);
            String bigMoney = NumberTo.number2CNMontrayUnit(numberOfMoney);

            // 调用service
            ReceiptSerivce receiptSerivce = new ReceiptSerivce();
            int i = receiptSerivce.register(receipt, bigMoney,dateTime);
            response.getWriter().print(i);
        } catch (Exception e) {
            e.printStackTrace();
            // 失败
            response.getWriter().print(0); //0 服务器异常
        }
    }

    private void MyReceipt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取当前页
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        //设置每页显示
        int pageSize = 8;
        IReceiptService receiptService = (IReceiptService) Factory.getBean("receiptService");
        PageBean pageBean = receiptService.myFavorite(pageNumber,pageSize);
        // 直接防放入域对象 带到页面中
        request.setAttribute("pb", pageBean);
        request.getRequestDispatcher("/myReceipt.jsp").forward(request, response);
    }

    private void findByReceipt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ReceiptSerivce receiptSerivce = new ReceiptSerivce();
        Receipt receipt = receiptSerivce.findByReceipt(id);
        request.setAttribute("route",receipt);
        request.getRequestDispatcher("/receipt_detail.jsp").forward(request, response);
    }
}
