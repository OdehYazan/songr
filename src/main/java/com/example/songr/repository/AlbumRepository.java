package com.example.songr.repository;


import com.example.songr.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

   Optional<Album> findAlbumByTitle(String title);



}
