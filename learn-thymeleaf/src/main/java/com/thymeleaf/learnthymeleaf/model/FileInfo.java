package com.thymeleaf.learnthymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FileInfo {
  private String name;
  private String url;
}