package com.test.backend.service;


import com.test.backend.dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBook();

    boolean saveAllBooks(List<BookDTO> bookDTOS);

    boolean updateBook(BookDTO bookDTO);

    boolean deleteBook(Integer id);
}
