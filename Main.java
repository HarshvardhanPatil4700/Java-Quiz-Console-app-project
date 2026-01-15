import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        char choice;

        do {
            QuestionService service = new QuestionService();
            service.playQuiz();
            service.printScore();

            System.out.print("Do you want to retry the quiz? (y/n): ");
            choice = sc.next().toLowerCase().charAt(0);

        } while (choice == 'y'); // if user enters 'y' then user can retry else not

        System.out.println("Thank you for playing!");
        sc.close();
    }
}
