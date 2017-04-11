# jackson-module-jsonSchema-examples
Examples for jackson-module-jsonSchema

Running com.prismoskills.SchemaTest
```javascript
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
```

