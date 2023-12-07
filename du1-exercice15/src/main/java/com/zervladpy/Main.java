package com.zervladpy;

public class Main {

    static final String[] words = {
            "Texto #3",
            "abcABC1",
            "vxpdylY .ph",
            "vv.xwfxo.fd"
    };

    public static void main(String[] args) {

        for (String word : words) {

            ProcessBuilder processBuilder = new ProcessBuilder();

            String[] command = {
                    "java",
                    "/workspaces/Psp-DAM/du1-exercice15/src/main/java/com/zervladpy/Encoder.java",
                    word
            };

            processBuilder.command(command);

            try {
                processBuilder.inheritIO();
                processBuilder.start();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
