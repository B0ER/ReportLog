package ua.b0er;

import java.io.*;

public class FileManager {
    private static String fullDirectory;

    public static void setDirectory(String directory){
        fullDirectory = directory;
    }

    public static void onCreateFile(){
        try{
            FileWriter writer = new FileWriter(fullDirectory,true);
            writer.close();
        }
        catch (IOException e){
            System.out.println("File not init");
        }
    }

    public static void onWriteFile(String message) {
        try {
                FileWriter writer = new FileWriter(fullDirectory, true);
                writer.write(message);
                writer.close();
        }catch (IOException e){
            System.out.println("Not write message");
        }
    }

    public static int ReadLog(String pathconfig) {

        int c = -1;
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(pathconfig))); //можно было не менять
            c = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (FileNotFoundException e){
            System.out.println("Not fined file");
        } catch (IOException e) {
            System.out.println("File not open");
            e.printStackTrace();
        }
        return c;
    }
}