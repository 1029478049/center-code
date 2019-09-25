package com.example.demo.controller.mongdb;

import com.example.demo.DTO.result.BookResultDTO;
import com.example.demo.service.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/mongo")
public class BookController {

    @Autowired
    private MongoDbService mongoDbService;

    @PostMapping("/save")
    public String saveObj(@RequestBody BookResultDTO book) {
        return mongoDbService.saveObj(book);
    }

    @GetMapping("/findAll")
    public List<BookResultDTO> findAll() {
        return mongoDbService.findAll();
    }

    @GetMapping("/findOne")
    public BookResultDTO findOne(@RequestParam String id) {
        return mongoDbService.getBookById(id);
    }

    @GetMapping("/findOneByName")
    public BookResultDTO findOneByName(@RequestParam String name) {
        return mongoDbService.getBookByName(name);
    }

    @PostMapping("/update")
    public String update(@RequestBody BookResultDTO book) {
        return mongoDbService.updateBook(book);
    }

    @PostMapping("/delOne")
    public String delOne(@RequestBody BookResultDTO book) {
        return mongoDbService.deleteBook(book);
    }

    @GetMapping("/delById")
    public String delById(@RequestParam String id) {
        return mongoDbService.deleteBookById(id);
    }
}
