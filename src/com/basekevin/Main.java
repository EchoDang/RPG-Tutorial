package com.basekevin;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static boolean dead = false;
    static boolean critHit = false;

    public static void main(String[] args) {
        String repeat = "yes";

        do {
            Scanner scan = new Scanner(System.in);
            demoDialogue();
            fightChoice();
            if (dead) {
                System.out.println("System: You defeated the boar!");
                demoQuestComplete();
                pressEnterToContinue();
                System.out.println("System: Congratulations!");
                System.out.println("System: You cleared the quest.");
                pressEnterToContinue();
                System.out.println("Ken: Alan! You did it!");
                System.out.println("Alan: (breathing heavily)");
                pressEnterToContinue();
                System.out.println("System: You drop to the ground and you raise your hand up to give \n" +
                        "Ken a thumbs up.");
                System.out.println("Ken: Wooo! We feast tonight Alan!");
                pressEnterToContinue();
            } else if (!dead){
                System.out.println("System: You have been slaughtered by the boar.");
            }
            System.out.println("System: Do you want to try the demo again?");
            System.out.println("System: Enter yes or no");
            String repeatChoice = scan.nextLine();
            boolean switchRepeat = true;
            while (switchRepeat == true) {
                switch (repeatChoice) {
                    case "yes":
                        repeat = "yes";
                        switchRepeat = false;
                        break;
                    case "no":
                        repeat = "no";
                        switchRepeat = false;
                        break;
                    default:
                        boolean defaultRepeat = true;

                        while (defaultRepeat) {
                            System.out.println("system: Invalid choice.");
                            System.out.println("System: Please enter yes or no");
                            repeatChoice = scan.nextLine();

                            switch (repeatChoice) {
                                case "yes":
                                    repeat = "yes";
                                    defaultRepeat = false;
                                    break;
                                case "no":
                                    repeat = "no";
                                    defaultRepeat = false;
                                    break;
                                default:
                                    defaultRepeat = true;
                            }

                        }
                        break;
                }
            }

        } while (repeat == "yes");

        System.out.println("System: Thanks for playing the demo!");
    }

    public static void demoDialogue() {
        System.out.println("Welcome to the game demo!\n");
        pressEnterToContinue();
        System.out.println("System: You find yourself walking through the woods.");
        pressEnterToContinue();
        System.out.println("???: Alan! Wait up!");
        System.out.println("System: A familiar voice calls out to you.");
        pressEnterToContinue();
        System.out.println("???: Why the rush man?");
        System.out.println("System: The boy running towards you is Ken, your childhood friend");
        pressEnterToContinue();
        System.out.println("Alan: Sorry Ken. I just couldn't help myself.");
        pressEnterToContinue();
        System.out.println("Alan: This is our first mission after all the training we've been through.");
        System.out.println("Alan: How can I not be excited?");
        pressEnterToContinue();
        System.out.println("Ken: I understand that, but we've got to be careful.");
        System.out.println("Ken: This boar is important since it's the festival's main event.");
        pressEnterToContinue();
        System.out.println("Alan: You're right. Let's stick together and get this mission done.");
        System.out.println("Ken: Right behind you.");
        pressEnterToContinue();
        demoQuestInfo();
        pressEnterToContinue();
        System.out.println("System: After walking several minutes in the forest you encounter a boar \n" +
                "that seems different from the rest.");
        System.out.println("Alan: Hey Ken, come here. (whispering)");
        pressEnterToContinue();
        System.out.println("Ken: Whoa that's huge.");
        System.out.println("Alan: We have to be sure, wait for me here.");
        pressEnterToContinue();
        System.out.println("System: You circle around the boar through the thickets and try to get a \n" +
                "better look at its forehead.");
        System.out.println("System: As you begin to circle around, you see the \"X\".");
        pressEnterToContinue();
        System.out.println("System: Your eyes meet with Ken as you try to prepare yourselves.");
        System.out.println("System: You both nod towards each and jump out.");
        pressEnterToContinue();
        System.out.println("Ken: Let's do this Alan!");
        System.out.println("Alan: I'm going in!");
        pressEnterToContinue();
        System.out.println("System: As you dive towards the boar, you notice that it has\n" +
                "its sights on Ken already, but before you can utter a word he's already hit.");
        System.out.println("Ken: Agh!");
        pressEnterToContinue();
        System.out.println("Alan: Ken!");
        System.out.println("System: The boar backs away and prepares itself for another charge.");
        pressEnterToContinue();
        System.out.println("Ken: He messed up my leg Alan! You have to run!");
        System.out.println("Alan: I can't just leave you. Watch my back.");
        pressEnterToContinue();
        System.out.println("System: You decide to face off against the boar by yourself.");
        System.out.println("System: Fight start.");
        pressEnterToContinue();
    }

    public static void pressEnterToContinue() {
        System.out.println("Press Enter to continue...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    public static void demoQuestInfo() {
        System.out.println("System: You have been given a quest from your village elder.");
        System.out.println("---------------------------------------");
        System.out.println("Quest Information: \n" +
                "Slay a boar in the woods.\n" +
                "Boar 0/1\n");

        System.out.println("Mob Description: \n" +
                "The boar is slightly larger than others and bears an \"X\" on it's forehead.");
        System.out.println("---------------------------------------");
    }

    public static void demoQuestComplete() {
        System.out.println("System: Quest updated.");
        System.out.println("---------------------------------------");
        System.out.println("Quest Information: \n" +
                "Slay a boar in the woods.\n" +
                "Boar 1/1\n");

        System.out.println("Mob Description: \n" +
                "The boar is slightly larger than others and bears an \"X\" on it's forehead.");
        System.out.println("---------------------------------------");
    }

    public static boolean fightChoice() {

        int alanHealthPoint = 150;
        int boarHealthPoint = 100;
        int playerDamage;
        int boarDamage;
        int defendDamage = 10;
        int boarDefDamage;
        boolean boarCritHit = false;
        int critStrike = 0;
        int boarCritStrike = 0;

        while(alanHealthPoint > 0 && boarHealthPoint > 0){
            System.out.println("You have " + alanHealthPoint + " health points.");
            System.out.println("The boar has " + boarHealthPoint + " health points.\n");
            System.out.println("1) Slash (10 - 25 damage)\n" +
                    "2) Stab (10 - 20 damage + 50% for critical strike)\n" +
                    "3) Defend (-10 damage)\n");
            Scanner scanner = new Scanner(System.in);

            int fightOption = scanner.nextInt();
            if (fightOption == 1) {
                boarCritChance();
                if (boarCritHit == true) {
                    boarCritStrike = 15;
                }
                else if (boarCritHit == false) {
                    boarCritStrike = 0;
                }
                boarDamage = randomBoarDamage() + boarCritStrike;
                playerDamage = randomSlashDamage();
                System.out.println("You have slashed for " + playerDamage + " damage.");
                pressEnterToContinue();
                System.out.println("The boar tackles you for " + boarDamage + " damage.");
                pressEnterToContinue();
                alanHealthPoint = alanHealthPoint - boarDamage;
                boarHealthPoint = boarHealthPoint - playerDamage;
                System.out.println("boar " + boarHealthPoint);
                System.out.println("alan " + alanHealthPoint);
            }
            else if (fightOption == 2) {
                critChance();
                if (critHit){
                    critStrike = 15;
                }
                else {
                    critStrike = 0;
                }
                playerDamage = randomStabDamage() + critStrike;
                boarCritChance();
                if (boarCritHit == true) {
                    boarCritStrike = 15;
                }
                else if (boarCritHit == false) {
                    boarCritStrike = 0;
                }
                boarDamage = randomBoarDamage() + boarCritStrike;
                System.out.println("You have stabbed for " + playerDamage + " damage.");
                if (critHit){
                    System.out.println("You critically strike for 15 damage!");
                }
                pressEnterToContinue();
                System.out.println("The boar tackles you for " + boarDamage + " damage.");
                pressEnterToContinue();
                alanHealthPoint = alanHealthPoint - boarDamage;
                boarHealthPoint = boarHealthPoint - playerDamage - 15;
                //System.out.println("boar " + boarHealthPoint);
                //System.out.println("alan " + alanHealthPoint);
            }
            else if (fightOption == 3) {
                boarCritChance();
                if (boarCritHit == true) {
                    boarCritStrike = 15;
                }
                else if (boarCritHit == false) {
                    boarCritStrike = 0;
                }
                boarDamage = randomBoarDamage() + boarCritStrike;
                System.out.println("The boar tackles you for " + boarDamage + " damage.");
                System.out.println("You have defended for 10 damage.");
                pressEnterToContinue();
                boarDefDamage = boarDamage - defendDamage;
                System.out.println("You take " + boarDefDamage + " damage.");
                pressEnterToContinue();
                alanHealthPoint = alanHealthPoint - boarDefDamage;
                //System.out.println("boar " + boarHealthPoint);
                //System.out.println("alan " + alanHealthPoint);
            }
            //this else if method is to test when you win faster
            else if (fightOption == 4) {
                playerDamage = 100;
                boarHealthPoint -= playerDamage;
            }
            //this else if method is to test when you  lose faster
            else if (fightOption == 5) {
                boarDamage = 150;
                alanHealthPoint -= boarDamage;
            }
            else {
                System.out.println("System: Invalid choice.");
                pressEnterToContinue();
            }
        }

        if (alanHealthPoint <= 0)
            dead = false;
        else if (alanHealthPoint > 0) {

            if (boarHealthPoint <= 0)
                dead = true;
            else
                dead = false;
        }
        return dead;
    }

    public static int randomSlashDamage() {
        Random rand = new Random();

        int slashDamage = rand.nextInt(16) + 10;
        return slashDamage;
    }

    public static int randomStabDamage(){
        Random rand = new Random();
        int stabDamage = rand.nextInt(11) + 10;
        return stabDamage;
    }

    public static int randomBoarDamage() {
        Random rand = new Random();
        int boarDamage = rand.nextInt( 21) + 15;
        return boarDamage;
    }

    public static boolean critChance() {
        Random rand = new Random();
        int critChance = rand.nextInt(101);
        boolean critHit = false;

        if (critChance >= 35) {
            critHit = true;
        }
        return critHit;
    }

    public static boolean boarCritChance() {
        Random rand = new Random();
        int critChance = rand.nextInt(101) + 20;
        boolean boarCritHit = false;

        if (critChance >= 75) {
            boarCritHit = true;
        }
        return boarCritHit;
    }
}