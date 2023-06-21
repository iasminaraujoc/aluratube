package br.com.alura.aluratube.video.repository;

import br.com.alura.aluratube.video.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
