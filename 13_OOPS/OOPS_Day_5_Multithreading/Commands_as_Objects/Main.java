// Client Setup
// A client assembles the system by creating command objects, 
// linking them with receivers, and assigning them to invokers.
class Main {
    public static void main(String[] args) {
        Light l = new Light();// Real object
        Command c = new TurnOnCommand(l);// Wrap request as object
        RemoteControl r = new RemoteControl();// Something that triggers commands
        r.setCommand(c);// Give it the command
        r.press();// Perform action

        c=new TurnOffCommand(l);
        r.setCommand(c);
        r.press();
    }
}
/*Let’s translate:

Step 1: Create the worker
Light l = new Light();

Step 2: Wrap the action “turn on this light” into a command object
Command c = new TurnOnCommand(l);
This turns the action into something that can be:
saved
sent
triggered later
undone
queued

Step 3: Set the command for the remote
r.setCommand(c);

Step 4: Press the button → execute the command
r.press(); 


Think of a remote-controlled toy car.
The car is the Receiver
The remote button is the Invoker
The instruction inside the button is the Command object
The driver is the Client setting everything up
When you press the button:
the button reads its instruction and triggers the car
the remote does NOT know how the car works internally*/