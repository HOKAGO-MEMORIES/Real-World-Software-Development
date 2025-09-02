package com.hokago_memories.chapter_2;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

// CSV 파싱 로직을 BankStatementCSVParser에 분리
public class BankStatementCSVParser implements BankStatementParser{
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");


    // BankTransaction 객체를 생성하는 클래스 정의
    /* 인터페이스 구현에 맞도록 작성
    private BankTransaction parseFromCSV(final String line) {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }

    public List<BankTransaction> parseLinesFromCSV(final List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        for (final String line : lines) {
            bankTransactions.add(parseFromCSV(line));
        }
        return bankTransactions;
    }
    */

    // 인터페이스 구현 (오버라이드)
    @Override
    public BankTransaction parseFrom(String line) {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        return lines.stream().map(this::parseFrom).collect(toList());
    }
}
