package com.zhichenkeji.web;

import com.zhichenkeji.domain.Receipt;
import com.zhichenkeji.service.ReceiptSerivce;
import com.zhichenkeji.utils.NumberTo;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

public class ReceiptServlet extends BaseServlet {
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
            int i = receiptSerivce.register(receipt,bigMoney);
            response.getWriter().print(i);
        } catch (Exception e) {
            e.printStackTrace();
            // 失败
            response.getWriter().print(0); //0 服务器异常
        }

    }


}
