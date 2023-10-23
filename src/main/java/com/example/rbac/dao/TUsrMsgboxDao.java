package com.example.rbac.dao;

import com.example.rbac.entity.TUsrMsgbox;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TUsrMsgbox)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-18 10:27:01
 */
@Mapper
public interface TUsrMsgboxDao {

    /**
     * 通过ID查询单条数据
     *
     * @param umId 主键
     * @return 实例对象
     */
    TUsrMsgbox queryById(Integer umId);

    /**
     * 查询指定行数据
     *
     * @param tUsrMsgbox 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TUsrMsgbox> queryAllByLimit(TUsrMsgbox tUsrMsgbox, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tUsrMsgbox 查询条件
     * @return 总行数
     */
    long count(TUsrMsgbox tUsrMsgbox);

    /**
     * 新增数据
     *
     * @param tUsrMsgbox 实例对象
     * @return 影响行数
     */
    int insert(TUsrMsgbox tUsrMsgbox);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUsrMsgbox> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TUsrMsgbox> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUsrMsgbox> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TUsrMsgbox> entities);

    /**
     * 修改数据
     *
     * @param tUsrMsgbox 实例对象
     * @return 影响行数
     */
    int update(TUsrMsgbox tUsrMsgbox);

    /**
     * 通过主键删除数据
     *
     * @param umId 主键
     * @return 影响行数
     */
    int deleteById(Integer umId);

    String getDetailById(Integer id);

}

