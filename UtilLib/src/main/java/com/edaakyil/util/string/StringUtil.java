/*-------------------------------------------------------------
	FILE		: StringUtil.java
	AUTHOR		: Java-Mar-2023 Group
	Last UPDATE	: 18th May 2024

	Utility class for string operations

	Copyleft (c) 1993 C and System Programmers Association
	All Right Free
-------------------------------------------------------------*/
package com.edaakyil.util.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.random.RandomGenerator;

public final class StringUtil {
    private StringUtil()
    {}

    public static final String LETTERS_EN;
    public static final String LETTERS_TR;
    public static final String CAPITAL_LETTERS_EN;
    public static final String CAPITAL_LETTERS_TR;
    public static final String ALL_LETTERS_TR;
    public static final String ALL_LETTERS_EN;

    static {
        LETTERS_EN = "abcdefghijklmnopqrstuvwxyz";
        LETTERS_TR = "abcçdefgğhıijklmnoöprsştuüvyz";
        CAPITAL_LETTERS_EN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        CAPITAL_LETTERS_TR = "ABCÇDEFGĞHIİJKLMNOÖPRSŞTUÜVYZ";
        ALL_LETTERS_TR = LETTERS_TR + CAPITAL_LETTERS_TR;
        ALL_LETTERS_EN = LETTERS_EN + CAPITAL_LETTERS_EN;
    }

    public static boolean areAllUnique(String str)
    {
        var set = new HashSet<Character>();

        for (var i = 0; i  < str.length(); ++i)
            set.add(str.charAt(i));

        return set.size() == str.length();
    }

    public static boolean areAnagram(CharSequence s1, CharSequence s2)
    {
        var len1 = s1.length();
        var len2 = s2.length();

        if (isBlank(s1) || isBlank(s2) || len1 != len2)
            return false;

        var map = new HashMap<Character, Integer>();

        for (var i = 0; i < len1; ++i) {
            var ch = s1.charAt(i);

            if (!map.containsKey(ch))
                map.put(ch, 1);
            else
                map.put(ch, map.get(ch) + 1);
        }

        for (var i = 0; i < len2; ++i) {
            var ch = s2.charAt(i);
            int count;

            if (!map.containsKey(ch) || (count = map.get(ch)) == 0)
                return false;

            map.put(ch, count - 1);
        }

        for (var v : map.values())
            if (v != 0)
                return false;

        return true;
    }

    public static String capitalize(String s)
    {
        return s.isEmpty() ? "" : Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase();
    }

    public static String changeCase(String s)
    {
        StringBuilder sb = new StringBuilder(s);
        int len = s.length();

        for (int i = 0; i < len; ++i) {
            char c = sb.charAt(i);

            sb.setCharAt(i, Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
        }

        return sb.toString();
    }

    public static boolean containsIgnoreCase(String str, String s, Locale locale)
    {
        return str.toLowerCase(locale).contains(s.toLowerCase(locale));
    }

    public static boolean containsIgnoreCase(String str, String s)
    {
        return containsIgnoreCase(str, s, Locale.getDefault());
    }


    public static int countString(String s1, String s2)
    {
        int count = 0;

        for (int index = 0; (index = s1.indexOf(s2, index)) != -1; ++index, ++count)
            ;

        return count;
    }

    public static int countStringIgnoreCase(String s1, String s2)
    {
        return countString(s1.toLowerCase(), s2.toLowerCase());
    }

    public static String generateRandomText(RandomGenerator randomGenerator, int count, String sourceText)
    {
        StringBuilder sb = new StringBuilder(count);
        int sourceTextLen = sourceText.length();

        for (int i = 0; i < count; ++i)
            sb.append(sourceText.charAt(randomGenerator.nextInt(sourceTextLen)));

        return sb.toString();
    }

    public static String generateRandomTextEN(RandomGenerator randomGenerator, int count)
    {
        return generateRandomText(randomGenerator, count, ALL_LETTERS_EN);
    }

    public static String generateRandomTextTR(RandomGenerator randomGenerator, int count)
    {
        return generateRandomText(randomGenerator, count, ALL_LETTERS_TR);
    }

    public static String [] generateRandomTexts(RandomGenerator randomGenerator, int count, int min, int bound, String sourceText)
    {
        var str = new String[count];

        for (int i = 0; i < count; ++i)
            str[i] = generateRandomText(randomGenerator, randomGenerator.nextInt(min, bound), sourceText);

        return str;
    }

    public static String [] generateRandomTextsTR(RandomGenerator randomGenerator, int count, int min, int bound)
    {
        return generateRandomTexts(randomGenerator, count, min, bound, ALL_LETTERS_TR);
    }

    public static String [] generateRandomTextsEN(RandomGenerator randomGenerator, int count, int min, int bound)
    {
        return generateRandomTexts(randomGenerator, count, min, bound, ALL_LETTERS_EN);
    }

    public static String getFirstLongestPalindrome(String s)
    {
        String result = "";

        int begin = 0;

        while (begin != s.length()) {
            int end = s.length();

            while (begin != end) {
                String str = s.substring(begin, end--);

                if (str.length() >= 2 && isPalindrome(str) && result.length() < str.length())
                    result = str;
            }
            ++begin;
        }

        return result;
    }

    public static String getLastLongestPalindrome(String s)
    {
        String result = "";

        int end = s.length();

        while (end != 0) {
            int begin = 0;

            while (begin != end) {
                String str = s.substring(begin++, end);

                if (str.length() >= 2 && isPalindrome(str) && result.length() < str.length())
                    result = str;
            }
            --end;
        }

        return result;
    }

    public static String getFirstShortestPalindrome(String s)
    {
        String result = s;

        int begin = 0;

        while (begin != s.length()) {
            int end = s.length();

            while (begin != end) {
                String str = s.substring(begin, end--);

                if (str.length() >= 2 && isPalindrome(str) && str.length() < result.length())
                    result = str;
            }
            ++begin;
        }

        return result;

    }

    public static String getLastShortestPalindrome(String s)
    {
        String result = s;

        int end = s.length();

        while (end != 0) {
            int begin = 0;

            while (begin != end) {
                String str = s.substring(begin++, end);

                if (str.length() >= 2 && isPalindrome(str) && str.length() < result.length())
                    result = str;
            }
            --end;
        }

        return result;
    }


    public static String getFirstPangramTR(String s)
    {
        String result = s;

        int begin = 0;

        while (begin != s.length()) {
            int end = s.length();

            while (begin != end) {
                String str = s.substring(begin, end--);

                if (str.length() >= 29 && isPangramTR(str) && str.length() < result.length())
                    result = str;
            }
            ++begin;
        }

        return result;
    }

    public static String getLastPangramTR(String s)
    {
        String result = s;

        int end = s.length();

        while (end != 0) {
            int begin = 0;

            while (begin != end) {
                String str = s.substring(begin++, end);

                if (str.length() >= 29 && isPangramTR(str) && str.length() < result.length())
                    result = str;
            }
            --end;
        }

        return result;
    }

    public static String getFirstPangramEN(String s)
    {
        String result = s;

        int begin = 0;

        while (begin != s.length()) {
            int end = s.length();

            while (begin != end) {
                String str = s.substring(begin, end--);

                if (str.length() >= 26 && isPangramEN(str) && str.length() < result.length())
                    result = str;
            }
            ++begin;
        }

        return result;
    }

    public static String getLastPangramEN(String s)
    {
        String result = s;

        int end = s.length();

        while (end != 0) {
            int begin = 0;

            while (begin != end) {
                String str = s.substring(begin++, end);

                if (str.length() >= 26 && isPangramEN(str) && str.length() < result.length())
                    result = str;
            }
            --end;
        }

        return result;
    }

    public static boolean isBlank(CharSequence s)
    {
        var len = s.length();

        for (var i = 0; i < len; ++i)
            if (!Character.isWhitespace(s.charAt(i)))
                return false;

        return true;
    }

    public static boolean isIdentifier(String s)
    {
        if (s.isBlank() || s.equals("_"))
            return false;

        if (!Character.isJavaIdentifierStart(s.charAt(0)))
            return false;

        int len = s.length();

        for (int i = 1; i < len; ++i)
            if (!Character.isJavaIdentifierPart(s.charAt(i)))
                return false;

        return true;
    }

    public static boolean isNullOrBlank(CharSequence s)
    {
        return s == null || isBlank(s);
    }

    public static boolean isPalindrome(String s)
    {
        int left = 0;
        int right = s.length() - 1;
        boolean result = true;

        while (left < right) {
            char cLeft = Character.toLowerCase(s.charAt(left));

            if (!Character.isLetter(cLeft)) {
                ++left;
                continue;
            }

            char cRight = Character.toLowerCase(s.charAt(right));

            if (!Character.isLetter(cRight)) {
                --right;
                continue;
            }

            if (cLeft != cRight) {
                result = false;
                break;
            }

            --right;
            ++left;
        }

        return result;
    }

    public static boolean isPangram(String s, String alphabet)
    {
        int len = alphabet.length();

        for (int i = 0; i < len; ++i) {
            char c = alphabet.charAt(i);

            if (s.indexOf(c) == -1)
                return false;
        }

        return true;
    }

    public static boolean isPangramEN(String s)
    {
        return isPangram(s.toLowerCase(), LETTERS_EN);
    }

    public static boolean isPangramTR(String s)
    {
        return isPangram(s.toLowerCase(), LETTERS_TR);
    }

    public static String join(String [] str, char separator)
    {
        return join(str, String.valueOf(separator));
    }

    public static String join(String [] str, String separator)
    {
        StringBuilder sb = new StringBuilder();

        for (String s : str)
            sb.append(s).append(separator);

        return sb.substring(0, sb.length() - separator.length());
    }

    public static String join(ArrayList<String> list, String separator)
    {
        StringBuilder sb = new StringBuilder();

        for (String s : list)
            sb.append(s).append(separator);

        return sb.substring(0, sb.length() - separator.length());
    }

    public static String join(ArrayList<String> list, char separator)
    {
        return join(list, String.valueOf(separator));
    }

    public static String padLeading(String s, int len, char ch)
    {
        int length = s.length();

        return len <= length ? s : (ch + "").repeat(len - length) + s;
    }

    public static String padLeading(String s, int len)
    {
        return padLeading(s, len, ' ');
    }

    public static String padTrailing(String s,  int len, char ch)
    {
        int length = s.length();

        return len <= length ? s : s + (ch + "").repeat(len - length);
    }

    public static String padTrailing(String s, int len)
    {
        return padTrailing(s, len, ' ');
    }

    public static String reverse(String s)
    {
        return new StringBuilder(s).reverse().toString();
    }

    public static String [] split(String s, String separators)
    {
        return split(s, separators, false);
    }

    public static String [] split(String s, String separators, boolean removeEmpties)
    {
        StringBuilder regexBuilder = new StringBuilder("[");

        for (int i = 0; i < separators.length(); ++i) {
            char c = separators.charAt(i);

            if (c == ']' || c == '[')
                regexBuilder.append('\\');

            regexBuilder.append(c);
        }

        regexBuilder.append("]");

        if (removeEmpties)
            regexBuilder.append("+");

        return s.split(regexBuilder.toString());
    }

    public static String squeeze(String s1, String s2)
    {
        StringBuilder sb = new StringBuilder();
        int len = s1.length();

        for (int i = 0; i < len; ++i) {
            char c = s1.charAt(i);

            if (!s2.contains(String.valueOf(c)))
                sb.append(c);
        }

        return sb.toString();
    }

    public static String wrapWith(String s, char c)
    {
        return wrapWith(s, String.valueOf(c));
    }

    public static String wrapWith(String s, String str)
    {
        return wrapWith(s, str, str);
    }

    public static String wrapWith(String s, char prefix, char suffix)
    {
        return wrapWith(s, String.valueOf(prefix), String.valueOf(suffix));
    }

    public static String wrapWith(String s, String prefix, String suffix)
    {
        return String.format("%s%s%s", prefix, s, suffix);
    }
}
