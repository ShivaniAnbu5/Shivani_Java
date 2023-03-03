package Patterns;

import java.util.Scanner;

//This is a behavioral design pattern in which an object is used to encapsulate all information needed to perform an action or trigger an event at a later time. 

//The executor of the command does not need to know anything at all about what the command is, what context information it needs on or what it does. All of that is encapsulated in the command.This allows us to do things such as have a list of commands that are executed in order, that are dependent on other items, that are assigned to some triggering event etc.

public class CommandPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		
		Remote remote = new Remote();
		
		Tv tv = new Tv();
		SetTopBox sbox=new SetTopBox();
		SoundSystem ss=new SoundSystem();
		VGame vgame=new VGame();

		Command newscommand=new NewsChannelCommand(tv, sbox, ss, vgame);
		Command cookingcommand=new CookingChannelCommand(tv, sbox, ss, vgame);
		Command ttgamecommand=new TTGameCommand(tv, sbox, ss, vgame);
		Command bowlinggamecommand=new BowlingGameCommand(tv, sbox, ss, vgame);
		
		remote.assignCommand(1, ttgamecommand);
		remote.assignCommand(2, bowlinggamecommand);
		remote.assignCommand(3, cookingcommand);
		remote.assignCommand(4, newscommand);
		
		System.out.println("Enter the channel you want:");
		
		remote.executeCommand(s.nextInt());
	}

}


class Remote{
	Command commands[] = new Command[6];
	public Remote() {
		// TODO Auto-generated constructor stub
		for(int i=0;i<6;i++) {
			commands[i] = new DummyCommand();
		}
		
		
	}
	
	void assignCommand(int slot,Command command) {
		commands[slot] = command;
	}
	
	void executeCommand(int slot) {
		commands[slot].execute();
	}
 }

abstract class Command{
	Tv tv;SetTopBox stBox;SoundSystem ss;VGame vgame;
	
	public Command() {
		// TODO Auto-generated constructor stub
	}

	public Command(Tv tv, SetTopBox stBox, SoundSystem ss, VGame vgame) {
		super();
		this.tv = tv;
		this.stBox = stBox;
		this.ss = ss;
		this.vgame = vgame;
	}
	
	abstract void execute();
}

class DummyCommand extends Command{

	@Override
	void execute() {
		// TODO Auto-generated method stub
		System.out.println("Dummy command");
	}
	
}

class NewsChannelCommand extends Command{

	public NewsChannelCommand(Tv tv, SetTopBox stBox, SoundSystem ss, VGame vgame) {
		super(tv, stBox, ss, vgame);
		// TODO Auto-generated constructor stub
	}

	@Override
	void execute() {
		// TODO Auto-generated method stub
		System.out.println("The news channel process started...");
		tv.av1();
		stBox.newsChannel();
		ss.increaseVolume();		
		System.out.println("Enjoy the news channel....");
		
	}
	
}

class CookingChannelCommand extends Command{

	public CookingChannelCommand(Tv tv, SetTopBox stBox, SoundSystem ss, VGame vgame) {
		super(tv, stBox, ss, vgame);
		// TODO Auto-generated constructor stub
	}

	@Override
	void execute() {
		// TODO Auto-generated method stub
		System.out.println("The cooking channel process started...");
		tv.av1();
		stBox.cookingChannel();
		ss.increaseVolume();		
		System.out.println("Enjoy the cooking channel....");
		
	}
	
}

class TTGameCommand extends Command{

	public TTGameCommand(Tv tv, SetTopBox stBox, SoundSystem ss, VGame vgame) {
		super(tv, stBox, ss, vgame);
		// TODO Auto-generated constructor stub
	}

	@Override
	void execute() {
		// TODO Auto-generated method stub
		System.out.println("The TT game started...");
		tv.av2();
		vgame.ttGame();
		ss.decreaseVolume();		
		System.out.println("Enjoy the TT game....");
	}
	
}

class BowlingGameCommand extends Command{

	public BowlingGameCommand(Tv tv, SetTopBox stBox, SoundSystem ss, VGame vgame) {
		super(tv, stBox, ss, vgame);
		// TODO Auto-generated constructor stub
	}

	@Override
	void execute() {
		// TODO Auto-generated method stub
		System.out.println("The Bowling game started...");
		tv.av2();
		vgame.bowling();
		ss.decreaseVolume();		
		System.out.println("Enjoy the Bowling game....");
	}
	
}

class Tv{
	void av1(){
		System.out.println("av1 mode...");
	}
	
	void av2(){
		System.out.println("av2 mode...");
	}
}

class SetTopBox{
	void newsChannel() {
		System.out.println("News channel....");
	}
	
	void cookingChannel() {
		System.out.println("Cooking channel....");
	}
	
}

class SoundSystem{
	void increaseVolume() {
		System.out.println("Volume increased...");
	}
	void decreaseVolume() {
		System.out.println("Volume decreased...");
	}
	
}

class VGame{
	void ttGame() {
		System.out.println("TT game started...");
	}
	void bowling() {
		System.out.println("Bowling game started...");
	}
}