package com.ithwang.wowassistant;

public class CharacterHandler {

  static class Character{
    int no;
    String serverName;
    String charName;
    String faction;
    String race;
    String charClass;
    String specialization;
    String role;
    int charLevel;
  }

  static final int LENGTH = 150;
  static Character[] characters = new Character[LENGTH];
  static int size = 0;

  static void add() {
    System.out.println("[케릭터 등록]");

    Character c = new Character();

    c.no = Prompt.inputInt("번호");
    c.serverName = Prompt.inputString("서버명");
    c.charName = Prompt.inputString("케릭터명");
    c.faction = Prompt.inputString("진영");
    c.race = Prompt.inputString("종족");
    c.charClass = Prompt.inputString("직업");
    c.specialization = Prompt.inputString("전문화");
    c.role = Prompt.inputString("역할");
    c.charLevel = Prompt.inputInt("캐릭터레벨", 1, 60);

    characters[size++] = c;
    System.out.println("케릭터 등록을 완료 하였습니다.");
  }

  static void list() {
    System.out.println("[케릭터 목록]");

    if (size == 0) {
      System.out.println("등록된 케릭터가 없습니다.");
    }

    for (int i = 0; i < size; i++) {
      Character c = characters[i];
      System.out.printf("%d, %s-%s, %s, %s, %s %s, %s, 레벨: %d\n",
          c.no, c.charName, c.serverName, c.faction, c.race, c.specialization,c.charClass, c.role, c.charLevel);
    }
  }
}
