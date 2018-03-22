package com.eny.dao;

import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by MoMo on 2018/1/2.
 */
public interface GenericDAO {
    /**
     *      基本查询--使用默认创建的连接
     *          当通用方法无法满足时,使用
     * @param sql         SQL语句
     * @param handler     结果处理器
     * @param paramValues SQL占位符参数
     * @param <T>         泛型
     * @return            结果对象集合
     * @throws Exception  异常
     */
     <T> List<T> query(String sql, ResultSetHandler<List<T>> handler, Object[] paramValues) throws Exception;

    /**
     *      (重载)基本查询--使用指定连接
     *          当通用方法无法满足时,使用
     * @param sql         SQL语句
     * @param handler     结果处理器
     * @param paramValues SQL占位符参数
     * @param <T>         泛型
     * @return            结果对象集合
     * @throws Exception  异常
     */
     <T> List<T> query(Connection conn, String sql, ResultSetHandler<List<T>> handler, Object[] paramValues) throws Exception;

    /**
     *      基本更新     当通用方法无法满足时,使用
     * @param sql           SQL(更新、修改、删除)
     * @param paramValues   所需要的参数
     * @return              所影响的行数
     * @throws SQLException 异常
     */
     int update(String sql, Object[] paramValues) throws SQLException;


    /**
     *      通用查询对象(有参数):
     *          可将一个对象参数存成KEY--->Value形式的map
     * @param sql        sql语句
     * @param clazz      对象类型
     * @param map        存储属性名和属性值(查询条件)
     * @param <T>        泛型
     * @return           单个对象
     * @throws Exception 异常
     */
     <T> List<T> generalSelectSQL(String sql, Class<T> clazz, Map map) throws Exception;

    /**
     *    重载--查询对象(无参数):
     *          可将一个对象参数存成KEY--->Value形式的map
     * @param sql        sql语句
     * @param clazz      对象类型
     * @param <T>        泛型
     * @return           单个对象
     * @throws Exception 异常
     */
     <T> List<T> generalSelectSQL(String sql, Class<T> clazz) throws Exception;


    /**
     *     通用删除
     * @param sql   DELETE 语句
     * @param map   SQL中的条件和参数
     * @return      影响的行数
     * @throws SQLException     异常
     */
    int generalDeleteSQL(String sql, Map map) throws SQLException;

    /**
     *      用于处理SQL语句
     *          将传过来的SQL进行连接
     *              把map进行拆分
     * @param sql  需要处理的sql
     * @param keyAndValue   需要处理的参数
     * @return  map(key=处理后的sql,valuee=处理后的参数数组)
     */
    Map handlerSQL(String sql, Map keyAndValue);

}
