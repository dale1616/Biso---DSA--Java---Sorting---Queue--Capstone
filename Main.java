
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ITSupportTicketSystem {

    static Scanner Input = new Scanner(System.in);

    static ArrayList<Integer> TicketNumbers = new ArrayList<>();
    static ArrayList<String> RequesterNames = new ArrayList<>();
    static ArrayList<String> TicketIssues = new ArrayList<>();
    static ArrayList<String> TicketDates = new ArrayList<>();
    static ArrayList<String> TicketStatuses = new ArrayList<>();

    static Queue<Integer> SupportQueue = new LinkedList<>();

    static int NextTicketNumber = 1;
    static boolean IsRunning = true;

    public static void main(String[] args) {

        while (IsRunning) {
            DisplayMenu();
            int Choice = GetIntegerInput("Enter your choice: ");

            switch (Choice) {
                case 1:
                    CreateTicket();
                    break;
                case 2:
                    DisplayAllTickets();
                    break;
                case 3:
                    DisplayPendingQueue();
                    break;
                case 4:
                    ProcessNextTicket();
                    break;
                case 5:
                    PeekNextTicket();
                    break;
                case 6:
                    BubbleSortTickets();
                    break;
                case 7:
                    InsertionSortTickets();
                    break;
                case 8:
                    SearchTicket();
                    break;
                case 9:
                    IsRunning = false;
                    System.out.println("\nExiting IT Support Ticket System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-9.");
            }
        }

        Input.close();
    }

    public static void DisplayMenu() {
        System.out.println("\n======================================");
        System.out.println("     IT SUPPORT TICKET SYSTEM");
        System.out.println("======================================");
        System.out.println("1. Create Ticket");
        System.out.println("2. Display All Tickets");
        System.out.println("3. Display Pending Queue");
        System.out.println("4. Process Next Ticket");
        System.out.println("5. View Next Ticket");
        System.out.println("6. Sort Tickets - Bubble Sort");
        System.out.println("7. Sort Tickets - Insertion Sort");
        System.out.println("8. Search Ticket");
        System.out.println("9. Exit");
        System.out.println("======================================");
    }

    public static int GetIntegerInput(String Message) {
        while (true) {
            System.out.print(Message);

            if (Input.hasNextInt()) {
                int Number = Input.nextInt();
                Input.nextLine();
                return Number;
            }

            System.out.println("Invalid input. Please enter a number.");
            Input.nextLine();
        }
    }

    public static String GetNonEmptyInput(String Message) {
        String Value;

        do {
            System.out.print(Message);
            Value = Input.nextLine().trim();

            if (Value.isEmpty()) {
                System.out.println("Input cannot be empty.");
            }
        } while (Value.isEmpty());

        return Value;
    }

    public static void CreateTicket() {
        System.out.println("\n===== CREATE SUPPORT TICKET =====");

        String RequesterName =
                GetNonEmptyInput("Enter requester name: ");

        String TicketIssue =
                GetNonEmptyInput("Describe the IT issue: ");

        String TicketDate =
                GetNonEmptyInput("Enter date (e.g., 2026-10-26): ");

        int NewTicketNumber = NextTicketNumber++;

        TicketNumbers.add(NewTicketNumber);
        RequesterNames.add(RequesterName);
        TicketIssues.add(TicketIssue);
        TicketDates.add(TicketDate);
        TicketStatuses.add("Pending");

        SupportQueue.add(NewTicketNumber);

        System.out.println("\nTicket created successfully!");
        DisplayTicket(NewTicketNumber);
        System.out.println("Added to the support queue.");
    }

    public static void DisplayTicket(int TicketNumber) {
        int Index = TicketNumbers.indexOf(TicketNumber);

        if (Index == -1) {
            System.out.println("Ticket not found.");
            return;
        }

        System.out.println("--------------------------------------");
        System.out.println("Ticket Number: T-"
                + String.format("%03d", TicketNumbers.get(Index)));
        System.out.println("Requester: " + RequesterNames.get(Index));
        System.out.println("Issue: " + TicketIssues.get(Index));
        System.out.println("Date: " + TicketDates.get(Index));
        System.out.println("Status: " + TicketStatuses.get(Index));
        System.out.println("--------------------------------------");
    }

    public static void DisplayAllTickets() {
        System.out.println("\n===== ALL SUPPORT TICKETS =====");

        if (TicketNumbers.isEmpty()) {
            System.out.println("No tickets have been created.");
            return;
        }

        for (int TicketNumber : TicketNumbers) {
            DisplayTicket(TicketNumber);
        }
    }

    public static void DisplayPendingQueue() {
        System.out.println("\n===== PENDING SUPPORT QUEUE =====");

        if (SupportQueue.isEmpty()) {
            System.out.println("No pending tickets in the queue.");
            return;
        }

        for (int TicketNumber : SupportQueue) {
            DisplayTicket(TicketNumber);
        }
    }

    public static void ProcessNextTicket() {
        System.out.println("\n===== PROCESS NEXT TICKET =====");

        if (SupportQueue.isEmpty()) {
            System.out.println("No pending tickets to process.");
            return;
        }

        int TicketNumber = SupportQueue.poll();
        int Index = TicketNumbers.indexOf(TicketNumber);

        if (Index == -1) {
            System.out.println("Ticket not found in the system.");
            return;
        }

        TicketStatuses.set(Index, "Resolved");
        System.out.println("Processing ticket: T-" + String.format("%03d", TicketNumber));
        DisplayTicket(TicketNumber);
        System.out.println("Ticket marked as resolved.");
    }

    public static void PeekNextTicket() {
        System.out.println("\n===== VIEW NEXT TICKET =====");

        if (SupportQueue.isEmpty()) {
            System.out.println("No pending tickets in the queue.");
            return;
        }

        int NextTicketNumber = SupportQueue.peek();
        DisplayTicket(NextTicketNumber);
    }

    public static void BubbleSortTickets() {
        System.out.println("\n===== SORT TICKETS (BUBBLE SORT) =====");

        if (TicketNumbers.isEmpty()) {
            System.out.println("No tickets available to sort.");
            return;
        }

        for (int I = 0; I < TicketNumbers.size() - 1; I++) {
            for (int J = 0; J < TicketNumbers.size() - 1 - I; J++) {
                if (TicketNumbers.get(J) > TicketNumbers.get(J + 1)) {
                    SwapTicketData(J, J + 1);
                }
            }
        }

        System.out.println("Tickets sorted successfully using Bubble Sort.");
        DisplayAllTickets();
    }

    public static void InsertionSortTickets() {
        System.out.println("\n===== SORT TICKETS (INSERTION SORT) =====");

        if (TicketNumbers.isEmpty()) {
            System.out.println("No tickets available to sort.");
            return;
        }

        for (int I = 1; I < TicketNumbers.size(); I++) {
            int KeyTicket = TicketNumbers.get(I);
            String KeyRequester = RequesterNames.get(I);
            String KeyIssue = TicketIssues.get(I);
            String KeyDate = TicketDates.get(I);
            String KeyStatus = TicketStatuses.get(I);

            int J = I - 1;

            while (J >= 0 && TicketNumbers.get(J) > KeyTicket) {
                TicketNumbers.set(J + 1, TicketNumbers.get(J));
                RequesterNames.set(J + 1, RequesterNames.get(J));
                TicketIssues.set(J + 1, TicketIssues.get(J));
                TicketDates.set(J + 1, TicketDates.get(J));
                TicketStatuses.set(J + 1, TicketStatuses.get(J));
                J--;
            }

            TicketNumbers.set(J + 1, KeyTicket);
            RequesterNames.set(J + 1, KeyRequester);
            TicketIssues.set(J + 1, KeyIssue);
            TicketDates.set(J + 1, KeyDate);
            TicketStatuses.set(J + 1, KeyStatus);
        }

        System.out.println("Tickets sorted successfully using Insertion Sort.");
        DisplayAllTickets();
    }

    public static void SearchTicket() {
        System.out.println("\n===== SEARCH TICKET =====");

        int TicketNumber = GetIntegerInput("Enter ticket number to search: ");
        int Index = TicketNumbers.indexOf(TicketNumber);

        if (Index == -1) {
            System.out.println("Ticket number T-" + String.format("%03d", TicketNumber) + " was not found.");
            return;
        }

        DisplayTicket(TicketNumber);
    }

    public static void SwapTicketData(int FirstIndex, int SecondIndex) {
        int TempTicketNumber = TicketNumbers.get(FirstIndex);
        String TempRequester = RequesterNames.get(FirstIndex);
        String TempIssue = TicketIssues.get(FirstIndex);
        String TempDate = TicketDates.get(FirstIndex);
        String TempStatus = TicketStatuses.get(FirstIndex);

        TicketNumbers.set(FirstIndex, TicketNumbers.get(SecondIndex));
        RequesterNames.set(FirstIndex, RequesterNames.get(SecondIndex));
        TicketIssues.set(FirstIndex, TicketIssues.get(SecondIndex));
        TicketDates.set(FirstIndex, TicketDates.get(SecondIndex));
        TicketStatuses.set(FirstIndex, TicketStatuses.get(SecondIndex));

        TicketNumbers.set(SecondIndex, TempTicketNumber);
        RequesterNames.set(SecondIndex, TempRequester);
        TicketIssues.set(SecondIndex, TempIssue);
        TicketDates.set(SecondIndex, TempDate);
        TicketStatuses.set(SecondIndex, TempStatus);
    }
}