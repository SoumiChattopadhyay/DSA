// class representing a request
// Concrete Command Classes
// Each operation is implemented in its own class.
// A concrete command keeps a reference to the object that carries out the actual work (called the receiver).
// Invoking execute() triggers the appropriate operation on that receiver.
class TurnOnCommand implements Command{
    Light light;
    
    TurnOnCommand(Light light){
        this.light=light;
    }

    public void execute(){
        light.turnOn();
    }
}
/*1. TurnOnCommand is a class representing a request
It does not turn the light on directly.

2. It stores a reference to the Light object
Light light;
This is like saying:
“I know which light I’m supposed to turn on.”

3. The constructor stores the target light
TurnOnCommand(Light light) {
    this.light = light;
}

4. The execute() method performs the action
light.turnOn();  // calling actual method inside Light


So when someone calls execute(), the lamp switches on. */