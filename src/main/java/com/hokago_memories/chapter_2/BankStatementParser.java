package com.hokago_memories.chapter_2;

import java.util.List;

// 입출금 내역 파서를 어떻게 사용하는지 정의하는 인터페이스 생성
// 인터페이스를 이용하면 여러 컴포넌트의 결합도를 제거할 수 있음
public interface BankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
