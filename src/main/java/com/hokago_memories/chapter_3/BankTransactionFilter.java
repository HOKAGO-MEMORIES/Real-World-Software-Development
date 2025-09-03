package com.hokago_memories.chapter_3;

// 한 개의 추상 메서드를 포함하는 인터페이스 -> 함수형 인터페이스
@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
