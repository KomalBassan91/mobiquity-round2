package com.mobiquity.test.service;

import com.mobiquity.test.client.RestAssuredClient;
import com.mobiquity.test.models.response.Comment;
import com.mobiquity.test.models.response.Post;
import com.mobiquity.test.utils.Helper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mobiquity.test.utils.Constants.*;

public class PostsTest {
    private RestAssuredClient restAssuredClient;


    public PostsTest(){
        this.restAssuredClient = new RestAssuredClient(baseURL);
    }


    @Test
    public void verifyCommentsforPosts(){
        Comment[] commentArray;
        List<List<Comment>> listComment = new ArrayList<>();
        Post[] postArray = restAssuredClient.httpGet(users+dummyUserId+posts).as(Post[].class);
        List<Post> postList = Arrays.asList(postArray);

        for(Post post: postList) {
            commentArray = restAssuredClient.httpGet(posts + post.getId() + comments).as(Comment[].class);
            listComment.add(Arrays.asList(commentArray));
        }

        for(int i=0; i<listComment.size()-1;i++){
            //System.out.println(listComment.get(i));
            for (int j=0;j<listComment.get(i).size();j++){
                System.out.println(listComment.get(i).get(j).getEmail());
            }
        }

    }


}
