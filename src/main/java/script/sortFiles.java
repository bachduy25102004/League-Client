package script;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class sortFiles {
    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("src/main/resources/com/lolclient/loading/");
        File folder = new File("src/main/resources/com/lolclient/loading/");
        File[] listOfFiles = folder.listFiles();

        ArrayList<String> champions = new ArrayList<>();
        int counter = 1;
        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                String filename = file.getName();
                if (filename.contains("_0.jpg")) {
                    String champ = filename.substring(0, filename.indexOf("_"));
//                    System.out.println(champ);
//                    System.out.println(counter);
//                    counter++;
                    String src = "src/main/resources/com/lolclient/loading/" + file.getName();
                    String des = "src/main/resources/com/lolclient/champs/" + file.getName();
                    Files.copy(new File(src).toPath(), new File(des).toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }
}
