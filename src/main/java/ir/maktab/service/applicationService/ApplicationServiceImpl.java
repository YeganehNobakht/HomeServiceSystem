package ir.maktab.service.applicationService;

import ir.maktab.service.exceptions.unchecked.InvalidInputRangeException;

import java.util.Scanner;

public class ApplicationServiceImpl implements ApplicationService{

    private final Scanner scanner;

    public ApplicationServiceImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void runApplication() {
        while (true) {
            System.out.println("1.Sign in as manager \n" +
                    "2.Sign in as customer \n" +
                    "3.Sign in as employee \n");

            boolean appInput = false;

            while (!appInput) {
                //TODO::method get instruction
                int instructionItem = 0;
                try {
                    String instruction = scanner.next();
                    instructionItem = Integer.parseInt(instruction);
                    if (instructionItem < 1 || instructionItem > 3)
                        throw new InvalidInputRangeException("Out of legal input range");
                    appInput = true;
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Wrong input type! try again...");
                } catch (InvalidInputRangeException exception) {
                    throw new InvalidInputRangeException("Invalid input");
                }
                //TODO :: method
                switch (instructionItem) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;

                }

            }//scanner.hasNext();
        }
    }
}
