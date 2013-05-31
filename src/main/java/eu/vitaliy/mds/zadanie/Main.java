package eu.vitaliy.mds.zadanie;

import eu.vitaliy.mds.zadanie.matcher.impl.WildCardMatcher;
import eu.vitaliy.mds.zadanie.matcher.IMatcher;

public class Main {
    public static void main(String[] args)
    {
        if(args.length != 2)
        {
           System.out.println("Parameters:\n  <text> <pattern>");
           System.exit(-1);
        }
        IMatcher match = new WildCardMatcher();
        boolean result = match.match(args[0], args[1]);
        System.out.println(result);
    }
}
