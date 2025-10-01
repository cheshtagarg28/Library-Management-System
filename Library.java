import java.util.*;
class Book{
    int id;
    String title;
    String author;
    boolean available;

    Book(int id, String title,String author){
        this.id=id;
        this.title=title;
        this.author=author;
        this.available=true;
    }
    void display() {
        System.out.println(id + " | " + title + " | " + author + " | " + (available ? "Available" : "Issued"));
    }
}

public class Library{
    private static Book[] books=new Book[50];
    private static int count=0;
    private static Scanner sc=new Scanner(System.in);

    static void addBook(){
        if(count>=books.length){
            System.out.println("Library is full. Cannot add more books.");
        return;
        }
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Book Author: ");
        String author = sc.nextLine();

        books[count]=new Book(id,title,author);
        count++;
        System.out.println("Book added successfully.");
    }
    //display books
    static void displayBooks(){
        if(count==0){
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("\n--- List of Books ---");
        for (int i = 0; i < count; i++) {
            books[i].display();
        }
    }
    // Issue a book
    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (books[i].id == id) {
                if (books[i].available) {
                    books[i].available = false;
                    System.out.println("Book issued successfully: " + books[i].title);
                } else {
                    System.out.println("Book is already issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
    // Return a book
    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        int id = sc.nextInt();
        for (int i = 0; i < count; i++) {
            if (books[i].id == id) {
                if (!books[i].available) {
                    books[i].available = true;
                    System.out.println("Book returned successfully: " + books[i].title);
                } else {
                    System.out.println("This book was not issued.");
                }
                return;
            }
        }
        System.out.println("Book not found.");
    }
     public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: addBook(); break;
                case 2: displayBooks(); break;
                case 3: issueBook(); break;
                case 4: returnBook(); break;
                case 5: 
                    System.out.println("Exiting... Thank you!");
                    return;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
    }
}