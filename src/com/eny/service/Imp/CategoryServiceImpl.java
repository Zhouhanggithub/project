package com.eny.service.Imp;

import com.eny.dao.Impl.GenericDaoImpl;
import com.eny.dao.GenericDAO;
import com.eny.domain.Category;
import com.eny.service.CategoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MoMo on 2018/1/2.
 */
public class CategoryServiceImpl implements CategoryService {
    private GenericDAO baseDao = new GenericDaoImpl();
    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = null;
        try {
            String sql = "select * from book_category";
            categories = baseDao.generalSelectSQL(sql, Category.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getCatecoryByName(String bookCategoryName) {
        List<Category> categories = null;
        try {
            String sql = "select * from book_category ";
            Map map = new HashMap();
            map.put("bookCategoryName",bookCategoryName);
            categories = baseDao.generalSelectSQL(sql, Category.class,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (categories.get(0) == null)?null:categories.get(0);
    }

}
