package com.mobiquity.test.service;

import com.mobiquity.test.client.RestAssuredClient;
import com.mobiquity.test.models.response.Album;
import com.mobiquity.test.models.response.Comment;
import com.mobiquity.test.models.response.Photo;
import com.mobiquity.test.models.response.Post;
import com.mobiquity.test.utils.Helper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mobiquity.test.utils.Constants.*;

public class AlbumsTest extends BaseClass {
    private RestAssuredClient restAssuredClient;
    public AlbumsTest() {
        this.restAssuredClient = new RestAssuredClient(baseURL);

    }

    @Test
    public void verifyPhotosforAlbums() {
        logger = report.createTest("Verify Photos for Albums for user :"+Helper.getUserId());
        Photo[] photoArray;
        List<List<Photo>> listPhoto = new ArrayList<>();
        Album[] albumArray = restAssuredClient.httpGet(users + Helper.getUserId() + albums).as(Album[].class);
        List<Album> albumList = Arrays.asList(albumArray);

        for (Album album : albumList) {
            photoArray = restAssuredClient.httpGet(albums + album.getId() + photos).as(Photo[].class);
            listPhoto.add(Arrays.asList(photoArray));
        }

        List urlList = new ArrayList();
        for (int i = 0; i < listPhoto.size() - 1; i++) {
            for (int j = 0; j < listPhoto.get(i).size(); j++) {
                urlList.add(Helper.isValidUrl(listPhoto.get(i).get(j).getUrl()));
                logger.info("Album ::" + listPhoto.get(i) + " Photo ::" + listPhoto.get(i).get(j) + " title ::" + listPhoto.get(i).get(j).getTitle());
            }
        }

        if (urlList.contains(false)) {
            Assert.fail("Assert False");
            logger.fail("Test Fail");
        } else if (!urlList.contains(false)) {
            Assert.assertTrue(true);
            logger.pass("Test Pass");
        }

    }
}
