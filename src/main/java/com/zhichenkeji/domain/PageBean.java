package com.zhichenkeji.domain;


import java.util.List;

public class PageBean {
    private List<Receipt> list; // 当前页面的数据
    private int pageNumber; //当前页
    private int pageSize; //页面的条数
    private int totalCount; // 总条数
    private int totalPage;// 总页数

    //起始数据
    private int begin;
    //结束的
    private int end;


    // 计算赋值
    public void compute() {
//        if 总页数 <=10  那么begin=1
        if (totalPage <= 10) {
            begin = 1;
            end = totalPage;  // end就是 有几页就显示几页
        } else {
            //总页数>10的时候
            begin = pageNumber - 5;  //当前页 - 5
            end = pageNumber + 4;  //当前页 + 4
            // 阻止角标越界行为
            if (begin < 1) {
                begin = 1;
                end = 10;
            }
            if (end > totalPage) {
                end = totalPage;
                begin = totalPage - 9;
            }
        }
    }

    public int getBegin() {
        compute(); //  前端调用begin时 先进行计算
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        compute();  //前端调用 也要计算
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public List<Receipt> getList() {
        return list;
    }

    public void setList(List<Receipt> list) {
        this.list = list;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
