package com.mobiquity.test.utils;

import com.mobiquity.test.client.RestAssuredClient;
import com.mobiquity.test.models.response.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.mobiquity.test.utils.Constants.*;

public class Helper {
    public static ExcelDataProvider excel;


    public static int getUserId() {
        RestAssuredClient restAssuredClient = new RestAssuredClient(baseURL);
        User[] userArray = restAssuredClient.httpGet(users).as(User[].class);
        List<User> userList = Arrays.asList(userArray);
        excel = new ExcelDataProvider();
        for (User user : userList) {
            int id;
            if (user.getUsername().equalsIgnoreCase(excel.getStringData("User", 0, 1))) {
                id = user.getId();
                System.out.println("User Id ::" + id);
                return id;
            }
        }

        return 0;
    }
    public static String getCurrentDateAndTime() {
        DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentDate = new Date();
        return customFormat.format(currentDate);
    }

}
