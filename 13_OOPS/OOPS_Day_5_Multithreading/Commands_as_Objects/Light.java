// Receiver : the object that does the REAL work(Light object)
// This is the object that contains the real logic.
// The command object forwards the request to this component.
class Light{
    void turnOn(){
        System.out.println("Light On");
    }
    void turnOff(){
        System.out.println("Light Off");
    }
}
// Think of it like:
// Light = Worker
// turnOn() = What the worker knows how to do