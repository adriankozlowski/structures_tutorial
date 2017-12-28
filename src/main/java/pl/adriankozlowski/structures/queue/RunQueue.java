package pl.adriankozlowski.structures.queue;

import java.util.Scanner;


public class RunQueue {
    /* menu */
    public static void menu() {
        System.out.println("(0) MENU\n(1) ADD\n(2) DELETE\n(3) SHOW");
        System.out.println("(4) ZLICZ\n(5) COPY\n(6) SCAL\n(7) EXIT");
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Queue queue = new Queue();
        Queue queue2 = new Queue();

        int t;
        while (in.hasNext()) {
            menu();
            t = in.nextInt();

            switch (t) {
                case 0:
                    menu();
                    break;
                case 1:
                    t = in.nextInt();
                    queue.add(t);
                    break;
                case 2:
                    queue.delete();
                    break;
                case 3:
                    queue.show();
                    break;
                case 4:
                    System.out.println(queue.count());
                    break;
                case 5:
                    queue.copy(queue2);
                    queue2.show();
                    break;
                case 6:
                    queue.merge(queue2);
                    break;
                case 7:
                    System.exit(0);
            }
        }

    }
}
