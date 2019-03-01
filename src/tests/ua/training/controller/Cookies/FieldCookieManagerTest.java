package ua.training.controller.Cookies;

import org.junit.Test;
import ua.training.controller.IConstants;

import javax.servlet.http.Cookie;

import static org.junit.Assert.*;

public class FieldCookieManagerTest {
    static FieldCookieManager manager = new FieldCookieManager();

    @Test
    public void getCookie() {
        Cookie[] cookies = new Cookie[]{new Cookie("name", "10.0"),
                new Cookie("name2", "10."),
                new Cookie("name3", "10"),
                new Cookie("name4", ".10")};
        assertEquals("10.0", manager.getCookie(cookies, "name"));
        assertEquals("10.", manager.getCookie(cookies, "name2"));
        assertEquals("10", manager.getCookie(cookies, "name3"));
        assertNotEquals(".10", manager.getCookie(cookies, "name4"));
        assertEquals("0", manager.getCookie(cookies, "name4"));
    }

    @Test
    public void getDefaultValue() {
        assertEquals(IConstants.DEFAULT_FIELD_VALUE, manager.getDefaultValue());
        assertNotEquals(IConstants.DEFAULT_LANGUAGE, manager.getDefaultValue());
    }

    @Test
    public void isValidValue() {
        assertTrue(manager.isValidValue("1.0"));
        assertTrue(manager.isValidValue("1."));
        assertTrue(manager.isValidValue("10"));
        assertFalse(manager.isValidValue(".0"));
        assertFalse(manager.isValidValue("."));
    }
}