package com.eny.domain;

/**
 * Created by MoMo on 2018/1/5.
 */
public class PageConfig {
    /**
     * 初始化每次显示多少页
     */
    private int initPageNum = 5;

    /**
     * 初始化每页显示多少条数据
     */
    private int initDataNum = 20;



    public int getInitPageNum() {
        return initPageNum;
    }


    public void setInitPageNum(int initPageNum) {
        this.initPageNum = initPageNum;
    }

    public int getInitDataNum() {
        return initDataNum;
    }

    public void setInitDataNum(int initDataNum) {
        this.initDataNum = initDataNum;
    }


}
