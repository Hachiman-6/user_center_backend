package user_center.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 通用返回类型
 *
 * @param <T>
 * @author 86139
 */
@Data
public class BaseResponse<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 5983520527579124015L;
    private int code;

    private T data;

    private String massage;

    private String description;

    public BaseResponse(int code, T data, String massage, String description) {
        this.code = code;
        this.data = data;
        this.massage = massage;
        this.description = description;
    }

    public BaseResponse(int code, T data, String massage){
        this(code,data,massage,"");
    }

    public BaseResponse(int code, T data){
        this(code,data,"","");
    }

    public BaseResponse(ErrorCode errorCode){
        this(errorCode.getCode(),null,errorCode.getMassage(),errorCode.getDescription());
    }

    public BaseResponse(ErrorCode errorCode, String massage){
        this(errorCode.getCode(),null,massage,errorCode.getDescription());
    }

    public BaseResponse(ErrorCode errorCode, String massage, String description){
        this(errorCode.getCode(),null,massage,description);
    }
}
