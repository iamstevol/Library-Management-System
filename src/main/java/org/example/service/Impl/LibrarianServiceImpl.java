package org.example.service.Impl;

import org.example.enums.Status;
import org.example.model.Books;
import org.example.model.User;
import org.example.service.LibrarianService;
import org.example.service.LibraryService;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class LibrarianServiceImpl implements LibrarianService {
    LibraryServiceImpl libraryService = new LibraryServiceImpl();
    List<String> header = libraryService.bookUtils.readHeader();
    List<Books> booksList = libraryService.bookUtils.readBookFile();
    Deque<User> bookRequestOnStatus = new ArrayDeque<>();
    private final String PATH = "src/main/resources/Books - Sheet1.csv";
    Queue<User> firstComeFirstServe = new PriorityQueue<>();

    public void bookRequestBasedOnStatus(User user) {
        if (libraryService.checkBookAvailability()) {
            if (user.getStatus().equals(Status.TEACHER)) {
                bookRequestOnStatus.offerFirst(user);
            } else if (user.getStatus().equals(Status.SENIOR_STUDENT)) {
                bookRequestOnStatus.offer(user);
            } else {
                bookRequestOnStatus.offerLast(user);
            }
        }
    }

    public void firstComeFirstServeRequest(User user) {
        if (libraryService.checkBookAvailability()) {
            firstComeFirstServe.add(user);
        }
    }

    public void updateBook() {
        for (Books book : booksList) {
            if (LibraryServiceImpl.getBookTitle().equals(book.getTitle())) {
                book.setCopies(book.getCopies() - 1);
            }
        }
        StringBuilder st = new StringBuilder();
        for (String head : header) {
            st.append(head).append(",");
        }
        st.append("\n");
        for (Books books : booksList) {
            st.append(books.getTitle()).append(",");
            st.append(books.getAuthor()).append(",");
            st.append(books.getPublisher()).append(",");
            st.append(books.getCopies()).append("\n");
        }
        try (BufferedWriter br = new BufferedWriter(new FileWriter(PATH))) {
            br.write(st.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void administerByStatus() {
        if(bookRequestOnStatus.isEmpty()){
            System.out.println("Sorry, no request has been made at this time");
        }
        else{
            User borrower = bookRequestOnStatus.pollFirst();
            borrower(borrower);
        }
        }

    public void administerByFirstComeFirstServe() {
        User borrower = firstComeFirstServe.remove();
        borrower(borrower);
    }
    private void borrower (User borrower) {
        assert borrower !=null;
        Books requestedBook = null;

        for (Books book : booksList) {
            if (LibraryServiceImpl.getBookTitle().equals(book.getTitle())) {
                requestedBook = book;
            }
        }
        assert requestedBook != null;
        if (requestedBook.getCopies() == 0) {
            booksList.remove(requestedBook);
            System.out.println("Sorry, book title " + requestedBook.getTitle() + " is no longer available");
        } else {
            updateBook();
            System.out.println("Congratulation " + borrower.getName() + " your request was successful");
        }
    }
}
