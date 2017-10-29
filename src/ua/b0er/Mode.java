package ua.b0er;

public enum Mode {
    DEBUG(1),
    INFO(2),
    WARNING(3),
    ERROR(4),
    FATAL(5);

    private int modeId;
    Mode(int modeId){
        this.modeId = modeId;
    }

    public int getModeId(){
        return modeId;
    }
}
