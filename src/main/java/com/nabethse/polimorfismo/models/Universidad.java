package com.nabethse.polimorfismo.models;

import java.util.ArrayList;

public class Universidad {
    private GestorEstudiantes bd1;
    private GestorEstudiantes bd2;
    private GestorEstudiantes bd3;

    private ArrayList<Student> students = new ArrayList<>();

    public boolean save(Student student) {
        students.add(student);
        return false;
    }

    public void update(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getMatricula() == student.getMatricula()) {
                students.set(i, student);
                break;
            }
        }
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }
}


