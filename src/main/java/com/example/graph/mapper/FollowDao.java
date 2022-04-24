package com.example.graph.mapper;

import com.example.pojo.FollowDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author DAIYI
 * @since 2022-04-23
 */
@Repository
public interface FollowDao {

    /**
     * mapper 插入操作
     *
     * @param entity 插入实体
     * @return 是否成功
     */
    int insert(FollowDO entity);

    /**
     * mapper 更新操作
     *
     * @param entity 更新实体
     * @return 是否成功
     */
    int update(FollowDO entity);

    /**
     * 批量插入
     *
     * @param batch 实体列表
     * @return i
     */
    int insertBatch(List<FollowDO> batch);


    /**
     * 根据起始点查询边属性
     *
     * @param src 起始点id
     * @param dst 终止点id
     * @return entity
     */
    FollowDO select(String src, String dst);

    /**
     * 根据起始点列表查询边属性
     *
     * @param batch 实体id列表
     * @return entity list
     */
    List<FollowDO> selectBatch(List<FollowDO> batch);

    /**
     * 批量删除
     *
     * @param src 边起点
     * @param dst 边终点
     * @return i
     */
    int delete(String src, String dst);

    /**
     * 批量删除
     *
     * @param batch 边列表
     * @return i
     */
    int deleteBatch(List<FollowDO> batch);

    // 以上代码自动生成

    /**
     * 根据起始点查询边属性
     *
     * @param srcName 起始点id
     * @param dstName 终止点id
     * @return entity
     */
    FollowDO selectReturnE(String srcName, String dstName);


}
