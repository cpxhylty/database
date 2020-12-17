package pojo;

import java.util.Date;

public class StaffSign {
    private Staff staff;
    private int day;
    private Date date;

    public StaffSign() {

    }

    public int getDay() {
        return day;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
