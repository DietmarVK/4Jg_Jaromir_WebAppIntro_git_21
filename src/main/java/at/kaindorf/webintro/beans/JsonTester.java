package at.kaindorf.webintro.beans;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class JsonTester {
    public static void main(String[] args) {
        File jsonFile = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "person.json").toFile();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Person[] persons = objectMapper.readValue(jsonFile, Person[].class);
            List<Person> personList = objectMapper.readValue(jsonFile, new TypeReference<List<Person>>() {});
            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(System.out, persons);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
