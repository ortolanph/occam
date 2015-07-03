package br.senac.sp.occam.parser.implementation;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import br.senac.sp.occam.parser.IOccamConfiguration;

public class ConfigurationParser implements IOccamConfiguration {
    private Document doc;
    private XPathExpression expr;
    private static final String PATTERN = "//operation[@name='%s']/@class";
    
    public ConfigurationParser(InputStream fileContents) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder;
        
        try {
        	builder = factory.newDocumentBuilder();
            doc = builder.parse(new InputSource(fileContents));
            System.out.println(String.format("Documento parseado"));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public String getOperationClass(String name) {
    	System.out.println(String.format("Obtendo classe de operação: %s", name));
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        String className = "";

        try {
            expr = xpath.compile(String.format(PATTERN, name));    
            
            Object result = expr.evaluate(doc, XPathConstants.STRING);

            className = (String)result;
            
            System.out.println(String.format("Encontrou: %s", className));
            
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        
        System.out.println(String.format("Retornando: %s", className));
        return className;
    }
}