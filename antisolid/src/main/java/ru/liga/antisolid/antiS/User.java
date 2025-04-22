package ru.liga.antisolid.antiS;

/**
 * Single Responsibility
 *
 * Нарушение заключается в том, что класс User не только содержит данные о пользователе,
 * но и отправляет сообщение, а также сохраняет данные в БД
 */
public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void sendMessage(String message) {
        System.out.println("Отправлено сообщение" + message);
    }

    public void saveToDatabase() {
        System.out.println("Данные о пользователе сохранены в базу данных!");
    }
}
