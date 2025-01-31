
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.annotation.Testable;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.vits.model.Task;
import com.vits.services.ScheduleCalculator;

@Testable
@ExtendWith(MockitoExtension.class)
public class TaskTest {

    @Mock
    ScheduleCalculator scheduleCalculatorMock;
    private HashMap<Task,Integer> hm;

    @BeforeAll
    void createAHashMap(){

        hm = new HashMap<>();
        Task dependency1= new Task("Task1-Dependency1", 3);
        Task dependency2= new Task("Task1-Dependency2", 5);
        List<Task> task1dependencies = new ArrayList<>();
        task1dependencies.add(dependency1);
        task1dependencies.add(dependency2);
        Task task1 = new Task("Task1",task1dependencies,5);

        hm.put(task1,0);

        Task dependency3= new Task("Task2-Dependency1", 3);
        Task dependency4= new Task("Task2-Dependency2", 7);
        List<Task> task2dependencies = new ArrayList<>();
        task2dependencies.add(dependency3);
        task2dependencies.add(dependency4);
        Task task2 = new Task("Task1",task2dependencies,5);
        
        hm.put(task2,1);
    }

    @Test
    void sortByValueTest(){
        assertNotNull(scheduleCalculatorMock);
        createAHashMap();


    }
}
