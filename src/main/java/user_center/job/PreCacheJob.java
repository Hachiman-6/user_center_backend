package user_center.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import user_center.model.domain.User;
import user_center.service.UserService;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 缓存预热任务
 *
 * @author 86139
 */
@Slf4j
@Component
public class PreCacheJob {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    private UserService userService;

    private List<Long> mainUserList = List.of(1L);

    //每天加载，预热推荐用户
    @Scheduled(cron = "0 59 23 * * *")
    public void doCacheRecommendUser(){
        for (Long userId : mainUserList) {
            QueryWrapper<User> queryWrapper =  new QueryWrapper<>();
            Page<User> userPage = userService.page(new Page<>(1, 20),queryWrapper);
            String redisKey = String.format("center:user:recommend:%s", userId);
            ValueOperations<String, Object> redisValueOperations = redisTemplate.opsForValue();
            try {
                redisValueOperations.set(redisKey, userPage, 30000, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                log.error("redis set key error", e);
            }
        }
    }
}
