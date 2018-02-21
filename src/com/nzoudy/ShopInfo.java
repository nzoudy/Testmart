package com.nzoudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPHeaderElement;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

@WebService
@SOAPBinding(style=Style.DOCUMENT)
public class ShopInfo /*implements SOAPHandler<SOAPMessageContext>*/{
	
	@WebMethod
	@WebResult(partName="lookupOutput")
	public String getShopInfo(@WebParam(partName="lookupInput") String property
			, @WebParam(header=true, mode=Mode.IN, name="exchangeId") String exchangeId) throws InvalidInputException, InvalidUserIdFault, SOAPException{ // 
		String response = null;
		exchangeId = new java.rmi.dgc.VMID().toString();
		
		/*SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
		
		SOAPHeader soapHeader = soapEnvelope.getHeader();
		// SOAPHeaderElement soapHeaderElement = soapHeader.addHeaderElement(soapEnvelope.createName("exchangeId", "http://schemas.xmlsoap.org/soap/envelope/", "toto"));
		String exID = soapHeader.getAttribute(exchangeId);
		soapHeader.setAttribute("exchangeId", "toto");
		soapHeader.addHeaderElement(soapEnvelope.createName("exchangeId", "http://schemas.xmlsoap.org/soap/envelope/", "toto"));
		// soapHeaderElement.setMustUnderstand(true);
*/		
		
		SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
		
		// SOAPHeader soapHeader = soapEnvelope.getHeader();
		
		soapEnvelope.getHeader().detachNode();
	    SOAPHeader sh = soapEnvelope.addHeader();
	      
	    System.out.println(sh.getAttribute(exchangeId));
	    SOAPHeaderElement shElement = sh.addHeaderElement(soapEnvelope.createName("exchangeId", null, exchangeId));
	    
		// soapHeader.addHeaderElement(soapEnvelope.createName("exchangeId", null, exchangeId));

		
		if("shopName".equals(property)){
			response = "Test Mart";
		}
		else if("since".equals(property)){
			response = "since 2012";
		}
		else if("userid".equals(property)){
			throw new InvalidUserIdFault("Invalid user", property + "is not valid input");
		}
		else{
			throw new InvalidInputException("Invalid Input", property + "is not valid input");
		}
		return response;
	}

	/*@Override
	@WebMethod(exclude=true)
	public boolean handleMessage(SOAPMessageContext context) {
		//This property checks whether the handler is being invoked for a service response
	      boolean response= ((Boolean) context.get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY)).booleanValue(); 

	      if (response) {
	          //this is a JAX-WS-provided map of HTTP headers
	          // Map<String, List<String>> headers = (Map<String, List<String>>) context.get(MessageContext.HTTP_RESPONSE_HEADERS);
	          Map<String, List<String>> headers = (Map<String, List<String>>) context.get(MessageContext.HTTP_REQUEST_HEADERS);

	          if (null == headers) {
	              //create a new map of HTTP headers if there isn't already one
	              headers = new HashMap<String, List<String>>();
	          }
	          //add your desired header
	          // headers.put("Operation",Collections.singletonList("something"));
	          List<String> vmid = new ArrayList<>(); vmid.add("toto");
	          headers.put("exchangeId", vmid);
	        }
	      return true;
	}

	@Override
	@WebMethod(exclude=true)
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@WebMethod(exclude=true)
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@WebMethod(exclude=true)
	public Set<QName> getHeaders() {
		// TODO Auto-generated method stub
		return null;
	}
*/

	
	
	

}
