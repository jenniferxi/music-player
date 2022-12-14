package Commands;

import Driver.AccountManager;
import Driver.Program;
import UI.TextUI;

import java.util.List;

/**
 * User can create new account
 */

public class Create extends Command{

    public Create(){
        super(2, 0);
    }

    /**
     * Create new account with the given username and password, display login menu
     *
     * @param AM account manager
     * @param p program
     * @param args provided arguments and command
     * @throws CommandException if argument or location of command is incorrect
     */
    public void executeCommand(AccountManager AM, Program p, List<String> args) throws CommandException{
        checkArguments(args);
        checkLocation(p);
        String username = args.get(0);
        String password = args.get(1);
        TextUI UI = new TextUI(AM, p.getSongManager());
        if(AM.createAccount(username, password)){
            UI.accountCreateSuccess();
            p.loginDisplay();
        }
        else{
            UI.accountCreateFail();
            p.loginDisplay();
        }
    }
}
