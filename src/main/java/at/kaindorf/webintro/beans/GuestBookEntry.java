package at.kaindorf.webintro.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuestBookEntry {
    private String nickname;
    private String email;
    private String comment;

    public String toHtmlString(){
        return String.format("<b>%s</b> (%s) says: %s <br/><br/>", nickname, email, comment);
    }
}