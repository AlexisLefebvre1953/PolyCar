package fr.unice.polytech.deantoni.vrep.polycar.fsm.polycar;

import fr.unice.polytech.deantoni.vrep.polycar.fsm.IStatemachine;
import fr.unice.polytech.deantoni.vrep.polycar.fsm.ITimerCallback;

import org.yakindu.sct.generator.polytech.java.types.Event;



public interface IPolycarStatemachine extends ITimerCallback,IStatemachine {

	public interface SCInterface {
	
	
		public Event stopCar = new Event();
		public Event goForward = new Event();
		public Event slowDown = new Event();
		public Event readSensors = new Event();
		public Event turnRight = new Event();
		public Event turnLeft = new Event();
		public Event turnVeryRight = new Event();
		public Event turnVeryLeft = new Event();
		public Event randomDirection = new Event();
		public Event randomSide = new Event();
		public Event randomForwardLeft = new Event();
		public Event randomForwardRight = new Event();
		public Event resetAccesses = new Event();
	
		public void raiseStart();
		
		public void raiseStop();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public boolean getLeftOut();
		
		public void setLeftOut(boolean value);
		
		public boolean getRightOut();
		
		public void setRightOut(boolean value);
		
		public boolean getMiddleOut();
		
		public void setMiddleOut(boolean value);
		
		public boolean getVeryRightOut();
		
		public void setVeryRightOut(boolean value);
		
		public boolean getVeryLeftOut();
		
		public void setVeryLeftOut(boolean value);
		
		public boolean getRedLight();
		
		public void setRedLight(boolean value);
		
		public boolean getCanGoStraight();
		
		public void setCanGoStraight(boolean value);
		
		public boolean getCanTurnLeft();
		
		public void setCanTurnLeft(boolean value);
		
		public boolean getCanTurnRight();
		
		public void setCanTurnRight(boolean value);
		
	}
	
	public SCInterface getSCInterface();
	
	
	
}