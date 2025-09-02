package com.hokago_memories.chapter_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCE = "src/main/resources/";

    public static void main(final String... args) throws IOException {
        // 1. KISS 원칙 사용 -> 코드를 한 개의 클래스로 구현
        final Path path = Paths.get(RESOURCE + args[0]);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transaction is " + total);

        // 2. 특정 달에 몇 건의 입출금 내역이 있는 확인 (위의 코드 복사하여 사용)
        // 갓 클래스와 코드 중복에 대한 위험성이 있음
        total = 0d;
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // 날짜 패턴
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0],DATE_PATTERN);
            if(date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }

        System.out.println("The total for all transaction in January is " + total);

        
        // 3. 입출금 내역 CSV 파서를 사용하여 기존 코드 리팩토링
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final List<BankTransaction> bankTransactions
                = bankStatementCSVParser.parseLinesFromCSV(lines);

        System.out.println("The total for all transaction is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transaction in January " + selectInMonth(bankTransactions, Month.JANUARY));
    }


    // 입출금 내역 목록 처리 메소드들
    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;
        for (final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }


}
