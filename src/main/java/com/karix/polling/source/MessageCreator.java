package com.karix.polling.source;


import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageCreator {

    public static String createMessage(String template, SourceEntity entity) {

        // Regular expression to match placeholders like <Param1>, <Param2>, etc.
        String regex = "<Param\\d+>";
        StringBuilder output = new StringBuilder();
        int start = 0;

        Matcher matcher = Pattern.compile(regex).matcher(template);

        while (matcher.find()) {
            // Append the part of the template before the placeholder
            output.append(template, start, matcher.start());

            // Extract the placeholder (e.g., <Param1>)
            String placeholder = matcher.group();

            // Convert to the corresponding entity field name (e.g., <Param1> -> parameter1)
            String fieldName = "parameter" + placeholder.substring(6, placeholder.length() - 1);

            try {
                // Use reflection to get the value of the field from the SourceEntity
                Field field = entity.getClass().getDeclaredField(fieldName);
                field.setAccessible(true); // Allow access to private fields
                Object value = field.get(entity);

                // Replace the placeholder with the field's value
                output.append(value != null ? value.toString() : "");
            } catch (NoSuchFieldException | IllegalAccessException e) {
                // Handle cases where the field does not exist or is inaccessible
                output.append(""); // Leave placeholder empty if field is not found
            }

            // Move the start pointer
            start = matcher.end();
        }

        // Append the remaining part of the template
        output.append(template.substring(start));

        return output.toString();
    }
}
