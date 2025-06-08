package Java_Day9.LibraryManagementSystem.Interface;

import Java_Day9.LibraryManagementSystem.ExceptionHandling.BookNotAvailableException;
import Java_Day9.LibraryManagementSystem.ExceptionHandling.MemberNotFoundException;
import Java_Day9.LibraryManagementSystem.ExceptionHandling.OverdueBookException;
import Java_Day9.LibraryManagementSystem.Modules.Book;
import Java_Day9.LibraryManagementSystem.Modules.LendingRecord;
import Java_Day9.LibraryManagementSystem.Modules.Member;


import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class LibraryService {
    static long recordNo=0;
    private Map<String, Book> bookMap = new HashMap<>();
    private Map<String, Member> memberMap = new HashMap<>();
    public List<LendingRecord> lendingRecords = new ArrayList<>();
    public void getLendingRecord(){
        for(LendingRecord l:lendingRecords){
            System.out.println(l);
        }
        

    }

    public void addBook(Book book) {
        bookMap.put(book.getBookId(), book);
    }

    public void addMember(Member member) {
        memberMap.put(member.getMemberId(), member);
    }

    public void issueBook(String bookId, String memberId)
            throws BookNotAvailableException, MemberNotFoundException, OverdueBookException {
        Book book = bookMap.get(bookId);
        if (book == null || book.isIssued()) {
            throw new BookNotAvailableException("Book is not available.");
        }
        Member member = memberMap.get(memberId);
        if (member == null) {
            throw new MemberNotFoundException("Member not found.");
        }
        boolean hasOverdue = lendingRecords.stream()
                .anyMatch(r -> r.getMember().getMemberId().equals(memberId)
                        && r.getReturnDate() == null
                        && r.getDueDate().isBefore(LocalDate.now()));

        if (hasOverdue) {
            throw new OverdueBookException("Member has overdue books.");
        }
        book.setIssued(true);
        LendingRecord record = new LendingRecord(recordNo,bookMap.get(bookId),memberMap.get(memberId),LocalDate.now(),LocalDate.now().plusDays(10),null);
        lendingRecords.add(record);
        recordNo++;
    }

    public void returnBook(String bookId, String memberId) {
        for (LendingRecord record : lendingRecords) {
            if (record.getBook().getBookId().equals(bookId) &&
                    record.getMember().getMemberId().equals(memberId) &&
                    record.getReturnDate() == null) {
                record.setReturnDate(LocalDate.now());
                record.getBook().setIssued(false);
                break;
            }
        }
    }

    public List<Book> searchBooksByAuthor(String author) {
        return bookMap.values().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> getSortedBooksByTitle() {
        return bookMap.values().stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Member> getMembersWithBorrowedBooks() {
        return lendingRecords.stream()
                .filter(record -> record.getReturnDate() == null)
                .map(LendingRecord::getMember)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<LendingRecord> getOverdueRecords() {
        return lendingRecords.stream()
                .filter(r -> r.getReturnDate() == null && r.getDueDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }
   
}
