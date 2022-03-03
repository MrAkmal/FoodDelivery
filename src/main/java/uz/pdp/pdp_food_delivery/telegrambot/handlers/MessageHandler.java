package uz.pdp.pdp_food_delivery.telegrambot.handlers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import uz.pdp.pdp_food_delivery.rest.entity.AuthUser;
import uz.pdp.pdp_food_delivery.rest.repository.auth.AuthUserRepository;
import uz.pdp.pdp_food_delivery.telegrambot.handlers.base.AbstractHandler;
import uz.pdp.pdp_food_delivery.telegrambot.processors.AuthorizationProcessor;
import uz.pdp.pdp_food_delivery.telegrambot.states.State;

@Component
@RequiredArgsConstructor
public class MessageHandler extends AbstractHandler {
    private final AuthUserRepository repository;
    private final AuthorizationProcessor authorizationProcessor;

    @Override
    public void handle(Update update) {

        String chatId = update.getMessage().getChatId().toString();
        Message message = update.getMessage();
        String text = message.getText();
        boolean existChatId = repository.existsByChatId(chatId);

        if ("/start".equals(text) && !existChatId) {
            AuthUser user = new AuthUser();
            user.setChatId(chatId);
            repository.save(user);
            authorizationProcessor.process(message, State.getState(chatId));
        }
    }
}


//
////        SendMessage sendMessage1 = new SendMessage(chatId, update.getMessage().toString());
////        bot.executeMessage(sendMessage1);
//        if (update.getMessage().hasText()) {
//            SendMessage sendMessage = new SendMessage();
//
//
//            if (!existChatId) {
//                AuthUserCreateDto createDto = new AuthUserCreateDto(chatId);
//                service.create(createDto);
//                sendMessage.setReplyMarkup(new ForceReplyKeyboard());
//                bot.executeMessage(sendMessage);
//                authorizationProcessor.process(message, State.getState(chatId));
//            }
//            if (Objects.isNull(role)) {
//                authorizationProcessor.process(message, State.getState(chatId));
//            } else if (active) {
////                menuProcessor.menu(chatId,role);
//            } else {
//                //sabr kardam
//            }
////            message.setChatId(update.getMessage().getChatId().toString());
////            message.setText(update.getMessage().getText());
//
//            if ("/start".equals(text) && active) {
////                menuProcessor.menu(chatId, role);
//
//
//                State.setMenuState(chatId, MenuState.UNDEFINED);
//                if (Objects.isNull(role)) {
//                    authorizationProcessor.process(message, State.getState(chatId));
//                }
//                if (Objects.nonNull(role) && State.getMenuState(chatId).equals(MenuState.UNDEFINED)) {
////                    menuProcessor.menu(chatId, role);
//                }
//                return;
//            }
//            bot.executeMessage(sendMessage);
//        }
//    }
//}
