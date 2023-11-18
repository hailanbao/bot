package com.tianbo.mall.modules.oms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tianbo.mall.dto.AddCarDTO;
import com.tianbo.mall.modules.oms.model.OmsCartItem;
import com.tianbo.mall.dto.CartItemStockDTO;

import java.util.List;

/**
 * <p>
 * 购物车表 服务类
 * </p>
 */
public interface OmsCartItemService extends IService<OmsCartItem> {

    Boolean add(AddCarDTO addCarDTO);

    /**
     * 初始化状态栏的购物车商品数量
     * @return
     */
    Integer getCarProdutSum();

    /**
     * 初始化购物车数据
     * @return
     */
    List<CartItemStockDTO> getList();

    /**
     * 更新商品数量
     * @param id
     * @param quantity
     * @return
     */
    boolean updateQuantity(Long id, Integer quantity);

    /**
     * 删除
     * @param ids
     * @return
     */
    Boolean delete(Long ids);
}
