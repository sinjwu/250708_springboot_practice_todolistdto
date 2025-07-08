package com.practice._250708_springboot_practice_todolistdto.controller;

import com.practice._250708_springboot_practice_todolistdto.dto.TodoDto;
import com.practice._250708_springboot_practice_todolistdto.model.Todo;
import com.practice._250708_springboot_practice_todolistdto.model.User;
import com.practice._250708_springboot_practice_todolistdto.repository.TodoRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoRepository todoRepository;
    private User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute("user");
    }
    @GetMapping
    public String list(HttpSession httpSession) {
        User user = getCurrentUser(httpSession);
        if(user == null) {
            return "redirect:/login";
        }
        return "todo-list";
    }
    @GetMapping("/add")
    public String addForm(HttpSession httpSession, Model model) {
        if (getCurrentUser(httpSession) == null) return "redirect:/login";
        model.addAttribute("todoDto", new TodoDto());
        return "todo-form";
    }
    @PostMapping("/add")
    public String add (
            @Valid @ModelAttribute TodoDto todoDto,
            BindingResult bindingResult,
            HttpSession httpSession
    ) {
        if (bindingResult.hasErrors()) return "todo-form";
        User user = getCurrentUser(httpSession);
        Todo todo = Todo.builder()
                .userId(user.getId())
                .title(todoDto.getTitle())
                .completed(todoDto.isCompleted())
                .build();
        todoRepository.save(todo);
        return "redirect:/todos";
    }
}
