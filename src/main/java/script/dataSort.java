package script;

import com.lolclient.model.Champion;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class dataSort {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("src/main/resources/com/lolclient/data/champion.json/");
        Scanner sc = new Scanner(fis);
        StringBuilder content = new StringBuilder();
        while (sc.hasNext()) {
            String line = sc.nextLine();
            content = content.append(line);
        }
        String dataString = content.toString();
//        System.out.println(data);
        JSONObject json = new JSONObject(dataString);
//        System.out.println(json.get("data"));
//        System.out.println(((JSONObject) json.get("data")).get("Aatrox"));
//        JSONObject aatrox = (JSONObject) ((JSONObject) json.get("data")).get("Aatrox");
//        System.out.println(aatrox.get("tags"));
        JSONObject data = (JSONObject) json.get("data");
//        JSONObject data = new JSONObject(json.get("data").toString());
//        System.out.println(data);
//        System.out.println(data);
        ArrayList<String> champions = new ArrayList<>(data.keySet());
        int counter =1;
        ArrayList<Champion> championList = new ArrayList<>();
        for (String champion : champions) {
            JSONObject champ = (JSONObject) data.get(champion);
            String name = (String) champ.get("name");
            String title = (String) champ.get("title");
String id = (String) champ.get("id");
            String image = champion + "_0.jpg";
            JSONArray tags = ((JSONArray) champ.get("tags"));


//            championList.add(new Champion(id, name, title, tags, image  ));

        }

//        for (Champion : championList) {
//            System.out.println(champion);
        }

//        JSONObject Aatrox = (JS);
//        String[] roles = (String[]) Aatrox.get("tags");
//        System.out.println(roles.toString());



    }

