package com.codegym.controller;

import com.codegym.entity.Song;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/playlist")
public class SongController {
    @Autowired
    private SongService service;

    @GetMapping("/list")
    public String list(Model model){
        List<Song> songList = service.findAll();
        model.addAttribute("songList", songList);
        return "playlist/list";
    }
    @GetMapping("/create")
    public String viewCreate(Model model){
        model.addAttribute("song",new Song());
        return "playlist/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("song") Song song){
        service.create(song);
        return "redirect:/playlist/list";
    }

    @GetMapping("/update")
    public String showUpdate(@RequestParam("id") int id, Model model){
        model.addAttribute("song", service.findById(id));
        return "playlist/update";
    }

    @PostMapping("/update")
    public String update(Song song, Model model){
        service.update(song.getId(), song);
        model.addAttribute("song", song);
        return "redirect:/playlist/list";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id, Model model){
        model.addAttribute("song",service.findById(id));
        return "/playlist/delete";
    }

    @PostMapping("/delete")
    public String delete(Song song){
        service.delete(song.getId());
        return "redirect:/playlist/list";
    }
}
