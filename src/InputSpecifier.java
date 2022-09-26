import java.util.Scanner;

public class InputSpecifier {


    private String dataFile;
    Scanner scanner = new Scanner(System.in);

    public String DataFileSpecification() {
        System.out.println("Name of the input file to be encrypted: ");
        dataFile = scanner.nextLine();

        return dataFile;
    }




}
