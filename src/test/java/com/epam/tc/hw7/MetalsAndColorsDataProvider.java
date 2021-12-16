package com.epam.tc.hw7;

import com.epam.tc.hw7.entities.MetalsAndColorsDataEntity;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.testng.annotations.DataProvider;

public class MetalsAndColorsDataProvider {
    private static final String JSON_DATA_SET =
        "src/test/resources/com/epam/tc/hw7/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "JSON Data Provider")
    public static Object[][] getMetalColorData() throws FileNotFoundException {
        JsonObject metalsColorsData = (JsonObject) JsonParser.parseReader(new FileReader(JSON_DATA_SET));

        Gson gson = new Gson();

        return metalsColorsData.keySet()
                               .stream()
                               .map(key -> gson.fromJson(metalsColorsData.get(key), MetalsAndColorsDataEntity.class))
                               .map(value -> new MetalsAndColorsDataEntity[]{value})
                               .toArray(Object[][]::new);
    }

}
