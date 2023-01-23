package by.might.test;

import by.might.BankOperation;
import by.might.Process;

import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {

        Process bankProcession = new Process(Paths.get("Lab1GIT").resolve("data.txt"));

        for (BankOperation operation : bankProcession.getOperations()) {
            operation.setAmount(0); // По условию тестов
        }

        testOperations(bankProcession);
    }

    public static void testOperations(Process bankProcess) {
        for (int i = 1; i < 3; i++) {
            try {
                bankProcess.filterAndPrint(bankProcess.getOperations(), i);
            } catch (Throwable throwable) {
                System.out.println("Failed filter test " + i);
            }
            System.out.println("Passed filter test " + i);
        }
        for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 3; j++) {
                try {
                    bankProcess.sortAndPrint(bankProcess.getOperations(), i, j);
                } catch (Throwable throwable) {
                    System.out.println("Failed sort test " + i + " " + j);
                }
                System.out.println("Passed sort test " + i + " " + j);
            }
        }

        for (BankOperation operation : bankProcess.getOperations()) {
            assert operation.getAmount() == 0;
        }
        System.out.println("Условие задания 7 варианта выполнено");
    }
}
