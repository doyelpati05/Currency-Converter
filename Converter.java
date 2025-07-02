import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🌍 Welcome to the Offline Java Currency Converter!");
        System.out.print("Enter base currency (e.g., USD): ");
        String base = scanner.nextLine().trim().toUpperCase();

        System.out.print("Enter target currency (e.g., INR): ");
        String target = scanner.nextLine().trim().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        convertCurrency(base, target, amount);
    }

    public static void convertCurrency(String base, String target, double amount) {
        Map<String, Double> rates = new HashMap<>();

        // ✅ Example: hardcoded rates (you can add more)
        rates.put("USD_INR", 83.21);
        rates.put("USD_EUR", 0.92);
        rates.put("EUR_INR", 90.55);
        rates.put("INR_USD", 0.012);
        rates.put("INR_EUR", 0.011);
        rates.put("EUR_USD", 1.09);

        String key = base + "_" + target;

        if (!rates.containsKey(key)) {
            System.out.println("❌ Conversion rate for " + base + " to " + target + " not available.");
            return;
        }

        double rate = rates.get(key);
        double result = rate * amount;

        System.out.printf("🔁 1 %s = %.4f %s\n", base, rate, target);
        System.out.printf("💰 %.2f %s = %.2f %s\n", amount, base, result, target);
    }
}
