package com.practice._250708_springboot_practice_todolistdto.repository;

import com.practice._250708_springboot_practice_todolistdto.model.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TodoRepository {
    private final JdbcTemplate jdbcTemplate;
    public int save(Todo todo) {
        String sql = "INSERT INTO todo (user_id, title, completed) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, todo.getUserId(), todo.getTitle(), todo.isCompleted());
    }
}
