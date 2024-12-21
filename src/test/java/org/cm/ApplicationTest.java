package org.cm;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.apache.xmlbeans.XmlObject;
import org.cm.config.XmlBeansService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
public class ApplicationTest {

    @Inject
    XmlBeansService xmlBeansService;

    @Test
    void testXmlParsing() throws Exception {
        String xml = "<root><element>value</element></root>";
        XmlObject xmlObject = xmlBeansService.parseXml(xml);
        assertNotNull(xmlObject);
    }
}
