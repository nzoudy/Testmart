package test;

import javax.xml.ws.Endpoint;

import com.nzoudy.ProductCatalog;
import com.nzoudy.ShopInfo;

public class TestWebService {

	public static void main(String[] args) {
		
		System.out.println("Server start");
		System.out.println("exchangeId = " +new java.rmi.dgc.VMID().toString());
		Endpoint.publish("http://localhost:8080/Testmart/TestMartCatalogService", new ProductCatalog());		
		Endpoint.publish("http://localhost:8080/Testmart/ShopInfoService", new ShopInfo());

	}

}
