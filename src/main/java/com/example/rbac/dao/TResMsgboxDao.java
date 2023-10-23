package com.example.rbac.dao;

import com.example.rbac.entity.TResMsgbox;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TResMsgbox)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-18 10:27:01
 */
@Mapper
public interface TResMsgboxDao {

    /**
     * 通过ID查询单条数据
     *
     * @param rmbId 主键
     * @return 实例对象
     */
    TResMsgbox queryById(Integer rmbId);

    /**
     * 查询指定行数据
     *
     * @param tResMsgbox 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TResMsgbox> queryAllByLimit(TResMsgbox tResMsgbox, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tResMsgbox 查询条件
     * @return 总行数
     */
    long count(TResMsgbox tResMsgbox);

    /**
     * 新增数据
     *
     * @param tResMsgbox 实例对象
     * @return 影响行数
     */
    int insert(TResMsgbox tResMsgbox);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TResMsgbox> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TResMsgbox> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TResMsgbox> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TResMsgbox> entities);

    /**
     * 修改数据
     *
     * @param tResMsgbox 实例对象
     * @return 影响行数
     */
    int update(TResMsgbox tResMsgbox);

    /**
     * 通过主键删除数据
     *
     * @param rmbId 主键
     * @return 影响行数
     */
    int deleteById(Integer rmbId);

    String getDetailById(Integer id);

}

