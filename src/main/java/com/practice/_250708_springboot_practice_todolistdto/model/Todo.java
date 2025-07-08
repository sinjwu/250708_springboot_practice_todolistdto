package com.practice._250708_springboot_practice_todolistdto.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Todo {
    private Integer id;
    private String title;
    private boolean completed;
    private Integer userId;
}
