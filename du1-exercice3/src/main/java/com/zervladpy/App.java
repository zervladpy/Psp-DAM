package com.zervladpy;

import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a directory path: ");
        String directoryPath = input.nextLine();

        ProcessBuilder pb = new ProcessBuilder();

        String[] commands = { "ls", "-la" };

        if (directoryPath.isEmpty()) {
            directoryPath = System.getProperty("user.dir");
        }

        File processDirectory = new File(directoryPath);

        pb.command(commands);
        pb.directory(processDirectory);

        try {
            pb.inheritIO();
            pb.start();
            System.out.println("Process Directory: " + pb.directory().getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
