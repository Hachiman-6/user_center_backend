package user_center.once;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 导入Excel文件
 *
 * @author 86139
 */
@Slf4j
public class ImportExcel {

    public static void main(String[] args) {
        ClassPathResource pathResource = new ClassPathResource("textExcel.xlsx");
        InputStream resourceInputStream;
        try {
            resourceInputStream = pathResource.getInputStream();
        } catch (IOException e) {
            log.error("类路径文件读取错误");
            throw new RuntimeException(e);
        }
//        readByListener(resourceInputStream);
        synchronousRead(resourceInputStream);
    }

    /**
     *写法1：监听器,JDK8+ ,不用额外写一个DemoDataListener
     *
     * @param resourceInputStream 类路径文件输入流
     */
    public static void readByListener(InputStream resourceInputStream) {
        EasyExcel.read(resourceInputStream, TableUserInfo.class, new TableListener()).sheet().doRead();
    }

    /**
     *写法2：同步的返回，如果数据量大会把数据放到内存里面
     *
     * @param resourceInputStream 类路径文件输入流
     */
    public static void synchronousRead(InputStream resourceInputStream) {
        List<TableUserInfo> totalDataList = EasyExcel.read(resourceInputStream).head(TableUserInfo.class).sheet().doReadSync();
        for (TableUserInfo tableUserInfo : totalDataList) {
            System.out.println(tableUserInfo);
        }
    }
}
