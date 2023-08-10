package com.onyx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onyx.entity.Album;

@Repository
public interface AlbumRepo extends JpaRepository<Album, Integer> {

}
