/*
 * CATMA Computer Aided Text Markup and Analysis
 *
 *    Copyright (C) 2008-2010  University Of Hamburg
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, either version 3 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package eu.interedition.fragmentContext.ws;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * A {@link java.io.FilterInputStream} which filters the UTF-ByteOrderMark (BOM). A call
 * to {@link java.io.FilterInputStream#read()} will return the first byte after the BOM.
 *
 * @author Marco Petris
 *
 */
public class BOMFilterInputStream extends FilterInputStream {
	
	public static final byte[] UTF_8_BOM = 
			new byte[] {(byte)0xEF, (byte)0xBB, (byte)0xBF};

    private final static Charset UTF8 = Charset.forName( "UTF-8" );
    private final static Charset UTF16 = Charset.forName( "UTF-16" );
    private final static Charset UTF16BE = Charset.forName( "UTF-16BE" );
    private final static Charset UTF16LE = Charset.forName( "UTF-16LE" );
    
    private int[] utf8bomTestBuffer = null;
    private int utf8bomTestBufferIdx = 3;
    
    public BOMFilterInputStream(InputStream in, Charset charset) throws IOException {
        super(in);
		handleBOM( charset );
    }

    /**
     * Skips the BOM from <code>this</code> stream.
     * @param charset the charset of the stream
     * @throws IOException access failure to the stream
     */
    private void handleBOM( Charset charset ) throws IOException {
        if( charset.equals( UTF8 ) ) {
        	int i1=read();
        	int i2=read();
        	int i3=read();
        	if ((((byte)i1)!=UTF_8_BOM[0]) || (((byte)i2)!=UTF_8_BOM[1]) || (((byte)i3)!=UTF_8_BOM[2])) {
        		utf8bomTestBuffer = new int[] { i1, i2, i3 };
        		utf8bomTestBufferIdx = -1;
        	}
        	else {
        		skip(3);
        	}
        }
        else if(
            charset.equals( UTF16 )
            || charset.equals( UTF16BE )
            || charset.equals( UTF16LE ) ) {
            skip( 2 );
        }
    }
    
    
    @Override
    public int read() throws IOException {
    	if (utf8bomTestBufferIdx <=1) {
    		utf8bomTestBufferIdx++;
    		return utf8bomTestBuffer[utf8bomTestBufferIdx];
    	}
    	
    	return super.read();
    }

}
