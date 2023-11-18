package com.tianbo.mall.modules.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tianbo.mall.modules.product.model.PmsBrand;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 品牌表 服务类
 * </p>
 *
 * @author tianbo
 * @since 2023-09-14
 */
public interface PmsBrandService extends IService<PmsBrand> {

    Page list(String keyword, Integer pageNum, Integer pageSize);

    boolean update(PmsBrand pmsBrand);

    boolean updateShowStatus(List<Long> ids, Integer showStatus);

    boolean updateFactoryStatus(List<Long> ids, Integer factoryStatus);
}
