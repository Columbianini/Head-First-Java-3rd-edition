package Chapter16;

public class QuizCard {
    private final String question;
    private final String answer;

    public QuizCard(String q, String a){
        question = q;
        answer = a;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }
}
