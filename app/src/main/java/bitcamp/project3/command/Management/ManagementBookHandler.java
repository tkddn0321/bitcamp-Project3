package bitcamp.project3.command.Management;

import bitcamp.project3.command.Command;
import bitcamp.project3.vo.Book;

import java.util.List;

public class ManagementBookHandler implements Command {

  public List<Book> bookList;

  public ManagementBookHandler(List<Book> list) {
    this.bookList = list;
  }

  public static String adjustLength(String input, int length) {
    if (input == null) {
      return String.format("%-" + length + "s", "");
    }
    int totalWidth = 0;
    for (char c : input.toCharArray()) {
      if (isFullWidth(c)) {
        totalWidth += 2;
      } else {
        totalWidth += 1;
      }
    }
    int paddingLength = length - totalWidth;
    if (paddingLength > 0) {
      return input + " ".repeat(paddingLength);
    } else {
      return input;
    }
  }

  public static boolean isFullWidth(char c) {
    // 유니코드 범위로 전각 문자인지 확인
    return (c >= '\u1100' && c <= '\u115F') || // Hangul Jamo
        (c >= '\u2E80' && c <= '\uA4CF') || // CJK Radicals Supplement and Kangxi Radicals
        (c >= '\uAC00' && c <= '\uD7A3') || // Hangul Syllables
        (c >= '\uF900' && c <= '\uFAFF') || // CJK Compatibility Ideographs
        (c >= '\uFE10' && c <= '\uFE19') || // Vertical forms
        (c >= '\uFE30' && c <= '\uFE6F') || // CJK Compatibility Forms
        (c >= '\uFF00' && c <= '\uFF60') || // Fullwidth Forms
        (c >= '\uFFE0' && c <= '\uFFE6');   // Fullwidth Symbol Forms
  }

  @Override
  public void execute(String menuName) {
    System.out.printf("[%s]\n", menuName);

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

