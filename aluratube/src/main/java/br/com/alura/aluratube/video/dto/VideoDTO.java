package br.com.alura.aluratube.video.dto;

import br.com.alura.aluratube.video.model.Video;

public record VideoDTO(Long id, String titulo, String descricao, String url) {
}
