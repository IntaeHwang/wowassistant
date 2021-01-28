package com.ithwang.wowassistant;

import java.sql.Date;

public class MemberHandler {
  static class Member{
    int no;
    String name;
    String email;
    String password;
    String photo;
    String phone;
    Date registeredDate;
  }

  static final int LENGTH = 100;
  static Member[] members = new Member[LENGTH];
  static int size = 0;

  static void add() {
    System.out.println("[회원 등록]");

    Member m = new Member();

    m.no = Prompt.inputInt("번호");
    m.name = Prompt.inputString("이름");
    m.email = Prompt.inputString("이메일");
    m.password = Prompt.inputString("암호");
    m.photo = Prompt.inputString("사진");
    m.phone = Prompt.inputString("전화");
    m.registeredDate = new java.sql.Date(System.currentTimeMillis());

    members[size++] = m;
    System.out.println("회원 등록을 완료 하였습니다.");
  }

  static void list() {
    System.out.println("[회원 목록]");
    
    if (size == 0) {
      System.out.println("등록된 회원이 없습니다.");
    }

    for (int i = 0; i < size; i++) {
      Member m = members[i];
      System.out.printf("%d, %s, %s, %s, %s\n",
          m.no, m.name, m.email, m.phone, m.registeredDate);
    }
  }
}
