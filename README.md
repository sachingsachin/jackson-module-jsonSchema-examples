# jackson-module-jsonSchema-examples
Examples for jackson-module-jsonSchema and JJSchema

## Interesting constructs

1. Circular references
2. Non-String Maps
3. Java polymorphism (Base obj = new Derived)
4. Classes extending Lists and Maps
5. UUID, Date, LocalDateTime etc.


## Sample Run

Running com.prismoskills.SchemaTest
```javascript
// com.prismoskills.SimplePojo
{
  "type" : "object",
  "id" : "urn:jsonschema:com:prismoskills:SimplePojo",
  "dependencies" : { },
  "patternProperties" : { },
  "properties" : {
    "data" : {
      "type" : "integer",
      "enum" : [ ]
    }
  },
  "enum" : [ ],
  "oneOf" : [ ]
}


// com.prismoskills.CircularList
{
  "type" : "object",
  "id" : "urn:jsonschema:com:prismoskills:CircularList",
  "dependencies" : { },
  "patternProperties" : { },
  "properties" : {
    "data" : {
      "type" : "integer",
      "enum" : [ ]
    },
    "prev" : {
      "type" : "object",
      "$ref" : "urn:jsonschema:com:prismoskills:CircularList"
    },
    "next" : {
      "type" : "object",
      "$ref" : "urn:jsonschema:com:prismoskills:CircularList"
    }
  },
  "enum" : [ ],
  "oneOf" : [ ]
}


// com.prismoskills.BaseType
{
  "type" : "object",
  "id" : "urn:jsonschema:com:prismoskills:BaseType",
  "dependencies" : { },
  "patternProperties" : { },
  "properties" : {
    "data" : {
      "type" : "integer",
      "enum" : [ ]
    },
    "types" : {
      "type" : "array",
      "items" : {
        "type" : "object",
        "$ref" : "urn:jsonschema:com:prismoskills:BaseType"
      },
      "enum" : [ ],
      "oneOf" : [ ]
    }
  },
  "enum" : [ ],
  "oneOf" : [ ]
}


// com.prismoskills.DerivedType1
{
  "type" : "object",
  "id" : "urn:jsonschema:com:prismoskills:DerivedType1",
  "dependencies" : { },
  "patternProperties" : { },
  "properties" : {
    "data" : {
      "type" : "integer",
      "enum" : [ ]
    },
    "types" : {
      "type" : "array",
      "items" : {
        "type" : "object",
        "id" : "urn:jsonschema:com:prismoskills:BaseType",
        "dependencies" : { },
        "patternProperties" : { },
        "properties" : {
          "data" : {
            "type" : "integer",
            "enum" : [ ]
          },
          "types" : {
            "type" : "array",
            "items" : {
              "type" : "object",
              "$ref" : "urn:jsonschema:com:prismoskills:BaseType"
            },
            "enum" : [ ],
            "oneOf" : [ ]
          }
        },
        "enum" : [ ],
        "oneOf" : [ ]
      },
      "enum" : [ ],
      "oneOf" : [ ]
    },
    "foo" : {
      "type" : "integer",
      "enum" : [ ]
    }
  },
  "enum" : [ ],
  "oneOf" : [ ]
}


// com.prismoskills.NonStringMap
{
  "type" : "object",
  "id" : "urn:jsonschema:com:prismoskills:NonStringMap",
  "dependencies" : { },
  "patternProperties" : { },
  "properties" : {
    "data" : {
      "type" : "integer",
      "enum" : [ ]
    },
    "map" : {
      "type" : "object",
      "additionalProperties" : {
        "type" : "object",
        "id" : "urn:jsonschema:com:prismoskills:Bar",
        "dependencies" : { },
        "patternProperties" : { },
        "properties" : {
          "value" : {
            "type" : "string",
            "enum" : [ ]
          }
        },
        "enum" : [ ],
        "oneOf" : [ ]
      },
      "dependencies" : { },
      "patternProperties" : { },
      "properties" : { },
      "enum" : [ ],
      "oneOf" : [ ]
    }
  },
  "enum" : [ ],
  "oneOf" : [ ]
}

// com.prismoskills.ExtendingList
{
  "type" : "array",
  "items" : {
    "type" : "integer",
    "enum" : [ ]
  },
  "enum" : [ ],
  "oneOf" : [ ]
}


// com.prismoskills.ExtendingMap
{
  "type" : "object",
  "additionalProperties" : {
    "type" : "integer",
    "enum" : [ ]
  },
  "dependencies" : { },
  "patternProperties" : { },
  "properties" : { },
  "enum" : [ ],
  "oneOf" : [ ]
}


// Running com.prismoskills.JJSchemaTest

// com.prismoskills.SimplePojo
{"type":"object","properties":{"data":{"type":"integer"}}}


// com.prismoskills.CircularList
{"type":"object","properties":{"data":{"type":"integer"},"next":{"$ref":"#"},"prev":{"$ref":"#"}}}


// com.prismoskills.BaseType
{"type":"object","properties":{"data":{"type":"integer"},"types":{"type":"array","items":{"$ref":"#"}}}}


// com.prismoskills.DerivedType1
{"type":"object","properties":{"data":{"type":"integer"},"foo":{"type":"integer"},"types":{"type":"array","items":{"type":"object","properties":{"data":{"type":"integer"},"types":{"type":"array","items":{"$ref":"#/properties/types/items"}}}}}}}


// com.prismoskills.NonStringMap
basicSchemaTest[4](com.prismoskills.JJSchemaTest)  Time elapsed: 0.003 sec  <<< ERROR!
java.lang.StringIndexOutOfBoundsException: String index out of range: 0
	at java.lang.String.charAt(String.java:658)
	at com.github.reinert.jjschema.v1.PropertyWrapper.firstToLowerCase(PropertyWrapper.java:374)
	at com.github.reinert.jjschema.v1.PropertyWrapper.processPropertyName(PropertyWrapper.java:369)
	at com.github.reinert.jjschema.v1.PropertyWrapper.getName(PropertyWrapper.java:147)
	at com.github.reinert.jjschema.v1.PropertyWrapper.<init>(PropertyWrapper.java:82)
	at com.github.reinert.jjschema.v1.CustomSchemaWrapper.processProperties(CustomSchemaWrapper.java:151)
	at com.github.reinert.jjschema.v1.CustomSchemaWrapper.<init>(CustomSchemaWrapper.java:76)
	at com.github.reinert.jjschema.v1.SchemaWrapperFactory.createWrapper(SchemaWrapperFactory.java:67)
	at com.github.reinert.jjschema.v1.PropertyWrapper.<init>(PropertyWrapper.java:126)
	at com.github.reinert.jjschema.v1.CustomSchemaWrapper.processProperties(CustomSchemaWrapper.java:151)
	at com.github.reinert.jjschema.v1.CustomSchemaWrapper.<init>(CustomSchemaWrapper.java:76)
	at com.github.reinert.jjschema.v1.CustomSchemaWrapper.<init>(CustomSchemaWrapper.java:52)
	at com.github.reinert.jjschema.v1.SchemaWrapperFactory.createWrapper(SchemaWrapperFactory.java:71)
	at com.github.reinert.jjschema.v1.SchemaWrapperFactory.createWrapper(SchemaWrapperFactory.java:47)
	at com.github.reinert.jjschema.v1.SchemaWrapperFactory.createWrapper(SchemaWrapperFactory.java:39)
	at com.github.reinert.jjschema.v1.JsonSchemaV4Factory.createSchema(JsonSchemaV4Factory.java:36)
	at com.prismoskills.JJSchemaTest.basicSchemaTest(JJSchemaTest.java:39)

// com.prismoskills.ExtendingList
{"type":"array"}

// com.prismoskills.ExtendingMap
java.lang.StringIndexOutOfBoundsException: String index out of range: 0
	at java.lang.String.charAt(String.java:658)
	at com.github.reinert.jjschema.v1.PropertyWrapper.firstToLowerCase(PropertyWrapper.java:374)
	at com.github.reinert.jjschema.v1.PropertyWrapper.processPropertyName(PropertyWrapper.java:369)
	at com.github.reinert.jjschema.v1.PropertyWrapper.getName(PropertyWrapper.java:147)
	at com.github.reinert.jjschema.v1.PropertyWrapper.<init>(PropertyWrapper.java:82)
	at com.github.reinert.jjschema.v1.CustomSchemaWrapper.processProperties(CustomSchemaWrapper.java:151)
	at com.github.reinert.jjschema.v1.CustomSchemaWrapper.<init>(CustomSchemaWrapper.java:76)
	at com.github.reinert.jjschema.v1.CustomSchemaWrapper.<init>(CustomSchemaWrapper.java:52)
	at com.github.reinert.jjschema.v1.SchemaWrapperFactory.createWrapper(SchemaWrapperFactory.java:71)
	at com.github.reinert.jjschema.v1.SchemaWrapperFactory.createWrapper(SchemaWrapperFactory.java:47)
	at com.github.reinert.jjschema.v1.SchemaWrapperFactory.createWrapper(SchemaWrapperFactory.java:39)
	at com.github.reinert.jjschema.v1.JsonSchemaV4Factory.createSchema(JsonSchemaV4Factory.java:36)
	at com.prismoskills.JJSchemaTest.basicSchemaTest(JJSchemaTest.java:41)
```

