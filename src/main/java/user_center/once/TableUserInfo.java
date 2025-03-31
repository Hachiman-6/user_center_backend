package user_center.once;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 处理Excel表格用户信息
 *
 * @author 86139
 */
@Data
public class TableUserInfo {
    /**
     * id
     */
    @ExcelProperty("成员编号")
    private String planetCode;

    /**
     * 用户昵称
     */
    @ExcelProperty("成员昵称")
    private String username;

}
