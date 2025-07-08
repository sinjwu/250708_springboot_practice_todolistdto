package com.practice._250708_springboot_practice_todolistdto.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchConnectionDetails;

@Data
@Builder
public class User {
    private Integer id;
    private String username;
    private String password;

}
