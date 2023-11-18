import request from '@/utils/request'
//获取指定订单设置
export function getOrderSetting(id) {
  return request({
    url:'/orderSetting/'+id,
    method:'get',
  })
}
//修改指定订单设置
export function updateOrderSetting(id,data) {
  return request({
    url:'/orderSetting/update/'+id,
    method:'post',
    data:data
  })
}
