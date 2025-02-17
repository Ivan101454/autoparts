package by.ivan101454.catalogue.enums;

import lombok.Getter;

@Getter
public enum Country {
    ENGLAND("T"), JAPAN("J"), USA("1"), AUSTRALIA("A"), GERMANY("6");
    private final String code;
    Country(String code) {
        this.code = code;
    }
}
