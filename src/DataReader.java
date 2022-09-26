import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataReader {

    private Path dataFileLocation;

    public DataReader(String dataFileLocation) {
        this.dataFileLocation = Paths.get(dataFileLocation);
    }

    public Path getDataFileLocation() {
        return dataFileLocation;
    }

    public void fileCheck(File fileName) {
        InputSpecifier input = "";
        boolean exists = Files.exists(dataFileLocation);
        if (exists){

        } else {
            System.out.println("This file does not exist, choose again");

            input.DataFileSpecification();
        }
    }


}
