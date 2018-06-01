package com.hms.type;

import com.hms.entity.EmployeeInfo;

public enum EmployeeType {
    chief("Chief Doctor",1),
    dupty("Associate Chief Doctor",2),
    attending("Doctor in Charge",3),
    Intern("Intern",5),
    Staff("Staff",4);

    EmployeeType(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    private String name;
    private int rank;


    public static int getValue(String name){
        for(EmployeeType e : EmployeeType.values()) {
            if(e.getName().trim() == name.trim()) {
                return e.rank;
            }
        }
        return 0x999999;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
