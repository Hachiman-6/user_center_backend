package user_center.once;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import user_center.mapper.UserMapper;
import user_center.model.domain.User;
import user_center.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Component
public class InsertUsers {

    @Resource
    private UserService userService;

    /**
     * 批量插入用户
     */
    //@Scheduled
    public void doInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 10000000;
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假用户");
            user.setUserAccount("JiaYongHu");
            user.setAvatarUrl("");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("123");
            user.setEmail("123");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("11111111");
            user.setTags("[]");
            userList.add(user);
        }
        userService.saveBatch(userList, 100);
        stopWatch.stop();
        stopWatch.getTotalTimeMillis();
    }
}
