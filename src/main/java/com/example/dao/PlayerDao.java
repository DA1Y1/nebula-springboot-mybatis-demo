package com.example.dao;

import com.example.pojo.PlayerDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author DAIYI
 * @since 2022-04-23
 */
@Repository
public interface PlayerDao {

    /**
     * mapper 插入操作
     * @param entity 插入实体
     * @return 是否成功
     */
    int insert(PlayerDO entity);

    /**
     * mapper 更新操作
     * @param entity 更新实体
     * @return 是否成功
     */
    int update(PlayerDO entity);

    /**
     * 批量插入
     * @param batch 实体列表
     * @return i
     */
    int insertBatch(List<PlayerDO> batch);

    /**
     * 根据id查询实体
     * @param id 实体id
     * @return entity
     */
    PlayerDO select(String id);

    /**
     * 根据id查询实体
     * @param batch 实体id列表
     * @return entity list
     */
    List<PlayerDO> selectBatch(List<String> batch);

    /**
     * 删除
     * @param id 实体列表id
     * @return i
     */
    int delete(String id);

    /**
     * 批量删除
     * @param batch 实体列表id
     * @return i
     */
    int deleteBatch(List<String> batch);

    // 以上代码自动生成

    /**
     * 根据id查询实体
     * @param id 实体id
     * @return entity
     */
    PlayerDO selectReturnV(String id);




}
