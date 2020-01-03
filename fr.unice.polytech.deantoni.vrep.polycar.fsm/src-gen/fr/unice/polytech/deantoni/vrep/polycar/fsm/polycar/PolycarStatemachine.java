	package fr.unice.polytech.deantoni.vrep.polycar.fsm.polycar;
	import fr.unice.polytech.deantoni.vrep.polycar.fsm.ITimer;
	
	public class PolycarStatemachine implements IPolycarStatemachine {

		protected class SCInterfaceImpl implements SCInterface {
		
			
			private boolean start;
			public void raiseStart() {
				start = true;
				runCycle();
			}
			
			
			private boolean stop;
			public void raiseStop() {
				stop = true;
				runCycle();
			}
			
			
			
			protected void raiseStopCar() {
				stopCar.emits();
			}
			
			
			
			protected void raiseGoForward() {
				goForward.emits();
			}
			
			
			
			protected void raiseSlowDown() {
				slowDown.emits();
			}
			
			
			
			protected void raiseReadSensors() {
				readSensors.emits();
			}
			
			
			
			protected void raiseTurnRight() {
				turnRight.emits();
			}
			
			
			
			protected void raiseTurnLeft() {
				turnLeft.emits();
			}
			
			
			
			protected void raiseTurnVeryRight() {
				turnVeryRight.emits();
			}
			
			
			
			protected void raiseTurnVeryLeft() {
				turnVeryLeft.emits();
			}
			
			
			
			protected void raiseRandomDirection() {
				randomDirection.emits();
			}
			
			
			
			protected void raiseRandomSide() {
				randomSide.emits();
			}
			
			
			
			protected void raiseRandomForwardLeft() {
				randomForwardLeft.emits();
			}
			
			
			
			protected void raiseRandomForwardRight() {
				randomForwardRight.emits();
			}
			
			
			
			protected void raiseParkLeft() {
				parkLeft.emits();
			}
			
			
			
			protected void raiseParkRight() {
				parkRight.emits();
			}
			
			
			
			protected void raiseCheckFreeRight() {
				checkFreeRight.emits();
			}
			
			
			
			protected void raiseCheckFreeLeft() {
				checkFreeLeft.emits();
			}
			
			
			
			protected void raiseForwardTillEndOfPlace() {
				forwardTillEndOfPlace.emits();
			}
			
			
			
			protected void raiseResetAccesses() {
				resetAccesses.emits();
			}
			
			private boolean leftOut;
			
			public boolean getLeftOut() {
				return leftOut;
			}
			
			public void setLeftOut(boolean value) {
				this.leftOut = value;
			}
			
			private boolean rightOut;
			
			public boolean getRightOut() {
				return rightOut;
			}
			
			public void setRightOut(boolean value) {
				this.rightOut = value;
			}
			
			private boolean veryRightOut;
			
			public boolean getVeryRightOut() {
				return veryRightOut;
			}
			
			public void setVeryRightOut(boolean value) {
				this.veryRightOut = value;
			}
			
			private boolean veryLeftOut;
			
			public boolean getVeryLeftOut() {
				return veryLeftOut;
			}
			
			public void setVeryLeftOut(boolean value) {
				this.veryLeftOut = value;
			}
			
			private boolean redLight;
			
			public boolean getRedLight() {
				return redLight;
			}
			
			public void setRedLight(boolean value) {
				this.redLight = value;
			}
			
			private boolean canGoStraight;
			
			public boolean getCanGoStraight() {
				return canGoStraight;
			}
			
			public void setCanGoStraight(boolean value) {
				this.canGoStraight = value;
			}
			
			private boolean canTurnLeft;
			
			public boolean getCanTurnLeft() {
				return canTurnLeft;
			}
			
			public void setCanTurnLeft(boolean value) {
				this.canTurnLeft = value;
			}
			
			private boolean canTurnRight;
			
			public boolean getCanTurnRight() {
				return canTurnRight;
			}
			
			public void setCanTurnRight(boolean value) {
				this.canTurnRight = value;
			}
			
			private boolean parkAsked;
			
			public boolean getParkAsked() {
				return parkAsked;
			}
			
			public void setParkAsked(boolean value) {
				this.parkAsked = value;
			}
			
			private boolean parkingPlaceLeft;
			
			public boolean getParkingPlaceLeft() {
				return parkingPlaceLeft;
			}
			
			public void setParkingPlaceLeft(boolean value) {
				this.parkingPlaceLeft = value;
			}
			
			private boolean parkingPlaceRight;
			
			public boolean getParkingPlaceRight() {
				return parkingPlaceRight;
			}
			
			public void setParkingPlaceRight(boolean value) {
				this.parkingPlaceRight = value;
			}
			
			private boolean parkingPlaceFree;
			
			public boolean getParkingPlaceFree() {
				return parkingPlaceFree;
			}
			
			public void setParkingPlaceFree(boolean value) {
				this.parkingPlaceFree = value;
			}
			
			private boolean parkingPlaceFull;
			
			public boolean getParkingPlaceFull() {
				return parkingPlaceFull;
			}
			
			public void setParkingPlaceFull(boolean value) {
				this.parkingPlaceFull = value;
			}
			
			protected void clearEvents() {
				start = false;
				stop = false;
			}
			public void clearOutEvents() {
			//nothings to do with the newly introduced Event Type
			}
			
		}
		
		protected SCInterfaceImpl sCInterface;
		
		private boolean initialized = false;
		
		public enum State {
			main_region_main,
			main_region_main_r1_Moving,
			main_region_main_r1_Moving_r1_GoingForward,
			main_region_main_r1_Moving_r1_Crossing,
			main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses,
			main_region_main_r1_Moving_r1_Crossing_r1_Turning,
			main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight,
			main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft,
			main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide,
			main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom,
			main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom,
			main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached,
			main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors,
			main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations,
			main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA,
			main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA,
			main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA,
			main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA,
			main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA,
			main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA,
			main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA,
			main_region_main_r1_Moving_r1_InACrossing,
			main_region_main_r1_Moving_r1_GoBackToRoad,
			main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight,
			main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft,
			main_region_main_r1_Stopped,
			main_region_main_r1_Init,
			main_region_main_r1_Parking,
			main_region_main_r1_Parking_r1_park,
			main_region_main_r1_Parking_r1_parkLeft,
			main_region_main_r1_Parking_r1_parkRight,
			main_region_main_r1_fullPlace,
			main_region_main_r2_ReadSensors,
			main_region_main__region2_Obstacle,
			$NullState$
		};
		
		private final State[] stateVector = new State[3];
		
		private int nextStateIndex;
		
		private ITimer timer;
		
		private final boolean[] timeEvents = new boolean[5];
		public PolycarStatemachine() {
			sCInterface = new SCInterfaceImpl();
		}
		
		public void init() {
			this.initialized = true;
			if (timer == null) {
				throw new IllegalStateException("timer not set.");
			}
			for (int i = 0; i < 3; i++) {
				stateVector[i] = State.$NullState$;
			}
			clearEvents();
			clearOutEvents();
			sCInterface.setLeftOut(false);
			
			sCInterface.setRightOut(false);
			
			sCInterface.setVeryRightOut(true);
			
			sCInterface.setVeryLeftOut(true);
			
			sCInterface.setRedLight(false);
			
			sCInterface.setCanGoStraight(true);
			
			sCInterface.setCanTurnLeft(true);
			
			sCInterface.setCanTurnRight(true);
			
			sCInterface.setParkAsked(false);
			
			sCInterface.setParkingPlaceLeft(false);
			
			sCInterface.setParkingPlaceRight(false);
			
			sCInterface.setParkingPlaceFree(false);
			
			sCInterface.setParkingPlaceFull(false);
		}
		
		public void enter() {
			if (!initialized) {
				throw new IllegalStateException(
						"The state machine needs to be initialized first by calling the init() function.");
			}
			if (timer == null) {
				throw new IllegalStateException("timer not set.");
			}
			enterSequence_main_region_default();
		}
		
		public void exit() {
			exitSequence_main_region();
		}
		
		/**
		 * @see IStatemachine#isActive()
		 */
		public boolean isActive() {
			return stateVector[0] != State.$NullState$||stateVector[1] != State.$NullState$||stateVector[2] != State.$NullState$;
		}
		
		/** 
		* Always returns 'false' since this state machine can never become final.
		*
		* @see IStatemachine#isFinal()
		*/
		public boolean isFinal() {
			return false;
		}
		/**
		* This method resets the incoming events (time events included).
		*/
		protected void clearEvents() {
			sCInterface.clearEvents();
			for (int i=0; i<timeEvents.length; i++) {
				timeEvents[i] = false;
			}
		}
		
		/**
		* This method resets the outgoing events !
		*/
		public void clearOutEvents() {
		}
		
		/**
		* Returns true if the given state is currently active otherwise false.
		*/
		public boolean isStateActive(State state) {
		
			switch (state) {
			case main_region_main:
				return stateVector[0].ordinal() >= State.
						main_region_main.ordinal()&& stateVector[0].ordinal() <= State.main_region_main__region2_Obstacle.ordinal();
			case main_region_main_r1_Moving:
				return stateVector[0].ordinal() >= State.
						main_region_main_r1_Moving.ordinal()&& stateVector[0].ordinal() <= State.main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft.ordinal();
			case main_region_main_r1_Moving_r1_GoingForward:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_GoingForward;
			case main_region_main_r1_Moving_r1_Crossing:
				return stateVector[0].ordinal() >= State.
						main_region_main_r1_Moving_r1_Crossing.ordinal()&& stateVector[0].ordinal() <= State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA.ordinal();
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning:
				return stateVector[0].ordinal() >= State.
						main_region_main_r1_Moving_r1_Crossing_r1_Turning.ordinal()&& stateVector[0].ordinal() <= State.main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom.ordinal();
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom;
			case main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations:
				return stateVector[0].ordinal() >= State.
						main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations.ordinal()&& stateVector[0].ordinal() <= State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA.ordinal();
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA;
			case main_region_main_r1_Moving_r1_InACrossing:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_InACrossing;
			case main_region_main_r1_Moving_r1_GoBackToRoad:
				return stateVector[0].ordinal() >= State.
						main_region_main_r1_Moving_r1_GoBackToRoad.ordinal()&& stateVector[0].ordinal() <= State.main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft.ordinal();
			case main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight;
			case main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft:
				return stateVector[0] == State.main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft;
			case main_region_main_r1_Stopped:
				return stateVector[0] == State.main_region_main_r1_Stopped;
			case main_region_main_r1_Init:
				return stateVector[0] == State.main_region_main_r1_Init;
			case main_region_main_r1_Parking:
				return stateVector[0].ordinal() >= State.
						main_region_main_r1_Parking.ordinal()&& stateVector[0].ordinal() <= State.main_region_main_r1_Parking_r1_parkRight.ordinal();
			case main_region_main_r1_Parking_r1_park:
				return stateVector[0] == State.main_region_main_r1_Parking_r1_park;
			case main_region_main_r1_Parking_r1_parkLeft:
				return stateVector[0] == State.main_region_main_r1_Parking_r1_parkLeft;
			case main_region_main_r1_Parking_r1_parkRight:
				return stateVector[0] == State.main_region_main_r1_Parking_r1_parkRight;
			case main_region_main_r1_fullPlace:
				return stateVector[0] == State.main_region_main_r1_fullPlace;
			case main_region_main_r2_ReadSensors:
				return stateVector[1] == State.main_region_main_r2_ReadSensors;
			case main_region_main__region2_Obstacle:
				return stateVector[2] == State.main_region_main__region2_Obstacle;
			default:
				return false;
			}
		}
		
		/**
		* Set the {@link ITimer} for the state machine. It must be set
		* externally on a timed state machine before a run cycle can be correctly
		* executed.
		* 
		* @param timer
		*/
		public void setTimer(ITimer timer) {
			this.timer = timer;
		}
		
		/**
		* Returns the currently used timer.
		* 
		* @return {@link ITimer}
		*/
		public ITimer getTimer() {
			return timer;
		}
		
		public void timeElapsed(int eventID) {
			timeEvents[eventID] = true;
			runCycle();
		}
		
		public SCInterface getSCInterface() {
			return sCInterface;
		}
		
		public void raiseStart() {
			sCInterface.raiseStart();
		}
		
		public void raiseStop() {
			sCInterface.raiseStop();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public boolean getLeftOut() {
			return sCInterface.getLeftOut();
		}
		
		public void setLeftOut(boolean value) {
			sCInterface.setLeftOut(value);
		}
		
		public boolean getRightOut() {
			return sCInterface.getRightOut();
		}
		
		public void setRightOut(boolean value) {
			sCInterface.setRightOut(value);
		}
		
		public boolean getVeryRightOut() {
			return sCInterface.getVeryRightOut();
		}
		
		public void setVeryRightOut(boolean value) {
			sCInterface.setVeryRightOut(value);
		}
		
		public boolean getVeryLeftOut() {
			return sCInterface.getVeryLeftOut();
		}
		
		public void setVeryLeftOut(boolean value) {
			sCInterface.setVeryLeftOut(value);
		}
		
		public boolean getRedLight() {
			return sCInterface.getRedLight();
		}
		
		public void setRedLight(boolean value) {
			sCInterface.setRedLight(value);
		}
		
		public boolean getCanGoStraight() {
			return sCInterface.getCanGoStraight();
		}
		
		public void setCanGoStraight(boolean value) {
			sCInterface.setCanGoStraight(value);
		}
		
		public boolean getCanTurnLeft() {
			return sCInterface.getCanTurnLeft();
		}
		
		public void setCanTurnLeft(boolean value) {
			sCInterface.setCanTurnLeft(value);
		}
		
		public boolean getCanTurnRight() {
			return sCInterface.getCanTurnRight();
		}
		
		public void setCanTurnRight(boolean value) {
			sCInterface.setCanTurnRight(value);
		}
		
		public boolean getParkAsked() {
			return sCInterface.getParkAsked();
		}
		
		public void setParkAsked(boolean value) {
			sCInterface.setParkAsked(value);
		}
		
		public boolean getParkingPlaceLeft() {
			return sCInterface.getParkingPlaceLeft();
		}
		
		public void setParkingPlaceLeft(boolean value) {
			sCInterface.setParkingPlaceLeft(value);
		}
		
		public boolean getParkingPlaceRight() {
			return sCInterface.getParkingPlaceRight();
		}
		
		public void setParkingPlaceRight(boolean value) {
			sCInterface.setParkingPlaceRight(value);
		}
		
		public boolean getParkingPlaceFree() {
			return sCInterface.getParkingPlaceFree();
		}
		
		public void setParkingPlaceFree(boolean value) {
			sCInterface.setParkingPlaceFree(value);
		}
		
		public boolean getParkingPlaceFull() {
			return sCInterface.getParkingPlaceFull();
		}
		
		public void setParkingPlaceFull(boolean value) {
			sCInterface.setParkingPlaceFull(value);
		}
		
		private boolean check_main_region_main_r1_Moving_tr0_tr0() {
			return sCInterface.stop;
		}
		
		private boolean check_main_region_main_r1_Moving_tr1_tr1() {
			return ((sCInterface.getParkAsked() && sCInterface.getParkingPlaceLeft()) && !sCInterface.getParkingPlaceFull());
		}
		
		private boolean check_main_region_main_r1_Moving_tr2_tr2() {
			return ((sCInterface.getParkAsked() && sCInterface.getParkingPlaceRight()) && !sCInterface.getParkingPlaceFull());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_GoingForward_tr0_tr0() {
			return (!sCInterface.getVeryRightOut() || !sCInterface.getVeryLeftOut());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_GoingForward_tr1_tr1() {
			return sCInterface.getLeftOut();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_GoingForward_tr2_tr2() {
			return sCInterface.getRightOut();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_GoingForward_tr3_tr3() {
			return (sCInterface.getRightOut() && sCInterface.getLeftOut());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_GoingForward_tr4_tr4() {
			return sCInterface.getRedLight();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses_tr0_tr0() {
			return (((!sCInterface.getVeryRightOut() && !sCInterface.getVeryLeftOut()) && sCInterface.getLeftOut()) && sCInterface.getRightOut());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses_tr1_tr1() {
			return (!sCInterface.getLeftOut() || !sCInterface.getRightOut());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses_tr2_tr2() {
			return (!sCInterface.getVeryRightOut() || !sCInterface.getVeryLeftOut());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_Turning_tr0_tr0() {
			boolean isPresent = timeEvents[0];
			timeEvents[0] = false;
			return isPresent;
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached_tr0_tr0() {
			return (!sCInterface.getVeryRightOut() && !sCInterface.getVeryLeftOut());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached_tr1_tr1() {
			return (!sCInterface.getVeryRightOut() && sCInterface.getVeryLeftOut());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached_tr2_tr2() {
			return (sCInterface.getVeryRightOut() && !sCInterface.getVeryLeftOut());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors_tr0_tr0() {
			return !sCInterface.getVeryLeftOut();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors_tr1_tr1() {
			return !sCInterface.getVeryRightOut();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr0_tr0() {
			return ((sCInterface.getCanTurnRight() && sCInterface.getCanTurnLeft()) && sCInterface.getCanGoStraight());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr1_tr1() {
			return !sCInterface.getCanTurnLeft();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr2_tr2() {
			return !sCInterface.getCanTurnRight();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr3_tr3() {
			return !sCInterface.getCanGoStraight();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_tr0_tr0() {
			return (sCInterface.getCanTurnLeft() && sCInterface.getCanTurnRight());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_tr1_tr1() {
			return !sCInterface.getCanTurnLeft();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_tr2_tr2() {
			return !sCInterface.getCanTurnRight();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_tr0_tr0() {
			return (sCInterface.getCanGoStraight() && sCInterface.getCanTurnLeft());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_tr1_tr1() {
			return !sCInterface.getCanTurnLeft();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_tr2_tr2() {
			return !sCInterface.getCanGoStraight();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_tr0_tr0() {
			return (sCInterface.getCanGoStraight() && sCInterface.getCanTurnRight());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_tr1_tr1() {
			return !sCInterface.getCanTurnRight();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_tr2_tr2() {
			return !sCInterface.getCanGoStraight();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA_tr0_tr0() {
			return sCInterface.getCanTurnLeft();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA_tr0_tr0() {
			return (sCInterface.getVeryLeftOut() && sCInterface.getVeryRightOut());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA_tr0_tr0() {
			return sCInterface.getCanTurnRight();
		}
		
		private boolean check_main_region_main_r1_Moving_r1_InACrossing_tr0_tr0() {
			boolean isPresent = timeEvents[1];
			timeEvents[1] = false;
			return isPresent;
		}
		
		private boolean check_main_region_main_r1_Moving_r1_GoBackToRoad_tr0_tr0() {
			return (!sCInterface.getRightOut() && !sCInterface.getLeftOut());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_GoBackToRoad_tr1_tr1() {
			return (sCInterface.getRightOut() && sCInterface.getLeftOut());
		}
		
		private boolean check_main_region_main_r1_Moving_r1_GoBackToRoad_tr2_tr2() {
			return sCInterface.getRedLight();
		}
		
		private boolean check_main_region_main_r1_Stopped_tr0_tr0() {
			return !sCInterface.getRedLight();
		}
		
		private boolean check_main_region_main_r1_Init_tr0_tr0() {
			return sCInterface.start;
		}
		
		private boolean check_main_region_main_r1_Parking_tr0_tr0() {
			return sCInterface.getParkingPlaceFull();
		}
		
		private boolean check_main_region_main_r1_Parking_r1_parkLeft_tr0_tr0() {
			return sCInterface.getParkingPlaceFree();
		}
		
		private boolean check_main_region_main_r1_Parking_r1_parkLeft_tr1_tr1() {
			boolean isPresent = timeEvents[2];
			timeEvents[2] = false;
			return isPresent;
		}
		
		private boolean check_main_region_main_r1_Parking_r1_parkRight_tr0_tr0() {
			return sCInterface.getParkingPlaceFree();
		}
		
		private boolean check_main_region_main_r1_Parking_r1_parkRight_tr1_tr1() {
			boolean isPresent = timeEvents[3];
			timeEvents[3] = false;
			return isPresent;
		}
		
		private boolean check_main_region_main_r1_fullPlace_tr0_tr0() {
			return !sCInterface.getParkingPlaceFull();
		}
		
		private boolean check_main_region_main_r2_ReadSensors_tr0_tr0() {
			boolean isPresent = timeEvents[4];
			timeEvents[4] = false;
			return isPresent;
		}
		
		private void effect_main_region_main_r1_Moving_tr0() {
			exitSequence_main_region_main_r1_Moving();
			sCInterface.raiseStopCar();
			
			enterSequence_main_region_main_r1_Stopped_default();
		}
		
		private void effect_main_region_main_r1_Moving_tr1() {
			exitSequence_main_region_main_r1_Moving();
			sCInterface.raiseCheckFreeLeft();
			
			enterSequence_main_region_main_r1_Parking_r1_parkLeft_default();
		}
		
		private void effect_main_region_main_r1_Moving_tr2() {
			exitSequence_main_region_main_r1_Moving();
			sCInterface.raiseCheckFreeRight();
			
			enterSequence_main_region_main_r1_Parking_r1_parkRight_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_GoingForward_tr0() {
			exitSequence_main_region_main_r1_Moving_r1_GoingForward();
			sCInterface.raiseSlowDown();
			
			enterSequence_main_region_main_r1_Moving_r1_InACrossing_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_GoingForward_tr1() {
			exitSequence_main_region_main_r1_Moving_r1_GoingForward();
			sCInterface.raiseTurnRight();
			
			enterSequence_main_region_main_r1_Moving_r1_GoBackToRoad_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_GoingForward_tr2() {
			exitSequence_main_region_main_r1_Moving_r1_GoingForward();
			sCInterface.raiseTurnLeft();
			
			enterSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_GoingForward_tr3() {
			exitSequence_main_region_main_r1_Moving_r1_GoingForward();
			sCInterface.raiseSlowDown();
			
			enterSequence_main_region_main_r1_Moving_r1_Crossing_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_GoingForward_tr4() {
			exitSequence_main_region_main_r1_Moving();
			sCInterface.raiseStopCar();
			
			enterSequence_main_region_main_r1_Stopped_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses_tr0() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses_tr1() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses_tr2() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_Turning_tr0() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing();
			sCInterface.raiseGoForward();
			
			sCInterface.raiseResetAccesses();
			
			enterSequence_main_region_main_r1_Moving_r1_GoingForward_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached_tr0() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached_tr1() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached_tr2() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors_tr0() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors_tr1() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr0() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations();
			sCInterface.raiseRandomDirection();
			
			entryAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr1() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr2() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr3() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_tr0() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations();
			sCInterface.raiseRandomSide();
			
			entryAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_tr1() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_tr2() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_tr0() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations();
			sCInterface.raiseRandomForwardLeft();
			
			entryAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_tr1() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA();
			sCInterface.raiseGoForward();
			
			sCInterface.raiseResetAccesses();
			
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_tr2() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_tr0() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations();
			sCInterface.raiseRandomForwardRight();
			
			entryAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_tr1() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA();
			sCInterface.raiseGoForward();
			
			sCInterface.raiseResetAccesses();
			
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_tr2() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA_tr0() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations();
			sCInterface.raiseTurnVeryLeft();
			
			entryAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA_tr0() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing();
			enterSequence_main_region_main_r1_Moving_r1_GoingForward_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA_tr0() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations();
			sCInterface.raiseTurnVeryRight();
			
			entryAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_InACrossing_tr0() {
			exitSequence_main_region_main_r1_Moving_r1_InACrossing();
			enterSequence_main_region_main_r1_Moving_r1_Crossing_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_GoBackToRoad_tr0() {
			exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad();
			sCInterface.raiseGoForward();
			
			enterSequence_main_region_main_r1_Moving_r1_GoingForward_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_GoBackToRoad_tr1() {
			exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad();
			sCInterface.raiseSlowDown();
			
			enterSequence_main_region_main_r1_Moving_r1_Crossing_default();
		}
		
		private void effect_main_region_main_r1_Moving_r1_GoBackToRoad_tr2() {
			exitSequence_main_region_main_r1_Moving();
			sCInterface.raiseStopCar();
			
			enterSequence_main_region_main_r1_Stopped_default();
		}
		
		private void effect_main_region_main_r1_Stopped_tr0() {
			exitSequence_main_region_main_r1_Stopped();
			sCInterface.raiseGoForward();
			
			enterSequence_main_region_main_r1_Moving_default();
		}
		
		private void effect_main_region_main_r1_Init_tr0() {
			exitSequence_main_region_main_r1_Init();
			sCInterface.raiseGoForward();
			
			enterSequence_main_region_main_r1_Moving_default();
		}
		
		private void effect_main_region_main_r1_Parking_tr0() {
			exitSequence_main_region_main_r1_Parking();
			sCInterface.raiseForwardTillEndOfPlace();
			
			enterSequence_main_region_main_r1_fullPlace_default();
		}
		
		private void effect_main_region_main_r1_Parking_r1_parkLeft_tr0() {
			exitSequence_main_region_main_r1_Parking_r1_parkLeft();
			sCInterface.raiseParkLeft();
			
			enterSequence_main_region_main_r1_Parking_r1_park_default();
		}
		
		private void effect_main_region_main_r1_Parking_r1_parkLeft_tr1() {
			exitSequence_main_region_main_r1_Parking_r1_parkLeft();
			sCInterface.raiseCheckFreeLeft();
			
			enterSequence_main_region_main_r1_Parking_r1_parkLeft_default();
		}
		
		private void effect_main_region_main_r1_Parking_r1_parkRight_tr0() {
			exitSequence_main_region_main_r1_Parking_r1_parkRight();
			sCInterface.raiseParkRight();
			
			enterSequence_main_region_main_r1_Parking_r1_park_default();
		}
		
		private void effect_main_region_main_r1_Parking_r1_parkRight_tr1() {
			exitSequence_main_region_main_r1_Parking_r1_parkRight();
			sCInterface.raiseCheckFreeRight();
			
			enterSequence_main_region_main_r1_Parking_r1_parkRight_default();
		}
		
		private void effect_main_region_main_r1_fullPlace_tr0() {
			exitSequence_main_region_main_r1_fullPlace();
			sCInterface.raiseGoForward();
			
			enterSequence_main_region_main_r1_Moving_default();
		}
		
		private void effect_main_region_main_r2_ReadSensors_tr0() {
			exitSequence_main_region_main_r2_ReadSensors();
			sCInterface.raiseReadSensors();
			
			enterSequence_main_region_main_r2_ReadSensors_default();
		}
		
		/* Entry action for state 'Turning'. */
		private void entryAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning() {
			timer.setTimer(this, 0, 2500, false);
		}
		
		/* Entry action for state 'InACrossing'. */
		private void entryAction_main_region_main_r1_Moving_r1_InACrossing() {
			timer.setTimer(this, 1, (1 * 1000), false);
		}
		
		/* Entry action for state 'parkLeft'. */
		private void entryAction_main_region_main_r1_Parking_r1_parkLeft() {
			timer.setTimer(this, 2, 100, false);
		}
		
		/* Entry action for state 'parkRight'. */
		private void entryAction_main_region_main_r1_Parking_r1_parkRight() {
			timer.setTimer(this, 3, 100, false);
		}
		
		/* Entry action for state 'ReadSensors'. */
		private void entryAction_main_region_main_r2_ReadSensors() {
			timer.setTimer(this, 4, 20, false);
		}
		
		/* Exit action for state 'Turning'. */
		private void exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning() {
			timer.unsetTimer(this, 0);
		}
		
		/* Exit action for state 'InACrossing'. */
		private void exitAction_main_region_main_r1_Moving_r1_InACrossing() {
			timer.unsetTimer(this, 1);
		}
		
		/* Exit action for state 'parkLeft'. */
		private void exitAction_main_region_main_r1_Parking_r1_parkLeft() {
			timer.unsetTimer(this, 2);
		}
		
		/* Exit action for state 'parkRight'. */
		private void exitAction_main_region_main_r1_Parking_r1_parkRight() {
			timer.unsetTimer(this, 3);
		}
		
		/* Exit action for state 'ReadSensors'. */
		private void exitAction_main_region_main_r2_ReadSensors() {
			timer.unsetTimer(this, 4);
		}
		
		/* 'default' enter sequence for state main */
		private void enterSequence_main_region_main_default() {
			enterSequence_main_region_main_r1_default();
			enterSequence_main_region_main_r2_default();
			enterSequence_main_region_main__region2_default();
		}
		
		/* 'default' enter sequence for state Moving */
		private void enterSequence_main_region_main_r1_Moving_default() {
			enterSequence_main_region_main_r1_Moving_r1_default();
		}
		
		/* 'default' enter sequence for state GoingForward */
		private void enterSequence_main_region_main_r1_Moving_r1_GoingForward_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_GoingForward;
		}
		
		/* 'default' enter sequence for state Crossing */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_default() {
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_default();
		}
		
		/* 'default' enter sequence for state CheckAccesses */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses;
		}
		
		/* 'default' enter sequence for state CurveRight */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight;
		}
		
		/* 'default' enter sequence for state CurveLeft */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft;
		}
		
		/* 'default' enter sequence for state RandomSide */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide;
		}
		
		/* 'default' enter sequence for state SideStraightRandom */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom;
		}
		
		/* 'default' enter sequence for state FullRandom */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom;
		}
		
		/* 'default' enter sequence for state FrontCanBeReached */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached;
		}
		
		/* 'default' enter sequence for state CheckSideSensors */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors;
		}
		
		/* 'default' enter sequence for state RandomA */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA;
		}
		
		/* 'default' enter sequence for state RandomSideA */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA;
		}
		
		/* 'default' enter sequence for state StraightLeftA */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA;
		}
		
		/* 'default' enter sequence for state StraightRightA */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA;
		}
		
		/* 'default' enter sequence for state LeftA */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA;
		}
		
		/* 'default' enter sequence for state StraightA */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA;
		}
		
		/* 'default' enter sequence for state RightA */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA;
		}
		
		/* 'default' enter sequence for state InACrossing */
		private void enterSequence_main_region_main_r1_Moving_r1_InACrossing_default() {
			entryAction_main_region_main_r1_Moving_r1_InACrossing();
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_InACrossing;
		}
		
		/* 'default' enter sequence for state GoBackToRoad */
		private void enterSequence_main_region_main_r1_Moving_r1_GoBackToRoad_default() {
			enterSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_default();
		}
		
		/* 'default' enter sequence for state TurnRight */
		private void enterSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight;
		}
		
		/* 'default' enter sequence for state TurnLeft */
		private void enterSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft;
		}
		
		/* 'default' enter sequence for state Stopped */
		private void enterSequence_main_region_main_r1_Stopped_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Stopped;
		}
		
		/* 'default' enter sequence for state Init */
		private void enterSequence_main_region_main_r1_Init_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Init;
		}
		
		/* 'default' enter sequence for state park */
		private void enterSequence_main_region_main_r1_Parking_r1_park_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Parking_r1_park;
		}
		
		/* 'default' enter sequence for state parkLeft */
		private void enterSequence_main_region_main_r1_Parking_r1_parkLeft_default() {
			entryAction_main_region_main_r1_Parking_r1_parkLeft();
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Parking_r1_parkLeft;
		}
		
		/* 'default' enter sequence for state parkRight */
		private void enterSequence_main_region_main_r1_Parking_r1_parkRight_default() {
			entryAction_main_region_main_r1_Parking_r1_parkRight();
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_Parking_r1_parkRight;
		}
		
		/* 'default' enter sequence for state fullPlace */
		private void enterSequence_main_region_main_r1_fullPlace_default() {
			nextStateIndex = 0;
			stateVector[0] = State.main_region_main_r1_fullPlace;
		}
		
		/* 'default' enter sequence for state ReadSensors */
		private void enterSequence_main_region_main_r2_ReadSensors_default() {
			entryAction_main_region_main_r2_ReadSensors();
			nextStateIndex = 1;
			stateVector[1] = State.main_region_main_r2_ReadSensors;
		}
		
		/* 'default' enter sequence for state Obstacle */
		private void enterSequence_main_region_main__region2_Obstacle_default() {
			nextStateIndex = 2;
			stateVector[2] = State.main_region_main__region2_Obstacle;
		}
		
		/* 'default' enter sequence for region main region */
		private void enterSequence_main_region_default() {
			react_main_region__entry_Default();
		}
		
		/* 'default' enter sequence for region r1 */
		private void enterSequence_main_region_main_r1_default() {
			react_main_region_main_r1__entry_Default();
		}
		
		/* 'default' enter sequence for region r1 */
		private void enterSequence_main_region_main_r1_Moving_r1_default() {
			react_main_region_main_r1_Moving_r1__entry_Default();
		}
		
		/* 'default' enter sequence for region r1 */
		private void enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_default() {
			react_main_region_main_r1_Moving_r1_Crossing_r1__entry_Default();
		}
		
		/* 'default' enter sequence for region r1 */
		private void enterSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_default() {
			react_main_region_main_r1_Moving_r1_GoBackToRoad_r1__entry_Default();
		}
		
		/* 'default' enter sequence for region r2 */
		private void enterSequence_main_region_main_r2_default() {
			react_main_region_main_r2__entry_Default();
		}
		
		/* 'default' enter sequence for region null */
		private void enterSequence_main_region_main__region2_default() {
			react_main_region_main__region2__entry_Default();
		}
		
		/* Default exit sequence for state Moving */
		private void exitSequence_main_region_main_r1_Moving() {
			exitSequence_main_region_main_r1_Moving_r1();
		}
		
		/* Default exit sequence for state GoingForward */
		private void exitSequence_main_region_main_r1_Moving_r1_GoingForward() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state Crossing */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1();
		}
		
		/* Default exit sequence for state CheckAccesses */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state CurveRight */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state CurveLeft */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state RandomSide */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state SideStraightRandom */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state FullRandom */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state FrontCanBeReached */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state CheckSideSensors */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state CheckAuthorizations */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations() {
			exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1();
		}
		
		/* Default exit sequence for state RandomA */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state RandomSideA */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state StraightLeftA */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state StraightRightA */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state LeftA */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state StraightA */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state RightA */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state InACrossing */
		private void exitSequence_main_region_main_r1_Moving_r1_InACrossing() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			
			exitAction_main_region_main_r1_Moving_r1_InACrossing();
		}
		
		/* Default exit sequence for state GoBackToRoad */
		private void exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad() {
			exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1();
		}
		
		/* Default exit sequence for state TurnRight */
		private void exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state TurnLeft */
		private void exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state Stopped */
		private void exitSequence_main_region_main_r1_Stopped() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state Init */
		private void exitSequence_main_region_main_r1_Init() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state Parking */
		private void exitSequence_main_region_main_r1_Parking() {
			exitSequence_main_region_main_r1_Parking_r1();
		}
		
		/* Default exit sequence for state park */
		private void exitSequence_main_region_main_r1_Parking_r1_park() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state parkLeft */
		private void exitSequence_main_region_main_r1_Parking_r1_parkLeft() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			
			exitAction_main_region_main_r1_Parking_r1_parkLeft();
		}
		
		/* Default exit sequence for state parkRight */
		private void exitSequence_main_region_main_r1_Parking_r1_parkRight() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
			
			exitAction_main_region_main_r1_Parking_r1_parkRight();
		}
		
		/* Default exit sequence for state fullPlace */
		private void exitSequence_main_region_main_r1_fullPlace() {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;
		}
		
		/* Default exit sequence for state ReadSensors */
		private void exitSequence_main_region_main_r2_ReadSensors() {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;
			
			exitAction_main_region_main_r2_ReadSensors();
		}
		
		/* Default exit sequence for state Obstacle */
		private void exitSequence_main_region_main__region2_Obstacle() {
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;
		}
		
		/* Default exit sequence for region main region */
		private void exitSequence_main_region() {
			switch (stateVector[0]) {
			case main_region_main_r1_Moving_r1_GoingForward:
				exitSequence_main_region_main_r1_Moving_r1_GoingForward();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA();
				break;
			case main_region_main_r1_Moving_r1_InACrossing:
				exitSequence_main_region_main_r1_Moving_r1_InACrossing();
				break;
			case main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight:
				exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight();
				break;
			case main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft:
				exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft();
				break;
			case main_region_main_r1_Stopped:
				exitSequence_main_region_main_r1_Stopped();
				break;
			case main_region_main_r1_Init:
				exitSequence_main_region_main_r1_Init();
				break;
			case main_region_main_r1_Parking_r1_park:
				exitSequence_main_region_main_r1_Parking_r1_park();
				break;
			case main_region_main_r1_Parking_r1_parkLeft:
				exitSequence_main_region_main_r1_Parking_r1_parkLeft();
				break;
			case main_region_main_r1_Parking_r1_parkRight:
				exitSequence_main_region_main_r1_Parking_r1_parkRight();
				break;
			case main_region_main_r1_fullPlace:
				exitSequence_main_region_main_r1_fullPlace();
				break;
			default:
				break;
			}
			
			switch (stateVector[1]) {
			case main_region_main_r2_ReadSensors:
				exitSequence_main_region_main_r2_ReadSensors();
				break;
			default:
				break;
			}
			
			switch (stateVector[2]) {
			case main_region_main__region2_Obstacle:
				exitSequence_main_region_main__region2_Obstacle();
				break;
			default:
				break;
			}
		}
		
		/* Default exit sequence for region r1 */
		private void exitSequence_main_region_main_r1() {
			switch (stateVector[0]) {
			case main_region_main_r1_Moving_r1_GoingForward:
				exitSequence_main_region_main_r1_Moving_r1_GoingForward();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA();
				break;
			case main_region_main_r1_Moving_r1_InACrossing:
				exitSequence_main_region_main_r1_Moving_r1_InACrossing();
				break;
			case main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight:
				exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight();
				break;
			case main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft:
				exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft();
				break;
			case main_region_main_r1_Stopped:
				exitSequence_main_region_main_r1_Stopped();
				break;
			case main_region_main_r1_Init:
				exitSequence_main_region_main_r1_Init();
				break;
			case main_region_main_r1_Parking_r1_park:
				exitSequence_main_region_main_r1_Parking_r1_park();
				break;
			case main_region_main_r1_Parking_r1_parkLeft:
				exitSequence_main_region_main_r1_Parking_r1_parkLeft();
				break;
			case main_region_main_r1_Parking_r1_parkRight:
				exitSequence_main_region_main_r1_Parking_r1_parkRight();
				break;
			case main_region_main_r1_fullPlace:
				exitSequence_main_region_main_r1_fullPlace();
				break;
			default:
				break;
			}
		}
		
		/* Default exit sequence for region r1 */
		private void exitSequence_main_region_main_r1_Moving_r1() {
			switch (stateVector[0]) {
			case main_region_main_r1_Moving_r1_GoingForward:
				exitSequence_main_region_main_r1_Moving_r1_GoingForward();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA();
				break;
			case main_region_main_r1_Moving_r1_InACrossing:
				exitSequence_main_region_main_r1_Moving_r1_InACrossing();
				break;
			case main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight:
				exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight();
				break;
			case main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft:
				exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft();
				break;
			default:
				break;
			}
		}
		
		/* Default exit sequence for region r1 */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1() {
			switch (stateVector[0]) {
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom();
				exitAction_main_region_main_r1_Moving_r1_Crossing_r1_Turning();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA();
				break;
			default:
				break;
			}
		}
		
		/* Default exit sequence for region r1 */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1() {
			switch (stateVector[0]) {
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom();
				break;
			default:
				break;
			}
		}
		
		/* Default exit sequence for region r1 */
		private void exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1() {
			switch (stateVector[0]) {
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA();
				break;
			case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA:
				exitSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA();
				break;
			default:
				break;
			}
		}
		
		/* Default exit sequence for region r1 */
		private void exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1() {
			switch (stateVector[0]) {
			case main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight:
				exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight();
				break;
			case main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft:
				exitSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft();
				break;
			default:
				break;
			}
		}
		
		/* Default exit sequence for region r1 */
		private void exitSequence_main_region_main_r1_Parking_r1() {
			switch (stateVector[0]) {
			case main_region_main_r1_Parking_r1_park:
				exitSequence_main_region_main_r1_Parking_r1_park();
				break;
			case main_region_main_r1_Parking_r1_parkLeft:
				exitSequence_main_region_main_r1_Parking_r1_parkLeft();
				break;
			case main_region_main_r1_Parking_r1_parkRight:
				exitSequence_main_region_main_r1_Parking_r1_parkRight();
				break;
			default:
				break;
			}
		}
		
		/* Default exit sequence for region r2 */
		private void exitSequence_main_region_main_r2() {
			switch (stateVector[1]) {
			case main_region_main_r2_ReadSensors:
				exitSequence_main_region_main_r2_ReadSensors();
				break;
			default:
				break;
			}
		}
		
		/* Default exit sequence for region null */
		private void exitSequence_main_region_main__region2() {
			switch (stateVector[2]) {
			case main_region_main__region2_Obstacle:
				exitSequence_main_region_main__region2_Obstacle();
				break;
			default:
				break;
			}
		}
		
		/* The reactions of state GoingForward. */
		private void react_main_region_main_r1_Moving_r1_GoingForward() {
			if (check_main_region_main_r1_Moving_r1_GoingForward_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_GoingForward_tr0();
			} else {
				if (check_main_region_main_r1_Moving_r1_GoingForward_tr1_tr1()) {
					effect_main_region_main_r1_Moving_r1_GoingForward_tr1();
				} else {
					if (check_main_region_main_r1_Moving_r1_GoingForward_tr2_tr2()) {
						effect_main_region_main_r1_Moving_r1_GoingForward_tr2();
					} else {
						if (check_main_region_main_r1_Moving_r1_GoingForward_tr3_tr3()) {
							effect_main_region_main_r1_Moving_r1_GoingForward_tr3();
						} else {
							if (check_main_region_main_r1_Moving_r1_GoingForward_tr4_tr4()) {
								effect_main_region_main_r1_Moving_r1_GoingForward_tr4();
							} else {
								if (check_main_region_main_r1_Moving_tr0_tr0()) {
									effect_main_region_main_r1_Moving_tr0();
								} else {
									if (check_main_region_main_r1_Moving_tr1_tr1()) {
										effect_main_region_main_r1_Moving_tr1();
									} else {
										if (check_main_region_main_r1_Moving_tr2_tr2()) {
											effect_main_region_main_r1_Moving_tr2();
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		/* The reactions of state CheckAccesses. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses_tr0();
			} else {
				if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses_tr1_tr1()) {
					effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses_tr1();
				} else {
					if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses_tr2_tr2()) {
						effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses_tr2();
					} else {
						if (check_main_region_main_r1_Moving_tr0_tr0()) {
							effect_main_region_main_r1_Moving_tr0();
						} else {
							if (check_main_region_main_r1_Moving_tr1_tr1()) {
								effect_main_region_main_r1_Moving_tr1();
							} else {
								if (check_main_region_main_r1_Moving_tr2_tr2()) {
									effect_main_region_main_r1_Moving_tr2();
								}
							}
						}
					}
				}
			}
		}
		
		/* The reactions of state CurveRight. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_Turning_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_Turning_tr0();
			} else {
				if (check_main_region_main_r1_Moving_tr0_tr0()) {
					effect_main_region_main_r1_Moving_tr0();
				} else {
					if (check_main_region_main_r1_Moving_tr1_tr1()) {
						effect_main_region_main_r1_Moving_tr1();
					} else {
						if (check_main_region_main_r1_Moving_tr2_tr2()) {
							effect_main_region_main_r1_Moving_tr2();
						}
					}
				}
			}
		}
		
		/* The reactions of state CurveLeft. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_Turning_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_Turning_tr0();
			} else {
				if (check_main_region_main_r1_Moving_tr0_tr0()) {
					effect_main_region_main_r1_Moving_tr0();
				} else {
					if (check_main_region_main_r1_Moving_tr1_tr1()) {
						effect_main_region_main_r1_Moving_tr1();
					} else {
						if (check_main_region_main_r1_Moving_tr2_tr2()) {
							effect_main_region_main_r1_Moving_tr2();
						}
					}
				}
			}
		}
		
		/* The reactions of state RandomSide. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_Turning_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_Turning_tr0();
			} else {
				if (check_main_region_main_r1_Moving_tr0_tr0()) {
					effect_main_region_main_r1_Moving_tr0();
				} else {
					if (check_main_region_main_r1_Moving_tr1_tr1()) {
						effect_main_region_main_r1_Moving_tr1();
					} else {
						if (check_main_region_main_r1_Moving_tr2_tr2()) {
							effect_main_region_main_r1_Moving_tr2();
						}
					}
				}
			}
		}
		
		/* The reactions of state SideStraightRandom. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_Turning_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_Turning_tr0();
			} else {
				if (check_main_region_main_r1_Moving_tr0_tr0()) {
					effect_main_region_main_r1_Moving_tr0();
				} else {
					if (check_main_region_main_r1_Moving_tr1_tr1()) {
						effect_main_region_main_r1_Moving_tr1();
					} else {
						if (check_main_region_main_r1_Moving_tr2_tr2()) {
							effect_main_region_main_r1_Moving_tr2();
						}
					}
				}
			}
		}
		
		/* The reactions of state FullRandom. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_Turning_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_Turning_tr0();
			} else {
				if (check_main_region_main_r1_Moving_tr0_tr0()) {
					effect_main_region_main_r1_Moving_tr0();
				} else {
					if (check_main_region_main_r1_Moving_tr1_tr1()) {
						effect_main_region_main_r1_Moving_tr1();
					} else {
						if (check_main_region_main_r1_Moving_tr2_tr2()) {
							effect_main_region_main_r1_Moving_tr2();
						}
					}
				}
			}
		}
		
		/* The reactions of state FrontCanBeReached. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached_tr0();
			} else {
				if (check_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached_tr1_tr1()) {
					effect_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached_tr1();
				} else {
					if (check_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached_tr2_tr2()) {
						effect_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached_tr2();
					} else {
						if (check_main_region_main_r1_Moving_tr0_tr0()) {
							effect_main_region_main_r1_Moving_tr0();
						} else {
							if (check_main_region_main_r1_Moving_tr1_tr1()) {
								effect_main_region_main_r1_Moving_tr1();
							} else {
								if (check_main_region_main_r1_Moving_tr2_tr2()) {
									effect_main_region_main_r1_Moving_tr2();
								}
							}
						}
					}
				}
			}
		}
		
		/* The reactions of state CheckSideSensors. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors_tr0();
			} else {
				if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors_tr1_tr1()) {
					effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors_tr1();
				} else {
					if (check_main_region_main_r1_Moving_tr0_tr0()) {
						effect_main_region_main_r1_Moving_tr0();
					} else {
						if (check_main_region_main_r1_Moving_tr1_tr1()) {
							effect_main_region_main_r1_Moving_tr1();
						} else {
							if (check_main_region_main_r1_Moving_tr2_tr2()) {
								effect_main_region_main_r1_Moving_tr2();
							}
						}
					}
				}
			}
		}
		
		/* The reactions of state RandomA. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr0();
			} else {
				if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr1_tr1()) {
					effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr1();
				} else {
					if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr2_tr2()) {
						effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr2();
					} else {
						if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr3_tr3()) {
							effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA_tr3();
						} else {
							if (check_main_region_main_r1_Moving_tr0_tr0()) {
								effect_main_region_main_r1_Moving_tr0();
							} else {
								if (check_main_region_main_r1_Moving_tr1_tr1()) {
									effect_main_region_main_r1_Moving_tr1();
								} else {
									if (check_main_region_main_r1_Moving_tr2_tr2()) {
										effect_main_region_main_r1_Moving_tr2();
									}
								}
							}
						}
					}
				}
			}
		}
		
		/* The reactions of state RandomSideA. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_tr0();
			} else {
				if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_tr1_tr1()) {
					effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_tr1();
				} else {
					if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_tr2_tr2()) {
						effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA_tr2();
					} else {
						if (check_main_region_main_r1_Moving_tr0_tr0()) {
							effect_main_region_main_r1_Moving_tr0();
						} else {
							if (check_main_region_main_r1_Moving_tr1_tr1()) {
								effect_main_region_main_r1_Moving_tr1();
							} else {
								if (check_main_region_main_r1_Moving_tr2_tr2()) {
									effect_main_region_main_r1_Moving_tr2();
								}
							}
						}
					}
				}
			}
		}
		
		/* The reactions of state StraightLeftA. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_tr0();
			} else {
				if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_tr1_tr1()) {
					effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_tr1();
				} else {
					if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_tr2_tr2()) {
						effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA_tr2();
					} else {
						if (check_main_region_main_r1_Moving_tr0_tr0()) {
							effect_main_region_main_r1_Moving_tr0();
						} else {
							if (check_main_region_main_r1_Moving_tr1_tr1()) {
								effect_main_region_main_r1_Moving_tr1();
							} else {
								if (check_main_region_main_r1_Moving_tr2_tr2()) {
									effect_main_region_main_r1_Moving_tr2();
								}
							}
						}
					}
				}
			}
		}
		
		/* The reactions of state StraightRightA. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_tr0();
			} else {
				if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_tr1_tr1()) {
					effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_tr1();
				} else {
					if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_tr2_tr2()) {
						effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA_tr2();
					} else {
						if (check_main_region_main_r1_Moving_tr0_tr0()) {
							effect_main_region_main_r1_Moving_tr0();
						} else {
							if (check_main_region_main_r1_Moving_tr1_tr1()) {
								effect_main_region_main_r1_Moving_tr1();
							} else {
								if (check_main_region_main_r1_Moving_tr2_tr2()) {
									effect_main_region_main_r1_Moving_tr2();
								}
							}
						}
					}
				}
			}
		}
		
		/* The reactions of state LeftA. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA_tr0();
			} else {
				if (check_main_region_main_r1_Moving_tr0_tr0()) {
					effect_main_region_main_r1_Moving_tr0();
				} else {
					if (check_main_region_main_r1_Moving_tr1_tr1()) {
						effect_main_region_main_r1_Moving_tr1();
					} else {
						if (check_main_region_main_r1_Moving_tr2_tr2()) {
							effect_main_region_main_r1_Moving_tr2();
						}
					}
				}
			}
		}
		
		/* The reactions of state StraightA. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA_tr0();
			} else {
				if (check_main_region_main_r1_Moving_tr0_tr0()) {
					effect_main_region_main_r1_Moving_tr0();
				} else {
					if (check_main_region_main_r1_Moving_tr1_tr1()) {
						effect_main_region_main_r1_Moving_tr1();
					} else {
						if (check_main_region_main_r1_Moving_tr2_tr2()) {
							effect_main_region_main_r1_Moving_tr2();
						}
					}
				}
			}
		}
		
		/* The reactions of state RightA. */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA() {
			if (check_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA_tr0();
			} else {
				if (check_main_region_main_r1_Moving_tr0_tr0()) {
					effect_main_region_main_r1_Moving_tr0();
				} else {
					if (check_main_region_main_r1_Moving_tr1_tr1()) {
						effect_main_region_main_r1_Moving_tr1();
					} else {
						if (check_main_region_main_r1_Moving_tr2_tr2()) {
							effect_main_region_main_r1_Moving_tr2();
						}
					}
				}
			}
		}
		
		/* The reactions of state InACrossing. */
		private void react_main_region_main_r1_Moving_r1_InACrossing() {
			if (check_main_region_main_r1_Moving_r1_InACrossing_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_InACrossing_tr0();
			} else {
				if (check_main_region_main_r1_Moving_tr0_tr0()) {
					effect_main_region_main_r1_Moving_tr0();
				} else {
					if (check_main_region_main_r1_Moving_tr1_tr1()) {
						effect_main_region_main_r1_Moving_tr1();
					} else {
						if (check_main_region_main_r1_Moving_tr2_tr2()) {
							effect_main_region_main_r1_Moving_tr2();
						}
					}
				}
			}
		}
		
		/* The reactions of state TurnRight. */
		private void react_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight() {
			if (check_main_region_main_r1_Moving_r1_GoBackToRoad_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_GoBackToRoad_tr0();
			} else {
				if (check_main_region_main_r1_Moving_r1_GoBackToRoad_tr1_tr1()) {
					effect_main_region_main_r1_Moving_r1_GoBackToRoad_tr1();
				} else {
					if (check_main_region_main_r1_Moving_r1_GoBackToRoad_tr2_tr2()) {
						effect_main_region_main_r1_Moving_r1_GoBackToRoad_tr2();
					} else {
						if (check_main_region_main_r1_Moving_tr0_tr0()) {
							effect_main_region_main_r1_Moving_tr0();
						} else {
							if (check_main_region_main_r1_Moving_tr1_tr1()) {
								effect_main_region_main_r1_Moving_tr1();
							} else {
								if (check_main_region_main_r1_Moving_tr2_tr2()) {
									effect_main_region_main_r1_Moving_tr2();
								}
							}
						}
					}
				}
			}
		}
		
		/* The reactions of state TurnLeft. */
		private void react_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft() {
			if (check_main_region_main_r1_Moving_r1_GoBackToRoad_tr0_tr0()) {
				effect_main_region_main_r1_Moving_r1_GoBackToRoad_tr0();
			} else {
				if (check_main_region_main_r1_Moving_r1_GoBackToRoad_tr1_tr1()) {
					effect_main_region_main_r1_Moving_r1_GoBackToRoad_tr1();
				} else {
					if (check_main_region_main_r1_Moving_r1_GoBackToRoad_tr2_tr2()) {
						effect_main_region_main_r1_Moving_r1_GoBackToRoad_tr2();
					} else {
						if (check_main_region_main_r1_Moving_tr0_tr0()) {
							effect_main_region_main_r1_Moving_tr0();
						} else {
							if (check_main_region_main_r1_Moving_tr1_tr1()) {
								effect_main_region_main_r1_Moving_tr1();
							} else {
								if (check_main_region_main_r1_Moving_tr2_tr2()) {
									effect_main_region_main_r1_Moving_tr2();
								}
							}
						}
					}
				}
			}
		}
		
		/* The reactions of state Stopped. */
		private void react_main_region_main_r1_Stopped() {
			if (check_main_region_main_r1_Stopped_tr0_tr0()) {
				effect_main_region_main_r1_Stopped_tr0();
			}
		}
		
		/* The reactions of state Init. */
		private void react_main_region_main_r1_Init() {
			if (check_main_region_main_r1_Init_tr0_tr0()) {
				effect_main_region_main_r1_Init_tr0();
			}
		}
		
		/* The reactions of state park. */
		private void react_main_region_main_r1_Parking_r1_park() {
			if (check_main_region_main_r1_Parking_tr0_tr0()) {
				effect_main_region_main_r1_Parking_tr0();
			}
		}
		
		/* The reactions of state parkLeft. */
		private void react_main_region_main_r1_Parking_r1_parkLeft() {
			if (check_main_region_main_r1_Parking_r1_parkLeft_tr0_tr0()) {
				effect_main_region_main_r1_Parking_r1_parkLeft_tr0();
			} else {
				if (check_main_region_main_r1_Parking_r1_parkLeft_tr1_tr1()) {
					effect_main_region_main_r1_Parking_r1_parkLeft_tr1();
				} else {
					if (check_main_region_main_r1_Parking_tr0_tr0()) {
						effect_main_region_main_r1_Parking_tr0();
					}
				}
			}
		}
		
		/* The reactions of state parkRight. */
		private void react_main_region_main_r1_Parking_r1_parkRight() {
			if (check_main_region_main_r1_Parking_r1_parkRight_tr0_tr0()) {
				effect_main_region_main_r1_Parking_r1_parkRight_tr0();
			} else {
				if (check_main_region_main_r1_Parking_r1_parkRight_tr1_tr1()) {
					effect_main_region_main_r1_Parking_r1_parkRight_tr1();
				} else {
					if (check_main_region_main_r1_Parking_tr0_tr0()) {
						effect_main_region_main_r1_Parking_tr0();
					}
				}
			}
		}
		
		/* The reactions of state fullPlace. */
		private void react_main_region_main_r1_fullPlace() {
			if (check_main_region_main_r1_fullPlace_tr0_tr0()) {
				effect_main_region_main_r1_fullPlace_tr0();
			}
		}
		
		/* The reactions of state ReadSensors. */
		private void react_main_region_main_r2_ReadSensors() {
			if (check_main_region_main_r2_ReadSensors_tr0_tr0()) {
				effect_main_region_main_r2_ReadSensors_tr0();
			}
		}
		
		/* The reactions of state Obstacle. */
		private void react_main_region_main__region2_Obstacle() {
		}
		
		/* Default react sequence for initial entry  */
		private void react_main_region_main_r1__entry_Default() {
			enterSequence_main_region_main_r1_Init_default();
		}
		
		/* Default react sequence for initial entry  */
		private void react_main_region_main_r1_Moving_r1__entry_Default() {
			enterSequence_main_region_main_r1_Moving_r1_GoingForward_default();
		}
		
		/* Default react sequence for initial entry  */
		private void react_main_region_main_r1_Moving_r1_Crossing_r1__entry_Default() {
			enterSequence_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses_default();
		}
		
		/* Default react sequence for initial entry  */
		private void react_main_region_main_r1_Moving_r1_GoBackToRoad_r1__entry_Default() {
			enterSequence_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight_default();
		}
		
		/* Default react sequence for initial entry  */
		private void react_main_region_main_r2__entry_Default() {
			enterSequence_main_region_main_r2_ReadSensors_default();
		}
		
		/* Default react sequence for initial entry  */
		private void react_main_region_main__region2__entry_Default() {
			enterSequence_main_region_main__region2_Obstacle_default();
		}
		
		/* Default react sequence for initial entry  */
		private void react_main_region__entry_Default() {
			enterSequence_main_region_main_default();
		}
		
		public void runCycle() {
			if (!initialized)
				throw new IllegalStateException(
						"The state machine needs to be initialized first by calling the init() function.");
			clearOutEvents();
			for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
				switch (stateVector[nextStateIndex]) {
				case main_region_main_r1_Moving_r1_GoingForward:
					react_main_region_main_r1_Moving_r1_GoingForward();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses:
					react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAccesses();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight:
					react_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveRight();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft:
					react_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_CurveLeft();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide:
					react_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_RandomSide();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom:
					react_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_SideStraightRandom();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom:
					react_main_region_main_r1_Moving_r1_Crossing_r1_Turning_r1_FullRandom();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached:
					react_main_region_main_r1_Moving_r1_Crossing_r1_FrontCanBeReached();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors:
					react_main_region_main_r1_Moving_r1_Crossing_r1_CheckSideSensors();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA:
					react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomA();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA:
					react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RandomSideA();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA:
					react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightLeftA();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA:
					react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightRightA();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA:
					react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_LeftA();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA:
					react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_StraightA();
					break;
				case main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA:
					react_main_region_main_r1_Moving_r1_Crossing_r1_CheckAuthorizations_r1_RightA();
					break;
				case main_region_main_r1_Moving_r1_InACrossing:
					react_main_region_main_r1_Moving_r1_InACrossing();
					break;
				case main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight:
					react_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnRight();
					break;
				case main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft:
					react_main_region_main_r1_Moving_r1_GoBackToRoad_r1_TurnLeft();
					break;
				case main_region_main_r1_Stopped:
					react_main_region_main_r1_Stopped();
					break;
				case main_region_main_r1_Init:
					react_main_region_main_r1_Init();
					break;
				case main_region_main_r1_Parking_r1_park:
					react_main_region_main_r1_Parking_r1_park();
					break;
				case main_region_main_r1_Parking_r1_parkLeft:
					react_main_region_main_r1_Parking_r1_parkLeft();
					break;
				case main_region_main_r1_Parking_r1_parkRight:
					react_main_region_main_r1_Parking_r1_parkRight();
					break;
				case main_region_main_r1_fullPlace:
					react_main_region_main_r1_fullPlace();
					break;
				case main_region_main_r2_ReadSensors:
					react_main_region_main_r2_ReadSensors();
					break;
				case main_region_main__region2_Obstacle:
					react_main_region_main__region2_Obstacle();
					break;
				default:
					// $NullState$
				}
			}
			clearEvents();
		}
		
}
