import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> dataFields = new ArrayList<>();
        ArrayList<String> dataValues = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

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
                String[] dataValuesString = input.split("\t");
                for(String dataValue : dataValuesString){
                    dataValues.add(dataValue);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int counter = dataFields.size();

        //=========================  creating and populating the column arrays with their data  ========================

        ArrayList<String> idArray = new ArrayList<>();
        for (int i = dataFields.size()-counter; i < dataValues.size(); i+=dataFields.size()) {
            idArray.add(dataValues.get(i));
        }
        counter = counter - 1;

        ArrayList<String> nameArray = new ArrayList<>();
        for (int i = dataFields.size()-counter; i < dataValues.size(); i+=dataFields.size()) {
            nameArray.add(dataValues.get(i));
        }
        counter = counter - 1;

        ArrayList<String> surnameArray = new ArrayList<>();
        for (int i = dataFields.size()-counter; i < dataValues.size(); i+=dataFields.size()) {
            surnameArray.add(dataValues.get(i));
        }
        counter = counter - 1;

        ArrayList<String> phoneNumberArray = new ArrayList<>();
        for (int i = dataFields.size()-counter; i < dataValues.size(); i+=dataFields.size()) {
            phoneNumberArray.add(dataValues.get(i));
        }

        HashMap<String, String[]> idColumn = new HashMap<>();
        idColumn.put(dataFields.get(0), idArray.toArray(new String[0]));

        HashMap<String, String[]> nameColumn = new HashMap<>();
        nameColumn.put(dataFields.get(1), nameArray.toArray(new String[0]));

        HashMap<String, String[]> surnameColumn = new HashMap<>();
        surnameColumn.put(dataFields.get(2), surnameArray.toArray(new String[0]));

        HashMap<String, String[]> phoneNumberColumn = new HashMap<>();
        phoneNumberColumn.put(dataFields.get(3), phoneNumberArray.toArray(new String[0]));


        System.out.println("Choose the configuration file");
//        String configureFileLocation = scanner.nextLine();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String configureFileLocation = null;
        try {
            configureFileLocation = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ArrayList<String> configuredFields = new ArrayList<>();
        try {
            Scanner configurationReader = new Scanner(new BufferedReader(new FileReader(configureFileLocation)));
            String fieldsToConfigureString = configurationReader.nextLine();
            String[] fieldsToSeparateFromConfigureFile = fieldsToConfigureString.split("\t");
            for (String field : fieldsToSeparateFromConfigureFile) {
                configuredFields.add(field);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Write the encrypted values to a .txt file
        try (BufferedWriter cypheredFile = new BufferedWriter(new FileWriter("cyphered.txt")))
        {
            cypheredFile.write("ID" + "\t" + "NAME" + "\t" + "SURNAME" + "\t" + "PHONE_NUMBER"+ "\n");
            for (int i = 0; i < dataValues.size()/ dataFields.size(); i++){
                cypheredFile.write(Arrays.toString(idColumn.get(i)) + "\t" + Arrays.toString(nameColumn.get(i)) + "\t" + Arrays.toString(surnameColumn.get(i)) + "\t" + Arrays.toString(phoneNumberColumn.get(i)) + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println(Arrays.toString(idColumn.get("id")));
        System.out.println(Arrays.toString(nameColumn.get("name")));
        System.out.println(Arrays.toString(surnameColumn.get("surname")));
        System.out.println(Arrays.toString(phoneNumberColumn.get("phonenumber")));
//        System.out.println(dataFields);
//        System.out.println(dataFields.size());
//
//        System.out.println(dataValues);
//        System.out.println(dataValues.size());
//
//        System.out.println(idArray);
//        System.out.println(idArray.size());
//
//        System.out.println(nameArray);
//        System.out.println(surnameArray);
//        System.out.println(phoneNumberArray);




    }



}