package com.reki.seu_blog.util;

import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Utility class for generating URL-friendly slugs
 */
public class SlugUtil {

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    private static final Pattern MULTIPLE_HYPHENS = Pattern.compile("-+");

    /**
     * Converts a string to a URL-friendly slug
     *
     * @param input The string to convert to a slug
     * @return A URL-friendly slug
     */
    public static String createSlug(String input) {
        if (input == null) {
            return "";
        }

        // Convert to lowercase and normalize
        String normalized = Normalizer
                .normalize(input.toLowerCase(Locale.ENGLISH), Normalizer.Form.NFD);

        // Remove accents and non-Latin characters
        String noAccents = NONLATIN.matcher(normalized).replaceAll("");

        // Replace spaces with hyphens
        String noSpaces = WHITESPACE.matcher(noAccents).replaceAll("-");

        // Replace multiple hyphens with a single hyphen
        String result = MULTIPLE_HYPHENS.matcher(noSpaces).replaceAll("-");

        // Trim hyphens from beginning and end
        return result.replaceAll("^-|-$", "");
    }

    /**
     * Checks if the slug already exists and appends a number if necessary
     *
     * @param slug The original slug
     * @param existsFunction A function that checks if a slug already exists
     * @return A unique slug
     */
    public static String ensureUniqueSlug(String slug, java.util.function.Predicate<String> existsFunction) {
        String uniqueSlug = slug;
        int counter = 1;

        while (existsFunction.test(uniqueSlug)) {
            uniqueSlug = slug + "-" + counter;
            counter++;
        }

        return uniqueSlug;
    }
}