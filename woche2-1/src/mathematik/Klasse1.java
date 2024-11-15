package mathematik;

public class Klasse1 {

	public static void main(String[] args) {
		Klasse1 instance = new Klasse1();
        int quersumme753 = instance.quersumme(753);
        int quersumme101 = instance.quersumme(101);

        System.out.println("Quersumme von 753: " + quersumme753);
        System.out.println("Quersumme von 101: " + quersumme101);
    }

    public int quersumme(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;	
	}

}
