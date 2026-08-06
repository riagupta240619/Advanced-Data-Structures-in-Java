package Greedy;

public class Task_Scheduling {

    public static void main(String[] args) {

        int[] deadline = {2, 1, 2, 1, 3};
        int[] profit = {100, 50, 10, 20, 30};
        char[] task = {'A', 'B', 'C', 'D', 'E'};

        boolean[] slot = new boolean[3];
        char[] result = new char[3];
        int totalProfit = 0;

        for (int i = 0; i < task.length; i++) {

            for (int j = i + 1; j < task.length; j++) {
                if (profit[i] < profit[j]) {

                    int temp = profit[i];
                    profit[i] = profit[j];
                    profit[j] = temp;

                    temp = deadline[i];
                    deadline[i] = deadline[j];
                    deadline[j] = temp;

                    char ch = task[i];
                    task[i] = task[j];
                    task[j] = ch;
                }
            }
        }

        for (int i = 0; i < task.length; i++) {
            for (int j = deadline[i] - 1; j >= 0; j--) {
                if (j < 3 && !slot[j]) {
                    slot[j] = true;
                    result[j] = task[i];
                    totalProfit += profit[i];
                    break;
                }
            }
        }

        System.out.print("Tasks: ");
        for (char c : result)
            System.out.print(c + " ");

        System.out.println("\nProfit = " + totalProfit);
    }
}