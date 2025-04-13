package user_center.model.request;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户退出队伍
 */
@Data
public class TeamQuitRequest implements Serializable {

    /**
     * id
     */
    private Long teamId;

    @Serial
    private static final long serialVersionUID = 1L;
}
