package com.zhaobo.stream.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhaobo.stream.dao.entity.AppDaily;

/**
 * AppDailyService.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/12 - 下午3:42
 * </p>
 */
public interface AppDailyService extends IService<AppDaily> {

    Page<AppDaily> queryPage();
}
