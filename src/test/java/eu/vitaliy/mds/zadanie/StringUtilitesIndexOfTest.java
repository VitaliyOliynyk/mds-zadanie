package eu.vitaliy.mds.zadanie;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.fest.assertions.Assertions.assertThat;

@RunWith(value = Parameterized.class)
public class StringUtilitesIndexOfTest {

    private String haystack;
    private String needle;
    private int expectedResult;
   // private BoyerMoore boyerMoore;

    public StringUtilitesIndexOfTest(String haystack, String needle, Integer expectedResult) {
        this.haystack = haystack;
        this.needle = needle;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
	 public static Collection<Object[]> data() {
	   Object[][] data = new Object[][] {
               {"", "", 0},
               { "abcde", "bc", 1 },
               { "abcde", "ac", -1 },
               { "abcde", "ab", 0 },
               { "abcde", "de", 3 }

       };
	   return Arrays.asList(data);
	 }

    @Before
    public void before()
    {
       //boyerMoore = new BoyerMoore(needle);
    }

    @Test
    public void testMatch()
    {
        //given
        int result;
        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();

        //when
        result = StringUtilites.indexOf(haystackChar, needleChar);

        //then
        assertThat(result).isEqualTo(expectedResult);

    }

}
