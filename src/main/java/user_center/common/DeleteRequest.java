package user_center.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 通用删除请求参数包装类
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private long id;

    @Serial
    private static final long serialVersionUID = 1L;
}
