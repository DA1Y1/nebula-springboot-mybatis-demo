package com.example.graph.mapper;

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
class PlayerDaoTest {


    @Resource
    private PlayerDao playerDao;

    @BeforeEach
    public void before() {
        PlayerDO daiyi = PlayerDO.builder().id("daiyi").name("daiyi").age(22l).build();
        PlayerDO joe = PlayerDO.builder().id("joe").name("joe").age(24l).build();
        playerDao.insertBatch(Lists.newArrayList(daiyi, joe));

    }

    @AfterEach
    public void after() {
        playerDao.deleteBatch(Lists.newArrayList("daiyi", "joe"));
    }

    @Test
    void insert() {
        this.delete();

        PlayerDO daiyi = PlayerDO.builder().id("daiyi").name("daiyi").age(22l).build();
        log.info("insert player {}", playerDao.insert(daiyi));

        log.info("player info {}", playerDao.selectBatch(Lists.newArrayList("daiyi", "joe")));
    }

    @Test
    void update() {
        log.info("player info {}", playerDao.select("daiyi"));
        playerDao.update(PlayerDO.builder().id("daiyi").name("daiyiupdate").build());
        log.info("player info {}", playerDao.select("daiyi"));
    }

    @Test
    void insertBatch() {
        // 见before
    }

    @Test
    void select() {
        log.info("player info {}", playerDao.select("daiyi"));
    }

    @Test
    void selectBatch() {
        log.info("player info {}", playerDao.selectBatch(Lists.newArrayList("daiyi", "joe")));
    }

    @Test
    void delete() {
        log.info("player info {}", playerDao.selectBatch(Lists.newArrayList("daiyi", "joe")));
        log.info("play delete {}", playerDao.delete("daiyi"));
        log.info("player info {}", playerDao.selectBatch(Lists.newArrayList("daiyi", "joe")));
    }

    @Test
    void deleteBatch() {
        // 见after
    }
}