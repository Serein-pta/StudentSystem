package studentsystem;

import java.util.FormatFlagsConversionMismatchException;

public class Class extends Student {
    private String major;

    public Class() {
    }

    public Class(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        int len = major.length();
        if(len < 2 ||len >15){
            throw new NameFormatException(major + "格式有误，长度应该是3~15");
        }
        this.major = major;
    }

    public String toString() {
        return "Class{major = " + major + "}";
    }

}
