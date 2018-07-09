package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Программа переворачивает каждое слово в веденной строке наоборот
 */

/* Examples:
Введено:
!qwerty, !loki, ?dinero?
Перевернутая строка:
!ytrewq, !ikol, ?orenid?
 */

public class ReverseWordOfString {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите строку!");
        String gotString = reader.readLine();
        String newString = reverseWordOfString(gotString);
        System.out.println("Перевернутая строка: \n" + newString);
    }

    public static String reverseWordOfString(String gotString) {
        String reversedString = "";
        StringBuilder stringBuilder;
        String[] words = gotString.split("[\\W]");
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals("")) {
                String betweenWords[] = gotString.split(words[i], 2);
                stringBuilder = new StringBuilder(words[i]);
                stringBuilder.reverse();
                reversedString = reversedString + betweenWords[0] + stringBuilder;
                gotString = betweenWords[1];
                if (i == words.length - 1) {
                    reversedString = reversedString + betweenWords[1];
                    break;
                }
            }
        }
        return reversedString;
    }
}
