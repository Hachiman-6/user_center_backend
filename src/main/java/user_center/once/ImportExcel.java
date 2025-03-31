package user_center.once;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

/**
 * 导入Excel文件
 *
 * @author 86139
 */
@Slf4j
public class ImportExcel {

    public static void main(String[] args) {

        // 写法1：JDK8+ ,不用额外写一个DemoDataListener
        // since: 3.0.0-beta1
        ClassPathResource pathResource = new ClassPathResource("textExcel.xlsx");
        InputStream resourceInputStream;
        try {
            resourceInputStream = pathResource.getInputStream();
        } catch (IOException e) {
            log.error("类路径文件读取错误");
            throw new RuntimeException(e);
        }

        EasyExcel.read(resourceInputStream, TableUserInfo.class, new TableListener()).sheet().doRead();

    }

}
