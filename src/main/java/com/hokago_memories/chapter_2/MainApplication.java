package com.hokago_memories.chapter_2;

import java.io.IOException;

public class MainApplication {
    public static void main(final String... args) throws IOException {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        // 객체지향의 다형성 활용
        // 특정 구현에 종속되지 않고, 역할을 기반으로 프로그래밍할 수 있어 유연하고 확장 가능한 시스템을 만들 수 있음
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze(args[0], bankStatementParser);
    }

}
