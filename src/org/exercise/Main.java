package org.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int items = 0;

        while (items <= 0){
            try {
                System.out.println("How many books do you want to include?");
                items = Integer.parseInt(scan.nextLine());
                if(items <= 0){
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                System.out.println("The input is not a number");
            } catch (IllegalArgumentException e){
                System.out.println("The number is less than or equal to 0");
            }
        }

        // creo l'array della dimensione inserita dall'utente
        Book[] books = new Book[items];

        // faccio le domande all'utente per popolare l'array
        for (int i = 0; i < items;) {

            try {
            System.out.println("Enter the book data");
            System.out.print("Title: ");
            String title = scan.nextLine();
            System.out.print("Author: ");
            String author = scan.nextLine();
            System.out.print("Publisher: ");
            String publisher = scan.nextLine();


            System.out.print("Pages: ");
            int pages = 0;
            try {
                pages = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {

            }


            Book book = new Book(title, pages, author, publisher);
            books[i] = book;
            i++;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        scan.close();

        // scrivo all'interno del file
        try (FileWriter fileWriter = new FileWriter("./resources/books.txt")){
           for (Book b: books){
               fileWriter.write(b.toString() + "\n");
           }
        } catch (IOException e) {
            System.out.println("File not found");
        }


        // leggo il file creato
        try (Scanner fileReader = new Scanner(new File("./resources/books.txt"))) {
            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
