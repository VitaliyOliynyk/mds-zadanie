package eu.vitaliy.mds.zadanie;

import eu.vitaliy.mds.zadanie.errors.StringInvalidPositionException;

public class StringUtilites {

    public static int indexOf(char[] source, char[] target) {
        int sourceCount = source.length;
        int targetCount = target.length;
        if (targetCount == 0) {
            return 0;
        }

        if (sourceCount == 0) {
            return (targetCount == 0 ? sourceCount : -1);
        }

        if (targetCount == 0) {
            return 0;
        }

        char first = target[0];
        int max = sourceCount - targetCount;

        for (int i = 0; i <= max; i++) {
            if (source[i] != first) {
                while (++i <= max && source[i] != first)
                {
                    /* nothing */
                }
            }

            if (i <= max) {
                int j = i + 1;
                int end = j + targetCount - 1;
                for (int k = 1; j < end && source[j] == target[k]; j++, k++)
                {
                    /*nothing*/
                }

                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static char[] copyRange(char[] from, int offset, int limitIndex) {
       return new String(from, offset, limitIndex - offset ).toCharArray();
    }

    public static int count(char[] chars, char searchChar) {
        int count = 0;
        for (char c : chars) {
            if (c == searchChar) {
                ++count;
            }
        }
        return count;
    }

    public static String substring(String source, int start, int end) {
       int count = source.length();
       if (start == 0 && end == count) {
            return source;
        }
        if (start < 0) {
            throw new StringInvalidPositionException(start);
        } else if (start > end) {
            throw new StringInvalidPositionException(end - start);
        } else if (end > count) {
            throw new StringInvalidPositionException(end);
        }

        return new String(source.toCharArray(), start, end - start);
    }

    public static String[] split(String str, char separatorChar) {

        if (str == null) {
            return null;
        }
        char[] strChars = str.toCharArray();
        int len = strChars.length;
        if (len == 0) {
            return new String[]{""};
        }

        int cnt = count(strChars, separatorChar);
        String[] splittedStr = new String[cnt+1];

        boolean match = false;
        boolean lastMatch = false;
        int i = 0, j = 0, start = 0;
        while (i < len) {
            if (strChars[i] == separatorChar) {

                splittedStr[j++] = StringUtilites.substring(str, start, i);
                match = false;
                lastMatch = true;
                start = ++i;
                continue;
            }
            lastMatch = false;
            match = true;
            i++;
        }
        if (match || lastMatch) {
            splittedStr[j++] =  StringUtilites.substring(str, start, i);
        }

        if (splittedStr.length == 0) {
            splittedStr = new String[]{""};
        }
        return splittedStr;
    }


     public static char[][] toCharArray(String[] cards) {
        char[][] ret = new char[cards.length][];
        for(int i=0;i<cards.length;i++)
        {
            ret[i] = cards[i].toCharArray();
        }
        return ret;
    }
}
