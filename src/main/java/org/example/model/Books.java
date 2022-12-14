package org.example.model;

import org.example.enums.BookAvailability;

public class Books {
    private String title;
    private String author;
    private String publisher;
    private int copies;
//    private BookAvailability availability;

    public Books(String title, String author, String publisher, int copies) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.copies = copies;
//        if (getCopies()>= 1) {
//            this.availability = BookAvailability.TRUE;
//        } else {
//            this.availability = BookAvailability.FALSE;
//        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

//    public BookAvailability getAvailability() {
//        return availability;
//    }
//
//    public void setAvailability(BookAvailability availability) {
//        this.availability = availability;
//    }

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", copies=" + copies +
//                ", availability=" + availability +
                '}';
    }
}
