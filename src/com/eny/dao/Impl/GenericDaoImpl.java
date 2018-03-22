package com.eny.dao.Impl;

import com.eny.dao.GenericDAO;
import com.eny.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by MoMo on 2018/1/2.
 */
public class GenericDaoImpl implements GenericDAO {
    /**
     *      基本查询
     * @param sql         SQL语句
     * @param paramValues SQL占位符参数
     * @param <T>         泛型
     * @return            结果对象集合
     * @throws Exception  异常
     */

    @Override
    public <T> List<T> query(String sql, ResultSetHandler<List<T>> handler, Object [] paramValues) throws Exception {
        QueryRunner qr = new QueryRunner(JdbcUtil.getDruidDataSource());
        return qr.query(sql, handler,paramValues);
    }

    @Override
    public <T> List<T> query(Connection conn ,String sql, ResultSetHandler<List<T>> handler, Object [] paramValues) throws Exception {
        QueryRunner qr = new QueryRunner();
        return qr.query(conn,sql, handler,paramValues);
    }

    /**
     *      基本更新
     * @param sql           SQL(更新、修改、删除)
     * @param paramValues   所需要的参数
     * @return              所影响的行数
     * @throws SQLException 异常
     */
    @Override
    public int update(String sql, Object [] paramValues) throws SQLException {
        Connection conn = JdbcUtil.getConnection();
        QueryRunner qr = new QueryRunner();
        return qr.update(conn, sql,paramValues);
    }

    /**
     *     通用删除
     * @param sql   DELETE 语句
     * @param map   SQL中的条件和参数
     * @return      影响的行数
     * @throws SQLException     异常
     */
    @Override
    public int generalDeleteSQL(String sql, Map map) throws SQLException {
        if (map == null || map.keySet().size() == 0){
            //无参数的 只有delete可能没有参数
            return this.update(sql, null);
        }
        //获取存放处理过后的SQL语句和参数的map
        Map keyAndValueMap = handlerSQL(sql, map);
        //从map中获取SQL语句
        sql = (String) keyAndValueMap.keySet().toArray()[0];
        //从map中获取到SQL语句占位符参数
        Object [] values = (Object[]) keyAndValueMap.get(sql);
        //调用通用更新语句
        return this.update(sql,values);
    }



    /**
     *      查询对象:
     *          可将一个对象参数存成KEY--->Value形式的map
     * @param clazz      对象类型
     * @param map        存储属性名和属性值(查询条件)
     * @param <T>        泛型
     * @return           单个对象
     * @throws Exception 异常
     */
    @Override
    public <T> List<T> generalSelectSQL(String sql, Class<T> clazz, Map map) throws Exception {
        //判断如果有map为空 表示没有参数  查询全部
        if(map == null || map.keySet().size() ==0){
            List<T> resultSet = this.query(sql,new BeanListHandler<T>(clazz), null);
            return resultSet == null || resultSet.size() == 0 ? null : resultSet;
        }
        //获取存放处理过后的SQL语句和参数的map
        Map keyAndValueMap = handlerSQL(sql, map);
        //从map中获取SQL语句
        sql = (String) keyAndValueMap.keySet().toArray()[0];
        //从map中获取到SQL语句占位符参数
        Object [] paramValues = (Object[]) keyAndValueMap.get(sql);
        //调用通用查询
        List<T> user = this.query(sql,new BeanListHandler<>(clazz),paramValues);
        //返回集合
        return user!=null&&user.size()>0?user:null;
    }
    //重载
    @Override
    public <T> List<T> generalSelectSQL(String sql, Class<T> clazz) throws Exception {
       return this.generalSelectSQL(sql,clazz,null);
    }

    /**
     *      处理SQL语句
     *          将传过来的SQL进行连接
     *              把map进行拆分
     * @param sql  需要处理的sql
     * @param keyAndValueMap   需要处理的参数
     * @return  map(key=处理后的sql,valuee=处理后的参数数组)
     */
    @Override
    public Map handlerSQL (String sql , Map keyAndValueMap){
        String linkStr_1 = " = ? and ";
        String linkStr_2 = " = ?";
        Map map = new HashMap();
        //定义SQL语句
        sql+=" where ";
        //数组下标
        int index = 0;
        //定义一个存放SQL语句占位符参数的数组
        Object [] paramValues = new Object[keyAndValueMap.keySet().size()];
        //获取map中的key(列名)的集合
        Set columnNames = keyAndValueMap.keySet();
        //遍历columnNames
        for (Object columnName:columnNames) {
            //根据key获取value(对应的值)
            Object value = keyAndValueMap.get(columnName);
            //把值存进数组
            paramValues[index++] = value;
            if(index == keyAndValueMap.keySet().size()){
                sql+=columnName+linkStr_2;
            }else{
                sql+=columnName+linkStr_1;
            }
        }
        map.put(sql,paramValues);
        return map;
    }



}
