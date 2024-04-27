package chap01;

import java.util.Arrays;

public class HelloBiodome08 {

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 1) {
            System.out.println("하나의 메시지를 입력해 주세요");
            return;
        }

        String input = args[0];

        if (input.isBlank()) {
            System.out.println("메시지를 입력해주세요");
            return;
        }

        if (input.length() > 100) {
            System.out.println("메시지의 최대 길이는 100자 입니다.");
            return;
        }

        if (input.contains(" ")) {
            System.out.println("공백 없는 문자를 입력해주세요");
            return;
        }

        // 사전 단어의 길이가 긴 순서대로 정렬
        Arrays.sort(MessageFormatter.ENGLISH_DICTIONARY, (o1, o2) -> o2.length() - o1.length());
        Arrays.sort(MessageFormatter.KOREAN_DICTIONARY, (o1, o2) -> o2.length() - o1.length());

        System.out.println(input);
        String result = MessageFormatter.addWhiteSpaceEnglish(input.trim(), MessageFormatter.ENGLISH_DICTIONARY);
        System.out.println(result);

        String bonusInput = "안녕하세요새로운나무를발견했습니다";
        System.out.println("보너스 문제 입력 -> " + bonusInput);
        String bonusResult = MessageFormatter.addWhiteSpaceKorean(bonusInput, MessageFormatter.KOREAN_DICTIONARY);
        System.out.println("보너스 문제 출력 -> " + bonusResult);
    }

    static class MessageFormatter {

        private static final String[] ENGLISH_DICTIONARY = {
                "hello", "where", "this", "biodome", "help",
                "tree", "new", "is", "problem", "please",
                "need", "we", "isn’t", "there", "a",
                "your", "any", "thanks", "the", "for",
                "solution", "can", "?", "you"
        };

        private static final String[] KOREAN_DICTIONARY = {"안녕하세요", "새로운", "나무", "발견했습니다",
                "신속", "지원", "감사합니다", "당신",
                "도움", "필요합니다"};

        public static String addWhiteSpaceEnglish(String message, String[] dictionary) {
            StringBuilder result = new StringBuilder();
            StringBuilder messageTemp = new StringBuilder(message);

            while (messageTemp.length() > 0) {
                boolean isMatched = false;
                for (String word : dictionary) {
                    if (MessageFormatter.isMatched(messageTemp, word)) {
                        int wordLength = word.length();
                        messageTemp.delete(0, wordLength);
                        if (result.length() > 0 && !word.equals("?") && result.charAt(result.length() - 1) != ' ') {
                            result.append(" ");
                        }
                        result.append(word);
                        isMatched = true;
                        break;
                    }
                }

                if (!isMatched) {
                    int nextWordIndex = MessageFormatter.findWord(messageTemp.toString(), dictionary);
                    if (nextWordIndex == -1) {
                        result.append(messageTemp);
                        messageTemp.delete(0, message.length());
                    } else {
                        result.append(" ");
                        result.append(messageTemp.toString(), 0, nextWordIndex);
                        if (messageTemp.charAt(nextWordIndex) != '?') {
                            result.append(" ");
                        }
                        messageTemp.delete(0, nextWordIndex);
                    }
                }
            }
            // 물음표로 끝나지 않으면 마침표 추가
            if (result.charAt(result.length() - 1) != '?') {
                result.append(".");
            }
            return result.toString();
        }

        public static String addWhiteSpaceKorean(String message, String[] dictionary) {
            StringBuilder result = new StringBuilder();
            StringBuilder messageTemp = new StringBuilder(message);

            while (messageTemp.length() > 0) {
                boolean isMatched = false;
                for (String word : dictionary) {
                    if (isMatched(messageTemp, word)) {
                        int wordLength = word.length();
                        messageTemp.delete(0, wordLength);
                        if (result.length() > 0 && !word.equals("?") && result.charAt(result.length() - 1) != ' ') {
                            result.append(" ");
                        }

                        result.append(word);
                        if (messageTemp.length() > 0 && (messageTemp.charAt(0) == '를' || messageTemp.charAt(0) == '한' || messageTemp.charAt(0) == '의' || messageTemp.charAt(0) == '이')) {
                            if (result.charAt(result.length() - 1) == ' ') {
                                result.deleteCharAt(result.length() - 1);
                            }
                            result.append(messageTemp.charAt(0));
                            messageTemp.deleteCharAt(0);
                            result.append(" ");
                        }

                        isMatched = true;
                        break;
                    }
                }

                if (!isMatched) {
                    int nextWordIndex = findWord(messageTemp.toString(), dictionary);
                    if (nextWordIndex == -1) {
                        result.append(messageTemp);
                        messageTemp.delete(0, message.length());
                    } else {
                        result.append(" ");
                        result.append(messageTemp.toString(), 0, nextWordIndex);
                        if (messageTemp.charAt(nextWordIndex) != '?') {
                            result.append(" ");
                        }
                        messageTemp.delete(0, nextWordIndex);
                    }
                }
            }
            // 물음표로 끝나지 않으면 마침표 추가
            if (result.charAt(result.length() - 1) != '?') {
                result.append(".");
            }
            return result.toString();
        }

        private static boolean isMatched(StringBuilder message, String word) {
            return message.indexOf(word) == 0;
        }

        private static int findWord(String str, String[] dictionary) {
            for (String word : dictionary) {
                int index = str.indexOf(word);
                if (index >= 0) {
                    return index;
                }
            }
            return -1;
        }
    }
}
