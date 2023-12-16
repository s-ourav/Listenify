package Listenify;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        Album a1=new Album("Arijit album","Arijit Singh");
        a1.addNewSong("Chhanna mereya",5.05f);
        a1.addNewSong("Heeriye",4.06f);
        a1.addNewSong("Apna Bana Le",6.5f);
        a1.addNewSong("Satranga",4.5f);

        Album a2=new Album("Mitraz TOP 5","Mitraz");
        a2.addNewSong("Zehen",3.05f);
        a2.addNewSong("Akhiyaan",7.05f);
        a2.addNewSong("Nadiyon Sa",5.07f);


        List<Song> playlist1 = new ArrayList<> ();

        a1.addToPlaylist(playlist1,3);
        a2.addToPlaylist(playlist1,"Akhiyaan");
        a1.addToPlaylist(playlist1,4);


        int currIdx=0;
        printMenu();
        System.out.println("Now playing "+ playlist1.get(currIdx).toString());

        playPlaylist(playlist1);


    }

    public static void playPlaylist(List <Song> playlist){
        Scanner sc=new Scanner(System.in);

        int currIdx=0;
        boolean quit = false;
        while (!quit) {
            int ch=sc.nextInt();
            switch(ch) {
                case 1 :
                    if( currIdx+1 >playlist.size()-1){
                        currIdx=0;
                    }
                    else currIdx++;
                    System.out.println("Now playing "+ playlist.get(currIdx).toString());
                    break;

                case 2 :
                    if( currIdx-1 <0){
                        currIdx=playlist.size()-1;
                    }
                    else currIdx--;
                    System.out.println("Now playing "+ playlist.get(currIdx).toString());
                    break;

                case 3 :
                    System.out.println("Now playing "+ playlist.get(currIdx).toString());
                    break;

                case 4 :
                    Collections.shuffle(playlist);
                    break;

                case 5 :
                    printMenu();
                    break;

                case 6 :
                    printPlayList(playlist);
                    break;

                case 7 :
                    playlist.remove(currIdx);
                    System.out.println("Song removed successfully");
                    break;

                case 8 :
                    quit=true;
                    break;
            }
        }

    }

    public static void printPlayList(List <Song> playlist){
        for(Song s:playlist){
            System.out.println(s.getName()+" "+s.getDuration());
        }
    }


    public static void printMenu(){

        System.out.println("<<<--------------->>>");
        System.out.println("1. Play the next Song");
        System.out.println("2. Play the previous Song");
        System.out.println("3. Repeat this Song");
        System.out.println("4. Shuffle the playList");
        System.out.println("5. Print the menu !!");
        System.out.println("6. Print PlayList");
        System.out.println("7. Delete the current Song");
        System.out.println("8. Exit the System");
        System.out.println("<<<--------------->>>");
        System.out.println("Enter your choice");

    }
}