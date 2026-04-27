import java.util.Scanner;

public class QuestionService {

    // int id;
    // String question;
    // String opt1;  We need to do it for all questions.Instead, we can use array. Rather we can create an object whose multiple arrays can be created.

    Question[] questions = new Question[5];// Declares and creates an array that can store references to 5 Question objects (initialized with null)
    String selection[] = new String[5]; // to get user's answer for all 5 questions

    public QuestionService() {
        // System.out.println(questions[0].getQuestion()); Error: java.lang.NullPointerException
        questions[0]= new Question(1, "Size of int?","2","6","4","8","4"); // Creates a new Question object and stores its reference at index 0 of the array
        questions[1]= new Question(2, "Size of double?","2","6","4","8","8"); 
        questions[2]= new Question(3, "Size of char?","2","6","4","8","2"); 
        questions[3]= new Question(4, "Size of long?","2","6","4","8","8"); 
        questions[4]= new Question(5, "Size of boolean?","1","2","4","6","1"); 
    }

    public void playQuiz() {
        int i = 0;
        for(Question q : questions) {
            // System.out.println(q.getQuestion());  Prints questions only
            // System.out.println(q); prints o/p in hashcode we need to get the toString in Question.java
            System.out.println("Question no. : " + q.getId()); //prints o/p in hashcode we need to get the toString in Question.java
            System.out.println(q.getQuestion());
            System.out.println(q.getOpt1());
            System.out.println(q.getOpt2());
            System.out.println(q.getOpt3());
            System.out.println(q.getOpt4());
            Scanner s = new Scanner(System.in); //to get user input(user answer)
            System.out.print("Enter your answer : ");
            selection[i] = s.nextLine();
            System.out.println("You entered : " + selection[i]);
            // new changes :
            System.out.println("Correct answer : " + q.getAnswer());
            System.out.println();
            i++;
        }

        for(String s : selection){ 
            System.out.println(s);
        }
    }

    public void printScore() {
        int score = 0;
        for(int i = 0; i<questions.length;i++) {
            Question ques = questions[i]; // store questions in 'ques'
            String actualAns = ques.getAnswer(); // the answer of question
            String userAns = selection[i];

            if(actualAns.equals(userAns)) {
                score++;
            }
        }   
        System.out.println("Your Score is : " + score +  " / " + selection.length);
        
        // Performance of User
        switch (score) {
            case 5:
                System.out.println("🎉 Excellent! You got a perfect score. Outstanding knowledge Keep it up!");
                break;
            case 4:
                System.out.println("👏 Very good! You scored high with only one mistake. Great job!");
                break;
            case 1: 
                System.out.println("🙂 Good effort! You have a decent understanding, but there's room to improve. Keep practicing!");
                break;
        
            default:
                System.out.println("⚠️ Needs improvement. Dont worry—review the concepts and try again. You'll do better next time!");
                break;
        }
    }
}
