package provatesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import provatest.User;
import provatest.UserManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {
    private UserManager userManager;

    @BeforeEach
    void setUp() {
        userManager = new UserManager();
    }

    @Test
    void testAddUser() {
        User user = new User("Juan Perez", "juan@correo.com", "password123");
        userManager.addUser(user);

        List<User> users = userManager.getAllUsers();
        assertEquals(1, users.size());
        assertEquals("Juan Perez", users.get(0).getName());
    }

    @Test
    void testFindUserByEmail() {
        User user = new User("Maria Gomez", "maria@correo.com", "password456");
        userManager.addUser(user);

        User foundUser = userManager.findUserByEmail("maria@correo.com");
        assertNotNull(foundUser);
        assertEquals("Maria Gomez", foundUser.getName());
    }

    @Test
    void testUpdateUser() {
        User user = new User("Carlos Lopez", "carlos@correo.com", "password789");
        userManager.addUser(user);

        userManager.updateUser("carlos@correo.com", "Carlos Actualizado", "nuevaPassword123");

        User updatedUser = userManager.findUserByEmail("carlos@correo.com");
        assertNotNull(updatedUser);
        assertEquals("Carlos Actualizado", updatedUser.getName());
        assertEquals("nuevaPassword123", updatedUser.getPassword());
    }

    @Test
    void testDeleteUser() {
        User user = new User("Ana Torres", "ana@correo.com", "password321");
        userManager.addUser(user);

        userManager.deleteUser("ana@correo.com");

        User deletedUser = userManager.findUserByEmail("ana@correo.com");
        assertNull(deletedUser);
        assertEquals(0, userManager.getAllUsers().size());
    }

    @Test
    void testGetAllUsers() {
        User user1 = new User("Juan Perez", "juan@correo.com", "password123");
        User user2 = new User("Maria Gomez", "maria@correo.com", "password456");

        userManager.addUser(user1);
        userManager.addUser(user2);

        List<User> users = userManager.getAllUsers();
        assertEquals(2, users.size());
    }
}
