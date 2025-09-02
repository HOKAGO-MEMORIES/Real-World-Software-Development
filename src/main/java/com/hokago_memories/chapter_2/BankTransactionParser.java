package com.hokago_memories.chapter_2;

// '파싱'이라는 논리로 그룹화함
// 세 메서드는 서로 관련이 없기에 클래스는 세 가지 책임을 가지게 되어 SRP 위배됨 -> 권장 x
public class BankTransactionParser {
    public BankTransaction parseFromCSV(final String line) {
        // ...
        throw new UnsupportedOperationException();
    }

    public BankTransaction parseFromJSON(final String line) {
        // ...
        throw new UnsupportedOperationException();
    }

    public BankTransaction parseFromXML(final String line) {
        // ...
        throw new UnsupportedOperationException();
    }
}
