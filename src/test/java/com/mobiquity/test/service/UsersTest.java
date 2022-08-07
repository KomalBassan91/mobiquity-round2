package com.mobiquity.test.service;

import com.mobiquity.test.client.RestAssuredClient;
import com.mobiquity.test.models.response.Album;
import com.mobiquity.test.models.response.Post;
import com.mobiquity.test.models.response.User;
import com.mobiquity.test.utils.Helper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.mobiquity.test.utils.Constants.*;


public class UsersTest extends BaseClass {
    private RestAssuredClient restAssuredClient;

    public UsersTest() {
        this.restAssuredClient = new RestAssuredClient(baseURL);
    }

    @Test(priority = 1)
    public void verifyPostsForUser() {
        logger = report.createTest("Verify Posts for user :" + Helper.getUserId());
        Post[] postArray = restAssuredClient.httpGet(users + Helper.getUserId() + posts).as(Post[].class);
        List<Post> postList = Arrays.asList(postArray);
        for (Post post : postList) {
            logger.pass("Post IDs :" + post.getId());
            int statusCode = restAssuredClient.httpGet(users + Helper.getUserId() + posts).getStatusCode();
            Assert.assertEquals(statusCode, 200);
        }
    }

    @Test(priority = 2)
    public void verifyAlbumsForUser() {
        logger = report.createTest("Verify Albums for user :" + Helper.getUserId());
        Album[] albumArray = restAssuredClient.httpGet(users + Helper.getUserId() + albums).as(Album[].class);
        List<Album> albumList = Arrays.asList(albumArray);
        for (Album album : albumList) {
            logger.pass("Album IDs :" + album.getId());
            int statusCode = restAssuredClient.httpGet(users + Helper.getUserId() + posts).getStatusCode();
            Assert.assertEquals(statusCode, 200);
        }
    }

    @Test(priority = 2)
    public void verifyIncorrectUser() {
        logger = report.createTest("Test for incorrect user id :" + Helper.getIncorrectUserId());
        User user = restAssuredClient.httpGet(users + Helper.getIncorrectUserId()).as(User.class);
        if (user.getUsername() == null) {
            int statusCode = restAssuredClient.httpGet(users + Helper.getIncorrectUserId()).getStatusCode();
            Assert.assertEquals(statusCode, 404);
            logger.pass("User Not found");
        }
    }

}

