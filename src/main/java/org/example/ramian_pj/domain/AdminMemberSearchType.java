package org.example.ramian_pj.domain;

import java.util.Arrays;
import java.util.List;

public interface AdminMemberSearchType {
    // member (ADMIN)전용
    String USERNAME = "name";
    String USERID = "userid";
    String USER_TELL = "phone";

    static List<String> values() {
        return Arrays.asList(USERNAME, USERID, USER_TELL);
    }
}
