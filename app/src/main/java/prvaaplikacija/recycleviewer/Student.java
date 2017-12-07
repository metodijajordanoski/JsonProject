package prvaaplikacija.recycleviewer;

/**
 * Created by Mende on 07.12.2017.
 */

public class Student {
    private String sName;
    private Boolean sOnline;

    public Student(String sName, Boolean sOnline) {
        this.sName = sName;
        this.sOnline = sOnline;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public void setsOnline(Boolean sOnline) {
        this.sOnline = sOnline;
    }

    public String getsName() {
        return sName;
    }

    public Boolean getsOnline() {
        return sOnline;
    }
}
