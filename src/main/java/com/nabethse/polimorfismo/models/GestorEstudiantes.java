package com.nabethse.polimorfismo.models;

import java.util.ArrayList;

public interface GestorEstudiantes {
    boolean save(Student student);
    void update(Student student);
    ArrayList<Student> getAllStudents();
}

