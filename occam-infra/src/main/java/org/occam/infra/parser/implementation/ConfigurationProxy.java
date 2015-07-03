package org.occam.infra.parser.implementation;

import org.occam.infra.parser.IOccamConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ConfigurationProxy implements IOccamConfiguration {
    private IOccamConfiguration parser;

    public ConfigurationProxy(URL location) {
        InputStream source;
        try {
            source = location.openStream();

            parser = new ConfigurationParser(source);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getOperationClass(String operationName) {
        return parser.getOperationClass(operationName);
    }

}
