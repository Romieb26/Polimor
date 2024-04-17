package com.nabethse.polimorfismo.controllers;

import com.nabethse.polimorfismo.models.BaseDeDatosUno;
import com.nabethse.polimorfismo.models.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button salir;

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, Integer> matriculaColumn;

    @FXML
    private TableColumn<Student, String> nombreColumn;

    @FXML
    private TableColumn<Student, Integer> edadColumn;

    @FXML
    void onClicksalir(MouseEvent event) {
        // Cerrar la ventana actual
    }

    @FXML
    void initialize() {
        assert salir != null : "fx:id=\"salir\" was not injected: check your FXML file 'ver-view.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'ver-view.fxml'.";
        assert matriculaColumn != null : "fx:id=\"matriculaColumn\" was not injected: check your FXML file 'ver-view.fxml'.";
        assert nombreColumn != null : "fx:id=\"nombreColumn\" was not injected: check your FXML file 'ver-view.fxml'.";
        assert edadColumn != null : "fx:id=\"edadColumn\" was not injected: check your FXML file 'ver-view.fxml'.";

        System.out.println("VerController initialize() method called.");

        // Configurar las columnas del TableView
        matriculaColumn.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        edadColumn.setCellValueFactory(new PropertyValueFactory<>("edad"));

        // Cargar y mostrar la lista de alumnos
        cargarListaAlumnos();
    }

    private void cargarListaAlumnos() {
        System.out.println("Cargando lista de alumnos...");
        // Obtener la lista de alumnos de la base de datos
        BaseDeDatosUno baseDeDatos = new BaseDeDatosUno(); // Puedes elegir la base de datos que prefieras aquí
        ArrayList<Student> students = baseDeDatos.getAllStudents();

        // Convertir la lista de alumnos a ObservableList
        ObservableList<Student> observableList = FXCollections.observableArrayList(students);

        // Mostrar la lista de alumnos en el TableView
        tableView.setItems(observableList);
        System.out.println("Lista de alumnos cargada en el TableView.");
    }
}


