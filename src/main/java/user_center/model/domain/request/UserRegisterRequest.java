package user_center.model.domain.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author 86139
 */
@Data
public class UserRegisterRequest implements Serializable {

    @Serial
    private static final long serialVersionUID = 5957564762479152143L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String planetCode;
}
