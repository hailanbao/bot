package com.tianbo.mall.modules.product.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 商品会员价格表
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("pms_member_price")
@ApiModel(value="PmsMemberPrice对象", description="商品会员价格表")
public class PmsMemberPrice implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long productId;

    private Long memberLevelId;

    @ApiModelProperty(value = "会员价格")
    private BigDecimal memberPrice;

    private String memberLevelName;


}
