package com.zhaobo.stream.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaobo.stream.dao.entity.AppDaily;
import com.zhaobo.stream.dao.mapper.AppDailyMapper;
import com.zhaobo.stream.service.AppDailyService;
import org.springframework.stereotype.Service;

/**
 * AppDailyServiceImpl.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/12 - 下午3:43
 * </p>
 */
@Service
public class AppDailyServiceImpl extends ServiceImpl<AppDailyMapper, AppDaily> implements AppDailyService {


    @Override
    public Page<AppDaily> queryPage() {

        // 创建page对象
        Page<AppDaily> page = new Page<>(1,50);

        // 创建用来封装条件的对象
        LambdaQueryWrapper lambdaQueryWrapper = new LambdaQueryWrapper();

        Page<AppDaily> pageResult = page(page, lambdaQueryWrapper);

        return pageResult;
    }
}
