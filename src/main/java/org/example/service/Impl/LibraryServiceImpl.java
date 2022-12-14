package org.example.service.Impl;

import org.example.model.Books;
import org.example.service.LibraryService;
import org.example.utils.Impl.BookUtilsImpl;

import java.util.List;
import java.util.Scanner;

public class LibraryServiceImpl implements LibraryService {
    private static String bookTitle;
    BookUtilsImpl bookUtils = new BookUtilsImpl();
    private final List<Books> booksList = bookUtils.readBookFile();

    public boolean checkBookAvailability (){
        Scanner getBookTitle = new Scanner(System.in);
        System.out.print("Enter Book Title: ");

        bookTitle = getBookTitle.nextLine();
        for (Books book : booksList) {
            if (bookTitle.equals(book.getTitle())){
                return true;
            }
        }
        System.out.println("book taken");
        return false;
    }

    public static String getBookTitle() {
        return bookTitle;
    }

    public static void setBookTitle(String bookTitle) {
        LibraryServiceImpl.bookTitle = bookTitle;
    }
}
