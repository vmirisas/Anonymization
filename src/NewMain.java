import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class NewMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> dataFields = new ArrayList<>();
        HashMap<String, String[]> dataInputList = new HashMap<>();

        System.out.println("Choose the data file for encryption");
        String fileLocation = scanner.nextLine();

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileLocation)));
            String fields = scanner.nextLine();
            String[] fieldsToSeparate = fields.split("\t");
            for (String field : fieldsToSeparate) {
                dataFields.add(field);
            }

            while(scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] dataRead = input.split("\t");
                String id = dataRead[0];
                String name = dataRead[1];
                String surname = dataRead[2];
                String phonenumber = dataRead[3];
                dataInputList.put;
                System.out.println("Imported id:" + id + ", name:" + name + ", surname:" + surname + ", phone number:" + phonenumber);

            }
        }catch (IOException e) {
            e.printStackTrace();
    }
}
