package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTestSuite {

    @InjectMocks
    DbService dbService;

    @Mock
    TaskRepository taskRepository;

    @Test
    public void shouldGetAllTasks() {
        dbService.getAllTasks();

        verify(taskRepository, times(1)).findAll();
    }

    @Test
    public void shouldGetTask() {
        Task task1 = new Task(1L, "test_title1", "test_content1");

        dbService.getTask(task1.getId());

        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    public void shouldSaveTask() {
        Task task1 = new Task(1L, "test_title1", "test_content1");
        Task task2 = new Task(1L, "test_title2", "test_content2");

        dbService.saveTask(task1);
        dbService.saveTask(task2);

        verify(taskRepository, times(1)).save(task1);
        verify(taskRepository, times(1)).save(task2);
        verify(taskRepository, times(2)).save(ArgumentMatchers.any(Task.class));

    }

    @Test
    public void shouldDeleteTask() {
        dbService.deleteTask(ArgumentMatchers.anyLong());

        verify(taskRepository, times(1)).deleteById(ArgumentMatchers.anyLong());
    }
}