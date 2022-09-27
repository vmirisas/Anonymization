import java.io.*;
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

        try (BufferedWriter cypheredFile = new BufferedWriter(new FileWriter("cyphered.txt")))
        {
            cypheredFile.write("ID" + "\t" + "NAME" + "\t" + "SURNAME" + "\t" + "PHONE_NUMBER"+ "\n");
            for (PlainData plainData : dataInputList){
                cypheredFile.write(plainData.getId() + "\t" + plainData.getName() + "\t" + plainData.getSurname() + "\t" + plainData.getPhonenumber() + "\n");
            }
        } catch (IOException e) {
           e.printStackTrace();
        }

    }

}