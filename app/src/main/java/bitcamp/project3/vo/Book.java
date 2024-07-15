package bitcamp.project3.vo;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

  private static int seqNo;

  private int no;
  private String bookName;
  private LocalDate date;
  private String writer;
  private String name;
  private String content;
  private String genre;


  public Book() {

  }

  public Book(int no) {
    this.no = no;
  }

  public static int getSeqNo() {
    return ++seqNo;
  }

  public static void setSeqNo(int seqNo) {
    Book.seqNo = seqNo;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object)
      return true;
    if (object == null || getClass() != object.getClass())
      return false;
    Book book = (Book) object;
    return no == book.no;
  }

  @Override
  public int hashCode() {
    return Objects.hash(no);
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
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

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }
}