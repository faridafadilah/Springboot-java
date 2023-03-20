package com.example.redisreactive.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.redisreactive.model.Book;
import com.example.redisreactive.service.BookServiceImpl;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class BookController {
  private final BookServiceImpl bookService;

  @PostMapping("/book")
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Book> addBook(@RequestBody @Valid Book book) {
    return bookService.create(book);
  }

  @GetMapping("/book")
  public Flux<Book> getAllBooks() {
    return bookService.getAll();
  }

  @GetMapping("/book/{id}")
  public Mono<Book> getBook(@PathVariable String id) {
    return bookService.getOne(id);
  }

  @DeleteMapping("/book/{id}")
  public Mono<Long> deleteBook(@PathVariable String id) {
    return bookService.deleteById(id);
  }
}
