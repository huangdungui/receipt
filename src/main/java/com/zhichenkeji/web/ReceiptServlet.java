package com.zhichenkeji.web;

import com.zhichenkeji.domain.Receipt;
import com.zhichenkeji.service.ReceiptSerivce;
import com.zhichenkeji.utils.NumberTo;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class ReceiptServlet extends BaseServlet {
    // 关注自己的方法
    // 注册
    private void register(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        try {

            Map<String, String[]> map = request.getParameterMap();
            Receipt receipt = new Receipt();
            BeanUtils.populate(receipt, map);
            String money = receipt.getMoney();

            //转化大写
            BigDecimal numberOfMoney = new BigDecimal(money);
            String bigMoney = NumberTo.number2CNMontrayUnit(numberOfMoney);

            // 调用service
            ReceiptSerivce receiptSerivce = new ReceiptSerivce();
            // 带着参数去注册
            int i = receiptSerivce.register(receipt,bigMoney);
            response.getWriter().print(i); //1(用户名为空)  2(用户名已被注册)  3（条件都满足 注册成功）
        } catch (Exception e) {
            e.printStackTrace();
            // 失败
            response.getWriter().print(0); //0 服务器异常
        }

    }


}
