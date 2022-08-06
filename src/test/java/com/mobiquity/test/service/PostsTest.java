package com.mobiquity.test.service;

import com.mobiquity.test.client.RestAssuredClient;
import com.mobiquity.test.models.response.Comment;
import com.mobiquity.test.models.response.Post;
import com.mobiquity.test.utils.Helper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mobiquity.test.utils.Constants.*;

public class PostsTest extends BaseClass {
    private RestAssuredClient restAssuredClient;
    public PostsTest() {
        this.restAssuredClient = new RestAssuredClient(baseURL);
    }


    @Test
    public void verifyEmailforPosts() {
        logger = report.createTest("Verify Email list for user :"+Helper.getUserId());
        Comment[] commentArray;
        List<List<Comment>> listComment = new ArrayList<>();
        Post[] postArray = restAssuredClient.httpGet(users + Helper.getUserId() + posts).as(Post[].class);
        List<Post> postList = Arrays.asList(postArray);

        for (Post post : postList) {
            commentArray = restAssuredClient.httpGet(posts + post.getId() + comments).as(Comment[].class);
            listComment.add(Arrays.asList(commentArray));
        }
        List emailList = new ArrayList();
        for (int i = 0; i < listComment.size() - 1; i++) {
            for (int j = 0; j < listComment.get(i).size(); j++) {
                emailList.add(Helper.isValidEmail(listComment.get(i).get(j).getEmail()));
            }
        }
        if (emailList.contains(false)) {
            Assert.fail("Assert False");
            logger.fail("Test Fail");
        } else if (!emailList.contains(false)) {
            Assert.assertTrue(true);
            logger.pass("Test Pass");
        }


    }


}
