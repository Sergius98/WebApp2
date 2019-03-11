package ua.training.controller;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * contains all constants used in the program
 */
public interface IConstants {
    HashMap<String, String> PATHES = Stream.of(new String[][] {
            { "input", "/input" },
            { "table", "/table" },
    }).collect(Collectors.toMap(key -> key[0], value -> value[1], (k1, k2) -> k1,  HashMap::new));

    String[] language_tags_list = {
            "en-US",
            "uk-UA"
    };

    double APPROXIMATION = 1e-2;

    String DEFAULT_PAGE = PATHES.get("input");
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
    String TABLE_PATH = PATHES.get("table");
    String MESSAGE = "MESSAGE";
    String LANGUAGES_LIST = "LANGUAGES_LIST";
    String URL = "URL";
    String TAXES_TABLE = "TAXES_TABLE";
}
