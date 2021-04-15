package com.zhaobo.stream.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhaobo.stream.dao.entity.AppWeekly;
import com.zhaobo.stream.dao.mapper.AppWeeklyMapper;
import com.zhaobo.stream.service.AppWeeklyService;
import org.springframework.stereotype.Service;

/**
 * AppWeeklyServiceImpl.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/12 - 下午6:04
 * </p>
 */
@Service
public class AppWeeklyServiceImpl extends ServiceImpl<AppWeeklyMapper, AppWeekly> implements AppWeeklyService {
    @Override
    public Page<AppWeekly> queryPage() {

        Page<AppWeekly> page = new Page<>(1, 20);

        LambdaQueryWrapper<AppWeekly> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.orderByAsc(AppWeekly::getCreateTime);

        Page<AppWeekly> pageResult = page(page, lambdaQueryWrapper);

        return pageResult;
    }
}
