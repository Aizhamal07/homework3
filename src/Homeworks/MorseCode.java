package Homeworks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MorseCode implements MilitaryCommunication {
    private static final Logger logger = LogManager.getLogger(MorseCode.class);
    private String morseCodeMsg;
    public String getMorseCodeMsg() {
        return send();
    }
    public void setMorseCodeMsg(String morseCodeMsg) {
        this.morseCodeMsg = morseCodeMsg;
    }

    @Override
    public String send() {
        boolean letterOnly = false;
        String convertedMessage = "";
        for (int i = 0; i < morseCodeMsg.length(); i++) {
            if (!Character.isLetter(morseCodeMsg.charAt(i))) {
                letterOnly = true;
                break;
            }
        }
        if (!letterOnly) {
            for (int i = 0; i < morseCodeMsg.length(); i++) {
                char c = morseCodeMsg.charAt(i);
                switch (c) {
                    case 'a':
                        convertedMessage += ".-";
                        break;
                    case 'b':
                        convertedMessage += "-...";
                        break;

                    case 'c':
                        convertedMessage += "-.-.";
                        break;
                    case 'd':
                        convertedMessage += "-..";
                        break;
                    case 'e':
                        convertedMessage += ".";
                        break;
                    case 'f':
                        convertedMessage += "..-.";
                        break;

                    case 'g':
                        convertedMessage += "--. ";
                        break;
                    case 'h':
                        convertedMessage += "....";
                        break;

                    case 'i':
                        convertedMessage += "..";
                        break;
                    case 'j':
                        convertedMessage += ".---";
                        break;
                    case 'k':
                        convertedMessage += "-.-";
                        break;
                    case 'l':
                        convertedMessage += ".-..";
                        break;
                    case 'm':
                        convertedMessage += "--";
                        break;
                    case 'n':
                        convertedMessage += "-.";
                        break;

                    case 'o':
                        convertedMessage += "---";
                        break;
                    case 'p':
                        convertedMessage += ".--.";
                        break;
                    case 'q':
                        convertedMessage += "--.-";
                        break;
                    case 'r':
                        convertedMessage += ".-. ";
                        break;

                    case 's':
                        convertedMessage += "...";
                        break;
                    case 't':
                        convertedMessage += "-";
                        break;

                    case 'u':
                        convertedMessage += "..-";
                        break;
                    case 'v':
                        convertedMessage += "...-";
                        break;
                    case 'w':
                        convertedMessage += ".--";
                        break;
                    case 'x':
                        convertedMessage += "-..-";
                        break;
                    case 'y':
                        convertedMessage += "-.--";
                        break;
                    case 'z':
                        convertedMessage += "--..";
                        break;

                    default:
                        break;
                }
            }
        }
        boolean isSecure = false;

        for (int i = 0; i < convertedMessage.length(); i++) {

            char c = convertedMessage.charAt(i);
            if ((c == ('.')) || (c == '-') || c == ' ') {
                isSecure = true;
            } else {
                isSecure = false;
            }
        }

        if (isSecure) {
            logger.info("Secure!");
            logger.info("Message \"" + morseCodeMsg + "\" is successfully sent");
        } else {
            logger.info("Not secure!");
            logger.info("Not sent!");

        }


        return morseCodeMsg = convertedMessage;

    }


    @Override
    public String receive() {

        boolean isSecure = false;
        for (int i = 0; i < morseCodeMsg.length(); i++) {
            char c = morseCodeMsg.charAt(i);
            if ((c == ('.')) || (c == '-') || c == ' ') {
                isSecure = true;
            } else {
                isSecure = false;
            }
        }
        if (isSecure) {
            logger.info("Received a new message: " + morseCodeMsg);
            return morseCodeMsg;
        } else {
            logger.info("No new message!");
        }
        return morseCodeMsg;

    }

}