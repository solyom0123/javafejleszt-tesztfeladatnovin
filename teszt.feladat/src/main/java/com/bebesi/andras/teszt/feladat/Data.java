package com.bebesi.andras.teszt.feladat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Bebesi András
 * @apiNote It stores incoming and out coming value and length data.
 */

@lombok.Data
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Data {
    /**
     * Value: a string, which will be examined by length
     */
    private String value;
    /**
     * length: it determines how much chars can be in value from same char maximum to be possible accept the value
     */
    private Long length;
}
