package com.mobiquity.test.service;

import com.mobiquity.test.client.RestAssuredClient;
import com.mobiquity.test.models.response.Album;
import com.mobiquity.test.models.response.Post;
import com.mobiquity.test.models.response.User;
import com.mobiquity.test.utils.Helper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.mobiquity.test.utils.Constants.*;
import static io.restassured.RestAssured.given;

public class UsersTest extends  BaseClass{
    private int id;
    private RestAssuredClient restAssuredClient;

    public UsersTest() {
        this.restAssuredClient = new RestAssuredClient(baseURL);
    }

    @Test(priority = 1)
    public void verifyPostsForUser() {

        Post[] postArray = restAssuredClient.httpGet(users +  ((BaseClass)this).id + posts).as(Post[].class);
        List<Post> postList = Arrays.asList(postArray);
        for (Post post : postList) {
            System.out.println("Post IDs :: " + post.getId());
            int statusCode = restAssuredClient.httpGet(users + id + posts).getStatusCode();
            Assert.assertEquals(statusCode, 200);
        }
    }

    @Test(priority = 2)
    public void verifyAlbumsForUser() {

        Album[] albumArray = restAssuredClient.httpGet(users + ((BaseClass)this).id + albums).as(Album[].class);
        List<Album> albumList = Arrays.asList(albumArray);
        for (Album album : albumList) {
            System.out.println("Album IDs :: " + album.getId());
            int statusCode = restAssuredClient.httpGet(users + ((BaseClass)this).id + posts).getStatusCode();
            Assert.assertEquals(statusCode, 200);
        }
    }

}

