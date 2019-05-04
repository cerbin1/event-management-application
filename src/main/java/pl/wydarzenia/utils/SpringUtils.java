package pl.wydarzenia.utils;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public class SpringUtils {
    public static Locale getActualLocale() {
        return LocaleContextHolder.getLocale();
    }
}
