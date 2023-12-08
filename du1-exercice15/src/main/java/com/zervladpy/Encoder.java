package com.zervladpy;

import java.lang.StringBuilder;

/**
 * You have been asked to build a simple encryption program that reads one line
 * of the standard input. This program should be able to create a coded message
 * without someone been able to read it. The process is very simple. It is
 * divided into two parts.
 * 
 * First, each uppercase or lowercase letter must be shifted three positions to
 * the right, according to the ASCII table: letter 'a' should become letter 'd',
 * letter 'y' must become the character '|' and so on. Second, the line must be
 * reversed. After being reversed, all characters from the half on (truncated)
 * must be moved one position to the left in ASCII. In this case, 'b' becomes
 * 'a' and 'a' becomes '`'.
 * 
 * For example, if the resulting word of the first part is "tesla", the letters
 * "sla" should be moved one position to the left. However, if the resulting
 * word of the first part is "t#$A", the letters "$A" are to be displaced.
 * 
 * The coded message should be displayed to the standard output.
 * 
 * Create a new program to launch the previous program several times. This
 * program has to read the messages to cypher from a file (the name of the file
 * should be an argument) and launch the previous program for each message in a
 * line.
 * 
 * Example of messages to cypher:
 * Texto #3
 * abcABC1
 * vxpdylY .ph
 * vv.xwfxo.fd
 * 
 * Example of cyphered messages:
 * 3# rvzgV
 * 1FECedc
 * ks. \n{frzx
 * gi.r{hyz-xx
 *
 */
public class Encoder {

    static final int SHIFT = 3;
    static final int TRUNCATE = 1;

    public static void main(String[] args) {

        String word = args[0];

        String encryptedWord = truncate(reverse(encodeShift(word)));

        System.out.println("Original word: " + word + System.lineSeparator() + "Encrypted word: " + encryptedWord);
        System.out.println();
    }

    static String encodeShift(String message) {

        StringBuilder builder = new StringBuilder();

        for (char letter : message.toCharArray()) {

            if (Character.isLetter(letter)) {
                builder.append((char) ((int) letter + SHIFT));

            } else {
                builder.append(letter);
            }
        }

        return builder.toString();
    }

    static String reverse(String message) {

        StringBuilder builder = new StringBuilder();

        for (int i = message.length() - 1; i >= 0; i--) {
            builder.append(message.charAt(i));
        }

        return builder.toString();
    }

    static String truncate(String message) {

        StringBuilder builder = new StringBuilder();

        int half = message.length() / 2;

        char[] messageSplitted = message.toCharArray();

        for (int i = 0; i < messageSplitted.length; i++) {
            if (i >= half) {
                builder.append((char) ((int) messageSplitted[i] - TRUNCATE));
            } else {
                builder.append(messageSplitted[i]);
            }
        }

        return builder.toString();
    }

}
