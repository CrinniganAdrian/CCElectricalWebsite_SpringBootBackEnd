package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Favourites;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavouritesRepository extends JpaRepository <Favourites,Long>  {

}
