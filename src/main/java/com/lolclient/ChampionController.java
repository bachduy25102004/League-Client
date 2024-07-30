package com.lolclient;

import com.lolclient.model.Champion;
import com.lolclient.model.SelectedChampion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChampionController implements Initializable {
    @FXML
    ImageView champImage;

    @FXML
    Button BackBtn;

    @FXML
    Label labelName;

    @FXML
    Label title;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        System.out.println("Init controller");
//        labelName.setText("hehe");
        Champion champion = SelectedChampion.champion;
        labelName.setText(champion.getName());
        Image image = new Image(champion.getImage().replace("champs","splash"));
        champImage.setImage(image);
        title.setText(champion.getTitle());
        BackBtn.setOnMouseClicked(mouseEvent -> {
            System.out.println("back!!!");
            Stage stage = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();

            Scene homeScene;
            FXMLLoader homeSceneLoader = new FXMLLoader(App.class.getResource("hello-view.fxml"));
            try {
                homeScene = new Scene(homeSceneLoader.load(), 1720, 880);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            stage.setScene(homeScene);

        });
    }
}
