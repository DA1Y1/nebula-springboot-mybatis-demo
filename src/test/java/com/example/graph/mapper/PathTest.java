package com.example.graph.mapper;

import com.example.pojo.FollowDO;
import com.example.pojo.PlayerDO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author DAIE
 * @date 2022/4/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class PathTest {
    @Resource
    private FollowDao followDao;
    @Resource
    private PlayerDao playerDao;
    @Resource
    private PathDao pathDao;

    @BeforeEach
    public void before() {
        PlayerDO daiyi = PlayerDO.builder().id("daiyi").name("daiyi").age(22l).build();
        PlayerDO joe = PlayerDO.builder().id("joe").name("joe").age(24l).build();
        PlayerDO peter = PlayerDO.builder().id("peter").name("peter").age(23l).build();
        playerDao.insertBatch(Lists.newArrayList(daiyi, joe, peter));

        FollowDO joe2daiyi = FollowDO.builder().src("joe").dst("daiyi").build();
        FollowDO daiyi2peter = FollowDO.builder().src("daiyi").dst("peter").build();
        followDao.insertBatch(Lists.newArrayList(joe2daiyi, daiyi2peter));

    }

    @AfterEach
    public void after() {
        playerDao.deleteBatch(Lists.newArrayList("daiyi", "joe", "peter"));

        FollowDO joe2daiyi = FollowDO.builder().src("joe").dst("daiyi").build();
        FollowDO daiyi2peter = FollowDO.builder().src("daiyi").dst("peter").build();
        followDao.deleteBatch(Lists.newArrayList(joe2daiyi, daiyi2peter));
    }

    @Test
    public void selectPath() {
        log.info("path info {}", pathDao.selectPath("joe", "peter"));
    }

}