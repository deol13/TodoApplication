package se.lexicon;

import se.lexicon.Data.Impl.AppUserDAOImpl;
import se.lexicon.Data.Impl.PersonDAOImpl;
import se.lexicon.Data.Impl.TodoItemDAOImpl;
import se.lexicon.Data.Impl.TodoItemTaskDAOImpl;
import se.lexicon.Model.*;
import se.lexicon.Sequencers.TodoItemIdSequencer;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //personDaoCollectionTest();
        appUserDaoCollectionTest();
        //todoItemTaskDaoCollectionTest();
        //todoItemDaoCollectionTest();
    }

    public static void appUserDaoCollectionTest() {
        AppUserDAOImpl appUsers = new AppUserDAOImpl();
        AppUser appUser1 = new AppUser("Dennis Olsen", "123abc", AppRole.ROLE_APP_USER);
        AppUser appUser2 = new AppUser("John Karlsson", "567kjl", AppRole.ROLE_APP_ADMIN);
        AppUser appUser3 = new AppUser("Alice Thorn", "987dfg", AppRole.ROLE_APP_USER);

        // persist
        appUsers.persist(appUser1);
        appUsers.persist(appUser2);
        appUsers.persist(appUser3);

        // findAll
        System.out.println("AppUsers: :");
        appUsers.findAll().forEach(System.out::println);
        System.out.println();

        // findByUsername
        System.out.println("App user with name Alice Thorn: \n"+appUsers.findByUsername("Alice Thorn").toString());
        System.out.println("App user with name Lola Ash: \n"+appUsers.findByUsername("Lola Ash"));
        System.out.println();

        // remove
        appUsers.remove("Lola Ash");
        appUsers.remove("Dennis Olsen");
        System.out.println("After removal:");
        appUsers.findAll().forEach(System.out::println);

    }

    public static void todoItemDaoCollectionTest() {
        TodoItemDAOImpl itemCollection = new TodoItemDAOImpl();

        Person person1 = new Person("Dennis", "Olsen", "dennisOlsen@test.com");
        Person person2 = new Person("John", "Karlsson", "johnKarlsson@test.com");
        Person person3 = new Person("Alice", "Thorn", "aliceThorn@test.com");

        TodoItem item1 = new TodoItem("Make calender", "Create a new calender", LocalDate.now().plusWeeks(3), false, person1);
        int id = TodoItemIdSequencer.getCurrentId();
        TodoItem item2 = new TodoItem("Make a pie", "Bake a pie", LocalDate.now().minusWeeks(1), false, person2);
        TodoItemIdSequencer.setCurrentId(id);
        TodoItem item3 = new TodoItem("Make a cake", "Bake a cake", LocalDate.now().plusWeeks(2), true, person3);

        // persist
        itemCollection.persist(item1);
        itemCollection.persist(item2);
        itemCollection.persist(item3);

        // find all
        System.out.println("Tasks: :");
        itemCollection.findAll().forEach(System.out::println);
        System.out.println();

        // find by
        System.out.println("Find by id:");
        System.out.println(itemCollection.findById(1));
        System.out.println();

        // find all by done status
        System.out.println("Done:");
        itemCollection.findAllByDoneStatus(true).forEach(System.out::println);
        System.out.println();
        System.out.println("Not done:");
        itemCollection.findAllByDoneStatus(false).forEach(System.out::println);

        // find by title
        System.out.println("\nFind by title: make calender:");
        itemCollection.findByTitleContains("Make calender").forEach(System.out::println);
        System.out.println("\nFind by title: make boat:");
        itemCollection.findByTitleContains("Make boat").forEach(System.out::println);

        // find by person id
        System.out.println("\nFind by person id: 2:");
        itemCollection.findByPersonId(2).forEach(System.out::println);

        // find by deadline before
        System.out.println("\nFind by deadline before:");
        itemCollection.findByDeadlineBefore(LocalDate.now()).forEach(System.out::println);

        // find by deadline after
        System.out.println("\nFind by deadline after:");
        itemCollection.findByDeadlineAfter(LocalDate.now()).forEach(System.out::println);

        // removal
    }

    public static void todoItemTaskDaoCollectionTest(){
        TodoItemTaskDAOImpl taskCollection = new TodoItemTaskDAOImpl();

        Person person1 = new Person("Dennis", "Olsen", "dennisOlsen@test.com");
        Person person2 = new Person("John", "Karlsson", "johnKarlsson@test.com");
        Person person3 = new Person("Alice", "Thorn", "aliceThorn@test.com");

        TodoItem item1 = new TodoItem("Make calender", "Create a new calender", LocalDate.now().plusWeeks(3), false, person1);
        TodoItem item2 = new TodoItem("Make a pie", "Bake a pie", LocalDate.now().minusWeeks(1), false, person2);
        TodoItem item3 = new TodoItem("Make a cake", "Bake a cake", LocalDate.now().plusWeeks(2), false, person3);

        TodoItemTask task1 = new TodoItemTask(item1, person1);
        TodoItemTask task2 = new TodoItemTask(item2, person2);
        TodoItemTask task3 = new TodoItemTask(item3, null);

        // persist
        taskCollection.persist(task1);
        taskCollection.persist(task2);
        taskCollection.persist(task3);

        // find all
        System.out.println("Tasks: :");
        for (TodoItemTask task : taskCollection.findAll()) {
            System.out.print("Task with id: "+task.getId() + ", TodoItem title: "+task.getTodoItem().getTitle());
            if(task.isAssigned())
                System.out.println(", creators name: " +task.getAssignee().getFirstName());
            else
                System.out.println(", creators name: none");

        }

        System.out.println();

        //find by id
        System.out.println("Find by id");
        System.out.println("Task with id 1: "+taskCollection.findById(1).getTodoItem().getTitle());
        System.out.println("Task with id 4: "+taskCollection.findById(4));
        System.out.println();

        //find by assigned status
        ArrayList<TodoItemTask> tasksAssigned = new ArrayList<>(taskCollection.findByAssignedStatus(true));
        ArrayList<TodoItemTask> tasksNotAssigned = new ArrayList<>(taskCollection.findByAssignedStatus(false));

        System.out.println("Find by status");
        System.out.println("Task with status assigned:");
        tasksAssigned.forEach(t -> System.out.println("Task with id: "+t.getId() + ", TodoItem title: "+t.getTodoItem().getTitle() + ", creators name: " +t.getAssignee().getFirstName()));
        System.out.println();
        System.out.println("Task with status not assigned: \n");
        tasksNotAssigned.forEach(t -> System.out.println("Task with id: "+t.getId() + ", TodoItem title: "+t.getTodoItem().getTitle()));

        System.out.println();

        //find by person id
        ArrayList<TodoItemTask> tasksId1 = new ArrayList<>(taskCollection.findByPersonId(1));
        ArrayList<TodoItemTask> tasksId5 = new ArrayList<>(taskCollection.findByPersonId(5));

        System.out.println("Find by person id 1");
        tasksAssigned.forEach(t -> System.out.println("Task with id: "+t.getId() + ", TodoItem title: "+t.getTodoItem().getTitle() + ", creators name: " +t.getAssignee().getFirstName()));
        System.out.println();
        System.out.println("Find by person id 5");
        tasksNotAssigned.forEach(t -> System.out.println("Task with id: "+t.getId() + ", TodoItem title: "+t.getTodoItem().getTitle()));

        // removal
        taskCollection.findByPersonId(1).remove(5);
        taskCollection.findByPersonId(1).remove(2);
        System.out.println("After removal: ");
        taskCollection.findAll().forEach(t -> System.out.println("Task with id: "+t.getId() + "TodoItem title: "+t.getTodoItem().getTitle() + ", creator: " + t.isAssigned()));
    }

    public static void personDaoCollectionTest() {
        PersonDAOImpl people = new PersonDAOImpl();

        Person person1 = new Person("Dennis", "Olsen", "dennisOlsen@test.com");
        Person person2 = new Person("John", "Karlsson", "johnKarlsson@test.com");
        Person person3 = new Person("Alice", "Thorn", "aliceThorn@test.com");

        // persist
        people.persist(person1);
        people.persist(person2);
        people.persist(person3);

        // findAll
        System.out.println("People: :");
        people.findAll().forEach(System.out::println);
        System.out.println();

        // findById
        System.out.println("Person with id 1: \n"+people.findById(1).toString());
        System.out.println("Person with id 4: \n"+people.findById(4));
        System.out.println();

        // findByEmail
        System.out.println("Person with email john: \n"+people.findByEmail("johnKarlsson@test.com").toString());
        System.out.println("Person with email: \n"+people.findByEmail(""));
        System.out.println();

        // remove
        people.remove(5);
        people.remove(2);
        System.out.println("After removal: ");
        people.findAll().forEach(System.out::println);
    }
}
