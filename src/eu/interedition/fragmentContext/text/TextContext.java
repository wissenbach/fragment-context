package eu.interedition.fragmentContext.text;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;

import eu.interedition.fragmentContext.Constraint;
import eu.interedition.fragmentContext.Context;
import eu.interedition.fragmentContext.Primary;

public class TextContext implements Context {

	public static enum HashType {
		MD5, SHA, Length
	};

	private byte[] checkSum;

	private HashType checkSumType;

	String beforeContext;

	String afterContext;

	public TextContext(TextPrimary primary, TextConstraint constraint,
			HashType checkSumType, int contextLength) {
		super();
		this.checkSumType = checkSumType;
		this.checkSum = checkSum(primary.getContent(), checkSumType);
		
		int beforeStart = constraint.getStartPos() - contextLength;
		beforeStart = Math.max(0, beforeStart);
		int beforeEnd = constraint.getStartPos();
		
		int afterStart = constraint.getEndPos();
		int afterEnd = constraint.getEndPos() + contextLength;
		afterEnd = Math.min(primary.getContent().length(), afterEnd);
		
		this.beforeContext = primary.getContent().substring(beforeStart, beforeEnd);
		this.afterContext = primary.getContent().substring(afterStart, afterEnd);
	}

	static byte[] checkSum(String content, HashType checksumType) {
		byte[] contentBytes;
		try {
			contentBytes = content.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException("Encoding unknown!");
		}
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(checksumType.name());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException("Algorithm unknown!");
		}
		byte[] digest = md.digest(contentBytes);

		return digest;
	}
	
	@Override
	public boolean verify(Primary primary) {
		if (!(primary instanceof TextPrimary))
			throw new IllegalArgumentException();

		TextPrimary textPrimary = (TextPrimary) primary;

		byte[] digest = checkSum(textPrimary.getContent(), this.checkSumType);
		
		
		return Arrays.equals(digest, this.checkSum);

	}

	@Override
	public Constraint match(Primary primary) {
		return null;
	}

}
