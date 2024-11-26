package provatest;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<User> users = new ArrayList<>();

    // Crear un nuevo usuario
    public void addUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo.");
        }
        if (findUserByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Ya existe un usuario con este email.");
        }
        users.add(user);
        System.out.println("Usuario añadido: " + user.getName());
    }

    // Leer todos los usuarios
    public List<User> getAllUsers() {
        return new ArrayList<>(users); // Retorna una copia de la lista para proteger los datos originales
    }

    // Leer un usuario por su email
    public User findUserByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null; // Retorna null si no se encuentra el usuario
    }

    // Actualizar un usuario
    public void updateUser(String email, String newName, String newPassword) {
        User user = findUserByEmail(email);
        if (user != null) {
            if (newName != null && !newName.trim().isEmpty()) {
                user.setName(newName);
            }
            if (newPassword != null && newPassword.length() >= 6) {
                user.setPassword(newPassword);
            }
            System.out.println("Usuario actualizado: " + user.getName());
        } else {
            throw new IllegalArgumentException("Usuario no encontrado.");
        }
    }

    // Eliminar un usuario
    public void deleteUser(String email) {
        User user = findUserByEmail(email);
        if (user != null) {
            users.remove(user);
            System.out.println("Usuario eliminado: " + email);
        } else {
            throw new IllegalArgumentException("Usuario no encontrado.");
        }
    }
}

