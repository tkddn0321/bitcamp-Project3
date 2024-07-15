package bitcamp.project3.command.Borrow;

import bitcamp.project3.command.Command;
import bitcamp.project3.vo.Book;
import bitcamp.util.Prompt;

import java.util.List;

public class BorrowExtendCommand implements Command {

  private List<Book> bookList;
  private BorrowBookHandler bookHandler;

  public BorrowExtendCommand(List<Book> bookList, BorrowBookHandler bookHandler) {
    this.bookList = bookList;
    this.bookHandler = bookHandler;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);
    String borrowerName = Prompt.input("연장하는 분의 이름을 입력하세요: ");
    List<Book> borrowedBooks = bookHandler.listBorrowedBooksByName(borrowerName);

    if (borrowedBooks.isEmpty()) {
      System.out.println("대출하신 책이 없습니다.");
      return;
    }

    while (true) {
      int bookNo = Prompt.inputInt("연장하실 책 번호를 입력하세요: ");
      Book book = bookHandler.findBookByNo(bookNo);

      if (book == null || !borrowedBooks.contains(book)) {
        System.out.println("유효한 책 번호가 아닙니다.");
      } else {
        book.setDate(book.getDate().plusDays(15));
        System.out.printf("%d년 %d월 %d일로 연장되었습니다.\n", book.getDate().getYear(),
            book.getDate().getMonthValue(), book.getDate().getDayOfMonth());
      }
      String answer = Prompt.input("더 연장하시겠습니까? (y/n): ");
      if (answer.equalsIgnoreCase("n")) {
        return;
      } else if (answer.equalsIgnoreCase("y")) {
        borrowedBooks = bookHandler.listBorrowedBooksByName(borrowerName);
        if (borrowedBooks.isEmpty()) {
          System.out.println("더 이상 연장할 책이 없습니다.");
          return;
        }
      } else {
        System.out.println("올바른 형식이 아닙니다.");
      }
    }
  }

}




