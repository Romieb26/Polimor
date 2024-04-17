package com.nabethse.polimorfismo.controllers;

import com.nabethse.polimorfismo.HelloApplication;
import com.nabethse.polimorfismo.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class AgregarController {
    // Usamos la interfaz GestorEstudiantes para trabajar con las bases de datos de manera polimórfica
    private GestorEstudiantes baseDeDatosUno = new BaseDeDatosUno();
    private GestorEstudiantes baseDeDatosDos = new BaseDeDatosDos();
    private GestorEstudiantes baseDeDatosTres = new BaseDeDatosTres();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Edad;

    @FXML
    private TextField Matricula;

    @FXML
    private TextField Nombre;

    @FXML
    private Button agregarE;

    @FXML
    private Button salir;

    @FXML
    void onClickagregarE(MouseEvent event) {
        try {
            // Obtener datos del estudiante desde los campos de texto
            String nombre = Nombre.getText();
            int matricula = Integer.parseInt(Matricula.getText());
            int edad = Integer.parseInt(Edad.getText());

            // Crear objeto Student
            Student student = new Student(matricula, nombre, edad);

            // Guardar el estudiante en cada base de datos usando polimorfismo
            baseDeDatosUno.save(student);
            baseDeDatosDos.save(student);
            baseDeDatosTres.save(student);

            // Mostrar mensaje de éxito
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Éxito");
            alert.setHeaderText(null);
            alert.setContentText("Estudiante agregado exitosamente");
            alert.showAndWait();

            // Limpiar los campos de texto después de agregar el estudiante
            Nombre.clear();
            Edad.clear();
            Matricula.clear();
        } catch (Exception e) {
            // Mostrar mensaje de error si ocurre una excepción
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se pudo agregar al estudiante");
            alert.showAndWait();
        }
    }

    @FXML
    void onClicksalir(MouseEvent event) {
        // Cerrar la ventana actual
        HelloApplication.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Edad != null : "fx:id=\"Edad\" was not injected: check your FXML file 'agregar-view.fxml'.";
        assert Matricula != null : "fx:id=\"Matricula\" was not injected: check your FXML file 'agregar-view.fxml'.";
        assert Nombre != null : "fx:id=\"Nombre\" was not injected: check your FXML file 'agregar-view.fxml'.";
        assert agregarE != null : "fx:id=\"agregarE\" was not injected: check your FXML file 'agregar-view.fxml'.";
        assert salir != null : "fx:id=\"salir\" was not injected: check your FXML file 'agregar-view.fxml'.";

    }
}
