package com.example.rbac.dao;

import com.example.rbac.entity.TUsrPermit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TUsrPermit)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-17 23:21:39
 */
@Mapper
public interface TUsrPermitDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pId 主键
     * @return 实例对象
     */
    TUsrPermit queryById(Integer pId);

    /**
     * 查询指定行数据
     *
     * @param tUsrPermit 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TUsrPermit> queryAllByLimit(TUsrPermit tUsrPermit, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tUsrPermit 查询条件
     * @return 总行数
     */
    long count(TUsrPermit tUsrPermit);

    /**
     * 新增数据
     *
     * @param tUsrPermit 实例对象
     * @return 影响行数
     */
    int insert(TUsrPermit tUsrPermit);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUsrPermit> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TUsrPermit> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUsrPermit> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TUsrPermit> entities);

    /**
     * 修改数据
     *
     * @param tUsrPermit 实例对象
     * @return 影响行数
     */
    int update(TUsrPermit tUsrPermit);

    /**
     * 通过主键删除数据
     *
     * @param pId 主键
     * @return 影响行数
     */
    int deleteById(Integer pId);

    Integer queryPermission(String account);
    Integer addNewUsr(String account);
    int deleteByAcc(String account);
    int updateByAcc(String account,String newAcc);

}

