package ua.training.controller.Cookies;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.training.controller.IConstants;

import javax.servlet.http.Cookie;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class LanguageCookieManagerTest {

    static LanguageCookieManager manager = new LanguageCookieManager();

    @Test
    public void getCookie() {
        Cookie[] cookies = new Cookie[]{new Cookie("name", "value"),
                new Cookie("name2", "uk-UA"),
                new Cookie("name3", "en-US"),
                new Cookie("name4", "value2")};
        assertEquals("en-US", manager.getCookie(cookies, "name"));
        assertEquals("uk-UA", manager.getCookie(cookies, "name2"));
        assertEquals("en-US", manager.getCookie(cookies, "name3"));
        assertNotEquals("value2", manager.getCookie(cookies, "name4"));
    }

    @Test
    public void getDefaultValue() {
        assertEquals(IConstants.DEFAULT_LANGUAGE, manager.getDefaultValue());
        assertNotEquals(IConstants.DEFAULT_FIELD_VALUE, manager.getDefaultValue());
    }

    @Test
    public void isValidValue() {
        assertTrue(manager.isValidValue("uk-UA"));
        assertTrue(manager.isValidValue("en-US"));
        assertFalse(manager.isValidValue("uk-RU"));
    }
}