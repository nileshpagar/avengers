package com.jpmorgan.ib.scpp.lasd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {

	private static final int TOTAL_SQUARES = 40;
	Board testObj; 
	
	@Before
	public void setup(){
		testObj = new Board(TOTAL_SQUARES); 
	}
	
	@Test
	public void initialize() {
		assertEquals(TOTAL_SQUARES, testObj.doNothingSquares.length);
	}
	
	@Test
	public void calculateNextSquare_WhenDieRolled(){
		int currentSquarePosition = 1;
		DoNothingSquare currentDoNothingSquare = new DoNothingSquare(currentSquarePosition);
		int diceTotal = 2;
		
		int nextSquarePosition = testObj.calculateNextSquare(diceTotal, currentDoNothingSquare).getCurrentPosition();
		
		assertEquals(currentSquarePosition + diceTotal,
						nextSquarePosition );
	}
	
	@Test
    public void calculateNextSquare_WhenStepOverflows_ShouldGoBackToBeginning(){
        int currentSquarePosition = 37;
        int diceTotal = 5;

        DoNothingSquare currentDoNothingSquare = new DoNothingSquare(currentSquarePosition);

        int nextSquarePosition = testObj.calculateNextSquare(diceTotal, currentDoNothingSquare).getCurrentPosition();

        assertEquals((currentSquarePosition + diceTotal) % TOTAL_SQUARES,
                nextSquarePosition );
    }

}
