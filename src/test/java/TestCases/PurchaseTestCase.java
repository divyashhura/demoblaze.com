package TestCases;

import Pages.PurchasePage;
import org.testng.annotations.Test;

import java.io.IOException;

public class PurchaseTestCase {
        PurchasePage purchobj;
    @Test
    void purchase() throws IOException, InterruptedException {
        purchobj=new PurchasePage();
        purchobj.placeOrder();

    }
}
