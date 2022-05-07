package com.example.test;

import com.example.dao.FollowDao;
import com.example.dao.PlayerDao;
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
class FollowDaoTest {
    @Resource
    private FollowDao followDao;
    @Resource
    private PlayerDao playerDao;

    @BeforeEach
    public void before() {
        PlayerDO daiyi = PlayerDO.builder().id("daiyi").name("daiyi").age(22l).build();
        PlayerDO joe = PlayerDO.builder().id("joe").name("joe").age(24l).build();
        PlayerDO peter = PlayerDO.builder().id("peter").name("peter").age(23l).build();
        playerDao.insertBatch(Lists.newArrayList(daiyi, joe, peter));

        FollowDO joe2daiyi = FollowDO.builder().src("joe").dst("daiyi").degree(100l).build();
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
    void insert() {
        this.delete();

        FollowDO joe2daiyi = FollowDO.builder().src("joe").dst("daiyi").build();
        log.info("follow insert {}", followDao.insert(joe2daiyi));

        this.selectBatch();
    }

    @Test
    void update() {
        log.info("follow info {}", followDao.select("joe", "daiyi"));

        FollowDO update = FollowDO.builder().src("joe").dst("daiyi").degree(50l).build();
        log.info("follow update {}", followDao.update(update));

        log.info("follow info {}", followDao.select("joe", "daiyi"));
    }

    @Test
    void insertBatch() {
        log.info("见before()");
    }

    @Test
    void selectReturnE() {
        log.info("follow info {}", followDao.selectReturnE("joe", "daiyi"));
    }

    @Test
    void select() {
        log.info("follow info {}", followDao.select("joe", "daiyi"));
    }

    @Test
    void selectBatch() {
        FollowDO joe2daiyi = FollowDO.builder().src("joe").dst("daiyi").build();
        FollowDO daiyi2peter = FollowDO.builder().src("daiyi").dst("peter").build();
        log.info("follow info {}", followDao.selectBatch(Lists.newArrayList(joe2daiyi, daiyi2peter)));
    }

    @Test
    void delete() {
        this.selectBatch();
        log.info("follow delete {}", followDao.delete("joe", "daiyi"));
        this.selectBatch();
    }

    @Test
    void deleteBatch() {
        log.info("见after()");
    }
}