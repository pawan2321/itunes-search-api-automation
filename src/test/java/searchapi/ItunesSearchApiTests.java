package searchapi;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ApiUtils;

import static io.restassured.RestAssured.given;

public class ItunesSearchApiTests extends BaseTest {
    @Test
    public void testSearchByTerm() {
        Response response = ApiUtils.search("Taylor Swift");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertFalse(response.jsonPath().getList("results").isEmpty());
    }

    @Test
    public void testSearchWithParameters() {
        Response response = ApiUtils.searchWithParams("Beatles", "music", "US", 5);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getList("results").size(), 5);
        Assert.assertEquals(response.jsonPath().getString("results[0].kind"), "song");
    }

    @Test
    public void testInvalidSearch() {
        Response response = ApiUtils.search("jsnfdkjdsnkfskfjds");
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("results").isEmpty());
    }
}
