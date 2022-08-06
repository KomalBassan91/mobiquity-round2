package com.mobiquity.test.utils;

import com.mobiquity.test.client.RestAssuredClient;
import com.mobiquity.test.models.response.User;


import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
                return id;
            }
        }

        return 0;
    }

    public static int getIncorrectUserId() {
        RestAssuredClient restAssuredClient = new RestAssuredClient(baseURL);
        User[] userArray = restAssuredClient.httpGet(users).as(User[].class);
        List<User> userList = Arrays.asList(userArray);
        excel = new ExcelDataProvider();
        for (User user : userList) {
            int id;
            if (user.getUsername().equalsIgnoreCase(excel.getStringData("User", 1, 1))) {
                id = user.getId();
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

    public static boolean isValidEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    public static boolean isValidUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
