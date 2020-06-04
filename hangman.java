public class hangman{

    public static void ausgabe(int fehlversuch)
    {   String strich = "----+----+----+----+----";
        System.out.println(strich);
        System.out.println();
        switch(fehlversuch){
        case 0: System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("_____ _____"); break;
        case 1: System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("_____|_____");break;
        case 2: System.out.println("");System.out.println("");System.out.println("");System.out.println("");System.out.println("     |   ");System.out.println("_____|_____");break;
        case 3: break;
        case 4: break;
        case 5: break;
        case 6: break;
        case 7: break;
        case 8: break;
        case 9: break;
        case 10: break;
        case 11: break;
        case 12: break;
        }
        System.out.println();
        System.out.println(strich);
    }
    public static void ende(Boolean gewonnen){

    }

    public static void main(String[] args) {
        ausgabe(2);

    }

}