package bitcamp.project3.command.Borrow;

import bitcamp.project3.command.Command;
import bitcamp.project3.vo.Book;
import bitcamp.util.Prompt;

import java.time.LocalDate;
import java.util.List;

public class BorrowBorrowCommand implements Command {

  private List<Book> bookList;
  private BorrowBookHandler bookHandler;

  public BorrowBorrowCommand(List<Book> bookList, BorrowBookHandler bookHandler) {
    this.bookList = bookList;
    this.bookHandler = bookHandler;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);

    if (!bookHandler.hasAvailableBooks()) {
      System.out.println("대출할 수 있는 책이 없습니다.");
      return;
    }

    String borrowerName = Prompt.input("대출하는 분의 이름을 입력하세요(연체시 대출이 불가능합니다.) : ");
    if (bookHandler.hasOverdueBooks(borrowerName)) {
      System.out.println("연체된 책이 있어 더 이상 대출할 수 없습니다.");
      return;
    }

    bookHandler.listAvailableBooks();

    while (true) {
      int bookNo = Prompt.inputInt("대출하실 책 번호를 입력하세요.");
      Book book = bookHandler.findBookByNo(bookNo);

      if (book == null) {
        System.out.println("유효한 책 번호가 아닙니다.");
      } else if (book.getDate() != null) {
        System.out.println("이미 대출된 책입니다.");
      } else {
        book.setName(Prompt.input("대출하는 분의 이름을 입력하세요."));
        LocalDate date = LocalDate.now();
        book.setDate(date.plusDays(15));
        System.out.printf("%d년 %d월 %d일이 반납일입니다.", book.getDate().getYear(),
            book.getDate().getMonthValue(), book.getDate().getDayOfMonth());
      }

      while (true) {
        String answer = Prompt.input("더 대여하시겠습니까? (y/n): ");
        if (answer.equalsIgnoreCase("n")) {
          System.out.println("책이 대여 되었습니다.");
          return;
        } else if ((answer.equalsIgnoreCase("y"))) {
          System.out.println("추가 대여합니다.");
          break;
        } else {
          System.out.println("올바른 형식이 아닙니다.");
          continue;
        }
      }
    }
  }
}




