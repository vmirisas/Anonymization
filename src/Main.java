import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, PlainData> dataLines = new HashMap<Integer, PlainData>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose the data file for encryption");
        String fileLocation = scanner.nextLine();
        try {
            scanner = new Scanner(new FileReader(fileLocation));
            scanner.useDelimiter("\t");
            while(scanner.hasNextLine()) {
                int id = scanner.nextInt();
                scanner.skip(scanner.delimiter());
                String name = scanner.next();
                scanner.skip(scanner.delimiter());
                String surname = scanner.next();
                scanner.skip(scanner.delimiter());
                String phonenumber = scanner.nextLine();
                System.out.println("Imported id:" + id + ", name:" + name + ", surname:" + surname + ", phone number:" + phonenumber);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (FileWriter cypheredFile = new FileWriter("cyphered.txt")){

        } catch (IOException e) {
           e.printStackTrace();
        }


    }



}