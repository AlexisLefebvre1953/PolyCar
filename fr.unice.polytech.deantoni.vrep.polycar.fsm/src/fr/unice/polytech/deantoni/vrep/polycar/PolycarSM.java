package fr.unice.polytech.deantoni.vrep.polycar;

import fr.unice.polytech.deantoni.vrep.polycar.fsm.polycar.PolycarStatemachine;
import fr.unice.polytech.deantoni.vrep.polycar.utils.Pixel;

import java.util.Random;

import fr.unice.polytech.deantoni.vrep.polycar.fsm.TimerService;
import fr.unice.polytech.deantoni.vrep.polycar.fsm.polycar.IPolycarStatemachine.SCInterface;

public class PolycarSM {
	
	private PolycarStatemachine polycarSM;
	private PolyCar car;
	private Pixel veryRight;
	private Pixel veryLeft;
	private Thread parkThread;
	
	public PolycarSM() {
		
		// Init the car
		car = new PolyCar("127.0.0.1", 19997);
	

		// Lambda Runnable
		Runnable readLeftSensorsTask = () -> { 
			car.readLeftSensor();
		};
		
		//SCInterface.readLeftSensors.subscribe(e -> new Thread(readLeftSensorsTask).start());
		//SCInterface.readSensors.subscribe(e -> new Thread(readSensorsTask).start());
		
		car.start();
		
		polycarSM = new PolycarStatemachine();
		TimerService timer = new TimerService();
		polycarSM.setTimer(timer);
		polycarSM.init();
		polycarSM.enter();
		
		SCInterface.goForward.subscribe(event -> goForward());
		SCInterface.slowDown.subscribe(event -> slowDown());
		SCInterface.stopCar.subscribe(event -> stopCar());
		SCInterface.readSensors.subscribe(event -> readSensors());
		SCInterface.turnRight.subscribe(event -> turnRight());
		SCInterface.turnLeft.subscribe(event -> turnLeft());
		SCInterface.turnVeryRight.subscribe(event -> turnVeryRight());
		SCInterface.turnVeryLeft.subscribe(event -> turnVeryLeft());
		SCInterface.randomDirection.subscribe(event -> randomDirection());
		SCInterface.randomSide.subscribe(event -> randomSide());
		SCInterface.randomForwardLeft.subscribe(event -> randomForwardLeft());
		SCInterface.randomForwardRight.subscribe(event -> randomForwardRight());
		SCInterface.resetAccesses.subscribe(event -> resetAccesses());

		// Raise start
		polycarSM.getSCInterface().raiseStart();
		while(true) {
			
		}
		
		
	}
	
	

	public void goForward() {
		
		car.goStraight(15);
		System.out.println("forward");
		
	}
	
	public void slowDown() {
		car.goStraight(4);
		System.out.println("slowDown");
	}
	
	
	public void readSensors() {
		

		
		
		// Front sensors road
		polycarSM.setLeftOut(!car.readLeftSensor().isBlack());
		
		polycarSM.setRightOut(!car.readRightSensor().isBlack());
		
		veryLeft =  car.readVeryLeftSensor();
		veryRight =  car.readVeryRightSensor();
		
		
		// Sides sensors road
		polycarSM.setVeryLeftOut(!veryLeft.isBlack());
		polycarSM.setVeryRightOut(!veryRight.isBlack());
		
		
		
		
		
		// Sides sensors colors
		polycarSM.setRedLight(veryRight.isRed());
		if(polycarSM.getCanTurnLeft() && veryLeft.isOrange()) {
			polycarSM.setCanTurnLeft(false);
			System.out.println("cannot turn left");
		}
		if(polycarSM.getCanTurnRight() && veryRight.isOrange()) {
			polycarSM.setCanTurnRight(false);
			System.out.println("cannot turn right");
		}
		if(polycarSM.getCanGoStraight() && veryLeft.isRed()) {
			polycarSM.setCanGoStraight(false);
			System.out.println("cannot go straight");
		}
		
		//polycarSM.setCanTurnRight(!veryRight.isOrange());
		//System.out.println("canturnright"+!veryRight.isOrange());
			// if the LEFT sensor is RED the car cannot go straight
		/*polycarSM.setCanGoStraight(!veryLeft.isRed());
		if(car.readVeryLeftSensor().isRed()) {
			System.out.println("RED LEFT");
		}
			// if the RIGHT sensor is ORANGE the car cannot turn right
		polycarSM.setCanTurnRight(!car.veryRight.isOrange());
			// if the RIGHT sensor is BLUE the car can turn right
		polycarSM.setCanTurnRight(car.veryRight.isBlue());
			// if the LEFT sensor is BLUE the car can turn left
		polycarSM.setCanTurnLeft(car.veryLeft.isBlue());
		
	*/
		 
		
		
	
		
	}
	
	public void stopCar() {
		car.goStraight(0);
		System.out.println("stop");
		
		
	}
	
	public void turnRight() {
		car.goCurved(12,10);
		System.out.println("turn right");
		
	}
	
	public void turnLeft() {
		car.goCurved(10,12);
		
		System.out.println("turn left");
		
	}
	
	public void turnVeryLeft() {
		
		
		car.goCurved(0,7);
		System.out.println("turn very left");
		
		
	}
	
	public void turnVeryRight() {
		
		car.goCurved(7,0);
	
		System.out.println("turn very right");
		
	}
	
	public void randomDirection() {
		Random rand = new Random();
		System.out.println("Random direction");
		int nombreAleatoire = rand.nextInt(2 - 0 + 1) + 0;
		switch(nombreAleatoire) {
			case 0:
				this.goForward();
				break;
			case 1:
				this.turnVeryLeft();
				break;
			case 2:
				this.turnVeryRight();
				break;
			default:
				this.stopCar();		
		}		
	}
	
	public void randomSide() {
		System.out.println("Random side");
		Random rand = new Random();
		int nombreAleatoire = rand.nextInt(1 - 0 + 1) + 0;
		switch(nombreAleatoire) {
			case 0:
				this.turnVeryRight();
				break;
			case 1:
				this.turnVeryLeft();
				break;
			default:
				this.stopCar();		
		}		
	}
	
	private void randomForwardRight() {
		System.out.println("Random forward right");
		Random rand = new Random();
		int nombreAleatoire = rand.nextInt(1 - 0 + 1) + 0;
		if(nombreAleatoire == 0) {
			this.goForward();
		}
		else {
			this.turnVeryRight();
		}
			
	}

	private void randomForwardLeft() {
		System.out.println("Random forward left");
		Random rand = new Random();
		int nombreAleatoire = rand.nextInt(1 - 0 + 1) + 0;
		if(nombreAleatoire == 0) {
			this.goForward();
		}
		else {
			this.turnVeryLeft();
		}
	}
	
	private void resetAccesses() {
	
		polycarSM.setCanGoStraight(true);
		polycarSM.setCanTurnRight(true);
		polycarSM.setCanTurnLeft(true);
		
		System.out.println("Reset accesses");
	
	}
	
	private void askToPark() {
		
		parkThread = new Thread();
		Runnable waitForPark = () -> waitForPark();
	}
	
	private void waitForPark() {
		
	}
	
	
	

}