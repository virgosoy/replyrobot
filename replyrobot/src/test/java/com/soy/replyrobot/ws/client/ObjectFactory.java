
package com.soy.replyrobot.ws.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soy.replyrobot.ws.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetContent_QNAME = new QName("http://ws.replyrobot.soy.com/", "getContent");
    private final static QName _GetContentResponse_QNAME = new QName("http://ws.replyrobot.soy.com/", "getContentResponse");
    private final static QName _GetModel_QNAME = new QName("http://ws.replyrobot.soy.com/", "getModel");
    private final static QName _GetModelResponse_QNAME = new QName("http://ws.replyrobot.soy.com/", "getModelResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soy.replyrobot.ws.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetContent }
     * 
     */
    public GetContent createGetContent() {
        return new GetContent();
    }

    /**
     * Create an instance of {@link GetContentResponse }
     * 
     */
    public GetContentResponse createGetContentResponse() {
        return new GetContentResponse();
    }

    /**
     * Create an instance of {@link GetModel }
     * 
     */
    public GetModel createGetModel() {
        return new GetModel();
    }

    /**
     * Create an instance of {@link GetModelResponse }
     * 
     */
    public GetModelResponse createGetModelResponse() {
        return new GetModelResponse();
    }

    /**
     * Create an instance of {@link Command }
     * 
     */
    public Command createCommand() {
        return new Command();
    }

    /**
     * Create an instance of {@link CommandContent }
     * 
     */
    public CommandContent createCommandContent() {
        return new CommandContent();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.replyrobot.soy.com/", name = "getContent")
    public JAXBElement<GetContent> createGetContent(GetContent value) {
        return new JAXBElement<GetContent>(_GetContent_QNAME, GetContent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetContentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.replyrobot.soy.com/", name = "getContentResponse")
    public JAXBElement<GetContentResponse> createGetContentResponse(GetContentResponse value) {
        return new JAXBElement<GetContentResponse>(_GetContentResponse_QNAME, GetContentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetModel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.replyrobot.soy.com/", name = "getModel")
    public JAXBElement<GetModel> createGetModel(GetModel value) {
        return new JAXBElement<GetModel>(_GetModel_QNAME, GetModel.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetModelResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.replyrobot.soy.com/", name = "getModelResponse")
    public JAXBElement<GetModelResponse> createGetModelResponse(GetModelResponse value) {
        return new JAXBElement<GetModelResponse>(_GetModelResponse_QNAME, GetModelResponse.class, null, value);
    }

}
