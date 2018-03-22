package com.eny.dao.Impl;

import com.eny.dao.CategoryDAO;
import com.eny.domain.Category;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MoMo on 2018/1/4.
 */
public class CategoryDaoImpl extends GenericDaoImpl implements CategoryDAO {
    @Override
    public Category findByCategoryId(int bookId) {
        List<Category> categories = null;
        try {
        String sql = "select * from book_category";
        Map map = new HashMap();
        map.put("bookCategoryId",bookId);
        categories = generalSelectSQL(sql, Category.class, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories == null || categories.size() == 0 ? null : categories.get(0);
    }
}
