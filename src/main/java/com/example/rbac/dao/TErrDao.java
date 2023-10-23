package com.example.rbac.dao;

import com.example.rbac.entity.TErr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TErr)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-19 11:40:18
 */
@Mapper
public interface TErrDao {

    /**
     * 通过ID查询单条数据
     *
     * @param eId 主键
     * @return 实例对象
     */
    TErr queryById(Integer eId);

    /**
     * 查询指定行数据
     *
     * @param tErr 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TErr> queryAllByLimit(TErr tErr, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tErr 查询条件
     * @return 总行数
     */
    long count(TErr tErr);

    /**
     * 新增数据
     *
     * @param tErr 实例对象
     * @return 影响行数
     */
    int insert(TErr tErr);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TErr> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TErr> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TErr> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TErr> entities);

    /**
     * 修改数据
     *
     * @param tErr 实例对象
     * @return 影响行数
     */
    int update(TErr tErr);

    /**
     * 通过主键删除数据
     *
     * @param eId 主键
     * @return 影响行数
     */
    int deleteById(Integer eId);

    int addRecord(int eid);

    List<TErr> getAllInfo();
}

