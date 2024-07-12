package bitcamp.project3.Command;

import bitcamp.project3.Util.Prompt;
import bitcamp.project3.Vo.Book;

import java.time.LocalDate;
import java.util.List;

public class BorrowManagementCommand extends AbstractCommand {

  String[] menus = {"도서 대출", "도서 반납", "대출 목록", "대출 수정"};
  private List<Book> bookList;

  public BorrowManagementCommand(String menuTitle, List<Book> list) {
    super(menuTitle);
    this.bookList = list;
  }

  @Override
  public String[] getMenus() {
    return menus;
  }

  @Override
  protected void processMenu(String menuName) {
    System.out.printf("[%s]\n", menuName);
    switch (menuName) {
      case "도서 대출":
        this.borrowBook();
        break;
      case "도서 목록":
        //        this.listBook();
        break;
      case "도서 변경":
        //        this.updateBook();
        break;
      case "도서 삭제":
        //        this.deleteBook();
        break;
    }
  }

  // 도서 대출
  public void borrowBook() {
    if (bookList.isEmpty()) {
      System.out.println("대출할 수 있는 책이 없습니다.");
      return;
    }
    
    listAvailableBooks();

    while (true) {
      int bookNo = Prompt.inputInt("대출하실 책 번호를 입력하세요.");
      Book book = findBookByNo(bookNo);

      if (book == null) {
        System.out.println("유효한 책 번호가 아닙니다.");
      } else if (book.getDate() != null) {
        System.out.println("이미 대출된 책입니다.");
      } else {
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

  public void listAvailableBooks() {
    System.out.println("대출 가능한 책 목록입니다.");
    for (Book book : bookList) {
      if (book.getDate() == null) {
        System.out.printf("%d. %s\t %s\n", book.getNo(), book.getBookName(), book.getWriter());
      }
    }
  }

  private Book findBookByNo(int bookNo) {
    for (Book book : bookList) {
      if (book.getNo() == bookNo) {
        return book;
      }
    }
    return null;
  }
}




