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
    book1.setGenre(Book.BookGenre.PROGRAM);
    book1.setContent("깨끗하고 유지 보수 가능한 코드를 작성하는 방법에 대한 자세한 설명.");
    books.add(book1);

    Book book2 = new Book();
    book2.setNo(Book.getSeqNo());
    book2.setBookName("이펙티브 자바");
    book2.setWriter("조슈아 블로크");
    book2.setGenre(Book.BookGenre.PROGRAM);
    book2.setContent("자바에서 견고하고 고성능 코드를 작성하는 종합 가이드.");
    books.add(book2);

    Book book3 = new Book();
    book3.setNo(Book.getSeqNo());
    book3.setBookName("실용주의 프로그래머");
    book3.setWriter("앤드류 헌트, 데이비드 토마스");
    book3.setGenre(Book.BookGenre.PROGRAM);
    book3.setContent("소프트웨어 개발, 코딩 관행, 경력 개발에 대한 실용적인 조언.");
    books.add(book3);

    Book book4 = new Book();
    book4.setNo(Book.getSeqNo());
    book4.setBookName("디자인 패턴");
    book4.setWriter("에리히 감마, 리처드 헬름, 랄프 존슨, 존 블리시디스");
    book4.setGenre(Book.BookGenre.PROGRAM);
    book4.setContent("23개의 디자인 패턴에 대한 심층적인 설명과 그 사용 및 구현.");
    books.add(book4);

    Book book5 = new Book();
    book5.setNo(Book.getSeqNo());
    book5.setBookName("리팩터링");
    book5.setWriter("마틴 파울러");
    book5.setGenre(Book.BookGenre.PROGRAM);
    book5.setContent("나쁜 코드를 좋은 구조의 코드로 변환하는 가이드.");
    books.add(book5);

    // 이미 대출된 책 (정상 반납일인 경우)
    Book book6 = new Book();
    book6.setNo(Book.getSeqNo());
    book6.setBookName("테스트 주도 개발");
    book6.setWriter("켄트 벡");
    book6.setGenre(Book.BookGenre.PROGRAM);
    book6.setContent("테스트 주도 개발의 원리와 실천 방법에 대한 책.");
    book6.setName("홍길동");
    book6.setDate(LocalDate.now().plusDays(7)); // 반납일까지 7일 남음
    books.add(book6);

    // 이미 대출된 책 (연체된 경우)
    Book book7 = new Book();
    book7.setNo(Book.getSeqNo());
    book7.setBookName("도메인 주도 설계");
    book7.setWriter("에릭 에반스");
    book7.setGenre(Book.BookGenre.PROGRAM);
    book7.setContent("복잡한 소프트웨어 프로젝트를 성공적으로 완성하기 위한 도메인 주도 설계 방법론.");
    book7.setName("이몽룡");
    book7.setDate(LocalDate.now().minusDays(3)); // 3일 연체됨
    books.add(book7);

    Book book8 = new Book();
    book8.setNo(Book.getSeqNo());
    book8.setBookName("드라큘라");
    book8.setWriter("브램 스토커");
    book8.setGenre(Book.BookGenre.HORROR);
    book8.setContent("흡혈귀 드라큘라의 이야기.");
    books.add(book8);

    Book book9 = new Book();
    book9.setNo(Book.getSeqNo());
    book9.setBookName("해리 포터와 마법사의 돌");
    book9.setWriter("J.K. 롤링");
    book9.setGenre(Book.BookGenre.FANTASY);
    book9.setContent("마법 학교에서의 해리 포터의 첫 해.");
    book9.setName("김철수");
    book9.setDate(LocalDate.now().plusDays(14)); // 반납일까지 14일 남음
    books.add(book9);

    Book book10 = new Book();
    book10.setNo(Book.getSeqNo());
    book10.setBookName("셜록 홈즈의 모험");
    book10.setWriter("아서 코난 도일");
    book10.setGenre(Book.BookGenre.MYSTERY);
    book10.setContent("명탐정 셜록 홈즈의 다양한 모험.");
    books.add(book10);

    Book book11 = new Book();
    book11.setNo(Book.getSeqNo());
    book11.setBookName("사랑의 기술");
    book11.setWriter("에리히 프롬");
    book11.setGenre(Book.BookGenre.ROMANCE);
    book11.setContent("사랑의 본질과 그 의미에 대한 고찰.");
    books.add(book11);

    Book book12 = new Book();
    book12.setNo(Book.getSeqNo());
    book12.setBookName("웃기는 얘기들");
    book12.setWriter("조지 번스");
    book12.setGenre(Book.BookGenre.COMEDY);
    book12.setContent("유머러스한 단편 이야기 모음.");
    books.add(book12);

    Book book13 = new Book();
    book13.setNo(Book.getSeqNo());
    book13.setBookName("시간의 역사");
    book13.setWriter("스티븐 호킹");
    book13.setGenre(Book.BookGenre.SCIENCE);
    book13.setContent("시간과 우주의 본질에 대한 과학적 설명.");
    books.add(book13);

    Book book14 = new Book();
    book14.setNo(Book.getSeqNo());
    book14.setBookName("공포의 묵시록");
    book14.setWriter("H.P. 러브크래프트");
    book14.setGenre(Book.BookGenre.HORROR);
    book14.setContent("초자연적 공포의 단편 소설 모음.");
    books.add(book14);

    Book book15 = new Book();
    book15.setNo(Book.getSeqNo());
    book15.setBookName("코믹스의 세계");
    book15.setWriter("스콧 맥클라우드");
    book15.setGenre(Book.BookGenre.COMEDY);
    book15.setContent("만화의 역사와 예술성에 대한 탐구.");
    books.add(book15);

    Book book16 = new Book();
    book16.setNo(Book.getSeqNo());
    book16.setBookName("로미오와 줄리엣");
    book16.setWriter("윌리엄 셰익스피어");
    book16.setGenre(Book.BookGenre.ROMANCE);
    book16.setContent("비극적인 사랑 이야기.");
    book16.setName("박영희");
    book16.setDate(LocalDate.now().minusDays(1)); // 1일 연체됨
    books.add(book16);

    Book book17 = new Book();
    book17.setNo(Book.getSeqNo());
    book17.setBookName("프랑켄슈타인");
    book17.setWriter("메리 셸리");
    book17.setGenre(Book.BookGenre.HORROR);
    book17.setContent("인조 인간을 창조한 과학자의 이야기.");
    books.add(book17);

    Book book18 = new Book();
    book18.setNo(Book.getSeqNo());
    book18.setBookName("은하수를 여행하는 히치하이커를 위한 안내서");
    book18.setWriter("더글러스 애덤스");
    book18.setGenre(Book.BookGenre.SCIENCE);
    book18.setContent("우주를 여행하는 코믹한 가이드.");
    books.add(book18);

    Book book19 = new Book();
    book19.setNo(Book.getSeqNo());
    book19.setBookName("추리 소설의 대가");
    book19.setWriter("애거사 크리스티");
    book19.setGenre(Book.BookGenre.MYSTERY);
    book19.setContent("다양한 추리 소설 단편 모음.");
    book19.setName("최지훈");
    book19.setDate(LocalDate.now().minusDays(5)); // 5일 연체됨
    books.add(book19);

    Book book20 = new Book();
    book20.setNo(Book.getSeqNo());
    book20.setBookName("인간 본성에 대하여");
    book20.setWriter("에드워드 윌슨");
    book20.setGenre(Book.BookGenre.SCIENCE);
    book20.setContent("인간 본성과 진화에 대한 심층적 탐구.");
    books.add(book20);

    return books;
  }
}
