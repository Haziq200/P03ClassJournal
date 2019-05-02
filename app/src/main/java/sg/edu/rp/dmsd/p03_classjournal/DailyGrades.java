package sg.edu.rp.dmsd.p03_classjournal;

import java.io.Serializable;

public class DailyGrades implements Serializable {

    private int week;
    private  String grade;
    private String moduleCode;

    public int getWeek() {
        return week;
    }

    public String getGrade(){
      return grade;
    }

    public  String getModuleCode(){
        return moduleCode;
    }

    public DailyGrades(int week, String grade,String moduleCode) {
        this.week = week;
        this.grade = grade;
        this.moduleCode = moduleCode;
    }

}
