package ir.sbu.db.State;

import ir.sbu.db.Controller.MainController;
import ir.sbu.db.Model.*;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fkohankhaki on 5/13/18.
 */
public class ExamState implements BotState
{
    private long chatId;
    MainController mainController;
    public ExamState(MainController mainController, long chatId)
    {
        this.chatId = chatId;
        this.mainController = mainController;
    }

    @Override
    public void validate(Update update)
    {
        if(update.getMessage().getText().length() < 30)
        {
            Exam exam = new Exam();
            List<ExamModel> examModelList = exam.getAll();
            String message = "";
            for (int i = 0; i < examModelList.size(); i++)
            {
                ExamModel examModel = examModelList.get(i);
                message += "Section: " + examModel.getSection() + "\n" + "Date: " + examModel.getDate() + "\n" + "Price: " + examModel.getPrice() + "\n\n";
            }
            String keyboardMessage = "Ok";
            this.changeState("exam");
            this.response(message, keyboardMessage);
        }
    }

    @Override
    public void changeState(String state)
    {
        User user = new User();
        //save state register for user in database !
        user.updateState(this.chatId, state);
    }

    @Override
    public void response(String message, String keyboardMessage)
    {
        SendMessage sm = new SendMessage() // Create a message object object
                .setChatId(this.chatId)
                .setText(message);

        // Create ReplyKeyboardMarkup object
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        // Create the keyboard (list of keyboard rows)
        List<KeyboardRow> keyboard = new ArrayList<>();
        // Create a keyboard row
        KeyboardRow row = new KeyboardRow();
        // Set each button, you can also use KeyboardButton objects if you need something else than text
        System.out.println();
        String[] kmessages = keyboardMessage.split(",");
        for (int i = 0; i < kmessages.length; i++)
        {
            row.add(kmessages[i]);
        }
        keyboard.add(row);
        // Set the keyboard to the markup
        keyboardMarkup.setKeyboard(keyboard);
        // Add it to the message

        sm.setReplyMarkup(keyboardMarkup);

        try
        {
            this.mainController.execute(sm);// Sending our message object to user
        }
        catch (TelegramApiException e)
        {
            e.printStackTrace();
        }
    }
}
