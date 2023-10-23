package com.example.rbac.dao;

import com.example.rbac.entity.TUsr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (TUsr)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-17 17:25:36
 */
@Mapper
public interface TUsrDao {

    /**
     * 通过ID查询单条数据
     *
     * @param usrId 主键
     * @return 实例对象
     */
    TUsr queryById(Integer usrId);

    /**
     * 查询指定行数据
     *
     * @param tUsr 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TUsr> queryAllByLimit(TUsr tUsr, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tUsr 查询条件
     * @return 总行数
     */
    long count(TUsr tUsr);

    /**
     * 新增数据
     *
     * @param tUsr 实例对象
     * @return 影响行数
     */
    int insert(TUsr tUsr);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUsr> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TUsr> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TUsr> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TUsr> entities);

    /**
     * 修改数据
     *
     * @param tUsr 实例对象
     * @return 影响行数
     */
    int update(TUsr tUsr);

    /**
     * 通过主键删除数据
     *
     * @param usrId 主键
     * @return 影响行数
     */
    int deleteById(Integer usrId);

    /**
     *
     * @param account
     * @param passwd
     * @return
     */
    Integer checkLoginInfo(String account,String passwd);

    List<TUsr> getAllInfo();

    Integer entryLogInfo(String account, String passwd);

    Integer addAccount(String account,String passwd);

    Integer checkAccount(String account);

    TUsr findUsr(String account);

    Integer updateById(Integer id, String passwd);

    String getAccById(Integer id);


}

