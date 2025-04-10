package user_center.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import user_center.mapper.TeamMapper;
import user_center.model.domain.Team;
import user_center.service.TeamService;

/**
* @author 86139
* @description 针对表【team(队伍)】的数据库操作Service实现
* @createDate 2025-04-10 18:20:18
*/
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team> implements TeamService {

}




