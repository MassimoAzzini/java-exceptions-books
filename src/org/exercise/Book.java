package org.exercise;

public class Book {
    private String title;
    private int pages;
    private String author;

    private String publisher;


    public Book(String title, int pages, String author, String publisher) {
        if (title == null || author == null || publisher == null || title.trim().isEmpty() || author.trim().isEmpty() || publisher.trim().isEmpty()){
            throw new NullPointerException("The title, author and publisher fields cannot be null");
        };

        if (pages <= 0){
            throw new IllegalArgumentException("Pages must be greater than 0");
        };

        this.title = title;
        this.pages = pages;
        this.author = author;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()){
            throw new NullPointerException("The title cannot be null");
        }

        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages <= 0){
            throw new IllegalArgumentException("Pages must be greater than 0");
        }

        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()){
            throw new NullPointerException("The author cannot be null");
        };
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if (publisher == null || publisher.trim().isEmpty()){
            throw new NullPointerException("The publisher cannot be null");
        };
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Publisher: " + publisher + ", Pages: " + pages;
    }
}
