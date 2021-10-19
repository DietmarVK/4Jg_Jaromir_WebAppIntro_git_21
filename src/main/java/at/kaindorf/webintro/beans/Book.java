package at.kaindorf.webintro.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.io.StringReader;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    @XmlAttribute
    private String id;
    private String author;
    private String title;
    private String genre;
    private Double price;
    @XmlElement(name = "publish_date")
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate publishDate;
    private String description;

    public static void main(String[] args) {
        String bookstr = "<book id=\"bk101\">\n" +
                "        <author>Gambardella, Matthew</author>\n" +
                "        <title>XML Developer's Guide</title>\n" +
                "        <genre>Computer</genre>\n" +
                "        <price>44.95</price>\n" +
                "        <publish_date>2000-10-01</publish_date>\n" +
                "        <description>An in-depth look at creating applications\n" +
                "            with XML.</description>\n" +
                "    </book>";
        Book book1 = JAXB.unmarshal(new StringReader(bookstr), Book.class);
    }
}
