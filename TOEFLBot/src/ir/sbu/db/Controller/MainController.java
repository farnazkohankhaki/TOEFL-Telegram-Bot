package ir.sbu.db.Controller;

import ir.sbu.db.Model.User;
import ir.sbu.db.Model.UserModel;
import ir.sbu.db.State.*;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public class MainController extends TelegramLongPollingBot
{
    boolean debug = true;
    public String addWord, addWordMeaning, qans;
    @Override
    public void onUpdateReceived(Update update)
    {
        if (update.hasMessage() && update.getMessage().hasText())
        {
            long chat_id = update.getMessage().getChatId();
            String message = update.getMessage().getText().toString();

            User user = new User();
            if(!user.isExist("id", chat_id))
            {
                UserModel userModel = new UserModel();
                userModel.setId(chat_id);
                userModel.setState("null");
                user.insert(userModel);
            }

            String userState = user.getState(chat_id);

            if(debug)
            {
                System.out.println("user state: " + userState);
                System.out.println("user message: " + message);
            }

            switch (userState)
            {
                case "null":
                    if (message.equals("/start"))
                    {
                        StartState startState = new StartState(this, chat_id);
                        startState.validate(update);
                    }
                    break;
                case "start":
                    if (message.equals("Register as Client"))
                    {
                        WaitingState waitingState = new WaitingState(this, chat_id);
                        waitingState.validate(update);
                    }
                    else if(message.equals("Login as Admin"))
                    {
                        VerifyingAdminState verifyingAdminState = new VerifyingAdminState(this, chat_id);
                        verifyingAdminState.validate(update);
                    }
                    break;
                case "waiting":
                    if (message.equals("New Word"))
                    {
                        DisplayingWordState displayingWordState = new DisplayingWordState(this, chat_id);
                        displayingWordState.validate(update);
                    }
                    else if (message.equals("Question"))
                    {
                        QuestionState questionState = new QuestionState(this, chat_id);
                        questionState.validate(update);
                    }
                    else if (message.equals("Back to Home"))
                    {
                        StartState startState = new StartState(this, chat_id);
                        startState.validate(update);
                    }
                    else if (message.equals("List of Institues"))
                    {
                        InstitueState institueState = new InstitueState(this, chat_id);
                        institueState.validate(update);
                    }
                    else if (message.equals("List of Exams"))
                    {
                        ExamState examState = new ExamState(this, chat_id);
                        examState.validate(update);
                    }
                    else if (message.equals("New Idiom"))
                    {
                        IdiomState idiomState = new IdiomState(this, chat_id);
                        idiomState.validate(update);
                    }
                    else if (message.equals("New Idiom Question"))
                    {
                        IdiomQuestionState idiomQuestionState = new IdiomQuestionState(this, chat_id);
                        idiomQuestionState.validate(update);
                    }
                    break;
                case "idiom":
                    if (message.equals("Ok"))
                    {
                        WaitingState waitingState = new WaitingState(this, chat_id);
                        waitingState.validate(update);
                    }
                    break;
                case "idiomQuestion":
                    if (true)
                    {
                        AnswerState answerState = new AnswerState(this, chat_id);
                        answerState.validate(update);
                    }
                    break;
                case "displayWord":
                    if (message.equals("Ok"))
                    {
                        WaitingState waitingState = new WaitingState(this, chat_id);
                        waitingState.validate(update);
                    }
                    break;
                case "institue":
                    if (message.equals("Ok"))
                    {
                        WaitingState waitingState = new WaitingState(this, chat_id);
                        waitingState.validate(update);
                    }
                    break;
                case "exam":
                    if (message.equals("Ok"))
                    {
                        WaitingState waitingState = new WaitingState(this, chat_id);
                        waitingState.validate(update);
                    }
                    break;
                case "question":
                    if (true)
                    {
                        AnswerState answerState = new AnswerState(this, chat_id);
                        answerState.validate(update);
                    }
                    break;
                case "answer":
                    if (message.equals("Ok"))
                    {
                        WaitingState waitingState = new WaitingState(this, chat_id);
                        waitingState.validate(update);
                    }
                    break;
                case "verifyingAdmin":
                    if (message.equals("farnaz")) //abcd is password
                    {
                        AdminWaitingState adminWaitingState = new AdminWaitingState(this, chat_id);
                        adminWaitingState.validate(update);
                    }
                    else
                    {
                        VerifyingAdminState verifyingAdminState = new VerifyingAdminState(this, chat_id);
                        verifyingAdminState.validate(update);
                    }
                    break;
                case "addWord":
                    if(true)
                    {
                        addWord = message;
                        AddWordMeaningState addWordMeaningState = new AddWordMeaningState(this, chat_id);
                        addWordMeaningState.validate(update);
                    }
                    break;
                case "addWordMeaning":
                    if(true)
                    {
                        addWordMeaning = message;
                        AdminWaitingState adminWaitingState = new AdminWaitingState(this, chat_id);
                        adminWaitingState.validate(update, addWord, addWordMeaning);
                    }
                    break;
                case "adminWaiting":
                    if (message.equals("Add Word"))
                    {
                        AddWordState addWordState = new AddWordState(this, chat_id);
                        addWordState.validate(update);
                    }
                    else if (message.equals("Back to Home"))
                    {
                        StartState startState = new StartState(this, chat_id);
                        startState.validate(update);
                    }
                    break;
                default:
                    if (debug)
                        System.out.println("default");
            }
        }
    }

    @Override
    public String getBotUsername()
    {
        return "toeflfkbot";
    }

    @Override
    public String getBotToken()
    {
         return "513012193:AAGFQxXVYbjQUayxw4R8pCK7PdnXzHBKhAc";
    }
}


