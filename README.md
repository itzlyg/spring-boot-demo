# 最新版本的spring boot

- 1、使用 springboot 3 m2 版本
- 2、集成 spring doc；

##### 流程
-1、启动流程
```
curl -X POST 'http://127.0.0.1:8100/api/flowable/start_flow' \
-H 'Content-Type: application/json' \
-d '{
  "flowId": "OrderApproval",
  "bsnId": "ordec_1334",
  "bsnNo": "No20220405001",
  "variables": {
    "params": "params",
    "userId": "xyb"
  }
}'

{
    "code": null,
    "message": null,
    "data": "34372608802074624_null"
}
```
2、查询用户下的待办
```
curl -X POST 'http://127.0.0.1:8100/api/flowable/user_tasks/xyb'


{
    "code": null,
    "message": null,
    "data": "[Task[id=34376299005259776, name=Order approval]]"
}
```
3、审核 通过或者不通过
```
curl -X POST 'http://127.0.0.1:8100/api/flowable/examine_flow' \
-H 'Content-Type: application/json' \
-d '{
  "taskId": "34376299005259776",
  "variables": { 
    "userId": "xyb",
    "approved": true
  }
}'

{
    "code": null,
    "message": null,
    "data": ""
}
```
4、查看流程图
```
curl -X POST 'http://127.0.0.1:8100/api/flowable/flow_img/34372608802074624'
```