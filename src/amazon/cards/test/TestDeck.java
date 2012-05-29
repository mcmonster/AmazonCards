package amazon.cards.test;

import amazon.cards.*;

public class TestDeck {
	private TestDeck() {}

	public static void main(String[] args) {
		int[][]   frequency = new int[Card.SuitType.SIZE][Card.FaceValueType.SIZE];
		final int NUM_SAMPLES = 100000;
		
		// Repeatedly shuffle and take the top card to 
		// analyze the randomness of the shuffle
		for(int sampleIter=0; sampleIter<NUM_SAMPLES; sampleIter++) {
			// Get the first card in the shuffled deck
			Deck testDeck = new Deck();
			testDeck.shuffle();
			Card card = testDeck.deal_one_card();
			
			// Update the frequency count
			int suitPos = 0;
			int facePos = 0; 
			switch(card.getSuit()) {
				case HEART:
					suitPos = 0;
					break;
				case SPADE:
					suitPos = 1;
					break;
				case CLUB:
					suitPos = 2;
					break;
				case DIAMOND:
					suitPos = 3;
					break;
			}
			switch(card.getFaceValue()) {
				case JACK:
					facePos = 9;
					break;
				case QUEEN:
					facePos = 10;
					break;
				case KING:
					facePos = 11;
					break;
				case ACE:
					facePos = 12;
					break;
				default:
					facePos = card.getFaceValue().getValue()-2;
					break;
			}
			frequency[suitPos][facePos]++;
		}
		
		// Print the results of the distribution test
		System.out.println("Frequencies:");
		System.out.println("\t2 \t3 \t4 \t5 \t6 \t7 \t8 \t9 \t10 \tJ \tQ \tK \tA");
		System.out.print("C\t");
		for(int faceIter=0; faceIter<Card.FaceValueType.SIZE; faceIter++)
			System.out.print(((float)frequency[0][faceIter]/NUM_SAMPLES)+"\t");
		System.out.print("\nD\t");
		for(int faceIter=0; faceIter<Card.FaceValueType.SIZE; faceIter++)
			System.out.print(((float)frequency[1][faceIter]/NUM_SAMPLES)+"\t");
		System.out.print("\nH\t");
		for(int faceIter=0; faceIter<Card.FaceValueType.SIZE; faceIter++)
			System.out.print(((float)frequency[2][faceIter]/NUM_SAMPLES)+"\t");
		System.out.print("\nS\t");
		for(int faceIter=0; faceIter<Card.FaceValueType.SIZE; faceIter++)
			System.out.print(((float)frequency[3][faceIter]/NUM_SAMPLES)+"\t");
	}
}
