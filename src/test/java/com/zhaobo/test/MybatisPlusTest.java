package com.zhaobo.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhaobo.stream.StreamApplication;
import com.zhaobo.stream.dao.entity.AppDaily;
import com.zhaobo.stream.dao.entity.AppWeekly;
import com.zhaobo.stream.service.AppDailyService;
import com.zhaobo.stream.service.AppWeeklyService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * MybatisPlusTest.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/12 - 下午3:56
 * </p>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StreamApplication.class})
@Slf4j
public class MybatisPlusTest {

    @Autowired
    private AppDailyService dailyService;

    @Autowired
    private AppWeeklyService appWeeklyService;

    private static void accept(AppDaily appDaily) {
        log.info("appDaily:{}", appDaily);
    }

    @Test
    public void demo() {
        Page<AppDaily> appDailyPage = dailyService.queryPage();
        List<AppDaily> records = appDailyPage.getRecords();
        records.forEach(appDaily -> {
            if (appDaily.getMachineName().equals("local-test")) {
                System.err.println(appDaily);
            }
        });
    }

    @Test
    public void demo02() {

        Page<AppWeekly> page = appWeeklyService.queryPage();
        List<AppWeekly> records = page.getRecords();
        records.forEach(appWeekly -> {
            if (log.isInfoEnabled()) {
                log.info("AppWeekly:{}",appWeekly);
            }
        });
    }
}
