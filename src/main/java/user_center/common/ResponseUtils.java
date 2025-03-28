package user_center.common;

/**
 * 返回值工具类
 *
 * @author 86139
 */
public class ResponseUtils {

    /**
     * 成功
     * @param data
     * @return
     * @param <T>
     */
    public static <T> BaseResponse<T> success(T data){
        return new BaseResponse<T>(0,data,"ok");
    }

    /**
     * 失败
     * @param errorCode
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode){
        return new BaseResponse(errorCode);
    }

    /**
     * 失败
     * @param
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode, String description){
        return new BaseResponse(errorCode.getCode(), null, errorCode.getMassage(), description);
    }

    /**
     * 失败
     * @param
     * @return
     */
    public static BaseResponse error(ErrorCode errorCode, String massage, String description){
        return new BaseResponse(errorCode.getCode(), null, massage, description);
    }

    /**
     * 失败
     * @param
     * @return
     */
    public static BaseResponse error(int code, String massage, String description){
        return new BaseResponse(code, null, massage, description);
    }
}
