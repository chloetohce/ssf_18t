package sg.edu.nus.iss.ssf_18t.model;

import java.time.LocalDate;

public class Session {
    private String name;

    private LocalDate dob;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    
}
