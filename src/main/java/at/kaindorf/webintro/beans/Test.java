package at.kaindorf.webintro.beans;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        GuestBookEntry entry1 = new GuestBookEntry("james", "bond@16.uk", "Martini");
        GuestBookEntry entry2 = new GuestBookEntry("Q", "q@16.uk", "Take care");
        GuestBookEntry[] entries = {entry1, entry2};
        List<GuestBookEntry> entryList = Arrays.stream(entries).collect(Collectors.toList());
        GuestBookEntry[] entryArray = entryList.stream().toArray(GuestBookEntry[]::new);
        entryList.forEach(System.out::println);
        System.out.println("----");
        entryList = entryList.stream().filter(e -> e.getEmail().contains("bond")).collect(Collectors.toList());
        entryList.removeIf(e -> !e.getEmail().contains("bond"));
        entryList = entryList.stream().sorted((e1, e2) -> e1.getNickname().compareTo(e2.getNickname())).collect(Collectors.toList());
        entryList.sort(Comparator.comparing(GuestBookEntry::getNickname).thenComparing(GuestBookEntry::getEmail).reversed());
        // entryList.sort(Comparator.naturalOrder());
        entryList.forEach(System.out::println);
    }
}