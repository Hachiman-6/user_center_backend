package user_center.model.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class TeamJoinRequest implements Serializable {

    /**
     * id
     */
    private Long teamId;

    /**
     * 密码
     */
    private String password;

    @Serial
    private static final long serialVersionUID = 1L;
}
