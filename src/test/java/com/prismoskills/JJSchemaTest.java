package com.prismoskills;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.reinert.jjschema.v1.JsonSchemaFactory;
import com.github.reinert.jjschema.v1.JsonSchemaV4Factory;

@RunWith(Parameterized.class)
public class JJSchemaTest {

    private final Class<?> type;
    private final JsonSchemaFactory jjSchemaFactory;

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

    public JJSchemaTest(Class<?> type) {
        jjSchemaFactory = new JsonSchemaV4Factory();
        this.type = type;
    }

    @Test
    public void basicSchemaTest() throws Exception {
        System.out.println("\n\n// " + type.getCanonicalName());
        JsonNode jjSchema = jjSchemaFactory.createSchema(type);
        System.out.println(jjSchema);
    }
}
