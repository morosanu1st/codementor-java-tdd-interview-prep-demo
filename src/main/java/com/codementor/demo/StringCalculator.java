package com.codementor.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Classic String Calculator kata — kept tiny for live TDD / pair sessions.
 *
 * Rules (interview-friendly):
 * - Empty string → 0
 * - Comma or newline separators by default
 * - Optional custom delimiter: "//;\n1;2"
 * - Negatives are rejected with a clear message listing all offenders
 */
public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String payload = numbers;
        String delimiterRegex = ",|\\n";

        if (numbers.startsWith("//")) {
            int newline = numbers.indexOf('\n');
            if (newline < 0) {
                throw new IllegalArgumentException("Custom delimiter header must end with a newline");
            }
            String custom = numbers.substring(2, newline);
            delimiterRegex = Pattern.quote(custom);
            payload = numbers.substring(newline + 1);
        }

        if (payload.isEmpty()) {
            return 0;
        }

        String[] parts = payload.split(delimiterRegex);
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;

        for (String part : parts) {
            if (part.isEmpty()) {
                continue;
            }
            int value = Integer.parseInt(part.trim());
            if (value < 0) {
                negatives.add(value);
            } else {
                sum += value;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negatives not allowed: " + negatives);
        }

        return sum;
    }
}
