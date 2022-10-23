package com.test.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.backend.dto.BookDTO;
import com.test.backend.entity.Book;
import com.test.backend.service.BookService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@Component
@RestController
@RequestMapping("/api")
public class BookController implements InitializingBean {

    @Autowired
    private BookService bookService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/loadBooks")
    public List<BookDTO> getAllBook(){
        return bookService.getAllBook();
    }

    @PostMapping("/update")
    public boolean updateBook(@RequestBody BookDTO bookDTO){
        return bookService.updateBook(bookDTO);
    }

    @GetMapping("/delete/{id}")
    public boolean deleteBook(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<BookDTO>listOfBook=new ArrayList<>();
        ResponseEntity<BookDTO[]> responseEntity = restTemplate.getForEntity("https://demo.dreamsquadgroup.com/test/index.json", BookDTO[].class);
        BookDTO[] objects = responseEntity.getBody();
        System.out.println(objects.toString());
        for (BookDTO  obj:objects){
            listOfBook.add(obj);
        }
        bookService.saveAllBooks(listOfBook);

    }
}
