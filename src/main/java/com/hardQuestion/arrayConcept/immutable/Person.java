package com.hardQuestion.arrayConcept.immutable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String fname;
    private String mname;
    private String lname;

}
