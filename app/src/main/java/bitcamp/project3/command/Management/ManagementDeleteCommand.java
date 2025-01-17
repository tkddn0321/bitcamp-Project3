package bitcamp.project3.command.Management;

import bitcamp.project3.command.Command;
import bitcamp.project3.vo.Book;
import bitcamp.util.Prompt;

import java.util.List;

public class ManagementDeleteCommand implements Command {

  public List<Book> bookList;
  private ManagementBookHandler managementBookHandler;

  public ManagementDeleteCommand(List<Book> list, ManagementBookHandler managementBookHandler) {
    this.bookList = list;
    this.managementBookHandler = managementBookHandler;
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);

    managementBookHandler.execute(menuName);

    int bookNo = Prompt.inputInt("삭제하실 번호를 입력하세요 뒤로가기(0) : ");
    if (bookNo == 0) {
      return;
    }
    int index = bookList.indexOf(new Book(bookNo));
    if (index == -1) {
      System.out.println("없는 번호입니다.");
      return;
    }

    Book deleteBook = bookList.remove(index);
    System.out.printf("%s 책을 삭제했습니다.\n", deleteBook.getBookName());
  }
}

