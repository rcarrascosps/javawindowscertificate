
package com.sps.ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SampleServiceService", targetNamespace = "http://mvnjaxws.scotth.com/", wsdlLocation = "http://localhost:7001/mvnjaxws-0.0.1-SNAPSHOT/SampleServiceService?WSDL")
public class SampleServiceService
    extends Service
{

    private final static URL SAMPLESERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException SAMPLESERVICESERVICE_EXCEPTION;
    private final static QName SAMPLESERVICESERVICE_QNAME = new QName("http://mvnjaxws.scotth.com/", "SampleServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:7001/mvnjaxws-0.0.1-SNAPSHOT/SampleServiceService?WSDL");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SAMPLESERVICESERVICE_WSDL_LOCATION = url;
        SAMPLESERVICESERVICE_EXCEPTION = e;
    }

    public SampleServiceService() {
        super(__getWsdlLocation(), SAMPLESERVICESERVICE_QNAME);
    }

    public SampleServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), SAMPLESERVICESERVICE_QNAME, features);
    }

    public SampleServiceService(URL wsdlLocation) {
        super(wsdlLocation, SAMPLESERVICESERVICE_QNAME);
    }

    public SampleServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SAMPLESERVICESERVICE_QNAME, features);
    }

    public SampleServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SampleServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SampleService
     */
    @WebEndpoint(name = "SampleServicePort")
    public SampleService getSampleServicePort() {
        return super.getPort(new QName("http://mvnjaxws.scotth.com/", "SampleServicePort"), SampleService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SampleService
     */
    @WebEndpoint(name = "SampleServicePort")
    public SampleService getSampleServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://mvnjaxws.scotth.com/", "SampleServicePort"), SampleService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SAMPLESERVICESERVICE_EXCEPTION!= null) {
            throw SAMPLESERVICESERVICE_EXCEPTION;
        }
        return SAMPLESERVICESERVICE_WSDL_LOCATION;
    }

}
