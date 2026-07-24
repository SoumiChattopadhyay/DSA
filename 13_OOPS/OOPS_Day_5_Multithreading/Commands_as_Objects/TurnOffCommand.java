class TurnOffCommand implements Command{
    Light light;
    
    TurnOffCommand(Light light){
        this.light=light;
    }
    
    public void execute(){
        light.turnOff();
    }
}
