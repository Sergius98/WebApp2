package ua.training.controller;

//import java.util.ArrayList;

public interface IConstants {
    String LANGUAGE = "language";
    String CALCULATOR_PAGE = "view/index.jsp";
    String CALCULATOR_RESULT_PAGE = "view/table.jsp";
    String MESSAGES_LOCALE_BASE_NAME = "resources/messages";
    String DEFAULT_LANGUAGE = "en-US";
    String DEFAULT_FIELD_VALUE = "0";
    String FIELD_REG_EX = "\\d+\\.?\\d*";
    String TAX_LIST = "TAX_LIST";
    String TAX_SUM = "TAX_SUM";
    String TAXES = "TAXES";
    String TABLE_PATH = "/table";
    String MESSAGE = "MESSAGE";
    String LANGUAGES_LIST = "LANGUAGES_LIST";
    String URL = "URL";
    String TAXES_TABLE = "TAXES_TABLE";

    String[] language_tags_list = {"en-US", "uk-UA"};
    // should have properties files in that language and property with the same name in messages properties
    /*ArrayList<String> language_tags_list = new ArrayList<>() {{
        add("en-US");
        add("uk-UA");
    }};*/
}
