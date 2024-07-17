package bitcamp.project3.command.Borrow;

import bitcamp.project3.command.Command;
import bitcamp.project3.command.Management.ManagementBookHandler;
import bitcamp.project3.vo.Book;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class BorrowListOverCommand implements Command {

  private List<Book> bookList;

  public BorrowListOverCommand(List<Book> bookList) {
    this.bookList = bookList;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    System.out.println("연체된 책 목록입니다.");
    System.out.printf("%-4s %-46s %-46s %-20s %-12s %-8s\n", "번호", "도서명", "저자", "대출자", "반납일",
        "연체일");

    LocalDate today = LocalDate.now();
    for (Book book : bookList) {
      String bookName = ManagementBookHandler.adjustLength(book.getBookName(), 50);
      String writer = ManagementBookHandler.adjustLength(book.getWriter(), 50);
      String name = ManagementBookHandler.adjustLength(book.getName(), 20);

      if (book.getDate() != null) {
        if (book.getDate().isBefore(today)) {
          long overdueDays = ChronoUnit.DAYS.between(book.getDate(), today);
          System.out.printf("\u001B[31m%d. %s %s %s %d년 %d월 %d일 \t\t%d일\u001B[0m\n", book.getNo(),
              bookName, writer, name, book.getDate().getYear(), book.getDate().getMonthValue(),
              book.getDate().getDayOfMonth(), overdueDays);
        }
      }
    }
  }
}




