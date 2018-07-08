import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLights {
    public static final String MINUTE = "минут";
    public static final String SECOND = "секунд";
    public static void main(String[] args) {
        String green = "зеленый", yellow = "желтый", red = "красный";
        String unitTime = SECOND;
        int greenTime, yellowTime, redTime;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        greenTime = requireTimeForColor(green, unitTime, reader);
        yellowTime = requireTimeForColor(yellow, unitTime, reader);
        redTime = requireTimeForColor(red, unitTime, reader);
        while (true) {
            try {
                outputTrafficLight(green, unitTime, greenTime);
                outputTrafficLight(yellow, unitTime, yellowTime);
                outputTrafficLight(red, unitTime, redTime);
            } catch (InterruptedException e) {
                System.out.println("Ошибка системы! Повторите попытку позже.");
                break;
            }
        }
    }

    public static int requireTimeForColor(String color, String unitTime, BufferedReader reader) {
        int time = 0;
        boolean wrongInput = true;
        System.out.println("Сколько " + unitTime + " должен гореть " + color + " цвет?");
        while (wrongInput) {
            try {
                time = Integer.parseInt(reader.readLine());
                wrongInput = false;
            } catch (Exception e) {
                System.out.println("Неверный формат ввода! Введите целое число "+ unitTime + "!");
            }
        }
        return time;
    }

    public static void outputTrafficLight(String colorName, String unitTime, int colorTime) throws InterruptedException {
        int countSecond = 0;
        if (unitTime == SECOND) countSecond = colorTime;
        else if (unitTime == MINUTE) countSecond = colorTime * 60;
        for (int i = countSecond; i > 0; i--) {
            System.out.println(colorName + ":    " + i + "...");
            Thread.sleep(1000);
        }
    }
}
