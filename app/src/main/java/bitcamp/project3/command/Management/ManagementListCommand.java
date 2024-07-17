package bitcamp.project3.command.Management;

import bitcamp.project3.command.Command;
import bitcamp.project3.vo.Book;

import java.util.List;

public class ManagementListCommand implements Command {

  public List<Book> bookList;

  public ManagementListCommand(List<Book> list) {
    this.bookList = list;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);

    System.out.print("도서 목록입니다.\n");
    System.out.printf("%-4s %-48s %-50s %-10s\n", "번호", "도서명", "저자", "장르");

    for (Book book : bookList) {
      String bookName = ManagementBookHandler.adjustLength(book.getBookName(), 50);
      String writer = ManagementBookHandler.adjustLength(book.getWriter(), 50);
      String genre = ManagementBookHandler.adjustLength(book.getGenre().getGenreName(), 10);

      String formattedBookInfo =
          String.format("%d. %s %s\t %s", book.getNo(), bookName, writer, genre);

      if (book.getName() != null) {
        System.out.printf("\u001B[31m%s\u001B[0m\n", formattedBookInfo);
      } else {
        System.out.printf("%s\n", formattedBookInfo);
      }
    }
  }

}
