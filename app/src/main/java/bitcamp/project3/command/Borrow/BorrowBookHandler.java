package bitcamp.project3.command.Borrow;

import bitcamp.project3.vo.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowBookHandler {

  public static int count = 0;
  private List<Book> bookList;

  public BorrowBookHandler(List<Book> bookList) {
    this.bookList = bookList;
  }

  // 특정 사용자가 연체된 책이 있는지 확인
  public boolean hasOverdueBooks(String borrowerName) {
    LocalDate today = LocalDate.now();
    for (Book book : bookList) {
      if (borrowerName.equals(book.getName()) && book.getDate().isBefore(today)) {
        return true;
      }
    }
    return false;
  }

  // 대출 가능한 책 리스트 출력
  public void listAvailableBooks() {
    System.out.println("대출 가능한 책 목록입니다.");
    for (Book book : bookList) {
      if (book.getDate() == null) {
        System.out.printf("%d. %s\t %s\n", book.getNo(), book.getBookName(), book.getWriter());
      }
    }
  }

  //번호로 책 찾기
  public Book findBookByNo(int bookNo) {
    for (Book book : bookList) {
      if (book.getNo() == bookNo) {
        return book;
      }
    }
    return null;
  }

  // 대출자의 이름으로 대출된 책 리스트 출력
  public List<Book> listBorrowedBooksByName(String borrowerName) {
    List<Book> borrowedBooks = new ArrayList<>();
    System.out.printf("'%s' 님이 대출한 책 목록입니다.\n", borrowerName);
    for (Book book : bookList) {
      if (borrowerName.equals(book.getName())) {
        System.out.printf("%d. %s\t %s\t 반납일: %d년 %d월 %d일\n", book.getNo(), book.getBookName(),
            book.getWriter(), book.getDate().getYear(), book.getDate().getMonthValue(),
            book.getDate().getDayOfMonth());
        borrowedBooks.add(book);
      }
    }
    return borrowedBooks;
  }

  // 대출 가능한 책이 있는지 확인
  public boolean hasAvailableBooks() {
    for (Book book : bookList) {
      if (book.getDate() == null) {
        return true;
      }
    }
    return false;
  }
}




