import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/returnApply/list',
    method:'get',
    params:params
  })
}
//批量删除
export function deleteApply(params) {
  return request({
    url:'/returnApply/delete',
    method:'post',
    params:params
  })
}
//更新申请状态
export function updateApplyStatus(id,data) {
  return request({
    url:'/returnApply/update/status/'+id,
    method:'post',
    data:data
  })
}
//获取退货申请详情
export function getApplyDetail(id) {
  return request({
    url:'/returnApply/'+id,
    method:'get'
  })
}
