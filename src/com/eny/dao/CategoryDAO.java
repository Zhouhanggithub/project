package com.eny.dao;

import com.eny.domain.Category;

/**
 * Created by MoMo on 2018/1/4.
 */
public interface CategoryDAO {
    Category findByCategoryId(int bookId);
}
