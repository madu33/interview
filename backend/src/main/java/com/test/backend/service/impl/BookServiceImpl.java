package com.test.backend.service.impl;

import com.test.backend.dto.BookDTO;
import com.test.backend.entity.Book;
import com.test.backend.repo.BookRepo;
import com.test.backend.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<BookDTO> getAllBook() {
        List<BookDTO>all=new ArrayList<>();
        List<Book> allBooks = bookRepo.findAll();
        for (Book obj:allBooks){
            all.add(modelMapper.map(obj,BookDTO.class));
        }
        return all;
    }

    @Override
    public boolean saveAllBooks(List<BookDTO> bookDTOS) {
        Book book=new Book();
        for (BookDTO obj:bookDTOS){
            book = bookRepo.save(modelMapper.map(obj, Book.class));
        }
        if(book.getId()!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateBook(BookDTO bookDTO) {
        Book save = bookRepo.save(modelMapper.map(bookDTO, Book.class));
        if(bookDTO.getId().equals(save.getId())){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBook(Integer id) {
        System.out.println(id);
        bookRepo.deleteById(id);
        return true;
    }


}
