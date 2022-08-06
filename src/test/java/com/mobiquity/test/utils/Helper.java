package com.mobiquity.test.utils;

import com.mobiquity.test.client.RestAssuredClient;
import com.mobiquity.test.models.response.User;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;

import static com.mobiquity.test.utils.Constants.*;

public class Helper {

    public static int getUserId() {
        RestAssuredClient restAssuredClient = new RestAssuredClient(baseURL);
        User[] userArray = restAssuredClient.httpGet(users).as(User[].class);
        List<User> userList = Arrays.asList(userArray);
        for (User user : userList) {
            int id;
            if (user.getUsername().equalsIgnoreCase(dummyUser)) {
                id = user.getId();
                System.out.println("User Id ::" + id);
                return id;
            }
        }

        return 0;
    }
}
