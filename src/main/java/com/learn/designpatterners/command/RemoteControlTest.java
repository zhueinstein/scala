package com.learn.designpatterners.command;

/**
 *
 * @author: WeFon
 * @date: 2018-10-31 22:33
 * @Copyright: 2018
 */
public class RemoteControlTest {

		public static void main(String[] args) {
				RemoteControl remoteControl = new RemoteControl();
				Light livingRoomLight = new Light("Living Room");
				Light kitchenLight = new Light("Kitchen");
				CeilingFan ceilingFan = new CeilingFan("Living Room");
				GarageDoor garageDoor = new GarageDoor("");
				Stereo stereo = new Stereo("Living Room");

				LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
				LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
				LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
				LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

				CeilingFanOnCommand ceilingFanOnCommand = new CeilingFanOnCommand(ceilingFan);
				CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);

				GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
				GarageDoorCloseCommand garageDoorCloseCommand = new GarageDoorCloseCommand(garageDoor);

				StereoOnWithCDCommand stereoOnWithCDCommand = new StereoOnWithCDCommand(stereo);
				StereoOffWithCDCommand stereoOffWithCDCommand = new StereoOffWithCDCommand(stereo);

				remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
				remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
				remoteControl.setCommand(2, ceilingFanOnCommand, ceilingFanOffCommand);
				remoteControl.setCommand(3, stereoOnWithCDCommand, stereoOffWithCDCommand);
				remoteControl.setCommand(4, garageDoorOpenCommand, garageDoorCloseCommand);
				System.out.println(remoteControl.toString());

				remoteControl.onButtonWasPressed(0);
				remoteControl.offButtonWaspressed(0);
				remoteControl.onButtonWasPressed(1);
				remoteControl.offButtonWaspressed(1);
				remoteControl.onButtonWasPressed(2);
				remoteControl.offButtonWaspressed(2);
				remoteControl.onButtonWasPressed(3);
				remoteControl.offButtonWaspressed(3);
				remoteControl.onButtonWasPressed(4);
				remoteControl.offButtonWaspressed(4);

		}
}
