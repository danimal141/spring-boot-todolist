package com.example.todolist

/**
 * Created by hideaki on 2019/10/03.
 */
interface TaskRepository {
    fun create(content: String): Task
    fun update(task: Task)
    fun findAll(): List<Task>
    fun findById(id: Long): Task?
}
