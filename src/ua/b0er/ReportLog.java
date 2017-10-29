package ua.b0er;

import java.io.File;

public class ReportLog {

    public static ReportLog instance = new ReportLog();
    private String currentMessage;
    private Mode currentMode = Mode.WARNING;
    private static String currentFileName;
    private static String pathSettings;

    private ReportLog(){
        currentFileName = Utils.currentDir(this);
        loadConfig();
        createFileName();
    }

    public static ReportLog GetInstance() {
        return instance;
    }

    private void createFileName() {
        FileManager.setDirectory(currentFileName + Utils.getDate() + ".txt");
        FileManager.onCreateFile();
        if(new File(String.valueOf(currentFileName + Utils.getDate() + ".txt")).isFile() == false){
            FileManager.onWriteFile("        ReportLog\n       " + Utils.getDate() + "\n------------------------\n");
        }
    }

    private void loadConfig() {
        String pathlog = currentFileName + "LogProperty.txt";
            File file = new File(String.valueOf(pathlog));
            if (file.isFile() == false) {
                FileManager.setDirectory(pathlog);
                FileManager.onCreateFile();
                FileManager.onWriteFile(Integer.toString(currentMode.getModeId()));
            }
            else{
                currentMode = Mode.values()[FileManager.ReadLog(pathlog)];
            }
    }

    public void writeMessageToFile(String currentMessage, Mode willMode) {
        if(willMode.getModeId() >= currentMode.getModeId())
        FileManager.onWriteFile(currentMessage);
    }
}