package com.example.rbac.dao;

import com.example.rbac.entity.TResHistory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TResHistory)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-17 17:05:58
 */
@Mapper
public interface TResHistoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param reshId 主键
     * @return 实例对象
     */
    TResHistory queryById(Integer reshId);

    /**
     * 查询指定行数据
     *
     * @param tResHistory 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TResHistory> queryAllByLimit(TResHistory tResHistory, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tResHistory 查询条件
     * @return 总行数
     */
    long count(TResHistory tResHistory);

    /**
     * 新增数据
     *
     * @param tResHistory 实例对象
     * @return 影响行数
     */
    int insert(TResHistory tResHistory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TResHistory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TResHistory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TResHistory> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TResHistory> entities);

    /**
     * 修改数据
     *
     * @param tResHistory 实例对象
     * @return 影响行数
     */
    int update(TResHistory tResHistory);

    /**
     * 通过主键删除数据
     *
     * @param reshId 主键
     * @return 影响行数
     */
    int deleteById(Integer reshId);

    List<TResHistory> getAllHis();

    Integer addHis(String account,String operation);

}

