package user_center.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * redisson配置
 *
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "spring.data.redis")
public class RedissonConfig {

    private String host;

    private String port;

    private String password;
    @Bean
    public RedissonClient redissonClient(){
        //1.创建配置config对象
        Config config = new Config();
        String redisAddress = String.format("redis://%s:%s", host, port);
        config.useSingleServer().setAddress(redisAddress).setPassword(password).setDatabase(3);
        //创建Redisson实例
        // 同步和异步 API
        return Redisson.create(config);
    }
}
