package com.lolclient;

import com.lolclient.model.ChampContainer;
import com.lolclient.model.Champion;
import com.lolclient.model.EnhancedChampContainer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;


public class Controller implements Initializable {
    @FXML
    VBox abc;
    @FXML
    GridPane gridContainer;
    @FXML
    ScrollPane scrollPane;
    @FXML
    ImageView lol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/com/lolclient/data/champion.json");
            Scanner sc = new Scanner(fis);

            StringBuilder sb = new StringBuilder();
            while (sc.hasNext()) {
                sb.append(sc.nextLine());
            }
            JSONObject json = new JSONObject(sb.toString());
            JSONObject data = (JSONObject) json.get("data");

            ArrayList<Champion> champions = new ArrayList<Champion>();

            ArrayList<String> sortedKeys = new ArrayList<String>(data.keySet());
            Collections.sort(sortedKeys);
            abc.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
            gridContainer.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
            scrollPane.setStyle("-fx-background-color: transparent;");
            scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

            String filePath = "file:src/main/resources/com/lolclient/champs/";
            for (String key : sortedKeys) {
                JSONObject champ = (JSONObject) data.get(key);

                String name = (String) champ.get("name");
                String image = filePath + key + "_0.jpg";
                String title = champ.getString("title");

                JSONArray tagsJSON = (JSONArray) champ.get("tags");
                String[] tags = new String[tagsJSON.length()];

                for (int i = 0; i < tagsJSON.length(); i++) {
                    tags[i] = tagsJSON.get(i).toString();
                }

                champions.add(new Champion(key, name, title, tags, image));
            }

            int champIndex = 0;

            int row = 0;
            int col = 0;

            while (champIndex < champions.size()) {
                EnhancedChampContainer champContainer = new EnhancedChampContainer(champions.get(champIndex));

                gridContainer.add(champContainer.getChampContainer(), col, row);
                champIndex++;

                col++;
                if (col > 8) {
                    col = 0;
                    row++;
                }
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public void archive() {
        File folder = new File("src/main/resources/com/lolclient/champs/");
        File[] listOfFiles = folder.listFiles();

        assert listOfFiles != null;
        Arrays.sort(listOfFiles);

        int fileIndex = 0;
        int row = 0;
        int col = 0;

        abc.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        gridContainer.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        scrollPane.setStyle("-fx-background-color: transparent;");
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);


        while (fileIndex < listOfFiles.length) {


            String filePath = "file:src/main/resources/com/lolclient/champs/" + listOfFiles[fileIndex].getName();
            String name = listOfFiles[fileIndex].getName().substring(0, listOfFiles[fileIndex].getName().lastIndexOf("_"));


            Label championName = new Label(name);
            Image splashArt = new Image(filePath, 300, 300, true, true);
            championName.setTextFill(Color.FLORALWHITE);
            championName.setFont(new Font("Arial", 16));
            ImageView champIv = new ImageView(splashArt);
            ChampContainer ChampContainer = new ChampContainer(champIv, championName);
            gridContainer.add(ChampContainer.getChampContainer(), col, row);

            fileIndex++;
            col++;
            if (col > 4) {
                col = 0;
                row++;
            }


            ChampContainer.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
//            HashMap<dataType, dataType> id = new HashMap<>();
//            id.put(key, value);
//            replace


        }
    }
}