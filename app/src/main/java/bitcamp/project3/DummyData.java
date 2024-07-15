package bitcamp.project3;

import bitcamp.project3.vo.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DummyData {

  public static List<Book> createDummyBooks() {
    List<Book> books = new ArrayList<>();

    Book book1 = new Book();
    book1.setNo(Book.getSeqNo());
    book1.setBookName("클린 코드");
    book1.setWriter("로버트 C. 마틴");
    book1.setGenre("프로그래밍");
    book1.setContent("깨끗하고 유지 보수 가능한 코드를 작성하는 방법에 대한 자세한 설명.");
    books.add(book1);

    Book book2 = new Book();
    book2.setNo(Book.getSeqNo());
    book2.setBookName("이펙티브 자바");
    book2.setWriter("조슈아 블로크");
    book2.setGenre("프로그래밍");
    book2.setContent("자바에서 견고하고 고성능 코드를 작성하는 종합 가이드.");
    books.add(book2);

    Book book3 = new Book();
    book3.setNo(Book.getSeqNo());
    book3.setBookName("실용주의 프로그래머");
    book3.setWriter("앤드류 헌트, 데이비드 토마스");
    book3.setGenre("프로그래밍");
    book3.setContent("소프트웨어 개발, 코딩 관행, 경력 개발에 대한 실용적인 조언.");
    books.add(book3);

    Book book4 = new Book();
    book4.setNo(Book.getSeqNo());
    book4.setBookName("디자인 패턴");
    book4.setWriter("에리히 감마, 리처드 헬름, 랄프 존슨, 존 블리시디스");
    book4.setGenre("소프트웨어 디자인");
    book4.setContent("23개의 디자인 패턴에 대한 심층적인 설명과 그 사용 및 구현.");
    books.add(book4);

    Book book5 = new Book();
    book5.setNo(Book.getSeqNo());
    book5.setBookName("리팩터링");
    book5.setWriter("마틴 파울러");
    book5.setGenre("프로그래밍");
    book5.setContent("나쁜 코드를 좋은 구조의 코드로 변환하는 가이드.");
    books.add(book5);

    // 이미 대출된 책 (정상 반납일인 경우)
    Book book6 = new Book();
    book6.setNo(Book.getSeqNo());
    book6.setBookName("테스트 주도 개발");
    book6.setWriter("켄트 벡");
    book6.setGenre("프로그래밍");
    book6.setContent("테스트 주도 개발의 원리와 실천 방법에 대한 책.");
    book6.setName("홍길동");
    book6.setDate(LocalDate.now().plusDays(7)); // 반납일까지 7일 남음
    books.add(book6);

    // 이미 대출된 책 (연체된 경우)
    Book book7 = new Book();
    book7.setNo(Book.getSeqNo());
    book7.setBookName("도메인 주도 설계");
    book7.setWriter("에릭 에반스");
    book7.setGenre("소프트웨어 디자인");
    book7.setContent("복잡한 소프트웨어 프로젝트를 성공적으로 완성하기 위한 도메인 주도 설계 방법론.");
    book7.setName("이몽룡");
    book7.setDate(LocalDate.now().minusDays(3)); // 3일 연체됨
    books.add(book7);

    return books;
  }
}
