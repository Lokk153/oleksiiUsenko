package lesson23;

import Tests.BaseTest;
import org.testng.annotations.Test;
import pageObjects.GeolocationPage;

public class GeolocationTests extends BaseTest {

    @Test
    public void getGeolocation() {
        GeolocationPage geolocationPage = homePage().goToGeolocationPage();
        System.out.println("Latitude: " + geolocationPage
                .clickWhereButton()
                .getLatitude());
        System.out.println("Longitude: " + geolocationPage
                .getLongitude());
    }
}
