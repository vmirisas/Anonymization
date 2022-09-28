import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        ArrayList<String> dataFields = new ArrayList<>();
        ArrayList<PlainData> dataInputList = new ArrayList<PlainData>();

        System.out.println("Choose the data file for encryption");
        String fileLocation = scanner.nextLine();

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(fileLocation)));
            scanner.useDelimiter("\t");
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
                dataInputList.add(new PlainData(id, name, surname, phonenumber));
                System.out.println("Imported id:" + id + ", name:" + name + ", surname:" + surname + ", phone number:" + phonenumber);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(dataInputList.size());
        for (PlainData data : dataInputList) {
            System.out.println(data);
        }

        System.out.println("Choose the configuration file");
//        String configureFileLocation = scanner.nextLine();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String configureFileLocation = null;
        try {
            configureFileLocation = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



//        try (BufferedReader configurationReader = new BufferedReader(new FileReader(configFileLocation))) {
//            //configuredFields.add(configurationReader.readLine().split("\t"));
//            configurationReader.
//            String configurableFields = configurationReader.readLine();
//            configuredFields.add(configurableFields.split("\t"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ArrayList<String> configuredFields = new ArrayList<>();
        try {
            Scanner configurationReader = new Scanner(new BufferedReader(new FileReader(configureFileLocation)));

            String configurableField = configurationReader.next();
            configuredFields.add(configurableField);
        } catch (IOException e) {
            e.printStackTrace();
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

        //printing the columns that can be encrypted
        for (String dataField : dataFields) {
            System.out.println(dataField);
        }
        System.out.println(dataFields.size());
        System.out.println(dataFields);

        for (String configuredField : configuredFields) {
            System.out.println(configuredField);
        }
        System.out.println(configuredFields.size());

//        System.out.println(fieldsIndexes.size());
//        for (int fieldIndex : fieldsIndexes) {
//            System.out.println(fieldIndex);
//        }

    }



}