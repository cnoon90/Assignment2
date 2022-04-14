
package assign2;

import java.io.*;
import java.util.Scanner;

public class Assign2 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Dictionary di = new Dictionary();
        Scanner scan = new Scanner(System.in);
        
        File file = new File("/Users/Owner/wordList.txt");
        BufferedReader read = new BufferedReader(new FileReader(file));
        String line;
        while((line = read.readLine()) != null){
            di.add(line," ");
        }
       
        String option = "";
        
        while(!"6".equals(option)){
            System.out.println("------------------------");
            System.out.println("1:Add New Word");
            System.out.println("2:Delete Word");
            System.out.println("3:Get Meaning");
            System.out.println("4:Dictionary List");
            System.out.println("5:Spell Chack a file");
            System.out.println("6:Exit");
            System.out.println("------------------------");
            
            System.out.println("Enter a menu option(1-6):");
            option = scan.nextLine();
            System.out.println("------------------------");
            
            if("1".equals(option)){
                System.out.println("Enter a word: ");
                String word = scan.nextLine();
        
                System.out.println("Enter it's meaning: ");
                String meaning = scan.nextLine();
            
                di.add(word.toLowerCase(), meaning);
            }
            else if("2".equals(option)){
                System.out.println("Enter a word to Delete:");
                String deleteString = scan.nextLine();
                di.delete(deleteString);
            }
            else if("3".equals(option)){
                System.out.println("Enter a word to find meaning:");
                String meaningString = scan.nextLine();
                System.out.println(di.getMeaning(meaningString));
            }
            else if("4".equals(option)){
                di.printDictionary();
            }
            else if("5".equals(option)){
                System.out.println("Enter a text file:");
                String in = scan.nextLine();
                File fi = new File(in);
                BufferedReader rea = new BufferedReader(new FileReader(fi)); 
                String line2;
                int count;
                while((line2=rea.readLine())!=null){
                    if(!di.exists(line2)){
                        System.out.println(line2);
                    }
                }
            }
        }
    }
    
}
