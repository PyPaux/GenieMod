import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GenieMod{

    public static void main(String[] args) {
        if(args.length == 1){
            try{
                String res = "";
                String tmp = "";
                FileReader f = new FileReader("./Placez ici votre fichier a convertir/"+args[0]);
                Scanner sc = new Scanner(f);
                while(sc.hasNextLine()){
                    tmp = sc.nextLine();
                    for(int i = 0; i < tmp.length(); i ++){
                        if(tmp.charAt(i) == 'm'){
                            res = res + 'b';
                        }else if(tmp.charAt(i) == 'M'){
                            res = res + 'B';
                        }else if(tmp.charAt(i) == 'b'){
                            res = res + 'm';
                        }else if(tmp.charAt(i) == 'B'){
                            res = res + 'M';
                        }else{
                            res = res + tmp.charAt(i);
                        }
                    }
                }
                sc.close();
                try{
                    FileWriter wr = new FileWriter("./resultat.txt");
                    wr.write(res);
                    wr.close();
                }catch(IOException e){
                    System.out.println("Chokbar de bz , ya bcp trop de m et de b");
                }
            }catch(FileNotFoundException e){
                System.out.println("Fichier introuvable");
            }
        }else{
            System.out.println("Incorrect arguments");
        }
    }
}