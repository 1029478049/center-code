package com.example.demo.controller.redisTest;
import com.example.demo.config.redis.RedisClientTemplate;
import com.example.demo.domin.User;
import com.example.demo.service.AacUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Hanyh
 * @since 2018-06-06 22:12
 **/
@RestController
public class UserRedisController {
    @Autowired
    private RedisClientTemplate redisClientTemplate;
    @Autowired
    private AacUserService aacUserService;

    /**
     * 测试集群
     * @return Object
     */
    @GetMapping(value = "/redisClusterTest")
    public String redisClientTest(String userName){
        boolean key = redisClientTemplate.isKey(userName);
        if(key){
            Object obj = redisClientTemplate.getRedis(userName);
            System.out.println(obj);
        }else {
            List<User> users = aacUserService.queryUserCacheList(userName);
            redisClientTemplate.setToRedis(userName,users);
            System.out.println(redisClientTemplate.getRedis(userName));
        }
        return "";
    }

}
