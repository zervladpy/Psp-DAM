package com.zervladpy;

/**
 * Create a program to print Hello World called Greeting.
 * 
 * Create another program to call the recently created Greeting.
 */
public class Caller {
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder();

        String classpath = System.getProperty("java.class.path");

        String[] command = { "java", "-cp", classpath, "com/zervladpy/Greeting" };

        System.out.println(classpath);

        pb.command(command);
        try {
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
