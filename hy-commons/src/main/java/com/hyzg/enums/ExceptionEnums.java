package com.hyzg.enums;//

//                       .::::.
//                     .::::::::.
//                    ::::::::::: 
//                 ..:::::::::::'
//              '::::::::::::'
//                .::::::::::
//           '::::::::::::::..
//                ..::::::::::::.
//              ``::::::::::::::::
//               ::::``:::::::::'        .:::.
//              ::::'   ':::::'       .::::::::.
//            .::::'      ::::     .:::::::'::::.
//           .:::'       :::::  .:::::::::' ':::::.
//          .::'        :::::.:::::::::'      ':::::.
//         .::'         ::::::::::::::'         ``::::.
//     ...:::           ::::::::::::'              ``::.
//    ```` ':.          ':::::::::'                  ::::..
//                       '.:::::'                    ':'````..
//

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
//创建一个枚举描述错误信息
//code为状态码，msg为提示信息
public enum ExceptionEnums {
    USER_NOT_EXIST(3000,"该用户不存在"),
    PASS_NOT_RIGHT(4000,"该用户信息不存在"),
    CARTYPE_NOT_FOUND (5000,"车辆类型找不到") ,
    GOODSTYPE_NOT_FOUND (6000,"商品种类找不到") ,
    GOODSKIND_NOT_FOUND (7000,"商品类别找不到") ,
    TRANSPORT_NOT_FOUND (8000,"线路类型找不到");
    private int code;
    private String msg;
}
