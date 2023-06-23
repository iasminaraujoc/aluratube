package br.com.alura.aluratube.video.controller;

import br.com.alura.aluratube.video.dto.VideoDTO;
import br.com.alura.aluratube.video.form.VideoForm;
import br.com.alura.aluratube.video.model.Video;
import br.com.alura.aluratube.video.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @PostMapping
    @CrossOrigin
    public ResponseEntity<VideoDTO> cadastrarVideo(@RequestBody VideoForm dados){
        var video = new Video(dados);
        videoRepository.save(video);

        return ResponseEntity.ok(new VideoDTO(video));
    }

    @GetMapping
    public ResponseEntity<List<VideoDTO>> listarVideos(){
        return ResponseEntity.ok(videoRepository.findAll().stream().map(VideoDTO::new).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoDTO> listarVideoPorId(@PathVariable Long id){
        Video video = videoRepository.getReferenceById(id);
        return  ResponseEntity.ok(new VideoDTO(video));
    }
}
