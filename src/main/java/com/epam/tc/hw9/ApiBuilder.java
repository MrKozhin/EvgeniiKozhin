package com.epam.tc.hw9;

import java.util.HashMap;
import java.util.Map;

public class ApiBuilder {
    public Map<String, String> params = new HashMap<>();

    public ApiBuilder setBoardName(String name) {
        params.put("name", name);
        return this;
    }

    public ApiBuilder setDescription(String description) {
        params.put("desc", description);
        return this;
    }

    public ApiBuilder setBackground(String color) {
        params.put("prefs_background", color);
        return this;
    }

    public ApiBuilder updBackground(String color) {
        params.put("prefs/background", color);
        return this;
    }


}
