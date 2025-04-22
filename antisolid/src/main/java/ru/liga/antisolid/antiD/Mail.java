package ru.liga.antisolid.antiD;

/**
 * Dependency Inversion Principle
 * Нарушение: Mail использует конкретный класс Gmail.
 * В идеале необходим интерфейс для классов, которые
 * отправляют сообщения
 */
public class Mail {
    private final Gmail gmail;

    public Mail() {
        gmail = new Gmail();
    }

    public void send(String message) {
        gmail.send(message);
    }

    static class Gmail {
        public void send(String message) {
            System.out.println("Отправка сообщения через Gmail: " + message);
        }
    }

    public static void main(String[] args) {
        Mail mail = new Mail();
        mail.send("Привет! Я нарушил DIP!");
    }
}
