package Java_Day9.LibraryManagementSystem;

import Java_Day9.LibraryManagementSystem.ExceptionHandling.BookNotAvailableException;
import Java_Day9.LibraryManagementSystem.ExceptionHandling.MemberNotFoundException;
import Java_Day9.LibraryManagementSystem.ExceptionHandling.OverdueBookException;
import Java_Day9.LibraryManagementSystem.Interface.LibraryService;
import Java_Day9.LibraryManagementSystem.Modules.Book;
import Java_Day9.LibraryManagementSystem.Modules.Member;

public class Main {
  public static void main(String[] args) {
     LibraryService service=new LibraryService();
    Book book1 = new Book("B001", "The Alchemist", "Paulo Coelho", false);
    Book book2 = new Book("B002", "1984", "George Orwell", false);
    Member member1 = new Member("M001", "Alice", "alice@example.com");
    Member member2 = new Member("M002", "Bob", "bob@example.com");
    service.addBook(book1);
    service.addBook(book2);
    service.addMember(member1);
    service.addMember(member2);

     try {
        service.issueBook("B001", "M001");
        System.out.println("Book B001 issued to Santosh.");

        service.returnBook("B001", "M001");
        System.out.println("Book B001 returned by Santosh.");

        service.issueBook("B001", "M002");
        System.out.println("Book B001 issued to Susmitha.");

    } catch (BookNotAvailableException | MemberNotFoundException | OverdueBookException e) {
        System.out.println("Error: " + e.getMessage());
    }
    service.getLendingRecord();

    }
}
