package ua.training.servlet;

import java.util.ArrayList;

public interface IConstants {
    String LANGUAGE = "language";
    String CALCULATOR_PAGE = "view/index.jsp";
    String RESULT_PAGE = "view/index.jsp";
    String MESSAGES_LOCALE_BASE_NAME = "resources/messages";
    String DEFAULT_LANGUAGE = "en-US";
    String DEFAULT_FIELD_VALUE = "0";
    String FIELD_REG_EX = "\\d+\\.?\\d*";

    // should have properties files in that language and property with the same name in messages properties
    ArrayList<String> language_tags_list = new ArrayList<String>() {{
        add("en-US");
        add("uk-UA");
    }};
}
