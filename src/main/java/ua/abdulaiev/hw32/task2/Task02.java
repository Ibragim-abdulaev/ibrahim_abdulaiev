package ua.abdulaiev.hw32.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.Integer.*;

public class Task02 {
    public static void main(String[] args) throws InterruptedException {
        List<HorseThread> listHorse = new ArrayList<>();
        int countHorse;
        int youHorse;
        do {
            System.out.println("Write negative number for exit");
            try {
                System.out.print("Write the number of participating horses: ");
                countHorse = parseInt(new Scanner(System.in).next());
                System.out.print(System.lineSeparator());
                if (countHorse < 1) {
                    break;
                }
                System.out.print("Select horse number for bets: ");
                youHorse = parseInt(new Scanner(System.in).next());
                System.out.print(System.lineSeparator());
                if (youHorse >= 1) {
                    if (youHorse > countHorse) {
                        System.out.println("Error! The selected horse does not exist" + System.lineSeparator());
                        continue;
                    }
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                continue;
            }
            runHorse(listHorse, youHorse, countHorse);
        } while (true);
    }

    public static void runHorse(List<HorseThread> listHorse, int youHorse, int countHorse) throws InterruptedException {
        System.out.println("Start of the race...");
        int i = 1;
        while (i <= countHorse) {
            HorseThread horse = new HorseThread(i);
            listHorse.add(horse);
            horse.start();
            i++;
        }
        listHorse.get(youHorse - 1).join();
        int place = listHorse.get(youHorse - 1).getPlace();
        System.out.println("Your horse took " + place +" place" + System.lineSeparator());
    }
}
