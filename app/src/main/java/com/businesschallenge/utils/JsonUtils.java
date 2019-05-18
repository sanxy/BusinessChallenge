package com.businesschallenge.utils;


import com.businesschallenge.model.Business;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {
    private static final String NAME = "name";
    private static final String MAIN_NAME = "mainName";
    private static final String DESCRIPTION = "description";
    private static final String IMAGE = "image";

    public static Business parseBusinessJson(String json) {
        try {
            JSONObject jsonData = new JSONObject(json);
            JSONObject names = jsonData.getJSONObject(NAME);
            String mainName = names.getString(MAIN_NAME);

            // Description
            String description = jsonData.getString(DESCRIPTION);

            // Image
            String image = jsonData.getString(IMAGE);

            // Return Business data
            return new Business(
                    mainName,
                    description,
                    image
            );

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
