package com.example.rbac.dao;

import com.example.rbac.entity.TResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TResource)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-17 17:23:26
 */
@Mapper
public interface TResourceDao {

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    TResource queryById(Integer rId);

    /**
     * 查询指定行数据
     *
     * @param tResource 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TResource> queryAllByLimit(TResource tResource, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tResource 查询条件
     * @return 总行数
     */
    long count(TResource tResource);

    /**
     * 新增数据
     *
     * @param tResource 实例对象
     * @return 影响行数
     */
    int insert(TResource tResource);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TResource> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TResource> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TResource> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TResource> entities);

    /**
     * 修改数据
     *
     * @param tResource 实例对象
     * @return 影响行数
     */
    int update(TResource tResource);

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 影响行数
     */
    int deleteById(Integer rId);

    List<TResource> getAllRes();

    List<TResource> findRes(String account);
    Integer addResource(String address,String account);
    Integer updateInfoById(int id,String address);

}

