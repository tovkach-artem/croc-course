package ru.croc.course.support.io;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.croc.course.task.Task;
import ru.croc.course.task.TaskStatus;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class ObjectIOManipulationServiceTest {
    private static final Path PATH_TO_TEST_DATABASE_FOR_READ = Path.of("src","test", "resources", "test_database_for_read.txt");
    private static final Path PATH_TO_TEST_DATABASE_FOR_WRITE = Path.of("src","test", "resources", "test_database_for_write.txt");
    private static final Task testTask1 = new Task("new_task",  "title", "description", "executor", TaskStatus.TO_DO);
    private static final Task testTask2 = new Task("task_updated",  "title_updated", "description_updated", "executor_updated", TaskStatus.DONE);
    private final ObjectIOManipulationService<Task> objectIOManipulationService = new ObjectIOManipulationService<>();

    @Test
    public void shouldDeserializeListOfTasksWhileReadingDatabaseFile() throws IOException, ClassNotFoundException {
        List<Task> actualTasks = objectIOManipulationService.readObjectsFromFile(PATH_TO_TEST_DATABASE_FOR_READ.toFile());
        List<Task> expectedTasks = List.of(testTask1, testTask2);
        Assertions.assertThat(actualTasks).containsAll(expectedTasks);
        Assertions.assertThat(actualTasks).hasSize(2);
    }

    @Test
    public void shouldSerializeListOfTasksWhileWritingDatabaseFile() throws IOException, ClassNotFoundException {
        objectIOManipulationService.writeObjectsToFile(List.of(testTask1, testTask2),PATH_TO_TEST_DATABASE_FOR_WRITE.toFile());
        List<String> actualStrings = Files.readAllLines(PATH_TO_TEST_DATABASE_FOR_WRITE, Charset.forName("windows-1251"));
        List<String> expectedStrings = Files.readAllLines(PATH_TO_TEST_DATABASE_FOR_READ, Charset.forName("windows-1251"));
        Assertions.assertThat(PATH_TO_TEST_DATABASE_FOR_WRITE.toFile()).exists();
        Assertions.assertThat(actualStrings).containsAll(expectedStrings);
    }

    @AfterEach
    public void destruct() throws IOException {
        if (Files.exists(PATH_TO_TEST_DATABASE_FOR_WRITE)) {
            Files.delete(PATH_TO_TEST_DATABASE_FOR_WRITE);
        }
    }

}