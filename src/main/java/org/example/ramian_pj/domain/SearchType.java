package org.example.ramian_pj.domain;

import java.util.Arrays;
import java.util.List;

public interface SearchType {


    // member 전용
    String USERNAME = "username";
    String USERID = "userid";
    String USER_TELL = "phone_number";

    static List<String> values() {
        return Arrays.asList(USERNAME, USERID, USER_TELL);
    }
}
