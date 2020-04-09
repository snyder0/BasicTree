import java.io.FileWriter;
import java.io.IOException;

public class fileOut
{
    void writeToFile(String output, boolean append)
    {
        try {
            FileWriter writer = new FileWriter("./output.txt", append);
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
