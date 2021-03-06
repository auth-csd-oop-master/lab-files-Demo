import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String outFile = "outfile.txt";

        // create and write
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(outFile))) {
            buffer.write("test");
            buffer.newLine();
            buffer.write("test2");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // open and append
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(outFile, true))) {
            buffer.write("test3");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //open for read
        try (BufferedReader buffer = new BufferedReader(new FileReader(outFile))) {
            String line = buffer.readLine();
            System.out.println(line.length());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // write binary
        List<String> list = Arrays.asList("george", "maria");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("binary.dat"))) {
            oos.writeObject(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //load binary
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("binary.dat"))) {
            list = (List<String>) oos.readObject();
            System.out.println(list);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}
