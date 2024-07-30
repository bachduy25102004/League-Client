package com.lolclient.model;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.File;

public class ChampContainer extends VBox {
    private VBox champContainer;
    public ChampContainer(ImageView champIv, Label championName) {

        champContainer = new VBox();

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

//        champContainer.setOnMouseClicked(mouseEvent -> {
//
//        });


    }
    public VBox getChampContainer() {return this.champContainer;}


}
