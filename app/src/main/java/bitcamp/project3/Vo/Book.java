package bitcamp.project3.Vo;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Book {

    private static int seqNo;

    private int no;
    private String bookName;
    private String bookIntro;
    private LocalDate date;
    private String writer;
    private String name;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Book book = (Book) object;
        return no == book.no && Objects.equals(bookName, book.bookName) && Objects.equals(bookIntro, book.bookIntro) && Objects.equals(date, book.date) && Objects.equals(writer, book.writer) && Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, bookName, bookIntro, date, writer, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Book(){

    }

    public static int getSeqNo() {
        return ++seqNo;
    }

    public static void setSeqNo(int seqNo) {
        Book.seqNo = seqNo;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookIntro() {
        return bookIntro;
    }

    public void setBookIntro(String bookIntro) {
        this.bookIntro = bookIntro;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
