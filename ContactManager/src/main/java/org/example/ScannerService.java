package org.example;

import lombok.Getter;

import java.util.Scanner;

@Getter
public class ScannerService {
    private final Scanner strScan;
    private final Scanner numScan;

    public ScannerService() {
        strScan = new Scanner(System.in);
        numScan = new Scanner(System.in);
    }
}
