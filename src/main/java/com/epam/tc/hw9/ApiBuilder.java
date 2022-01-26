package com.epam.tc.hw9;

import java.util.HashMap;
import java.util.Map;

public class ApiBuilder {
    public Map<String, String> params = new HashMap<>();

    public ApiBuilder setName(String name) {
        params.put("name", name);
        return this;
    }
}
