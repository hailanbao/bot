package com.tianbo.mall.modules.oms.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 订单操作历史记录
 * </p>
 *
 * @author tianbo
 * @since 2023-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("oms_order_operate_history")
@ApiModel(value="OmsOrderOperateHistory对象", description="订单操作历史记录")
public class OmsOrderOperateHistory implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "订单id")
    private Long orderId;

    @ApiModelProperty(value = "操作人：用户；系统；后台管理员")
    private String operateMan;

    @ApiModelProperty(value = "操作时间")
    private Date createTime;

    @ApiModelProperty(value = "订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单")
    private Integer orderStatus;

    @ApiModelProperty(value = "备注")
    private String note;


}
