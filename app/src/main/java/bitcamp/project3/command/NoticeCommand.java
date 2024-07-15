package bitcamp.project3.command;

public class NoticeCommand implements Command {
  public void execute(String menuName) {
    System.out.println("1. 책 대출 연체시 대출이 제한됩니다.");
  }
}
