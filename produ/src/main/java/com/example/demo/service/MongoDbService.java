package com.example.demo.service;

import com.example.demo.DTO.result.BookResultDTO;

import java.util.List;

public interface MongoDbService {
    String saveObj(BookResultDTO book);

    List<BookResultDTO> findAll();

    BookResultDTO getBookById(String id);

    BookResultDTO getBookByName(String name);

    String updateBook(BookResultDTO book);

    String deleteBook(BookResultDTO book);

    String deleteBookById(String id);
}
