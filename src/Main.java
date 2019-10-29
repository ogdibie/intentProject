public class Main {
    public static void main(String[] args) {
        TerminalProgram terminal = new TerminalProgram();
        terminal.setPricing('A',2.0);
        terminal.setPricing('A',4,7.0);
        terminal.setPricing('B',12.0);
        terminal.setPricing('C',1.25);
        terminal.setPricing('C',6,6);
        terminal.setPricing('D',0.15);

//        terminal.scan("AAAAA");
//        System.out.println(terminal.total());

        //example 1
        terminal.scan("ABCDABAA");
        System.out.println(terminal.total());
        //example 2
        terminal.scan("CCCCCCC");
        System.out.println(terminal.total());

        //example 3
        terminal.scan("ABCD");
        System.out.println(terminal.total());
    }
}
