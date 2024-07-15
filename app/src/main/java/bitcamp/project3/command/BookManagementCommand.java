package bitcamp.project3.command;

import bitcamp.project3.vo.Book;
import bitcamp.util.Prompt;

import java.util.List;

public class BookManagementCommand extends AbstractCommand {

  public List<Book> bookList;
  String[] menus = {"도서 등록", "도서 목록", "도서 변경", "도서 삭제"};

  public BookManagementCommand(String menuTitle, List<Book> list) {
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
      case "도서 등록":
        this.addBook();
        break;
      case "도서 목록":
        this.listBook();
        break;
      case "도서 변경":
        this.updateBook();
        break;
      case "도서 삭제":
        this.deleteBook();
        break;
    }
  }

  public void addBook() {

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

  public void listBook() {
    System.out.print("번호 도서명\t 저자명\t 장르\t 내용\n");
    for (Book book : bookList) {
      if(book.getName() != null){
        System.out.printf("\u001B[31m%d. %s\t %s\t %s\t %s\u001B[0m\n", book.getNo(), book.getBookName(),
                book.getWriter(), book.getGenre().getGenreName(), book.getContent());
      } else {
        System.out.printf("%d. %s\t %s\t %s\t %s\n", book.getNo(), book.getBookName(),
                book.getWriter(), book.getGenre().getGenreName(), book.getContent());
      }
    }
  }

  public void updateBook() {
    listBook();
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

  public void deleteBook() {
    listBook();
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

