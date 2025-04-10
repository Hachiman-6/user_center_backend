package user_center.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import user_center.common.BaseResponse;
import user_center.common.ErrorCode;
import user_center.common.ResponseUtils;
import user_center.exception.BusinessException;
import user_center.model.domain.Team;
import user_center.model.dto.TeamQuery;
import user_center.service.TeamService;
import user_center.service.UserService;

import java.util.Date;
import java.util.List;

/**
 * 组队接口
 *
 * @author 86139
 */
@RestController
@RequestMapping("/team")
@CrossOrigin(origins = {"http://localhost:3000"})
@Slf4j
public class TeamController {

    @Resource
    private UserService userService;

    @Resource
    private TeamService teamService;

    @PostMapping("/add")
    public BaseResponse<Long> addTeam(@RequestBody Team team) {
        if (team == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean result = teamService.save(team);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "插入失败");
        }
        return ResponseUtils.success(team.getId());
    }

    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteTeam(@RequestBody long id) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        boolean result = teamService.removeById(id);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "删除失败");
        }
        return ResponseUtils.success(true);
    }

    @PostMapping("/update")
    public BaseResponse<Boolean> updateTeam(@RequestBody Team team) {
        if (team == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long id = team.getId();
        if (id == null && id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        team.setUpdateTime(new Date());
        boolean result = teamService.updateById(team);
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "更新失败");
        }
        return ResponseUtils.success(true);
    }

    @GetMapping("/get")
    public BaseResponse<Team> getTeamById(long id) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Team team = teamService.getById(id);
        if (team == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        return ResponseUtils.success(team);
    }

    @GetMapping("/list")
    public BaseResponse<List<Team>> listTeams(@ParameterObject TeamQuery teamQuery) {
        if (teamQuery == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Team team = new Team();
        BeanUtils.copyProperties(team, teamQuery);
        QueryWrapper<Team> queryWrapper = new QueryWrapper<>(team);
        List<Team> resultList = teamService.list(queryWrapper);
        if (resultList == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        return ResponseUtils.success(resultList);
    }

    @GetMapping("/list/page")
    public BaseResponse<Page<Team>> listTeamsByPage(@ParameterObject TeamQuery teamQuery) {
        if (teamQuery == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Team team = new Team();
        BeanUtils.copyProperties(team, teamQuery);
        Page<Team> page = new Page<>(teamQuery.getPageNum(), teamQuery.getPageSize());
        QueryWrapper<Team> queryWrapper = new QueryWrapper<>(team);
        Page<Team> resultPage = teamService.page(page, queryWrapper);
        if (resultPage == null) {
            throw new BusinessException(ErrorCode.NULL_ERROR);
        }
        return ResponseUtils.success(resultPage);
    }
}
