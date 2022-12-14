package org.example.model;

import java.util.List;

public class Library {
    private List<Books> bookList;
    private Librarian librarian;

    public Library(List<Books> bookList, Librarian librarian) {
        this.bookList = bookList;
        this.librarian = librarian;
    }

    public List<Books> getBookList() {
        return bookList;
    }

    public void setBookList(List<Books> bookList) {
        this.bookList = bookList;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    @Override
    public String toString() {
        return "Library{" +
                "bookList=" + bookList +
                ", librarian=" + librarian +
                '}';
    }
}
