package user_center.service;

import com.baomidou.mybatisplus.extension.service.IService;
import user_center.model.domain.Team;
import user_center.model.domain.User;

/**
* @author 86139
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2025-04-10 18:20:18
*/
public interface TeamService extends IService<Team> {

    /**
     * 新建队伍
     * @param team 队伍信息
     * @return 新建队伍id
     */
    long addTeam(Team team, User loginUser);

}
