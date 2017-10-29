package ua.b0er;

public class NewThreedClass extends Thread{

    public void run() {
        try{

            throw new NumberFormatException();
        }catch (NumberFormatException e)
        {
            ReportLog a = ReportLog.GetInstance();
            int i = 0;
            while(i < 5){
                i++;
            a.writeMessageToFile(i + " NumberFormatException\n", Mode.FATAL);
            }
        }
    }
}
