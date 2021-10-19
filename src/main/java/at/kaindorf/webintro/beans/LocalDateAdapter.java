package at.kaindorf.webintro.beans;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-LL-dd");
    @Override
    public LocalDate unmarshal(String s) throws Exception {
        if(s == null) {
            return null;
        }
        return LocalDate.parse(s, DTF);
    }

    @Override
    public String marshal(LocalDate localDate) throws Exception {
        if(localDate == null) {
            return "";
        }
        return DTF.format(localDate);
    }
}
