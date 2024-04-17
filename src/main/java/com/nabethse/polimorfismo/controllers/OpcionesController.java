package com.nabethse.polimorfismo.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.nabethse.polimorfismo.HelloApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class OpcionesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregar;

    @FXML
    private Button editar;

    @FXML
    private Button salir;

    @FXML
    private Button ver;

    @FXML
    void onClickagregar(MouseEvent event) {
        HelloApplication.newStage("agregar-view","AGREGAR");
    }

    @FXML
    void onClickeditar(MouseEvent event) {
        HelloApplication.newStage("editar-view","EDITAR");
    }

    @FXML
    void onClicksalir(MouseEvent event) {
        HelloApplication.getStageView().close();
    }

    @FXML
    void onClickver(MouseEvent event) {
        HelloApplication.newStage("ver-view","VER");
    }

    @FXML
    void initialize() {
        assert agregar != null : "fx:id=\"agregar\" was not injected: check your FXML file 'opciones-view.fxml'.";
        assert editar != null : "fx:id=\"editar\" was not injected: check your FXML file 'opciones-view.fxml'.";
        assert salir != null : "fx:id=\"salir\" was not injected: check your FXML file 'opciones-view.fxml'.";
        assert ver != null : "fx:id=\"ver\" was not injected: check your FXML file 'opciones-view.fxml'.";

    }

}
