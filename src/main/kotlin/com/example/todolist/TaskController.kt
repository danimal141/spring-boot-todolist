package com.example.todolist

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by hideaki on 2019/09/28.
 */
@RestController
@RequestMapping("tasks")
class TaskController {
    @GetMapping("")
    fun index(model: Model): String {
        val tasks = listOf(
            Task(1, "Test", false)
        )
        model.addAttribute("tasks", tasks)
        return tasks.toString()
    }
}
