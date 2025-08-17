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
        int guestCount = -1;
        if (guestCount == 0) {
            System.out.println("Пока никто не записался на мероприятие!");
        } else if (guestCount > 0) {
            String guestWord;
            if (guestCount % 100 >= 11 && guestCount % 100 <= 14) {
                guestWord = "гостей";
            } else if (guestCount % 10 == 1) {
                guestWord = "гость";
            } else if (guestCount % 10 >= 2 && guestCount % 10 <= 4) {
                guestWord = "гостя";
            } else {
                guestWord = "гостей";
            }

            if (guestCount % 2 == 0) {
                System.out.printf("Записалось %d %s. Можно формировать пары для конкурсов.", 
                        guestCount, guestWord);
            } else {
                System.out.printf("Записалось %d %s. Нужны индивидуальные задания.", guestCount, guestWord);
            }
        } else {
            System.out.println("Ошибка!");
        }

        System.out.println("\n\n4. ОПРЕДЕЛЕНИЕ ПЕРВОГО СИМВОЛА НИКНЕЙМА");
        String nickname = "@Dog";
        char firstChar = nickname.charAt(0);

        // с помощью проверки символа на его вхождение в диапазон кодов
        String description = "символа";
        if (firstChar >= 'a' && firstChar <= 'z') {
            description = "маленькой буквы";
        } else if (firstChar >= 'A' && firstChar <= 'Z') {
            description = "большой буквы";
        } else if (firstChar >= '0' && firstChar <= '9') {
            description = "цифры";
        }
        System.out.printf("Имя %s начинается с %s '%c'%n", nickname, description, firstChar);

        // с помощью методов класса Character, определяющих символы
        description = "символа";
        if (Character.isLowerCase(firstChar)) {
            description = "маленькой буквы";
        } else if (Character.isUpperCase(firstChar)) {
            description = "большой буквы";
        } else if (Character.isDigit(firstChar)) {
            description = "цифры";
        }
        System.out.printf("Имя %s начинается с %s '%c'%n", nickname, description, firstChar);

        System.out.println("\n5. ИНВЕНТАРИЗАЦИЯ");
        int dbSerialNumber = 123;
        int pcNumber = 103;
        if (dbSerialNumber == pcNumber) {
            System.out.printf("[№%d]: компьютер на 3-м этаже в кабинете 2", pcNumber);
        } else {
            int dbHundreds = dbSerialNumber / 100;
            int dbTens = (dbSerialNumber / 10) % 10;
            int dbOnes = dbSerialNumber % 10;
            int pcHundreds = pcNumber / 100;
            int pcTens = (pcNumber / 10) % 10;
            int pcOnes = pcNumber % 10;

            String factNumber =
                    (dbHundreds == pcHundreds ? String.valueOf(pcHundreds) : "_") +
                    (dbTens == pcTens ? String.valueOf(pcTens) : "_") +
                    (dbOnes == pcOnes ? String.valueOf(pcOnes) : "_");

            if (dbHundreds == pcHundreds || dbTens == pcTens || dbOnes == pcOnes) {
                System.out.println("""
                    Нет полного совпадения:
                    База данных: [№%d]
                    Фактический: [№%s]
                        """.formatted(dbSerialNumber, factNumber));
            } else {
                System.out.printf("[№%d]: оборудование не идентифицировано", pcNumber);
            }
        }

        System.out.println("6. ПОДСЧЕТ НАЧИСЛЕННЫХ БАНКОМ %");
        float depositAmountRub = 321123.79f;
        float rate = 0.10f;
        if (depositAmountRub < 100_000) {
            rate = 0.05f;
        } else if (depositAmountRub >= 100_000 && depositAmountRub < 300_000) {
            rate = 0.07f;
        }

        float interestEarned = depositAmountRub * rate;
        float totalSumRub = depositAmountRub + interestEarned;
        System.out.println("Сумма вклада = " + depositAmountRub);
        System.out.println("Сумма начисленного % = " + interestEarned);
        System.out.println("Итоговая сумма с % = " + totalSumRub);

        BigDecimal depositAmountRubBd = new BigDecimal("321123.79");
        BigDecimal rateBd = new java.math.BigDecimal("0.10");
        if (depositAmountRubBd.compareTo(BigDecimal.valueOf(100000)) < 0) {
            rateBd = new BigDecimal("0.05");
        } else if (depositAmountRubBd.compareTo(BigDecimal.valueOf(300000)) <= 0) {
            rateBd = new BigDecimal("0.07");
        } else {
            rateBd = new BigDecimal("0.10");
        }
        BigDecimal interestEarnedBd = depositAmountRubBd.multiply(rateBd).setScale(2, RoundingMode.HALF_UP);
        BigDecimal totalSumRubBd = depositAmountRubBd.add(interestEarnedBd).setScale(2, RoundingMode.HALF_UP);
        System.out.println("\nСумма вклада: " + depositAmountRubBd);
        System.out.println("Сумма начисленных %: " + interestEarnedBd);
        System.out.println("Итоговая сумма с %: " + totalSumRubBd);

        System.out.println("\n7. ОПРЕДЕЛЕНИЕ ОЦЕНКИ ПО ПРЕДМЕТАМ");
        double historyPercent = 59.0;
        int historyGrade = 2;
        if (historyPercent >= 92) {
            historyGrade = 5;
        } else if (historyPercent >= 74) {
            historyGrade = 4;
        } else if (historyPercent >= 61) {
            historyGrade = 3;
        }

        double programmingPercent = 92.0;
        int programmingGrade = 2;
        if (programmingPercent >= 92) {
            programmingGrade = 5;
        } else if (programmingPercent >= 74) {
            programmingGrade = 4;
        } else if (programmingPercent >= 61) {
            programmingGrade = 3;
        }
        
        System.out.println("История: " + historyGrade);
        System.out.println("Программирование: " + programmingGrade);

        double averageGrade = (historyGrade + programmingGrade) / 2.0;
        double averagePercent = (historyPercent + programmingPercent) / 2.0;
        System.out.println("Средний балл = " + averageGrade);
        System.out.println("Средний процент = " + averagePercent);

        System.out.println("\n8. РАСЧЕТ ГОДОВОЙ ПРИБЫЛИ");
        BigDecimal monthlyRevenueRubBd = new BigDecimal("13025.233");
        BigDecimal monthlyRentExpenseRubBd = new BigDecimal("5123.018");
        BigDecimal monthlyProductionExpenseRuBd = new BigDecimal("9001.729");

        BigDecimal totalMonthlyExpensesRubBd = monthlyRentExpenseRubBd.add(monthlyProductionExpenseRuBd);
        BigDecimal monthlyProfitRubBd = monthlyRevenueRubBd.subtract(totalMonthlyExpensesRubBd);
        BigDecimal yearlyProfitRubBd = monthlyProfitRubBd.multiply(BigDecimal.valueOf(12));

        String sign = "";
        if (yearlyProfitRubBd.compareTo(BigDecimal.ZERO) > 0) {
            sign = "+";
        }

        System.out.println("Прибыль за год: " + sign + yearlyProfitRubBd + "руб.");
    }
}