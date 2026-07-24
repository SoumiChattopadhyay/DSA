// Invoker 
// It holds a command object and triggers it.
// It does not need to know the details of the action.
class RemoteControl {
    Command button;

    void setCommand(Command c){
        button=c;
    }

    void press(){
        button.execute();
    }
}
/*What this means:
RemoteControl does not know how to turn on a light
It only knows it has a button
When you press the button, it just calls execute()

It doesn't know:
which light
what command
what operation

This is the whole beauty of the pattern. */