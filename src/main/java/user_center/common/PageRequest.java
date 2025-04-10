package user_center.common;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 通用分页请求参数包装类
 */
@Data
public class PageRequest implements Serializable {


    @Serial
    private static final long serialVersionUID = -8820681778814447995L;
    /**
     * 页面大小
     */
    protected int pageSize = 10;

    /**
     * 当前的页面页数
     */
    protected int pageNum = 1;
}
