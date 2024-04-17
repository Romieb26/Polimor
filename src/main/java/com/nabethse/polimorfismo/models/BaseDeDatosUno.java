package com.nabethse.polimorfismo.models;

import java.util.ArrayList;

public class BaseDeDatosUno implements GestorEstudiantes {
    private ArrayList<Student> students = new ArrayList<>();

    @Override
    public boolean save(Student student) {
       return students.add(student);
    }

    @Override
    public void update(Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getMatricula() == student.getMatricula()) {
                students.set(i, student);
                break;
            }
        }
    }

    @Override
    public ArrayList<Student> getAllStudents() {
        return students;
    }
}

