package bitcamp.project3.command.Management;

import bitcamp.project3.command.Command;
import bitcamp.project3.vo.Book;

import java.util.List;

public class ManagementShowListCommand implements Command {

  public List<Book> bookList;

  public ManagementShowListCommand(List<Book> list) {
    this.bookList = list;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);

    System.out.print("번호 도서명\t 저자명\t 장르\n");
    for (Book book : bookList) {
      if(book.getName() != null){
        System.out.printf("\u001B[31m%d. 도서명 : %s\t 저자 : %s\t 장르 : %s\u001B[0m\n", book.getNo(), book.getBookName(),
                book.getWriter(), book.getGenre().getGenreName());
      } else {
        System.out.printf("%d. 도서명 : %s\t 저자 : %s\t 장르 : %s\n", book.getNo(), book.getBookName(),
                book.getWriter(), book.getGenre().getGenreName());
      }
    }
  }
}

