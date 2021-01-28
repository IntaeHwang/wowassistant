package com.ithwang.wowassistant;

public class ProductRecipeHandler {
  static class ProductRecipe{
    int no;
    String productName;
    int materialSize;
    Material[] materials;
  }



  static final int LENGTH = 100;
  static ProductRecipe[] productRecipes = new ProductRecipe[LENGTH];
  static int size = 0;

  static class Material {
    String name;
    int numberOfMaterial;
    int auctionPrice;
    //    Date inputPriceTime;
  }

  static void add() {
    System.out.println("[제작품 레시피 등록]");

    ProductRecipe p = new ProductRecipe();

    p.no = Prompt.inputInt("번호");
    p.productName = Prompt.inputString("제작품 이름");
    p.materialSize = Prompt.inputInt("재료 가지수");
    p.materials = new Material[p.materialSize];

    for (int i = 0; i < p.materialSize; i++) {
      Material m = new Material();

      m.name = Prompt.inputString(String.format("재료%d 이름", i+1));
      m.numberOfMaterial = Prompt.inputInt("필요한 개수");

      p.materials[i] = m;
    }

    productRecipes[size++] = p;
  }

  static void list() {
    System.out.println("[제작품 레시피 목록]");

    if (size == 0) {
      System.out.println("등록된 제작품 레시피가 없습니다.");
    }

    for (int i = 0; i < size; i++) {
      ProductRecipe p = productRecipes[i];

      String materialsString = ""; 
      for (int j = 0; j < p.materialSize; j++) {
        Material m = p.materials[j];
        if (j != 0) {
          materialsString += ", ";
        }
        materialsString += String.format("%s %d개", m.name, m.numberOfMaterial);
      }

      System.out.printf("%d, %s, 재료[%s]\n", p.no, p.productName, materialsString);
    }
  }

  static void makeMoneyInAuction() {
    list();
    if (size == 0) {
      return;
    }
    int command = Prompt.inputInt("레시피 번호 선택(뒤로: 0)",0 , size);

    if (command == 0) {
      return;
    }

    ProductRecipe p = productRecipes[command];
    command = Prompt.inputInt("");
  }
}
