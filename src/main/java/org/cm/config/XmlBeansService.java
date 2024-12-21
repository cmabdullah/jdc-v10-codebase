package org.cm.config;

import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlObject;

import jakarta.inject.Singleton;

import java.io.IOException;
import java.io.StringReader;

@Singleton
public class XmlBeansService {

    public XmlObject parseXml(String xml) throws XmlException, IOException {
        XmlOptions options = new XmlOptions();
        options.setLoadStripWhitespace();
        return XmlObject.Factory.parse(new StringReader(xml), options);
    }
}
