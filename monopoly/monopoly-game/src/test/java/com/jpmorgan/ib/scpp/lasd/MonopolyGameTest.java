package com.jpmorgan.ib.scpp.lasd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class MonopolyGameTest {

	private static final int NUMBER_OF_ROUNDS = 3;
	private static final int NUMBER_OF_PLAYERS = 2;
	private MonopolyGame testObject;

	@Before
	public void setup() {
		testObject = new MonopolyGame();
	}

	@Test
	public void playGame_whenHaving3Rounds2Players_gameInitialized() {
		testObject.playGame(NUMBER_OF_PLAYERS, NUMBER_OF_ROUNDS);
		assertEquals(NUMBER_OF_PLAYERS, testObject.players.size());
		assertEquals(NUMBER_OF_ROUNDS, testObject.numberOfRounds);
		assertNotNull(testObject.board);
	}
	
	@Test
	public void playGame_whenHaving3Rounds2Players_roundsCompleted() {
		testObject.playGame(NUMBER_OF_PLAYERS, NUMBER_OF_ROUNDS);
		assertEquals(NUMBER_OF_ROUNDS, testObject.roundsCompleted);
	}
	
	@Test
	public void playGame_whenHaving3Rounds2Players_currentRoundIsEqualToNumberOfRoundsAndEveryPlayerHasTakenTurn() {
		testObject.playGame(NUMBER_OF_PLAYERS, NUMBER_OF_ROUNDS);
		assertEquals(NUMBER_OF_ROUNDS, testObject.currentRound);
		for (Player player : testObject.players) {
			assertEquals(NUMBER_OF_ROUNDS, player.numberOfTurnsTaken);
		}
	}
	
}
