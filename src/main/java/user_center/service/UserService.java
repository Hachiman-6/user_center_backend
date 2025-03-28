package user_center.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;
import user_center.model.domain.User;

/**
* @author 86139
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-03-08 21:44:11
*/
public interface UserService extends IService<User> {

    /**
     * 用户注册
     *
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param checkPassword 第二次输入检查密码
     * @return 新用户id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword, String planetCode);

    /**
     * 用户登录
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户退出登录
     * @param request request
     * @return 1-成功
     */
    int userLogout(HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser 原始用户数据
     * @return 脱敏后的用户数据
     */
    User getSafetyUser(User originUser);
}
