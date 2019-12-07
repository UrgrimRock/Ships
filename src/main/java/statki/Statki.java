package statki;

import java.util.Random;
import java.util.Scanner;

public class Testy {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    int length = 10;
    int sheaps = 2;
    String statek = "$ ";
    String hit = "X ";
    String miss = "O ";
    String hidden = ". ";
    String [][] realBoard = new String[length][length];
    String [][] seeBoard = new String[length][length];
    public  void Display(){

        for (int i = 0; i < length; i++) {
            for (int j = 0; j <length; j++) {
                realBoard[i][j] = hidden;
                seeBoard[i][j] = hidden;
            }
        }
        for (int i = 0; i < sheaps;) {
            int dupa1 = rand.nextInt(10);
            int dupa2 = rand.nextInt(10);
            if (!realBoard[dupa1][dupa2].equals(statek)){
                realBoard[dupa1][dupa2] = statek;
                i++;
            }
        }
        boolean game = true;
        while(game){
            int move = 0;
            System.out.println("Menu:\n1:Graj\n2:Wyświetl planszę\n3:Exit");
            int menuChoice = scanner.nextInt();
            if (menuChoice==1) {

                System.out.println("Podaj dwie lizby od 0-9");
                int fLocation = scanner.nextInt();
                int sLocation = scanner.nextInt();
                if (realBoard[fLocation][sLocation].equals(statek)) {
                    seeBoard[fLocation][sLocation] = hit;
                    realBoard[fLocation][sLocation] = hit;
                    sheaps--;
                }
                else if (realBoard[fLocation][sLocation].equals(miss)||realBoard[fLocation][sLocation].equals(hit)){
                    System.out.println("To już było!");
                }
                else {
                    seeBoard[fLocation][sLocation] = miss;
                    realBoard[fLocation][sLocation] = miss;
                }
                displaySea();
                if (sheaps==0){
                    System.out.println("Wygrałeś w "+ move+" ruchach.");
                    game=false;
                }
            }
            else if (menuChoice==2){
                displayReal();

            }
            else if (menuChoice==3){
                game=false;
            }
        }
    }
    public void displayReal(){
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(realBoard[i][j]);
            }
            System.out.println();
        }
    }
    public void displaySea(){
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(seeBoard[i][j]);
            }
            System.out.println();
        }

    }

}
