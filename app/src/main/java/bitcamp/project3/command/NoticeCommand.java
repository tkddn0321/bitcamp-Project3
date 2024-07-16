package bitcamp.project3.command;

import bitcamp.project3.command.Borrow.BorrowBookHandler;

import java.util.ArrayList;
import java.util.List;

public class NoticeCommand implements Command {
  public void execute(String menuName) {
    List<String> notice = new ArrayList<>();
    notice.add("책 대출 연체시 대출이 제한됩니다.");
    notice.add("연체된 책은 대출기간 연장이 불가능합니다.");
    notice.add("현재 대여중인 책 수량은 " + (BorrowBookHandler.count + 5) + "권입니다.");

    for (int i = 0; i < notice.size(); i++) {
      System.out.printf("%d. %s\n", i + 1, notice.get(i));
    }
  }
}
