package javaFund;

import javax.swing.JOptionPane;

class Game {

    //멤버 필드
    private int win;
    private int lose;
    private int draw;
    private boolean gameStart;

    //기본 생성자
    public Game() {
        this(0, 0, 0);   // 생성자 오버로딩 호출
    }

    //생성자 오버로딩
    public Game(int win, int lose, int draw) {
        this.win = win;
        this.lose = lose;
        this.draw = draw;
        this.gameStart = true;
    }

    //게임 실행 메서드
    public void start() {
        while (gameStart) {
            int userVal = inputUser();
            if (userVal == -1) break;

            int comVal = (int)(Math.random() * 3) + 1;
            judge(userVal, comVal);
            askContinue();
        }
        showResult();
    }

    //사용자 입력 처리
    private int inputUser() {
        String input = JOptionPane.showInputDialog(
                "가위(1), 바위(2), 보(3)를 입력하세요");

        if (input == null) return -1;

        switch (input) {
            case "1":
            case "가위": return 1;
            case "2":
            case "바위": return 2;
            case "3":
            case "보": return 3;
            default:
                JOptionPane.showMessageDialog(null, "잘못된 입력입니다!");
                return inputUser(); // 재귀로 다시 입력
        }
    }

    //승부 판정
    private void judge(int user, int com) {
        String result = "컴 : " + convert(com) +
                        ", 당신 : " + convert(user) + "\n";

        if (user == com) {
            result += "무승부!";
            draw++;
        }
        else if (
                (user == 1 && com == 3) ||
                (user == 2 && com == 1) ||
                (user == 3 && com == 2)
        ) {
            result += "당신 승리!";
            win++;
        }
        else {
            result += "컴 승리!";
            lose++;
        }

        JOptionPane.showMessageDialog(null, result);
    }

    //계속 여부
    private void askContinue() {
        String cont = JOptionPane.showInputDialog("계속 하시겠습니까? (y/n)");
        if (cont == null || cont.equalsIgnoreCase("n")) {
            gameStart = false;
        }
    }

    //결과 출력
    private void showResult() {
        int total = win + lose + draw;
        double rate = (total == 0) ? 0 : (win / (double) total) * 100;

        JOptionPane.showMessageDialog(null,
                "===== 최종 결과 =====\n" +
                "승 : " + win + "\n" +
                "패 : " + lose + "\n" +
                "무 : " + draw + "\n" +
                String.format("승률 : %.2f%%", rate));
    }

    //값 → 문자열 변환
    private String convert(int v) {
        switch (v) {
            case 1: return "가위";
            case 2: return "바위";
            case 3: return "보";
        }
        return "";
    }
}

public class Gawibawibo {

    public static void main(String[] args) {

        // 기본 생성자
        Game game1 = new Game();
        game1.start();

        // 생성자 오버로딩 사용 예
        // Game game2 = new Game(1, 0, 0);
        // game2.start();
    }
}
/*
 * 사용자는 가위,바위,보 대신 1,2,3, 을 값으로 낼수 있습니다. 
 * 그럼 프로그램은 이 값을 분석해서 랜덤한 컴퓨터의 값(Math.random())
 * 으로 게임을 진행시키고, 결과를 다음처럼 출력 시키세요
 * 컴 : 가위, 당신 : 보
 * 컴 승리!
 * 
 * 위 처럼 결과를 출력 후, 게임을 다시 할 건지를 물어봅니다.
 * ex>게임을 계속 할래요? 이때 사용자는 y or n 를 입력 하게 되고
 * 이에 따라서 게임이 계속되거나 끝나거나 합니다.
 * 
 * 단 게임이 끝날때는 총전적, 승,패,무, 승률(소수점 2자리까지)을 
 * 출력 시키고 게임을 종료시킵니다.
 */