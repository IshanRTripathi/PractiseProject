package extractJSONFields;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class ExtractKeyFromJsonArray {
    public static void main(String[] args) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String fileName = "/Users/ishanrtripathi/IdeaProjects/SampleProject/src/main/java/extractJSONFields/"; //this path is on my local
        try (BufferedReader fileBufferReader = new BufferedReader(new FileReader(fileName+ "input1.txt"))) {
            String fileLineContent;
            while ((fileLineContent = fileBufferReader.readLine()) != null) {
                stringBuilder.append(fileLineContent);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = (JsonArray) jsonParser.parse(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        StringBuilder finalStringBuilder = stringBuilder;
        jsonArray.forEach(jsonElement -> finalStringBuilder.append(jsonElement.getAsJsonObject().get("jsonPayload").getAsJsonObject().get("message")).append(
            "\n"));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName+"output.txt"));
        writer.write(finalStringBuilder.toString());

        writer.close();
    }
}
