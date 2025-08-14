public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. ПЕРЕВОД ПСЕВДОКОДА НА ЯЗЫК JAVA");
        boolean isMale = true;
        if (!isMale) {
            System.out.println("Женщины - вы самый прекрасный пол на Земле");
        } else {
            System.out.println("Здарова, мужик!");
        }

        int age = 21;
        if (age > 18) {
            System.out.println("Можно получить ВУ категории \"В\"");
        } else {
            System.out.println("Нельзя получить ВУ категории \"В\"");
        }

        double heightMeters = 1.85;
        if (heightMeters < 1.8) {
            System.out.println("Ваш рост ниже 1.8 м");
        } else {
            System.out.println("Ваш рост выше 1.8 м");
        }

        System.out.println("\n2. ПОИСК БОЛЬШЕГО ЧИСЛА ШАГОВ");
        int yesterdayStepCount = 11165;
        int todayStepCount = 5920;
        System.out.printf("Вчера: %d, сегодня: %d%n", yesterdayStepCount, todayStepCount);

        if (yesterdayStepCount > todayStepCount) {
            System.out.println("Вчера больше");
        } else if (yesterdayStepCount < todayStepCount) {
            System.out.println("Сегодня больше");
        } else {
            System.out.println("Поровну");
        }

        double averageStepCount = (yesterdayStepCount + todayStepCount) / 2.0;
        System.out.printf("Cреднее %.2f", averageStepCount);
    }
}