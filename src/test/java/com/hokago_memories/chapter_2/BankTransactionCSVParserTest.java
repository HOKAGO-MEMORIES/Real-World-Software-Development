package com.hokago_memories.chapter_2;


import java.time.LocalDate;
import java.time.Month;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTransactionCSVParserTest {
    private final BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        // 메서드 실행 결과를 실패로 만듦, 테스트 코드를 구현하기 전에 플레이스홀더로 유용하게 활용 가능
        // Assertions.fail("Not yet implemented");

        // 테스트의 콘텍스트 생성 (Given)
        final String line = "30-01-2017,-50,Tesco";
        final BankTransaction result = statementParser.parseFrom(line);

        // 동작 실행 (When)
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0d;

        // 예상된 결과를 어서션으로 지정 (Then)
        Assertions.assertEquals(expected.getDate(), result.getDate()); // 두 값이 같은지 테스트
        Assertions.assertEquals(expected.getAmount(), result.getAmount(), tolerance); // 두 float나 double이 delta 범위 내에서 같은지 테스트
        Assertions.assertEquals(expected.getDescription(), result.getDescription());

    }
}
