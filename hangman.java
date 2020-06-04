import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class hangman{
    public static Boolean Spielan = true;

    public static void ende(Boolean gewonnen) {
        if (gewonnen){
            Spielan = false;
            System.out.println("HURA, Gewonnen");
        }
        else {
            Spielan = false;
            System.out.println("OHJE, du wurdest gehängt");
        }
    }

    public static String picaword(int lvl){
        String[] level = {"","lvl1.txt","lvl2.txt","lvl3.txt"};
        File file = new File(level[lvl]);

        ArrayList<String> worte=new ArrayList<String>();
        if (!file.canRead() || !file.isFile())
        System.exit(0);

        BufferedReader in = null;
    try {
        in = new BufferedReader(new FileReader(level[lvl]));
        String zeile = null;
        while ((zeile = in.readLine()) != null) {
            worte.add(zeile);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (in != null)
            try {
                in.close();
            } catch (IOException e) {
            }
    }
    int random = (int)(Math.random()*worte.size());
    return worte.get(random);
       
    }

    public static void ausgabe(int fehlversuch) {
        String strich = "----+----+----+----+----";
        System.out.println(strich);
        System.out.println();
        switch (fehlversuch) {
            case 0:
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("_____ _____");
                break;
            case 1:
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("_____|_____");
                break;
            case 2:
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("     |   ");
                System.out.println("_____|_____");
                break;
            case 3:
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("     |   ");
                System.out.println("     |   ");
                System.out.println("_____|_____");
                break;
            case 4:
                System.out.println("");
                System.out.println("");
                System.out.println("     |   ");
                System.out.println("     |   ");
                System.out.println("     |   ");
                System.out.println("_____|_____");
                break;
            case 5:
                System.out.println("");
                System.out.println("     |   ");
                System.out.println("     |   ");
                System.out.println("     |   ");
                System.out.println("     |   ");
                System.out.println("_____|_____");
                break;
            case 6:
                System.out.println("     _____");
                System.out.println("     |   ");
                System.out.println("     |   ");
                System.out.println("     |   ");
                System.out.println("     |   ");
                System.out.println("_____|_____");
                break;
            case 7:
                System.out.println("     _____");
                System.out.println("     |/  ");
                System.out.println("     |   ");
                System.out.println("     |   ");
                System.out.println("     |   ");
                System.out.println("_____|_____");
                break;
            case 8:
                System.out.println("     _____");
                System.out.println("     |/  |");
                System.out.println("     |   ");
                System.out.println("     |   ");
                System.out.println("     |   ");
                System.out.println("_____|_____");
                break;
            case 9:
                System.out.println("     _____");
                System.out.println("     |/  |");
                System.out.println("     |   O");
                System.out.println("     |   ");
                System.out.println("     |   ");
                System.out.println("_____|_____");
                break;
            case 10:
                System.out.println("     _____");
                System.out.println("     |/  |");
                System.out.println("     |   O");
                System.out.println("     |   |");
                System.out.println("     |   ");
                System.out.println("_____|_____");
                break;
            case 11:
                System.out.println("     _____");
                System.out.println("     |/  |");
                System.out.println("     |   O");
                System.out.println("     |   |");
                System.out.println("     |   ^");
                System.out.println("_____|_____");
                break;
            case 12:
                System.out.println("     _____");
                System.out.println("     |/  |");
                System.out.println("     |   O");
                System.out.println("     |  `|´");
                System.out.println("     |   ^");
                System.out.println("_____|_____");
                ende(false);
                break;
        }
        System.out.println();
        System.out.println(strich);
        System.out.print("Versuche übrig: ");
        System.out.println(12-fehlversuch);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Gebe eine Schwierigkeit zwischen 1 und 3 an");
        
        String wort = picaword(1).toUpperCase();
        int wortlength = wort.length();
        char[] wortrat = new char[wortlength];
        int fehlversuch = 0;
        while (Spielan)
        {
        System.out.println("Rate einen Buchstaben!");
        String rate1 = s.nextLine().toUpperCase();
        char rate = rate1.charAt(0);
        boolean save = false;
            for(int i=0;i<wort.length();i++)
            {
                if(rate==wort.charAt(i))
                {
                    wortrat[i]= rate;
                    save= true;
                }
            }
            int nixda=0;
            for(int i = 0;i< wortrat.length ;i++)
            {
                System.out.print("|"); System.out.print(wortrat[i]);
                
                if(wortrat[i]==0)
                {
                    nixda++;
                }
            }

            System.out.println();
            if(!save)
            {
                fehlversuch++;
            }
            
            ausgabe(fehlversuch);
            if(nixda==0)
            {
                ende(true);
            }
        }
        
        System.out.println("Danke fürs Spielen!");
        s.close();
    }

}