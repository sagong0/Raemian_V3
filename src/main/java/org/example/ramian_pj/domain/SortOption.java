package org.example.ramian_pj.domain;

import java.util.Arrays;
import java.util.List;

public interface SortOption {
    String userName = "username";
    String userId = "userid";
    String created_At = "created_at";

    static List<String> values(){
        return Arrays.asList(userName, userId, created_At);
    }
}
