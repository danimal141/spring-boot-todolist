package com.example.todolist

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.junit4.SpringRunner

/**
 * Created by hideaki on 2019/10/19.
 */
@RunWith(SpringRunner::class)
@SpringBootTest
@Sql(statements = arrayOf("DELETE FROM task"))
class JdbcTaskRepositoryTest {
    @Autowired
    private lateinit var sut: JdbcTaskRepository

    @Test
    fun testFindAll() {
        val got = sut.findAll()
        assertThat(got).isEmpty()
    }

    fun testFindById() {
        val task = sut.create("TEST")
        val got = sut.findById(task.id)
        assertThat(got).isEqualTo(task)
    }
}
