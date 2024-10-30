package com.fullstack.FullStack.Repository;

import com.fullstack.FullStack.Model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public class AlbumRepo {

    @Autowired
    JdbcTemplate template;

    public List<Album> showList(){
        String sql = "SELECT * FROM album";
        RowMapper<Album> rowMapper = new BeanPropertyRowMapper<Album>(Album.class);
        return template.query(sql, rowMapper);
    }

    public void addAlbum(Album album){
        String sql = "INSERT INTO album(artist, album_title, track, track_duration, release_year, record_company) VALUES(?, ?, ?, ?, ?, ?)";
        template.update(sql, album.getArtist(), album.getAlbum_title(), album.getTrack(), album.getTrack_duration(), album.getRelease_year(), album.getRecord_company());
    }

    public void deleteAlbum(String artist){
        String sql = "DELETE FROM album WHERE artist = ?";
        template.update(sql, artist);
    }

    public void updateAlbum(Album album){
        String sql = "UPDATE album SET track = ?, track_duration = ?, release_year = ?, record_company = ? WHERE artist = ? AND album_title = ?";
        template.update(sql, album.getTrack(), album.getTrack_duration(), album.getRelease_year(), album.getRecord_company(), album.getArtist(), album.getAlbum_title());
    }




}
