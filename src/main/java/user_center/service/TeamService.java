package user_center.service;

import com.baomidou.mybatisplus.extension.service.IService;
import user_center.model.domain.Team;
import user_center.model.domain.User;
import user_center.model.dto.TeamQuery;
import user_center.model.request.TeamJoinRequest;
import user_center.model.request.TeamUpdateRequest;
import user_center.model.vo.TeamUserVO;

import java.util.List;

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

    /**
     * 搜索队伍
     * @param teamQuery 查询条件
     * @param isAdmin 当前登录用户是否为管理员
     * @return 返回值列表
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 修改队伍信息
     * @param teamUpdateRequest 修改参数
     * @param loginUser 当前登录用户
     * @return 是否成功
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 用户加入队伍
     * @param teamJoinRequest 加入参数
     * @param loginUser 当前登录用户
     * @return 是否成功
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);
}
