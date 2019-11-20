package com.hyzg.advice;//


import com.hyzg.enums.ExceptionEnums;
import com.hyzg.exception.HyzgException;
import com.hyzg.vo.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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


//默认情况下，@ControllerAdvice会拦截所有加了@Controller的类
@ControllerAdvice
public class CommonExceptionHandler {
    //该注解用在方法上，声明要处理的异常
    @ExceptionHandler(HyzgException.class)
    public ResponseEntity<ExceptionResult> handleException(HyzgException e){
        ExceptionEnums exceptionEnums = e.getExeptionEnums();
        ExceptionResult result = new ExceptionResult(exceptionEnums);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
