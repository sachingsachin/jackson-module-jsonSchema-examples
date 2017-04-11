package com.prismoskills;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jsonSchema.JsonSchema;
import com.fasterxml.jackson.module.jsonSchema.JsonSchemaGenerator;

@RunWith(Parameterized.class)
public class JacksonModuleSchemaTest {

    private final ObjectMapper mapper;
    private final JsonSchemaGenerator schemaGen;
    private final Class<?> type;

    @Parameterized.Parameters
    public static Collection testParams() {
        return Arrays.asList(new Object[][] {
            { SimplePojo.class },
            { CircularList.class },
            { BaseType.class },
            { DerivedType1.class },
            { NonStringMap.class },
            { ExtendingList.class },
            { ExtendingMap.class },
       });
    }

    public JacksonModuleSchemaTest(Class<?> type) {
        mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(Include.NON_NULL);
        schemaGen = new JsonSchemaGenerator(mapper);
        this.type = type;
    }

    @Test
    public void basicSchemaTest() throws Exception {
        System.out.println("\n\n// " + type.getCanonicalName());
        JsonSchema schema = schemaGen.generateSchema(type);
        System.out.println(mapper.writeValueAsString(schema));
    }
}
