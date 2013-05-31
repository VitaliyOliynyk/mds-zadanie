package eu.vitaliy.mds.zadanie.matcher.impl;

import eu.vitaliy.mds.zadanie.StringUtilites;
import eu.vitaliy.mds.zadanie.matcher.IMatcher;


public class WildCardMatcher implements IMatcher {
    @Override
    public boolean match(String text, String pattern) {
        String[] cards = StringUtilites.split(pattern, '*');
        char[] textChars = text.toCharArray();
        char[][] cardsCharArray = StringUtilites.toCharArray(cards);

        for (char[] card : cardsCharArray) {
            int idx = StringUtilites.indexOf(textChars, card);

            if (idx == -1 && card[card.length-1] != '\\' ) {
                return false;
            }

            textChars = StringUtilites.copyRange(textChars, idx + card.length, textChars.length );

        }

        return true;
    }






}
