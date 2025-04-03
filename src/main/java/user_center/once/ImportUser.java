package user_center.once;

import com.alibaba.excel.EasyExcel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class ImportUser {

    public static void main(String[] args) {
        ClassPathResource pathResource = new ClassPathResource("textExcel.xlsx");
        InputStream resourceInputStream;
        try {
            resourceInputStream = pathResource.getInputStream();
        } catch (IOException e) {
            log.error("类路径文件读取错误");
            throw new RuntimeException(e);
        }
        List<TableUserInfo> userInfoList = EasyExcel.read(resourceInputStream).head(TableUserInfo.class).sheet().doReadSync();
        System.out.println("总数 = " + userInfoList.size());
//        去重
        Map<String, List<TableUserInfo>> listMap = userInfoList.stream()
                .filter(userInfo -> StringUtils.isNotEmpty(userInfo.getUsername()))
                .collect(Collectors.groupingBy(TableUserInfo::getUsername));
        System.out.println("不重复的昵称数量 = " + listMap.keySet().size());
    }
}
