package com.nabethse.polimorfismo.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.nabethse.polimorfismo.HelloApplication;
import com.nabethse.polimorfismo.models.BaseDeDatosDos;
import com.nabethse.polimorfismo.models.BaseDeDatosTres;
import com.nabethse.polimorfismo.models.BaseDeDatosUno;
import com.nabethse.polimorfismo.models.Student;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EditarController {
    protected BaseDeDatosUno baseDeDatosUno = new BaseDeDatosUno();
    protected BaseDeDatosDos baseDeDatosDos =new BaseDeDatosDos();
    protected BaseDeDatosTres baseDeDatosTres = new BaseDeDatosTres();
    @FXML
    private TextField Edad;

    @FXML
    private TextField Matricula;

    @FXML
    private TextField Nombre;

    @FXML
    private Button editar;

    @FXML
    private Button salir;

    @FXML
    void onClickeditar(MouseEvent event) {
        try {
            String nombre = Nombre.getText();
            int matricula = Integer.parseInt(Matricula.getText());
            int edad = Integer.parseInt(Edad.getText());
            Student student = new Student(matricula,nombre,edad);

            baseDeDatosUno.update(student);
            baseDeDatosDos.update(student);
            baseDeDatosTres.update(student);
            Alert alert = new  Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Hecho");
            alert.setHeaderText(null);
            alert.setContentText("Editado con exito");
            alert.showAndWait();

            Nombre.clear();
            Edad.clear();
            Matricula.clear();
        }
        catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se ha podido editar al estudiante");
            alert.showAndWait();
        }
    }

    @FXML
    void onClicksalir(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

}
