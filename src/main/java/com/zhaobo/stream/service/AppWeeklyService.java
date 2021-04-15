package com.zhaobo.stream.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhaobo.stream.dao.entity.AppWeekly;

/**
 * AppWeeklyService.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/12 - 下午6:02
 * </p>
 */
public interface AppWeeklyService extends IService<AppWeekly> {

    Page<AppWeekly> queryPage();
}
