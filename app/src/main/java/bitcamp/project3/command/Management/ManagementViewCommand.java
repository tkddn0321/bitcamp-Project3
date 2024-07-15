package bitcamp.project3.command.Management;

import bitcamp.project3.command.Command;
import bitcamp.project3.vo.Book;
import bitcamp.util.Prompt;

import java.util.List;

public class ManagementViewCommand implements Command {

  public List<Book> bookList;

  public ManagementViewCommand(List<Book> list) {

    this.bookList = list;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);

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
  }
}

