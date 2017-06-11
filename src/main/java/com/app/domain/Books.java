package com.app.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Books.
 */
@Entity
@Table(name = "books")
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_name")
    private String bookName;

    @Column(name = "author")
    private String author;

    @Column(name = "title")
    private String title;

    @Column(name = "year_of_publication")
    private Integer yearOfPublication;

    @Column(name = "har_copy")
    private Boolean harCopy;

    @Column(name = "online_copy")
    private Boolean onlineCopy;

    @ManyToOne
    private Library library;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public Books bookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public Books author(String author) {
        this.author = author;
        return this;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public Books title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public Books yearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
        return this;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Boolean isHarCopy() {
        return harCopy;
    }

    public Books harCopy(Boolean harCopy) {
        this.harCopy = harCopy;
        return this;
    }

    public void setHarCopy(Boolean harCopy) {
        this.harCopy = harCopy;
    }

    public Boolean isOnlineCopy() {
        return onlineCopy;
    }

    public Books onlineCopy(Boolean onlineCopy) {
        this.onlineCopy = onlineCopy;
        return this;
    }

    public void setOnlineCopy(Boolean onlineCopy) {
        this.onlineCopy = onlineCopy;
    }

    public Library getLibrary() {
        return library;
    }

    public Books library(Library library) {
        this.library = library;
        return this;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Books books = (Books) o;
        if (books.id == null || id == null) {
            return false;
        }
        return Objects.equals(id, books.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Books{" +
            "id=" + id +
            ", bookName='" + bookName + "'" +
            ", author='" + author + "'" +
            ", title='" + title + "'" +
            ", yearOfPublication='" + yearOfPublication + "'" +
            ", harCopy='" + harCopy + "'" +
            ", onlineCopy='" + onlineCopy + "'" +
            '}';
    }
}
