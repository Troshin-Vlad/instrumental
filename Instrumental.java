public class Instrumental {

    public static Player player;
    public static User user;

    public static void main(String[] args){
        player = new Player();
        user = new User();

        boolean display = true;
        String cmd;

        while(true) {

            cmd = user.input();

            if(cmd.equals("quit") || cmd.equals("exit")){
                break;
            }
            else if(cmd.equals("play")){
                player.playMusic(35);
            }
            else if(cmd.equals("instrumental")){
                player.displayInstruments();
            }
            else if(cmd.equals("timeout")){
                System.out.println(player.getTimeout() + "ms");
            }
            else if(cmd.contains("timeout")){
                int sleep = Integer.parseInt(cmd.substring(8, cmd.length()));
                player.setTimeout(sleep);
            }
            else if(cmd.equals("instrument")){
                System.out.println("instrument: " + player.getInstrument());
            }
            else if(cmd.equals("music")){
                System.out.println("instrument: " + player.getInstrument());
                System.out.println("timeout: " + player.getTimeout());
            }
            else if(cmd.equals("help")) {
                help();
            }
            else if(cmd.equals("no display")){
                display = false;
            }
            else if(cmd.equals("display")){
                display = true;
            }
            else{
                if(player.changeInstrument(0, cmd))
                    player.playNotes(display);
                else
                    System.out.println("unknow command and instrument");
            }

        }

        player.close();
    }


    public static void help(){
        System.out.println("  play          - play music with last choose instrument");
        System.out.println("  quit|exit     - exit program");
        System.out.println("  help          - print this help page");
        System.out.println("  instrumental  - print all instruments");
        System.out.println("  instrument    - print choose instrument");
        System.out.println("  timeout       - print timeout");
        System.out.println("  timeout <ms>  - set timeout (ms)");
        System.out.println("  no display    - no print playing notes");
        System.out.println("  display       - print playing notes");
        System.out.println("  <instrument>  - play select instrument");
    }
}