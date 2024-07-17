package bitcamp.project3.command.Borrow;

import bitcamp.project3.command.Management.ManagementBookHandler;
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

  public static String adjustLength(String input, int length) {
    if (input == null) {
      return String.format("%-" + length + "s", "");
    }
    int totalWidth = 0;
    for (char c : input.toCharArray()) {
      if (isFullWidth(c)) {
        totalWidth += 2;
      } else {
        totalWidth += 1;
      }
    }
    int paddingLength = length - totalWidth;
    if (paddingLength > 0) {
      return input + " ".repeat(paddingLength);
    } else {
      return input;
    }
  }

  public static boolean isFullWidth(char c) {
    // 유니코드 범위로 전각 문자인지 확인
    return (c >= '\u1100' && c <= '\u115F') || // Hangul Jamo
        (c >= '\u2E80' && c <= '\uA4CF') || // CJK Radicals Supplement and Kangxi Radicals
        (c >= '\uAC00' && c <= '\uD7A3') || // Hangul Syllables
        (c >= '\uF900' && c <= '\uFAFF') || // CJK Compatibility Ideographs
        (c >= '\uFE10' && c <= '\uFE19') || // Vertical forms
        (c >= '\uFE30' && c <= '\uFE6F') || // CJK Compatibility Forms
        (c >= '\uFF00' && c <= '\uFF60') || // Fullwidth Forms
        (c >= '\uFFE0' && c <= '\uFFE6');   // Fullwidth Symbol Forms
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
    System.out.printf("%-4s %-48s %-50s\n", "번호", "도서명", "저자");

    for (Book book : bookList) {
      String bookName = ManagementBookHandler.adjustLength(book.getBookName(), 50);
      String writer = ManagementBookHandler.adjustLength(book.getWriter(), 50);

      if (book.getDate() == null) {
        System.out.printf("%d. %s\t %s\n", book.getNo(), bookName, writer);
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
    System.out.printf("%-4s %-46s %-40s %12s\n", "번호", "도서명", "저자", "반납일");

    for (Book book : bookList) {
      String bookName = ManagementBookHandler.adjustLength(book.getBookName(), 50);
      String writer = ManagementBookHandler.adjustLength(book.getWriter(), 50);

      if (borrowerName.equals(book.getName())) {
        System.out.printf("%d. %s %s %d년 %d월 %d일\n", book.getNo(), bookName, writer,
            book.getDate().getYear(), book.getDate().getMonthValue(),
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




