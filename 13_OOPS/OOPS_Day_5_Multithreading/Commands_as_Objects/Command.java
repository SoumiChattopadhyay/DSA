// Command Abstraction
// A command is usually expressed through an interface (or abstract class)
// This interface defines the general shape of an action without specifying how the action is performed.
interface Command{
    void execute();
}
// Every command should have an execute() method.
// This is the button we press to perform the action.