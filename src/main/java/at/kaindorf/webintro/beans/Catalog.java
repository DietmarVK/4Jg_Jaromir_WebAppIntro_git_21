package at.kaindorf.webintro.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog {
    @XmlElement(name = "book")
    private List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        File xmlFile = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "book_catalog.xml").toFile();
        Catalog catalog = JAXB.unmarshal(xmlFile, Catalog.class);
        JAXB.marshal(catalog, System.out);
//        catalog.getBooks().forEach(System.out::println);
    }
}
