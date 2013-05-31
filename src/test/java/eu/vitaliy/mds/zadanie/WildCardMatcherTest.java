package eu.vitaliy.mds.zadanie;

import eu.vitaliy.mds.zadanie.matcher.impl.WildCardMatcher;
import eu.vitaliy.mds.zadanie.matcher.IMatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.fest.assertions.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class WildCardMatcherTest {


    private String haystack;
    private String needle;
    private boolean expectedResult;
    private IMatcher matcher;

    public WildCardMatcherTest(String haystack, String needle, boolean expectedResult) {
        this.haystack = haystack;
        this.needle = needle;
        this.expectedResult = expectedResult;
    }

    @Before
    public void before()
    {
       matcher = new WildCardMatcher();
    }

    @Parameterized.Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] {
               {"", "", true},
               { "abcde", "bc", true },
               { "abcde", "ac", false },
               { "abcde", "ab", true },
               { "abcde", "de", true },
               {"abcdefg","b*f", true },
               {"abcdefg","bf", false },
               {"abcdefg","*b*d*f*g*", true },
               {"abcdefg","a*", true },
               {"aXXXbc", "*a*b*c*", true},
               {"a*cdefg","a\\*c", true },
               {"a*cdefg","a\\*c", true },
               {"a*\\cdefg","a\\*\\c", true },
               {"\\a*\\cdefg","\\a\\*\\c", true },
               {"aaa\\\\", "*\\\\*", true}

       };
	   return Arrays.asList(data);
	 }

    @Test
    public void testMatch()
    {
        //given
        boolean result;

        //when
        result = matcher.match(haystack, needle);

        //then
        assertThat(result).isEqualTo(expectedResult);

    }


}
