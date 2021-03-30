import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static Scanner input = new Scanner(System.in);
  public static ArrayList<Soldier> myTeam = new ArrayList<Soldier>();

  public static ArrayList<Soldier> enemyTeam = new ArrayList<Soldier>();

  public static void main(String[] args) {
    System.out.println("Hello world!");

    createTeam();

    initiateBattle();
  }


  //adds the selcted soldiers to each team
  public static void createTeam(){
    System.out.println("Select the two members you would like in your squad:");
    System.out.println("0) MK-III");
    System.out.println("1) Glock 26");

    for(int i = 0; i < 2; i++){
      int userSelect = input.nextInt();
      input.nextLine();
      if(userSelect == 0){
        myTeam.add(new MkIII());
      }else if(userSelect == 1){
        myTeam.add(new Glock26());
      }
    }
    

    enemyTeam.add(new MkIII());
    enemyTeam.add(new MkIII());
  }

  //initiates and carries out the battle
  public static void initiateBattle(){
    System.out.println("Battle Beginning");
    while(true){
      //user Selection
      System.out.println("What would you like to do?");
      System.out.println("0) Attack");
      System.out.println("1) Repair Kit");

      int userSelect = input.nextInt();
      input.nextLine();

      //user actions
      //attack
      if(userSelect == 0){
        System.out.println("Who would you like to fire upon?");
        for(int i = 0; i < enemyTeam.length(); i++){
          System.out.println(i + ") " + enemyTeam.get(i));
        }

        int enemySelect = input.nextInt();

        Soldier selected = enemyTeam.get(enemySelect);
  
        System.out.println("Firing!");
        int attack = myTeam.get(enemySelect).attack();
        selected.damage(attack);
        System.out.println("Enemy Now has " + selected.getCurrentHp() + "hp");
      }

      //win condition
      if(enemyTeam.get(0).getCurrentHp() < 0){
        System.out.println("You have Won");
        break;
      }


      //enemy actions
      //enemy attack
      System.out.println("Enemy Firing! Incoming!");
      int enemyAttack = enemyTeam.get(0).attack();
      myTeam.get(0).damage(enemyAttack);
      System.out.println("We now have " + myTeam.get(0).getCurrentHp());


      //win condition
      if(myTeam.get(0).getCurrentHp() < 0){
        System.out.println("You have Lost");
        break;
      }
    }
   
  }
}