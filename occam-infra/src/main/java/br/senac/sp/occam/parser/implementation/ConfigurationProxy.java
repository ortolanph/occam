package br.senac.sp.occam.parser.implementation;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import br.senac.sp.occam.parser.IOccamConfiguration;

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
