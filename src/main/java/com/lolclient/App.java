package com.lolclient;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1720, 880);

        stage.setTitle("LOL champions database");

        stage.setScene(scene);
//        stage.initStyle(StageStyle.UNDECORATED);
//        BorderPane borderPane = new BorderPane();
//        borderPane.setStyle("-fx-background-color: white;");
//
//        ToolBar toolBar = new ToolBar();
//
//        int height = 25;
//        toolBar.setPrefHeight(height);
//        toolBar.setMinHeight(height);
//        toolBar.setMaxHeight(height);
//
//        toolBar.getItems().add(new WindowButtons());
//        borderPane.setTop(toolBar);


        stage.show();
    }}

