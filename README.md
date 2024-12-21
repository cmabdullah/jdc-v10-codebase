curl "localhost:8080/transformer/capitalize?q=Hello"

Step 1

```
[
  {
    "name": "org.cm.transformer.StringCapitalizer",
    "methods": [
      {
        "name": "capitalize",
        "parameterTypes": [
          "java.lang.String"
        ]
      }
    ]
  },
  {
    "name": "org.cm.transformer.StringReverser",
    "methods": [
      {
        "name": "reverse",
        "parameterTypes": [
          "java.lang.String"
        ]
      }
    ]
  }
]
```

Step 2

```java
@ReflectionConfig(
        type = StringReverser.class,
        methods = {
                @ReflectionConfig.ReflectiveMethodConfig(name = "reverse", parameterTypes = {String.class})
        }
)
@ReflectionConfig(
        type = StringCapitalizer.class,
        methods = {
                @ReflectionConfig.ReflectiveMethodConfig(name = "capitalize", parameterTypes = {String.class})
        }
)
class GraalConfig {
}
```

Step 3

If you can access the code, as in this example, you can annotate the class or method being accessed with reflection with @ReflectiveAccess.

```java
import io.micronaut.core.annotation.ReflectiveAccess;

public class StringReverser {
    @ReflectiveAccess 
    static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }
}
```

> java -jar -agentlib:native-image-agent=config-output-dir=config-files,config-write-period-secs=1,config-write-initial-delay-secs=1 build/libs/mmicronautreflection-0.1.jar

> ./gradlew clean assemble


> jar xf build/libs/micronautreflection-0.1.jar META-INF/MANIFEST.MF 

> cat META-INF/MANIFEST.MF

> java -jar -agentlib:native-image-agent=config-output-dir=config-files,config-write-period-secs=1,config-write-initial-delay-secs=1 build/libs/micronautreflection-0.1.jar

>  ./gradlew runCustom

[micronaut graalvm reflection gradle java](https://guides.micronaut.io/latest/micronaut-graalvm-reflection-gradle-java.html)
[tracing agent](https://www.graalvm.org/latest/reference-manual/native-image/metadata/AutomaticMetadataCollection/#tracing-agent)
[micronaut graalvm reflection gradle java](https://guides.micronaut.io/latest/micronaut-graalvm-reflection-gradle-java.html)