package bitcamp.project3.Command;

import bitcamp.project3.Util.Prompt;
import bitcamp.project3.Vo.Book;

import java.time.LocalDate;
import java.util.ArrayList;
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
      case "대출 목록":
        this.listBorrowedBooks();
        break;
      case "도서 반납":
        this.returnBook();
        break;
      case "대출 수정":
        //        this.deleteBook();
        break;
    }
  }

  // 도서 대출
  public void borrowBook() {
    if (!hasAvailableBooks()) {
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

  // 도서 반납
  public void returnBook() {
    String borrowerName = Prompt.input("반납하는 분의 이름을 입력하세요: ");
    List<Book> borrowedBooks = listBorrowedBooksByName(borrowerName);

    if (borrowedBooks.isEmpty()) {
      System.out.println("반납할 책이 없습니다.");
      return;
    }

    while (true) {
      int bookNo = Prompt.inputInt("반납하실 책 번호를 입력하세요: ");
      Book book = findBookByNo(bookNo);

      if (book == null || !borrowedBooks.contains(book)) {
        System.out.println("유효한 책 번호가 아닙니다.");
      } else {
        book.setName(null);
        book.setDate(null);
        System.out.println("책이 반납되었습니다.");
      }

      String answer = Prompt.input("더 반납하시겠습니까? (y/n): ");
      if (answer.equalsIgnoreCase("n")) {
        return;
      } else if (answer.equalsIgnoreCase("y")) {
        borrowedBooks = listBorrowedBooksByName(borrowerName);
        if (borrowedBooks.isEmpty()) {
          System.out.println("더 이상 반납할 책이 없습니다.");
          return;
        }
      } else {
        System.out.println("올바른 형식이 아닙니다.");
      }
    }
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

  // 대출 된 책 리스트 출력
  public void listBorrowedBooks() {
    System.out.println("대출된 책 목록입니다.");
    for (Book book : bookList) {
      if (book.getDate() != null) {
        System.out.printf("%d. %s\t %s\t 반납일: %d년 %d월 %d일\n", book.getNo(), book.getBookName(),
            book.getWriter(), book.getDate().getYear(), book.getDate().getMonthValue(),
            book.getDate().getDayOfMonth());
      }
    }
  }

  //번호로 책 찾기
  private Book findBookByNo(int bookNo) {
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
  private boolean hasAvailableBooks() {
    for (Book book : bookList) {
      if (book.getDate() == null) {
        return true;
      }
    }
    return false;
  }
}




