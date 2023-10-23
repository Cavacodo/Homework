package com.example.rbac.dao;

import com.example.rbac.entity.TRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TRole)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-17 17:25:36
 */
@Mapper
public interface TRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param rPermission 主键
     * @return 实例对象
     */
    TRole queryById(Integer rPermission);

    /**
     * 查询指定行数据
     *
     * @param tRole 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TRole> queryAllByLimit(TRole tRole, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tRole 查询条件
     * @return 总行数
     */
    long count(TRole tRole);

    /**
     * 新增数据
     *
     * @param tRole 实例对象
     * @return 影响行数
     */
    int insert(TRole tRole);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TRole> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TRole> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TRole> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TRole> entities);

    /**
     * 修改数据
     *
     * @param tRole 实例对象
     * @return 影响行数
     */
    int update(TRole tRole);

    /**
     * 通过主键删除数据
     *
     * @param rPermission 主键
     * @return 影响行数
     */
    int deleteById(Integer rPermission);

    String queryRole(int r_permission);

}

