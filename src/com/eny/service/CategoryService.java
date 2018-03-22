package com.eny.service;

import com.eny.domain.Category;

import java.util.List;

/**
 * Created by MoMo on 2018/1/2.
 */
public interface CategoryService {
    List<Category> getAllCategory();

    /**
     * 根据分类名字获取该分类
     * @param bookCategoryName
     */
    Category getCatecoryByName(String bookCategoryName);
}
