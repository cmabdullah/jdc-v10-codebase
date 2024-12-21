> java -jar -agentlib:native-image-agent=config-output-dir=config-files,config-write-period-secs=1,config-write-initial-delay-secs=1 build/libs/mmicronautreflection-0.1.jar

> ./gradlew clean assemble


> jar xf build/libs/micronautreflection-0.1.jar META-INF/MANIFEST.MF 

> cat META-INF/MANIFEST.MF

> java -jar -agentlib:native-image-agent=config-output-dir=config-files,config-write-period-secs=1,config-write-initial-delay-secs=1 build/libs/micronautreflection-0.1.jar

>  ./gradlew runCustom

[micronaut graalvm reflection gradle java](https://guides.micronaut.io/latest/micronaut-graalvm-reflection-gradle-java.html)
[tracing agent](https://www.graalvm.org/latest/reference-manual/native-image/metadata/AutomaticMetadataCollection/#tracing-agent)