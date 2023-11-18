import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/order/list',
    method:'get',
    params:params
  })
}

export function closeOrder(params) {
  return request({
    url:'/order/update/close',
    method:'post',
    params:params
  })
}

export function deleteOrder(params) {
  return request({
    url:'/order/delete',
    method:'post',
    params:params
  })
}
//批量发货
export function deliveryOrder(data) {
  return request({
    url:'/order/update/delivery',
    method:'post',
    data:data
  });
}
//获取订单详情:订单信息、商品信息、操作记录
export function getOrderDetail(id) {
  return request({
    url:'/order/'+id,
    method:'get'
  });
}
//修改收货人信息
export function updateReceiverInfo(data) {
  return request({
    url:'/order/update/receiverInfo',
    method:'post',
    data:data
  });
}
//修改订单费用信息
export function updateMoneyInfo(data) {
  return request({
    url:'/order/update/moneyInfo',
    method:'post',
    data:data
  });
}
//备注订单
export function updateOrderNote(params) {
  return request({
    url:'/order/update/note',
    method:'post',
    params:params
  })
}
