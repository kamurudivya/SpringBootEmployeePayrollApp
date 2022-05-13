package com.bridgelabz.employeepayrollapp.exceptions;


import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
//@Slf4j
public class EmployeePayrollExceptionalHandler {
    private static final String message = "Exception while processing REST Request ";

    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(EmployeePayrollException exception) {
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request", exception.getMessage());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMesg = errorList.stream().map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception While Processing REST Request", errMesg);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
    }
//
//    @ExceptionHandler(EmployeePayrollException.class)
//    public ResponseEntity<ResponseDTO> handleEmployeePayrollException(
//            EmployeePayrollException exception) {
//        ResponseDTO responseDTO = new ResponseDTO("Exception while REST Request",
//                exception.getMessage());
//        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
//    }
//}
//    public ResponseEntity<ResponseDTO> handleHTTPMessageNotReadableException(
//            HttMessageNotReadableException exception) {
//        log.error("Invalid Date Format", exception);
//        ResponseDTO responseDTO = new ResponseDTO(message, "Should have date in the Formate dd MMM yyyy");
//        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
//    }
//////        List<ObjectError> errorList = exception.getBindingResult().getAllError();
//////        List<String> errMesg = errorList.stream().map(objErr -> object.getDefaultMessage());
//////                     .collect(Collectors.toList());
//////        RespponseDTO respDTO = new ResponseDTO(message, errMesg);
//////        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.BAD_REQUEST);
////
////    }
////
////
//    @ExceptionHandler(EmployeePayrollException.class)
//    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException (EmployeePayrollException exception) {
//        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request",exception.getMessage());
//        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
//    }
}


