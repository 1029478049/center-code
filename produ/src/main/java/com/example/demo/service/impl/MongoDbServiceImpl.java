package com.example.demo.service.impl;

import com.example.demo.DTO.result.BookResultDTO;
import com.example.demo.service.MongoDbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MongoDbServiceImpl implements MongoDbService {

    private static final Logger logger = LoggerFactory.getLogger(MongoDbServiceImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存对象
     *
     * @param book book
     * @return String
     */
    @Override
    public String saveObj(BookResultDTO book) {
        logger.info("--------------------->[MongoDB save start]");
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        mongoTemplate.save(book);
        return "添加成功";
    }

    /**
     * 查询所有
     *
     * @return List<BookResultDTO>
     */
    @Override
    public List<BookResultDTO> findAll() {
        logger.info("--------------------->[MongoDB find start]");
        return mongoTemplate.findAll(BookResultDTO.class);
    }

    /***
     * 根据id查询
     * @param id id
     * @return BookResultDTO
     */
    @Override
    public BookResultDTO getBookById(String id) {
        logger.info("--------------------->[MongoDB find start]");
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, BookResultDTO.class);
    }

    /**
     * 根据名称查询
     *
     * @param name name
     * @return BookResultDTO
     */
    @Override
    public BookResultDTO getBookByName(String name) {
        logger.info("--------------------->[MongoDB find start]");
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.findOne(query, BookResultDTO.class);
    }

    /**
     * 更新对象
     *
     * @param book book
     * @return String
     */
    @Override
    public String updateBook(BookResultDTO book) {
        logger.info("--------------------->[MongoDB update start]");
        Query query = new Query(Criteria.where("_id").is(book.getId()));
        Update update = new Update().set("publish", book.getPublish())
                .set("info", book.getInfo())
                .set("updateTime", new Date());
        //updateFirst 更新查询返回结果集的第一条
        mongoTemplate.updateFirst(query, update, BookResultDTO.class);
        //updateMulti 更新查询返回结果集的全部
//        mongoTemplate.updateMulti(query,update,Book.class);
        //upsert 更新对象不存在则去添加
//        mongoTemplate.upsert(query,update,Book.class);
        return "success";
    }

    /***
     * 删除对象
     * @param book book
     * @return String
     */
    @Override
    public String deleteBook(BookResultDTO book) {
        logger.info("--------------------->[MongoDB delete start]");
        mongoTemplate.remove(book);
        return "success";
    }

    /**
     * 根据id删除
     *
     * @param id id
     * @return String
     */
    @Override
    public String deleteBookById(String id) {
        logger.info("--------------------->[MongoDB delete start]");
        //findOne
        BookResultDTO book = getBookById(id);
        //delete
        deleteBook(book);
        return "success";
    }
}
