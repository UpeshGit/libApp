package com.app.web.rest;

import io.github.jhipster.web.util.ResponseUtil;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.domain.Books;
import com.app.repository.BooksRepository;
import com.app.web.rest.util.HeaderUtil;

/**
 * REST controller for managing Books.
 */
@RestController
@RequestMapping("/api")
public class BooksResource {

    private final Logger log = LoggerFactory.getLogger(BooksResource.class);

    private static final String ENTITY_NAME = "books";
        
    private final BooksRepository booksRepository;

    public BooksResource(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    /**
     * POST  /books : Create a new books.
     *
     * @param books the books to create
     * @return the ResponseEntity with status 201 (Created) and with body the new books, or with status 400 (Bad Request) if the books has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/books")
    
    public ResponseEntity<Books> createBooks(@RequestBody Books books) throws URISyntaxException {
        log.debug("REST request to save Books : {}", books);
        if (books.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new books cannot already have an ID")).body(null);
        }
        Books result = booksRepository.save(books);
        return ResponseEntity.created(new URI("/api/books/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /books : Updates an existing books.
     *
     * @param books the books to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated books,
     * or with status 400 (Bad Request) if the books is not valid,
     * or with status 500 (Internal Server Error) if the books couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/books")
    
    public ResponseEntity<Books> updateBooks(@RequestBody Books books) throws URISyntaxException {
        log.debug("REST request to update Books : {}", books);
        if (books.getId() == null) {
            return createBooks(books);
        }
        Books result = booksRepository.save(books);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, books.getId().toString()))
            .body(result);
    }

    /**
     * GET  /books : get all the books.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of books in body
     */
    @GetMapping("/books")
    
    public List<Books> getAllBooks() {
        log.debug("REST request to get all Books");
        List<Books> books = booksRepository.findAll();
        return books;
    }

    /**
     * GET  /books/:id : get the "id" books.
     *
     * @param id the id of the books to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the books, or with status 404 (Not Found)
     */
    @GetMapping("/books/{id}")
    
    public ResponseEntity<Books> getBooks(@PathVariable Long id) {
        log.debug("REST request to get Books : {}", id);
        Books books = booksRepository.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(books));
    }

    /**
     * DELETE  /books/:id : delete the "id" books.
     *
     * @param id the id of the books to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/books/{id}")
    
    public ResponseEntity<Void> deleteBooks(@PathVariable Long id) {
        log.debug("REST request to delete Books : {}", id);
        booksRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
