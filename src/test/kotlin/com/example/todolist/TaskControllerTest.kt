package com.example.todolist

import org.hamcrest.Matchers
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

/**
 * Created by hideaki on 2019/10/19.
 */
@RunWith(SpringRunner::class)
@WebMvcTest(TaskController::class)
class TaskControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var taskRepository: TaskRepository

    @MockBean
    private lateinit var commandLineRunner: CommandLineRunner

    @Test
    fun testIndex() {
        val tasks = listOf(
                Task(id = 1, content = "foo", done = false),
                Task(id = 2, content = "bar", done = true)
        )
        Mockito.`when`(taskRepository.findAll()).thenReturn(tasks)

        mockMvc.perform(MockMvcRequestBuilders.get("/tasks"))
                .andExpect(view().name("tasks/index"))
                .andExpect(model().attribute("tasks", tasks))
    }

    @Test
    fun testCreate() {
        mockMvc.perform(MockMvcRequestBuilders.post("/tasks").param("content", "foo"))
                .andExpect(redirectedUrl("/tasks"))
        Mockito.verify(taskRepository).create("foo")
    }
}
