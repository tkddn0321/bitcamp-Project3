package bitcamp.project3.command.Management;

import bitcamp.project3.command.Command;
import bitcamp.project3.vo.Book;
import bitcamp.util.Prompt;

import java.util.List;

public class ManagementAddCommand implements Command {

  public List<Book> bookList;

  public ManagementAddCommand(List<Book> list) {
    this.bookList = list;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);

    while (true) {
      Book book = new Book();

      book.setBookName(Prompt.input("등록하실 책 이름을 입력하세요 : "));
      book.setWriter(Prompt.input("책 저자를 입력하세요 : "));
      System.out.println("책 장르를 선택하세요:");
      for (int i = 0; i < Book.BookGenre.values().length; i++) {
        System.out.printf("%d. %s\n", i + 1, Book.BookGenre.values()[i].getGenreName());
      }

      while (true) {
        int genreSelect = Prompt.inputInt("장르 번호를 입력하세요: ");
        if (genreSelect >= 1 && genreSelect <= Book.BookGenre.values().length) {
          book.setGenre(Book.BookGenre.values()[genreSelect - 1]);
          break;
        } else {
          System.out.println("올바른 장르 번호를 입력해주세요.");
        }
      }
      book.setContent(Prompt.input("책 내용을 입력하세요 : "));
      book.setNo(Book.getSeqNo());
      bookList.add(book);

      while (true) {
        String answer = Prompt.input("더 등록하시겠습니까? (y/n): ");
        if (answer.equalsIgnoreCase("n")) {
          System.out.println("책이 등록 되었습니다.");
          return;
        } else if (answer.equalsIgnoreCase("y")) {
          System.out.println("추가 등록합니다.");
          break;
        } else {
          System.out.println("올바른 형식이 아닙니다.");
          continue;
        }
      }
    }
  }
}

