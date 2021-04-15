package com.zhaobo.stream.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * AppWeekly.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/12 - 下午5:51
 * </p>
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AppWeekly extends Model<AppWeekly> {

    /*id` int NOT NULL AUTO_INCREMENT COMMENT '主键自增序列',
            `machine_id` int NOT NULL COMMENT '机种id',
            `machine_name` varchar(32) NOT NULL COMMENT '机种名',
            `config_id` int NOT NULL COMMENT 'config id',
            `config_name` varchar(32) NOT NULL COMMENT 'config名',
            `category` int NOT NULL COMMENT '供需种类 1:Daily Input; 2:Daily Output; 3:Daily Ship to FATP CD; 4:WIP数量; 5:Inventory; 6:MPS; 7:SVC; 8:LRP Scrap; 9:Fresh Scrap; 10:FATP Other Use;	11:Other Use; 12:On hold WIP; 13:Delta（Ship-MPS）; 14:DSI指数; 15:WIP指数',
            `cum_plan` int NOT NULL COMMENT 'cum plan即累计计划投入量',
            `cum_actual` int NOT NULL COMMENT 'cum actual即累计真实计划量',
            `status` int NOT NULL DEFAULT '1' COMMENT '数据物理状态：0已删除 1未删除',
            `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
            `update_time` times*/

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    private Integer machineId;

    private String machineName;

    private Integer configId;

    private String configName;

    private Integer category;

    private Integer cumPlan;

    private Integer cumActual;

    private Integer status;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;


}
