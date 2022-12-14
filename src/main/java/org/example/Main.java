package org.example;

import org.example.enums.Status;
import org.example.model.User;
import org.example.service.Impl.LibrarianServiceImpl;
import org.example.utils.Impl.BookUtilsImpl;

public class Main {
    public static void main(String[] args) {
//        BookUtilsImpl bookUtils = new BookUtilsImpl();
//        bookUtils.readBookFile().forEach(System.out::println);

        LibrarianServiceImpl librarianService = new LibrarianServiceImpl();


        User user1 = new User("john", 23, Status.TEACHER);
        User user2 = new User("doe", 15, Status.SENIOR_STUDENT);
        User user3 = new User("Frank", 11, Status.JUNIOR_STUDENT);

        librarianService.bookRequestBasedOnStatus(user2);
        librarianService.bookRequestBasedOnStatus(user1);
        librarianService.bookRequestBasedOnStatus(user3);
        librarianService.administerByStatus();
    }
}