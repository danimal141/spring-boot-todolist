package com.example.todolist

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

/**
 * Created by hideaki on 2019/10/06.
 */
class TaskUpdateForm {
    @NotBlank
    @Size(max = 20)
    var content: String? = null
    var done: Boolean = false
}
