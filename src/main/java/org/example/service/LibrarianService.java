package org.example.service;

import org.example.model.User;

public interface LibrarianService {
    void bookRequestBasedOnStatus(User user);
    void firstComeFirstServeRequest(User user);
    void updateBook();
    void administerByStatus();
    void administerByFirstComeFirstServe();

}
