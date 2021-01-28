package com.ithwang.wowassistant;

import java.sql.Date;
import java.util.Scanner;

public class Prompt {
  static Scanner keyboardScan = new Scanner(System.in);

  static String inputString(String title) {
    System.out.println(title);
    System.out.print("> ");
    return keyboardScan.nextLine();
  }

  static int inputInt(String title) {
    return Integer.parseInt(inputString(title));
  }

  static int inputInt(String title, int min, int max) {
    int inputNumber = inputInt(title);

    while (true) {
      if (min > inputNumber || max < inputNumber) {
        System.out.printf("잘못 입력하셨습니다.(유효범위: %d ~ %d)\n", min, max);
        inputNumber = inputInt(title);
      } else {
        break;
      }
    }

    return inputNumber;
  }

  static Date inputDate(String title) {
    return Date.valueOf(inputString(title));
  }

  static void close() {
    keyboardScan.close();
  }
}
