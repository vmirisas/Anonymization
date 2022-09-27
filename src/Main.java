import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<PlainData> dataInputList = new ArrayList<PlainData>();

        System.out.println("Choose the data file for encryption");
        String fileLocation = scanner.nextLine();

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileLocation)));
            scanner.useDelimiter("\t");
            scanner.nextLine();
            while(scanner.hasNextLine()) {
//                int id = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String name = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String surname = scanner.next();
//                scanner.skip(scanner.delimiter());
//                String phonenumber = scanner.nextLine();
                String input = scanner.nextLine();
                String[] dataRead = input.split("\t");
                int id = Integer.parseInt(dataRead[0]);
                String name = dataRead[1];
                String surname = dataRead[2];
                String phonenumber = dataRead[3];
                dataInputList.add(new PlainData(id, name, surname, phonenumber));
                System.out.println("Imported id:" + id + ", name:" + name + ", surname:" + surname + ", phone number:" + phonenumber);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(dataInputList.size());
        for (int i = 0; i < dataInputList.size(); i++){
            PlainData d = dataInputList.get(i);
            System.out.println(d);
        }

        try (FileWriter cypheredFile = new FileWriter("cyphered.txt")){

        } catch (IOException e) {
           e.printStackTrace();
        }


    }



}