package pl.adriankozlowski.structures.stack;

import java.util.Scanner;

public class RunStack {
    public static void menu() {
        System.out.println("(0) Menu\n(1) PUSH\n(2) POP\n(3) SHOW");
        System.out.println("(4) ZLICZ\n(5) REVERSE\n(6) SORT\n(7) EXIT");
    }

    /* main */
    public static void main(String[] args) {
        Stack Stack1 = new Stack();
        Stack Stack2 = new Stack();
        Stack Stack3 = new Stack();
        Scanner in = new Scanner(System.in);
        int t;
        menu();
        while (in.hasNext()) {
            t = in.nextInt();
            switch (t) {
                case 0:
                    menu();
                    break;
                case 1:
                    System.out.println("Podaj liczbę do wypchnięcia na stos");
                    t = in.nextInt();
                    Stack1.push(t);
                    menu();
                    break;
                case 2:
                    Stack1.pop();
                    menu();
                    break;
                case 3:
                    Stack1.show();
                    menu();
                    break;
                case 4:
                    System.out.println(Stack1.size());
                    menu();
                    break;
                case 5:
                    Stack1.reverse(Stack2, Stack3);
                    menu();
                    break;
                case 6:
                    Stack1.sort(Stack2);
                    menu();
                    break;
                case 7:
                    System.exit(0);
                default:
            }
        }


    }
}
