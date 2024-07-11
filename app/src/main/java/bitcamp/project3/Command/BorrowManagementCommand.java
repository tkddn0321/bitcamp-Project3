package bitcamp.project3.Command;

import bitcamp.project3.Util.Prompt;
import bitcamp.project3.Vo.Book;
import bitcamp.project3.Command.BookManagementCommand;

import java.time.LocalDate;
import java.util.List;

public class BorrowManagementCommand implements Command{

    public List<Book> bookList;

    public void execute(){

    }


    private void BorrowBook(){
        abc:
        while (true) {
            LocalDate date = LocalDate.now();
            Book book = new Book();
            // List 뜨기
            book.setNo(Prompt.inputInt("대출하실 책 번호를 입력하세요."));
            book.setDate(date.plusDays(15));
            System.out.printf("%d년 %d월 %d일이 반납일입니다.", book.getDate().getYear(), book.getDate().getMonth().getValue(), book.getDate().getDayOfMonth());
            //bookList.add(book);
            while (true) {
                String answer = Prompt.input("더 대여하시겠습니까? (y/n): ");
                if (answer.equalsIgnoreCase("n")) {
                    System.out.println("책이 대여 되었습니다.");
                    break;
                } else if ((answer.equalsIgnoreCase("y"))) {
                    System.out.println("추가 대여합니다.");
                    continue abc;
                } else {
                    System.out.println("올바른 형식이 아닙니다.");
                }
            }
            break;
        }
    }


}
