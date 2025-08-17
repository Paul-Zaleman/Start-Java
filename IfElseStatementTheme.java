import java.math.BigDecimal;
import java.math.RoundingMode;

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

        System.out.println("\n\n3. ПРОВЕРКА КОЛИЧЕСТВА ГОСТЕЙ");
        int guestCount = 1;
        if (guestCount == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guestCount % 2 == 0 && guestCount > 0) {
            System.out.printf("Записалось %d гостей. Можно формировать пары для конкурсов.", guestCount);
        } else if (guestCount % 2 != 0 && guestCount > 0) {
            System.out.printf("Записалось %d гостей. Нужны индивидуальные задания.", guestCount);
        } else {
            System.out.println("Ошибка!");
        }

        System.out.println("\n\n4. ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА");
        String nickname = "@Dog";
        char firstChar = nickname.charAt(0);

        // с помощью проверки символа на его вхождение в диапазон кодов
        if (firstChar >= 'a' && firstChar <= 'z') {
            System.out.printf("Имя %s начинается с маленькой буквы '%c'%n", nickname, firstChar);
        } else if (firstChar >= 'A' && firstChar <= 'Z') {
            System.out.printf("Имя %s начинается с большой буквы '%c'%n", nickname, firstChar);
        } else if (firstChar >= '0' && firstChar <= '9') {
            System.out.printf("Имя %s начинается с цифры '%c'%n", nickname, firstChar);
        } else {
            System.out.printf("Имя %s начинается с символа '%c'%n", nickname, firstChar);
        }

        // с помощью методов класса Character, определяющих символы
        if (Character.isLowerCase(firstChar)) {
            System.out.printf("Имя %s начинается с маленькой буквы '%c'%n", nickname, firstChar);
        } else if (Character.isUpperCase(firstChar)) {
            System.out.printf("Имя %s начинается с большой буквы '%c'%n", nickname, firstChar);
        } else if (Character.isDigit(firstChar)) {
            System.out.printf("Имя %s начинается с цифры '%c'%n", nickname, firstChar);
        } else {
            System.out.printf("Имя %s начинается с символа '%c'%n", nickname, firstChar);
        }

        System.out.println("\n5. ИНВЕНТАРИЗАЦИЯ");
        int dbSerialNumber = 123;
        int compNumber = 103;
        if (dbSerialNumber == compNumber) {
            System.out.printf("[№%d]: компьютер на 3-м этаже в кабинете 2", compNumber);
        } else {
            int dbHundreds = dbSerialNumber / 100;
            int dbTens = (dbSerialNumber / 10) % 10;
            int dbUnits = dbSerialNumber % 10;
            int compHundreds = compNumber / 100;
            int compTens = (compNumber / 10) % 10;
            int compUnits = compNumber % 10;

            String factNumber =
                    (dbHundreds == compHundreds ? String.valueOf(compHundreds) : "_") +
                    (dbTens == compTens ? String.valueOf(compTens) : "_") +
                    (dbUnits == compUnits ? String.valueOf(compUnits) : "_");

            if (dbHundreds == compHundreds || dbTens == compTens || dbUnits == compUnits) {
                System.out.println("""
                    Нет полного совпадения:
                    База данных: [№%d]
                    Фактический: [№%s]
                        """.formatted(dbSerialNumber, factNumber));
            } else {
                System.out.printf("[№%d]: оборудование не идентифицировано", compNumber);
            }
        }

        System.out.println("6. ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");
        float depositAmountRub = 321123.79f;
        float rate;
        if (depositAmountRub < 100_000) {
            rate = 0.05f;
        } else if (depositAmountRub >= 100_000 && depositAmountRub < 300_000) {
            rate = 0.07f;
        } else {
            rate = 0.10f;
        }
        float interestEarned = depositAmountRub * rate;
        float totalSumRub = depositAmountRub + interestEarned;
        System.out.println("Сумма вклада = " + depositAmountRub);
        System.out.println("Сумма начисленного % = " + interestEarned);
        System.out.println("Итоговая сумма с % = " + totalSumRub);

        BigDecimal depositAmountRubBd = new BigDecimal("321123.79");
        BigDecimal rateBd;
        if (depositAmountRubBd.compareTo(new BigDecimal("100000")) < 0) {
            rateBd = new BigDecimal("0.05");
        } else if (depositAmountRubBd.compareTo(new BigDecimal("300000")) <= 0) {
            rateBd = new BigDecimal("0.07");
        } else {
            rateBd = new BigDecimal("0.10");
        }
        BigDecimal interestEarnedBd = depositAmountRubBd.multiply(rateBd).setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalSumRubBd = depositAmountRubBd.add(interestEarnedBd).setScale(2, RoundingMode.HALF_UP);
        System.out.println("\nСумма вклада: " + depositAmountRubBd);
        System.out.println("Сумма начисленных %: " + interestEarnedBd);
        System.out.println("Итоговая сумма с %: " + totalSumRubBd);
    }
}