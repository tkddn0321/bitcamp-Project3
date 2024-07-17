package bitcamp.project3.command.Management;

import bitcamp.menu.MenuGroup;
import bitcamp.project3.command.Command;
import bitcamp.project3.vo.Book;
import bitcamp.util.Prompt;

import java.util.List;
import java.util.Objects;

public class ManagementViewCommand implements Command {


  public List<Book> bookList;

  public ManagementViewCommand(List<Book> list) {

    this.bookList = list;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);

    while (true) {
      System.out.println("1. 책 번호별 조회");
      System.out.println("2. 책 장르별 조회");
      System.out.println("\u001B[31m0. 이전\u001B[0m");

      int choice = Prompt.inputInt("메인/도서 관리/도서 조회>");

      switch (choice) {
        case 1:
          viewBookNo();
          break;
        case 2:
          viewGenre();
          break;
        case 0:
          System.out.println("이전 메뉴 선택");
          return;
        default:
          System.out.println("잘못된 선택입니다.");
      }
    }
  }

  private void viewBookNo() {
    int bookNo = Prompt.inputInt("조회할 책 번호를 입력하세요 :");
    int index = bookList.indexOf(new Book(bookNo));
    if (index == -1) {
      System.out.println("없는 책 번호입니다.");
      return;
    }

    Book book = bookList.get(index);

    System.out.printf("책 이름 : %s\n", book.getBookName());
    System.out.printf("책 저자 : %s\n", book.getWriter());
    System.out.printf("책 장르 : %s\n", book.getGenre().getGenreName());
    System.out.printf("책 내용 : %s\n", book.getContent());

    System.out.println("-------------------------");
  }

  private void viewGenre() {

    for (int i = 0; i < Book.BookGenre.values().length; i++) {
      System.out.printf("%d. %s\n", i + 1, Book.BookGenre.values()[i].getGenreName());
    }

    int genreNo = Prompt.inputInt("조회할 장르 번호를 입력하세요: ");
    if (genreNo < 1 || genreNo > Book.BookGenre.values().length) {
      System.out.println("잘못된 장르 번호입니다.");
      return;
    }

    Book.BookGenre selectGenre = Book.BookGenre.values()[genreNo - 1];
    boolean foundGenre = false;

    for (Book book : bookList) {
      if (book.getGenre().equals(selectGenre)) {
        System.out.printf("%d. 도서명 : %s\t 저자 : %s\n", book.getNo(), book.getBookName(), book.getWriter());
        foundGenre = true;
      }
    }

    if (!foundGenre) {
      System.out.println("조회하신 장르의 책은 없습니다.");
    }
    System.out.println("-------------------------");
  }
}




