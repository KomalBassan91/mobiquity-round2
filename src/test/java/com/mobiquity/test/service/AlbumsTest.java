package com.mobiquity.test.service;

import com.mobiquity.test.client.RestAssuredClient;
import com.mobiquity.test.models.response.Album;
import com.mobiquity.test.models.response.Comment;
import com.mobiquity.test.models.response.Photo;
import com.mobiquity.test.models.response.Post;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mobiquity.test.utils.Constants.*;

public class AlbumsTest extends BaseClass{
    private RestAssuredClient restAssuredClient;
    private int id;

    public AlbumsTest(){
        this.restAssuredClient = new RestAssuredClient(baseURL);
    }

    @Test
    public void verifyPhotosforAlbums(){
        Photo[] photoArray;
        List<List<Photo>> listPhoto = new ArrayList<>();
        Album[] albumArray = restAssuredClient.httpGet(users+((BaseClass)this).id+albums).as(Album[].class);
        List<Album> albumList = Arrays.asList(albumArray);

        for(Album album: albumList) {
            photoArray = restAssuredClient.httpGet(albums + album.getId() + photos).as(Photo[].class);
            listPhoto.add(Arrays.asList(photoArray));
        }

        for(int i=0; i<listPhoto.size()-1;i++){
            //System.out.println(listPhoto.get(i));
            for (int j=0;j<listPhoto.get(i).size();j++){
                System.out.println("Album ::"+listPhoto.get(i)+" Photo ::"+listPhoto.get(i).get(j)+" title ::"+listPhoto.get(i).get(j).getTitle());
            }
        }

    }
}
