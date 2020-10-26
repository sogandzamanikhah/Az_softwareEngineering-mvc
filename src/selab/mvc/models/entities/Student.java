package selab.mvc.models.entities;

import selab.mvc.models.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Student implements Model {
    private String name;
    private String studentNo;
    private Map<Course,Integer> courses = new HashMap<>();

    @Override
    public String getPrimaryKey() {
        return this.studentNo;
    }

    public void addCourses(Course C,int point){
        courses.put(C,point);
    }

    public void setName(String value) { this.name = value; }
    public String getName() { return this.name; }

    public void setStudentNo(String value) {
        if (!validateStudentNo(value))
            throw new IllegalArgumentException("The format is not correct");

        this.studentNo = value;
    }
    public String getStudentNo() { return this.studentNo; }

    public float getAverage() {
        // TODO: Calculate and return the average of the points

        int average = 0;
        for (Integer points : courses.values())
            average += points ;
        average = average/courses.size();
        return average;

    }

    public String getCourses() {
        // TODO: Return a comma separated list of course names
        String course_string = "";

        for (Course courses : courses.keySet())
            course_string += courses.getCourseNo() + "-";
        return course_string;
    }


    /**
     *
     * @param studentNo Student number to be checeked
     * @return true, if the format of the student number is correct
     */
    private boolean validateStudentNo(String studentNo) {
        Pattern pattern = Pattern.compile("^[8-9]\\d{7}$");
        return pattern.matcher(studentNo).find();
    }
}
