package com.movie.feign.moviefeign.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SpokenLanguages {
  private String english_name;
  private String iso_639_1;
  private String name;
}
