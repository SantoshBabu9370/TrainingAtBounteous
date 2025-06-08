package Java_Day9.LibraryManagementSystem.Repository;

import Java_Day9.LibraryManagementSystem.Modules.Book;
import Java_Day9.LibraryManagementSystem.Modules.LendingRecord;
import Java_Day9.LibraryManagementSystem.Modules.Member;

import java.util.*;

public class GenericRepository {
    private final Map<String, Book> bookMap = new HashMap<>();
    private final Map<String, Member> memberMap = new HashMap<>();
    private final List<LendingRecord> lendingRecords = new ArrayList<>();

    // Add a book to the bookMap
    public void addBook(String id, Book book) {
        bookMap.put(id, book);
    }

    // Get a book by its ID
    public Book getBook(String id) {
        return bookMap.get(id);
    }

    // Remove a book from the bookMap
    public void removeBook(String id) {
        bookMap.remove(id);
    }

    // Add a member to the memberMap
    public void addMember(String id, Member member) {
        memberMap.put(id, member);
    }

    // Get a member by their ID
    public Member getMember(String id) {
        return memberMap.get(id);
    }

    // Remove a member from the memberMap
    public void removeMember(String id) {
        memberMap.remove(id);
    }

    // Add a lending record to the lendingRecords list
    public void addLendingRecord(LendingRecord record) {
        lendingRecords.add(record);
    }

    // Get all lending records
    public List<LendingRecord> getAllLendingRecords() {
        return new ArrayList<>(lendingRecords);
    }

    // Print all data for debugging
    public void printAllData() {
        System.out.println("Books:");
        bookMap.forEach((id, book) -> System.out.println(id + ": " + book));
        System.out.println("Members:");
        memberMap.forEach((id, member) -> System.out.println(id + ": " + member));
        System.out.println("Lending Records:");
        lendingRecords.forEach(System.out::println);
    }
}
