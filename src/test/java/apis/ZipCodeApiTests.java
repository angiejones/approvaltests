package apis;

import org.approvaltests.Approvals;
import org.testng.annotations.Test;

public class ZipCodeApiTests {

    @Test
    public void testWhiteHouseZipBody(){
        ZipCodeApi api = new ZipCodeApi("20500");
        api.get().then().statusCode(200);
        Approvals.verify(api.getBody());
    }

    @Test
    public void testWhiteHouseZipAll(){
        ZipCodeApi api = new ZipCodeApi("20500");
        api.get();
        Approvals.verify(api.getFullResponse(true));
    }
}
