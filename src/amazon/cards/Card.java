package amazon.cards;

// @author R. Matt McCann
//! Represents a playing card, including its face value and suit
public class Card {
	//! Constructs a card given the provided face value and suit
	public Card(final FaceValueType faceValue,
			    final SuitType suit) {
		FaceValue = faceValue;
		Suit = suit;
	}

	//! Get the face value of the card
	public final FaceValueType getFaceValue() {
		return FaceValue;
	}
	
	//! Get the suit of the card
	public final SuitType getSuit() {
		return Suit;
	}
	
	//! Get the value of the card in the range of 2-11
	//! Relevant to Black Jack, etc.
	public int getValue() {
		return FaceValue.getValue();
	}

	//! Set the face value of the card
	public void setFaceValue(final FaceValueType faceValue) {
		FaceValue = faceValue;
	}

	//! Set the suit of the card
	public void setSuit(final SuitType suit) {
		Suit = suit;
	}
	
	//! Enumeration of valid face values
	public enum FaceValueType {
		TWO(2),
		THREE(3),
		FOUR(4),
		FIVE(5),
		SIX(6),
		SEVEN(7),
		EIGHT(8),
		NINE(9),
		TEN(10),
		JACK(10),
		QUEEN(10),
		KING(10),
		ACE(11);
		
		private FaceValueType(final int value) {
			Value = value;
		}
		
		@Override
		public String toString() {
			return Integer.toString(Value);
		}
		
		public int getValue() {
			return Value;
		}
		
		public final static int SIZE = 14;
		private int Value;
	}
	
	//! Enumeration of valid suits
	public enum SuitType {
		CLUB("Club"),
		DIAMOND("Diamond"),
		HEART("Heart"),
		SPADE("Spade");
		
		private SuitType(final String value) {
			Value = value;
		}
		
		@Override
		public String toString() {
			return Value;
		}
		
		public final static int SIZE = 4;
		private String Value;
	}

	private FaceValueType FaceValue; //!< Face value of the card
	private SuitType      Suit; //!< Suit of the card
}
