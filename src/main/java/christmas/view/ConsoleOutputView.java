package christmas.view;

import static christmas.message.OutputMessage.WELCOME_MESSAGE;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printWelcome() {
        System.out.println(WELCOME_MESSAGE.getMessage());
    }
}
