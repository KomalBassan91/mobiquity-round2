package com.mobiquity.test.service;

import com.mobiquity.test.client.RestAssuredClient;
import com.mobiquity.test.models.response.Album;
import com.mobiquity.test.models.response.Post;
import com.mobiquity.test.models.response.User;
import com.mobiquity.test.utils.Helper;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import static com.mobiquity.test.utils.Constants.*;

public class UsersTest {

    private int id;
    private RestAssuredClient restAssuredClient;

    public UsersTest(){
        this.restAssuredClient = new RestAssuredClient(baseURL);
    }

    @BeforeClass
    public void getUserId(){
        id= Helper.getUserId();
    }


    /*@Test(priority = 0)
    public void verifyUser(){
        User[] userArray = restAssuredClient.httpGet(users).as(User[].class);
        List<User> userList = Arrays.asList(userArray);
        for(User user: userList){
            int id;
            if(user.getUsername().equalsIgnoreCase(dummyUser)){
                id=user.getId();
                System.out.println("User Id ::"+id);
            }
        }
    }*/

    @Test(priority = 1)
    public void verifyPostsForUser(){

        Post[] postArray = restAssuredClient.httpGet(users+id+posts).as(Post[].class);
        List<Post> postList = Arrays.asList(postArray);
        for (Post post: postList){
            System.out.println("Post IDs :: "+post.getId());
        }
    }

    @Test(priority = 2)
    public void verifyAlbumsForUser(){

        Album[] albumArray = restAssuredClient.httpGet(users+id+albums).as(Album[].class);
        List<Album> albumList = Arrays.asList(albumArray);
        for (Album album: albumList){
            System.out.println("Album IDs :: "+album.getId());
        }
    }

}
