package bitcamp.project3.Command;

import bitcamp.project3.Util.Prompt;
import bitcamp.project3.Vo.Book;

import java.time.LocalDate;
import java.util.List;

public class BorrowManagementCommand extends AbstractCommand {

  public List<Book> borrowList;
  String[] menus = {"도서 대출", "도서 반납", "대출 목록", "대출 수정"};

  public BorrowManagementCommand(String menuTitle, List<Book> list) {
    super(menuTitle);
    this.borrowList = list;
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
        //        this.borrowBook();
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

  public void BorrowBook() {

    while (true) {
      LocalDate date = LocalDate.now();
      Book book = new Book();
      // List 뜨기
      book.setNo(Prompt.inputInt("대출하실 책 번호를 입력하세요."));
      book.setDate(date.plusDays(15));

      System.out.printf("%d년 %d월 %d일이 반납일입니다.", book.getDate().getYear(),
          book.getDate().getMonthValue(), book.getDate().getDayOfMonth());
      //bookList.add(book);
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




