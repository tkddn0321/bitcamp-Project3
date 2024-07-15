package bitcamp.project3.command.Borrow;

import bitcamp.project3.command.Command;
import bitcamp.project3.vo.Book;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class BorrowListCommand implements Command {

  private List<Book> bookList;

  public BorrowListCommand(List<Book> bookList) {
    this.bookList = bookList;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);

    System.out.println("대출된 책 목록입니다.");
    LocalDate today = LocalDate.now();
    for (Book book : bookList) {
      if (book.getDate() != null) {
        if (book.getDate().isBefore(today)) {
          long overdueDays = ChronoUnit.DAYS.between(book.getDate(), today);
          System.out.printf(
              "\u001B[31m%d. %s\t %s\t 대출자: %s\t 반납일: %d년 %d월 %d일\t 연체일: %d일\u001B[0m\n",
              book.getNo(), book.getBookName(), book.getWriter(), book.getName(),
              book.getDate().getYear(), book.getDate().getMonthValue(),
              book.getDate().getDayOfMonth(), overdueDays);
        } else {
          System.out.printf("%d. %s\t %s\t 대출자: %s\t 반납일: %d년 %d월 %d일\n", book.getNo(),
              book.getBookName(), book.getWriter(), book.getName(), book.getDate().getYear(),
              book.getDate().getMonthValue(), book.getDate().getDayOfMonth());
        }
      }
    }
  }
}




