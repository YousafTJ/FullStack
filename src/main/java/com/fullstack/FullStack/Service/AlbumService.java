package com.fullstack.FullStack.Service;

import com.fullstack.FullStack.Model.Album;
import com.fullstack.FullStack.Repository.AlbumRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    AlbumRepo albumRepo;

    public List<Album> showList(){
        return albumRepo.showList();
    }


    public void addAlbum(Album album){
        albumRepo.addAlbum(album);
    }



    public void deleteAlbum(String artist){
        albumRepo.deleteAlbum(artist);
    }
    public void saveAlbum(Album album) {
        albumRepo.updateAlbum(album); // Update existing album in the database
    }




}
