package com.fullstack.FullStack.Controller;
import com.fullstack.FullStack.Service.AlbumService;

import com.fullstack.FullStack.Service.AlbumService;
import com.fullstack.FullStack.Model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {

    @Autowired
    AlbumService albumService;


    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("albums", albumService.showList());
        return "index";
    }

    @GetMapping("/create")
    public String create(){
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Album album){
        albumService.addAlbum(album);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public RedirectView delete(@RequestParam("artist") String artist){
        albumService.deleteAlbum(artist);
        return new RedirectView("/");
    }

    @PostMapping("/view")
    public String viewAlbum(@ModelAttribute Album album, Model model) {
        // Add the album to the model so it can be displayed in the view
        model.addAttribute("album", album);
        return "view";
    }

    @PostMapping("/edit")
    public String editAlbum(
            @RequestParam("artist") String artist,
            @RequestParam("album_title") String albumTitle,
            @RequestParam("track") String track,
            @RequestParam("track_duration") String trackDuration,
            @RequestParam("release_year") int releaseYear,
            @RequestParam("record_company") String recordCompany,
            Model model
    ) {
        Album album = new Album();
        album.setArtist(artist);
        album.setAlbum_title(albumTitle);
        album.setTrack(track);
        album.setTrack_duration(trackDuration);
        album.setRelease_year(releaseYear);
        album.setRecord_company(recordCompany);

        model.addAttribute("album", album); // Pass album to edit.html
        return "edit";
    }


    @PostMapping("/update")
    public String updateAlbum(
            @RequestParam("artist") String artist,
            @RequestParam("album_title") String albumTitle,
            @RequestParam("track") String track,
            @RequestParam("track_duration") String trackDuration,
            @RequestParam("release_year") int releaseYear,
            @RequestParam("record_company") String recordCompany
    ) {
        // Create an Album object with the updated values
        Album album = new Album();
        album.setArtist(artist);
        album.setAlbum_title(albumTitle);
        album.setTrack(track);
        album.setTrack_duration(trackDuration);
        album.setRelease_year(releaseYear);
        album.setRecord_company(recordCompany);

        // Save the album (inserts or updates depending on existing records)
        albumService.saveAlbum(album);
        return "redirect:/"; // Redirect to the album list
    }


}
