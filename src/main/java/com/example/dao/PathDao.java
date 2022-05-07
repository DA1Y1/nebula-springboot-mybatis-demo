package com.example.dao;

import com.example.pojo.PathDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 查询路径接口
 *
 * @author DAIYI
 * @since 2021-09-10
 */
@Repository
public interface PathDao {

    /**
     * 查询两点之间的路径
     */
    List<PathDO> selectPath(String src, String dst);

}
