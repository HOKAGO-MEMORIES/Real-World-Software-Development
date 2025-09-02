package com.hokago_memories.chapter_2;

import java.time.LocalDate;

// BankTransaction 도메인 객체를 처리하는 메서드를 그룹화함 (정보를 기준으로 그룹화함)
// 객체를 만들고, 읽고, 갱신하고, 삭제하는 기능만을 제공함 (CRUD)
public class BankTransactionDAO {
     public BankTransaction create(final LocalDate date, final double amount, final String description) {
         // ...
         throw new UnsupportedOperationException();
     }

     public BankTransaction read(final long id) {
         // ...
         throw new UnsupportedOperationException();
     }

     public BankTransaction update(final long id) {
         // ...
         throw new UnsupportedOperationException();
     }

     public BankTransaction delete(final BankTransaction BankTransaction) {
         // ...
         throw new UnsupportedOperationException();
     }

}
