package user_center.service;

import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.http.HttpServletRequest;
import user_center.model.domain.User;

import java.util.List;

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

    /**
     * 根据标签搜索用户
     *
     * @param tagNameList 用户拥有的标签
     * @return 返回值
     */
    List<User> searchUsersByTags(List<String> tagNameList);

    /**
     * 更新用户信息
     *
     * @param user 客户端上传需修改用户
     * @return 返回标识
     */
    int updateUser(User user, User loginUser);

    /**
     * 获取当前登录用户信息
     * @param request request
     * @return 当前登录用户信息
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 判断是否为管理员
     * @param request request
     * @return boolean
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 判断是否为管理员
     * @param loginUser 当前登录用户
     * @return boolean
     */
    boolean isAdmin(User loginUser);

    /**
     * 匹配用户
     * @param num
     * @param loginUser
     * @return
     */
    List<User> matchUsers(long num, User loginUser);
}
