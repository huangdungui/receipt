package com.zhichenkeji.idao;

import com.zhichenkeji.domain.Receipt;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface IReceiptDao {


    List<Receipt> myFavorite(int pageNumber, int pageSize);

    int Count();
}
