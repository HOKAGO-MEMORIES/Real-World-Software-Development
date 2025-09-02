package com.hokago_memories.chapter_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// KISS 원칙 사용 -> 코드를 한 개의 클래스로 구현
public class BankTransactionAnalyzerSimple {
    private static final String RESOURCE = "src/main/resources";

    public static void main(final String... args) throws IOException {
        final Path path = Paths.get(RESOURCE + args[0]);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transaction is " + total);
    }
}
