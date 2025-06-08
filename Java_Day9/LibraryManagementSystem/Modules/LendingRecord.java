package Java_Day9.LibraryManagementSystem.Modules;

import java.time.LocalDate;

public class LendingRecord {
    private long recordId;
    private Book book;
    private Member member;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    public LendingRecord(long recordId, Book book, Member member, 
                         LocalDate issueDate, LocalDate dueDate, LocalDate returnDate) {
        this.recordId = recordId;
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
    }

    public long getId() {
        return recordId;
    }

    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    
    @Override
public String toString() {
    return "RecordID:"+recordId + " lent by" + member.getName() + ". Book name:" + book.getTitle()
            + ". Issued on " + issueDate
            + " " + (returnDate == null ? ". Due by " + dueDate : ".Returned on "+returnDate);
}


}

