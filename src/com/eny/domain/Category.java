package com.eny.domain;

/**
 * @author Momo
 * 2017年9月11日
 * 图书类别信息实体
 */
public class Category {

    /**
     * 图书类别信息实体
     */
    public Category(){}

    public Category(Integer bookCategoryId){
        this.bookCategoryId = bookCategoryId;
    }

    /**
     * 主键ID
     */
    private Integer bookCategoryId;

    /**
     * 图书类别名称
     */
    private String bookCategoryName;

    /**
     * 图书类别数量
     */
    private Integer bookNum = 0;

    /**
     * 图片路径
     */
    private String bookImgPath;


    /**
     * 分类书籍描述(简单描述)
     */
    private String bookDis_1;

    /**
     * 分类书籍描述(详细描述)
     */
    private String bookDis_2;

    /**
     * 更新时间
     */
    private String updateTime;


    public String getBookDis_1() {
        return bookDis_1;
    }

    public void setBookDis_1(String bookDis_1) {
        this.bookDis_1 = bookDis_1;
    }

    public String getBookDis_2() {
        return bookDis_2;
    }

    public void setBookDis_2(String bookDis_2) {
        this.bookDis_2 = bookDis_2;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getBookImgPath() {
        return bookImgPath;
    }

    public void setBookImgPath(String bookImgPath) {
        this.bookImgPath = bookImgPath;
    }

    public Integer getBookCategoryId() {
        return bookCategoryId;
    }

    public void setBookCategoryId(Integer bookCategoryId) {
        this.bookCategoryId = bookCategoryId;
    }

    public String getBookCategoryName() {
        return bookCategoryName;
    }

    public void setBookCategoryName(String bookCsategoryName) {
        this.bookCategoryName = bookCsategoryName;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    @Override
    public int hashCode() {
        return this.bookCategoryId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Category){
            Category category = (Category)obj;
            if(category.getBookCategoryId().equals(this.bookCategoryId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Category{" +
                "bookCategoryId=" + bookCategoryId +
                ", bookCategoryName='" + bookCategoryName + '\'' +
                ", bookNum=" + bookNum +
                '}';
    }


}
