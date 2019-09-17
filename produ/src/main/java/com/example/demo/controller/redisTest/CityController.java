package com.example.demo.controller.redisTest;
import com.example.demo.config.redis.RedisClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hanyh
 * @since 2018-06-06 22:12
 **/
@RestController
public class CityController {
    @Autowired
    private RedisClientTemplate redisClientTemplate;

    /**
     * 测试集群
     * @return Object
     */
    @GetMapping(value = "/redisClusterTest")
    public Object testSet(){
        redisClientTemplate.setToRedis("Hanyh","Hanyh测试redis集群");
        System.out.println(redisClientTemplate.getRedis("Frank"));
        return null;
    }

}
