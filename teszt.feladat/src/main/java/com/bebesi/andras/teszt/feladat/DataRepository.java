package com.bebesi.andras.teszt.feladat;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * @author Bebesi András.
 */
public class DataRepository {

    private BannedLettersRepository bannedLettersRepository;

    /**
     * It count the income char amount in the income value
     * @param value String which is contains the all letter
     * @param c Int which is a char code in integer
     * @return Long value which is the found chars number in the world
     */
    private Long getLetterAmountInValue(String value, int c) {
        return StringUtils.isEmpty(value) ? 0L : value.chars().filter(ch -> ch == c).count();
    }

    /**
     * It collects the data from same letters amount in the income world. It make a filter on summery by the actual banned letters.
     * @param value String which is contains the income letters.
     * @return ArrayList which contains amounts of the same letters the income value.
     */
    private ArrayList<Long> getSummaryLettersNumberInValue(String value) {
        bannedLettersRepository = new BannedLettersRepository();
        HashMap<Character, Long> summaryHashMap = new HashMap<>();
        value.chars().forEach(ch -> {
            Long charAmount = summaryHashMap.get(((char) ch));
            if (charAmount == null
                    && (bannedLettersRepository.getChars().stream().filter(bannedChar -> ch == bannedChar).count() == 0)) {
                summaryHashMap.put((char) ch, getLetterAmountInValue(value, ch));
            }

        });
        return new ArrayList<Long>(summaryHashMap.values());
    }

    /**
     * It decided the income value is correct for the system or not.
     * @param data Data type which contains the length and value data.
     * @return true if the world is correct or false if the word is not correct
     */
    public boolean isCorrectData(Data data) {
        ArrayList<Long> summary = getSummaryLettersNumberInValue(data.getValue());
        return summary.stream().filter(aLong -> aLong == data.getLength()).count() > 0;
    }
}
