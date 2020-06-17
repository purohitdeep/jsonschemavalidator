package com.deep;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;


public class JSONSchemaUnitTest {

    @Test(expected = ValidationException.class)
    public void givenInvalidInput_whenValidating_thenInvalid() {

        JSONObject jsonSchema = new JSONObject(new JSONTokener(JSONSchemaUnitTest.class.getResourceAsStream("/talentForAll-schema.json")));
        JSONObject jsonSubject = new JSONObject(new JSONTokener(JSONSchemaUnitTest.class.getResourceAsStream("/invalid_t4a.json")));

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
    }

    @Test
    public void givenValidInput_whenValidating_thenValid() {

        JSONObject jsonSchema = new JSONObject(new JSONTokener(JSONSchemaUnitTest.class.getResourceAsStream("/talentForAll-schema.json")));
        JSONObject jsonSubject = new JSONObject(new JSONTokener(JSONSchemaUnitTest.class.getResourceAsStream("/valid_t4a.json")));

        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
    }
}