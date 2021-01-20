package com.bebesi.andras.teszt.feladat;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Bebesi András.
 */
@RestController
public class ValueExaminerController {

    private final DataRepository dataRepository = new DataRepository();

    /**
     * It filtering the income Data type data
     * @param incomeData Data type list
     * @return the correct data's list
     */
    @PostMapping("/data")
    List<Data> filterData(@RequestBody List<Data> incomeData) {
        return incomeData.stream().filter(data -> dataRepository.isCorrectData(data)).collect(Collectors.toList());
    }
}
