package com.lolclient.model;

import com.lolclient.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;

public class EnhancedChampContainer extends VBox {
    private VBox champContainer;

    public EnhancedChampContainer(Champion champion) {

        champContainer = new VBox();
        Image champImage = new Image(champion.getImage(), 283, 283, true, true);
        ImageView champIv = new ImageView(champImage);

        Label championName = new Label(champion.getName());
        championName.setTextFill(Color.FLORALWHITE);
        championName.setFont(new Font("Arial", 16));

        champContainer.getChildren().addAll(champIv, championName);
        champContainer.setAlignment(Pos.CENTER);
        champContainer.setPadding(new Insets(12));

        String musicFile = "src/main/resources/com/lolclient/lol/mouseover.wav";     // For example
        Media sound = new Media(new File(musicFile).toURI().toString());


        champContainer.setOnMouseEntered(mouseEvent -> {
            champContainer.getScene().setCursor(Cursor.HAND);
            champContainer.setBorder(new Border(new BorderStroke(Color.LIGHTGOLDENRODYELLOW, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.setStartTime(new Duration(0));
            mediaPlayer.setVolume(0.1);
            mediaPlayer.play();
        });

        champContainer.setOnMouseExited(mouseEvent -> {
            champContainer.getScene().setCursor(Cursor.DEFAULT);
            champContainer.setBorder(null);
//            mediaPlayer.stop();
        });






        champContainer.setOnMouseClicked(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            FXMLLoader FXMLLoader = new FXMLLoader(App.class.getResource("champion-view.fxml"));
//            String selectedChampionName = champion.getName();

//            VBox container = new VBox();
//            Label champName = new Label(champion.getName());
//            Button backBtn = new Button("Back to home");

//            Scene homeScene;
            SelectedChampion.champion = champion;
            Scene champScene = null;
            try {
                champScene = new Scene(FXMLLoader.load(), 1720, 880);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }



//            container.getChildren().addAll(champName, backBtn);

            if (stage != null) stage.setScene(champScene);


        });
    }

    public VBox getChampContainer() {
        return this.champContainer;
    }


}



