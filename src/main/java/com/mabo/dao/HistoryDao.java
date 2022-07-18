package com.mabo.dao;

import com.mabo.entity.History;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.Map;

/**
 * (History)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-18 11:19:24
 */
public interface HistoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    Map queryById(@Param("ip") String ip, @Param("sdkname") String sdkname,@Param("start") Date start,@Param("end") Date end);


    /**
     * 新增数据
     *
     * @param history 实例对象
     * @return 影响行数
     */
    int insert(History history);

}

