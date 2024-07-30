import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class QuizApplication
{


    public static int new_quiz (String name, String question_bank_path){
        Quiz quiz = new Quiz();
        User user = new User(name);
        quiz.generate_quiz(question_bank_path);
        int x = quiz.display_next_question();

        while (x != -1) {
            user.update_score(x);
            x = quiz.display_next_question();
        }
        return user.get_score();
    }

    

    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList<Integer>> user_scores_hm = new HashMap<>();
        String fp = "/Users/decatrox/OOP_Task/src/main/resources/questions.txt";
        String name = "";
        int score;

        while (!name.equals("exit")) {
            System.out.print("Name: ");
            name = sc.nextLine();
            score = new_quiz(name, fp);
            if (user_scores_hm.containsKey(name)) {
                ArrayList<Integer> scores = new ArrayList<>(user_scores_hm.get(name));
                scores.add(score);
                user_scores_hm.put(name, scores);
            }
            System.out.println("Your score is: " + score + "\n\n\n");
        }

        printTable(user_scores_hm);




//        Quiz quiz = new Quiz(4, 20);
//        Quiz quiz = new Quiz();
//        User user = new User("Omar");
//        quiz.generate_quiz(fp);
//        int x = quiz.display_next_question();
//
//        while (x != -1) {
//            user.update_score(x);
//            x = quiz.display_next_question();
//        }
//
//        System.out.println(user.get_score());
//        QuestionReader qqr = new QuestionReader();
//        Question q = qqr.createQuestionFromLine("What is the capital of France?;Paris;London;Berlin;Madrid;Paris");
//        System.out.println(q.toString());

//        List<Question> lq = qqr.readFile("/Users/decatrox/OOP_Task/src/main/resources/questions.txt");
//        for (Question q : lq) {
//            System.out.println(q);
//        }
//        System.out.println(System.getProperty("user.dir"));
    }
}
