package bitcamp.project3.command.Management;

import bitcamp.project3.command.Command;
import bitcamp.project3.vo.Book;
import bitcamp.util.Prompt;

import java.util.List;

public class ManagementUpdateCommand implements Command {

  public List<Book> bookList;
  private ManagementBookHandler managementBookHandler;

  public ManagementUpdateCommand(List<Book> list, ManagementBookHandler managementBookHandler) {
    this.bookList = list;
    this.managementBookHandler = managementBookHandler;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);

    managementBookHandler.execute(menuName);
    int bookNo = Prompt.inputInt("책 번호를 입력하세요 뒤로가기(0) :  ");
    if (bookNo == 0) {
      return;
    }
    int index = bookList.indexOf(new Book(bookNo));
    if (index == -1) {
      System.out.println("없는 책 번호입니다.");
      return;
    }

    Book book = bookList.get(index);

    book.setBookName(Prompt.input("변경하실 책 이름을 입력하세요 : "));
    book.setWriter(Prompt.input("변경하실 저자를 입력하세요 : "));
    System.out.println("변경하실 책 장르를 선택하세요:");
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
    book.setContent(Prompt.input("변경하실 내용을 입력하세요 : "));
    System.out.println("변경했습니다.");
  }
}

