package com.example.backend;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;

@RestController
public class AppController{

    List<Book> books = Arrays.asList(new Book("Pride and Prejudice", "Jane Austen"),new Book("Pride and Prejudice", "Jane Austen"),new Book("Pride and Prejudice", "Jane Austen"));

    @GetMapping
    String welcome(){
        return "<h1>Hello World!</h1>";
    }

    @GetMapping("/books")
    ResponseEntity<?> getAll(){
        return ResponseEntity.ok(books);
    }
     
}

@Data
@AllArgsConstructor
class Book {
    private String name;
    private String author;
}