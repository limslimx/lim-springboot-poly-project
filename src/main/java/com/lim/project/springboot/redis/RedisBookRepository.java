package com.lim.project.springboot.redis;

import com.lim.project.springboot.web.dto.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Repository
public class RedisBookRepository {

    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));
    private final RedisTemplate<String, Object> redisDb;

    public boolean getExists(String key) throws Exception {
        log.info(this.getClass().getName()+".getExists start and end!");
        return redisDb.hasKey(key);
    }

    public List<BookDto> getBookFromRedis(String key) throws Exception {
        log.info(this.getClass().getName()+".getBookFromRedis start!");

        List<BookDto> bookDtoList=null;
        redisDb.setKeySerializer(new StringRedisSerializer());
        redisDb.setValueSerializer(new Jackson2JsonRedisSerializer<>(BookDto.class));

        if (redisDb.hasKey(key)) {
            bookDtoList = (List) redisDb.opsForList().range(key, 0, -1);
        }
        log.info(this.getClass().getName()+".getBookFromRedis end!");
        return bookDtoList;
    }

    public void setBookToRedis(String key, List<BookDto> bookDtoList) throws Exception {
        log.info(this.getClass().getName() + ".setBookToRedis start!");

        redisDb.setKeySerializer(new StringRedisSerializer());
        redisDb.setValueSerializer(new Jackson2JsonRedisSerializer<>(BookDto.class));

        if (this.getExists(key)) {
            redisDb.delete(key);
        }

        Iterator<BookDto> it = bookDtoList.iterator();
        while (it.hasNext()) {
            BookDto bookDto = (BookDto) it.next();
            redisDb.opsForList().rightPush(key, bookDto);
            bookDto = null;
        }
        log.info(this.getClass().getName() + ".setBookToRedis end!");
    }

    public boolean setTimeOutHour(String key, int hours) throws Exception {
        log.info(this.getClass().getName() + ".setTimeOutHour start and end!");
        return redisDb.expire(key, hours, TimeUnit.HOURS);
    }

}
