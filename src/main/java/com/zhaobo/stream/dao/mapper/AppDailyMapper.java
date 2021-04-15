package com.zhaobo.stream.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhaobo.stream.dao.entity.AppDaily;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * app日结果主表 Mapper 接口
 * </p>
 *
 * @author code-generator
 * @since 2020-11-16
 */
@Repository
public interface AppDailyMapper extends BaseMapper<AppDaily> {

    Boolean updateCumPlan(List<Map<String,Integer>> list);
    Boolean updateCumActual(List<Map<String,Integer>> list);
}
