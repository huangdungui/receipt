package com.zhichenkeji.iservice;

import com.zhichenkeji.domain.PageBean;

public interface IReceiptService {

    PageBean myFavorite(int pageNumber, int pageSize);
}
