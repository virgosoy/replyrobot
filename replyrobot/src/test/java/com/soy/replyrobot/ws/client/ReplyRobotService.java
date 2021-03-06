package com.soy.replyrobot.ws.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.6
 * 2016-12-01T15:40:16.040+08:00
 * Generated source version: 3.1.6
 * 
 */
@WebServiceClient(name = "ReplyRobotService", 
                  wsdlLocation = "http://localhost/replyrobot/ws/autoReply?wsdl",
                  targetNamespace = "http://ws.replyrobot.soy.com/") 
public class ReplyRobotService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.replyrobot.soy.com/", "ReplyRobotService");
    public final static QName ReplyRobotPort = new QName("http://ws.replyrobot.soy.com/", "ReplyRobotPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost/replyrobot/ws/autoReply?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(ReplyRobotService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost/replyrobot/ws/autoReply?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public ReplyRobotService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public ReplyRobotService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ReplyRobotService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public ReplyRobotService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public ReplyRobotService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public ReplyRobotService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns ReplyRobot
     */
    @WebEndpoint(name = "ReplyRobotPort")
    public ReplyRobot getReplyRobotPort() {
        return super.getPort(ReplyRobotPort, ReplyRobot.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ReplyRobot
     */
    @WebEndpoint(name = "ReplyRobotPort")
    public ReplyRobot getReplyRobotPort(WebServiceFeature... features) {
        return super.getPort(ReplyRobotPort, ReplyRobot.class, features);
    }

}
