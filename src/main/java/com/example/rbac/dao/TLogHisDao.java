package com.example.rbac.dao;

import com.example.rbac.entity.TLogHis;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TLogHis)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-18 15:09:23
 */
@Mapper
public interface TLogHisDao {

    /**
     * 通过ID查询单条数据
     *
     * @param lhId 主键
     * @return 实例对象
     */
    TLogHis queryById(Integer lhId);

    /**
     * 查询指定行数据
     *
     * @param tLogHis 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TLogHis> queryAllByLimit(TLogHis tLogHis, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tLogHis 查询条件
     * @return 总行数
     */
    long count(TLogHis tLogHis);

    /**
     * 新增数据
     *
     * @param tLogHis 实例对象
     * @return 影响行数
     */
    int insert(TLogHis tLogHis);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TLogHis> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TLogHis> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TLogHis> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TLogHis> entities);

    /**
     * 修改数据
     *
     * @param tLogHis 实例对象
     * @return 影响行数
     */
    int update(TLogHis tLogHis);

    /**
     * 通过主键删除数据
     *
     * @param lhId 主键
     * @return 影响行数
     */
    int deleteById(Integer lhId);

    List<TLogHis> getAllHis();

    Integer insertRecord(String account);

}

