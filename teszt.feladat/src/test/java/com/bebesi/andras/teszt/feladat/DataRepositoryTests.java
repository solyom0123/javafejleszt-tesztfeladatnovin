package com.bebesi.andras.teszt.feladat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.util.ReflectionTestUtils;
import java.util.ArrayList;
import static org.mockito.Mockito.when;


public class DataRepositoryTests {

    private DataRepository dataRepository = new DataRepository();
    private ArrayList<Integer> emptyList;
    private ArrayList<Integer> filledList;
    private BannedLettersRepository bannedLettersRepository;

    @Before
    public void setup(){
        bannedLettersRepository = Mockito.mock(BannedLettersRepository.class);
        ReflectionTestUtils.setField(dataRepository, "bannedLettersRepository", bannedLettersRepository);
        emptyList= new ArrayList<>();
        filledList = new ArrayList<>();
        filledList.add(97);
        when(bannedLettersRepository.getChars()).thenReturn(emptyList);
    }
    @Test
    public void calculationTest_shallPass() {
        String testWord= "alma";
        Long testLength= 2L;
        Data testData = new Data(testWord,testLength);
        boolean result = dataRepository.isCorrectData(testData);
        Assert.assertEquals(true,result);
    }
    @Test
    public void calculationTest_shallFail() {
        when(bannedLettersRepository.getChars()).thenReturn(filledList);
        String testWord= "alma";
        Long testLength= 2L;
        Data testData = new Data(testWord,testLength);
        boolean result = dataRepository.isCorrectData(testData);
        Assert.assertEquals(false,result);
    }

}