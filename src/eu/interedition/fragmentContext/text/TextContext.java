package eu.interedition.fragmentContext.text;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import de.tud.kom.stringmatching.shinglecloud.ShingleCloud;
import de.tud.kom.stringutils.tokenization.CharacterTokenizer;
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
	
	public TextContext(TextConstraint constraint, byte[] checkSum,
			HashType checkSumType, String beforeContext, String afterContext) {
		super();
		this.checkSumType = checkSumType;
		this.checkSum = checkSum;
		
		this.beforeContext = beforeContext;
		this.afterContext = afterContext;
	}

	public static byte[] checkSum(String content, HashType checksumType) {
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
	public Constraint match(Primary primary) throws Context.NoMatchFoundException {
		if (!(primary instanceof TextPrimary))
			throw new IllegalArgumentException();
		TextPrimary textPrimary = (TextPrimary) primary;
		
		ShingleCloud sc = new ShingleCloud(textPrimary.getContent());
		
		sc.setTokenizer(new CharacterTokenizer());
		sc.setNGramSize(2);
		sc.setMinimumNumberOfOnesInMatch(1);
		sc.setSortMatchesByRating(true);
		
		//find the text before the annotation
		sc.match(this.beforeContext);
		if (sc.getMatches().isEmpty())
			throw new Context.NoMatchFoundException();
		
		int startPos = sc.getMatches().get(0).getStart() +
			sc.getMatches().get(0).getLength();	
		
		//find text after annotation
		sc.match(this.afterContext);
		if (sc.getMatches().isEmpty())
			throw new Context.NoMatchFoundException();
		
		int endPos = sc.getMatches().get(0).getStart();
		
		//sanity check
		if (endPos < startPos)
			throw new Context.NoMatchFoundException();
			
		return new TextConstraint(startPos, endPos);
	}

}
