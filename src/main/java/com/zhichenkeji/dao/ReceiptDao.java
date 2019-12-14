package com.zhichenkeji.dao;

import com.zhichenkeji.domain.Receipt;
import com.zhichenkeji.utils.JdbcUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class ReceiptDao {
    public void register(Receipt receipt, String bigMoney) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
        String sql="insert into receipt values(null,?,?,?)";
        Object[] obj={receipt.getTime(),receipt.getMoney(),bigMoney};
        jdbcTemplate.update(sql,obj);
    }


}
