package com.zhichenkeji.dao;

import com.zhichenkeji.domain.Receipt;
import com.zhichenkeji.idao.IReceiptDao;
import com.zhichenkeji.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ReceiptDao implements IReceiptDao{

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    public void register(Receipt receipt, String bigMoney, String dateTime) {
        String sql="insert into receipt values(null,?,?,?,?,?)";
        Object[] obj={receipt.getTime(),receipt.getMoney(),bigMoney,receipt.getName(),dateTime};
        jdbcTemplate.update(sql,obj);
    }


    @Override
    public int Count() {
        String sql = "select count(*) from receipt";
        Integer count = jdbcTemplate.queryForObject(sql, int.class);
        return count;
    }

    @Override
    public List<Receipt> myFavorite(int pageNumber, int pageSize) {
//求起始数据库
        int start = (pageNumber - 1) * pageSize;
        String sql = "SELECT * FROM receipt limit ?,?";
        List<Receipt> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Receipt>(Receipt.class), start,pageSize);
        return list;
    }


    public Receipt findByReceipt(String id) {

        String sql = "select * from receipt where id = ?";
        Receipt receipt = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Receipt>(Receipt.class), id);
        return receipt;
    }
}
