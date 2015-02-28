// ========================================================================
// Copyright (c) 2004-2009 Mort Bay Consulting Pty. Ltd.
// ------------------------------------------------------------------------
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0
// and Apache License v2.0 which accompanies this distribution.
// The Eclipse Public License is available at 
// http://www.eclipse.org/legal/epl-v10.html
// The Apache License v2.0 is available at
// http://www.opensource.org/licenses/apache2.0.php
// You may elect to redistribute this code under either of these licenses. 
// ========================================================================

package com.loveahu.filter.jetty.http;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

import com.loveahu.filter.jetty.io.Buffer;
import com.loveahu.filter.jetty.io.BufferCache;
import com.loveahu.filter.jetty.io.ByteArrayBuffer;


/**
 * Cached HTTP Header values.
 * This class caches the conversion of common HTTP Header values to and from {@link ByteArrayBuffer} instances.
 * The resource "/org/eclipse/jetty/useragents" is checked for a list of common user agents, so that repeated
 * creation of strings for these agents can be avoided.
 * 
 * 
 */
public class HttpHeaderValues extends BufferCache
{
    public final static String
        CLOSE="close",
        CHUNKED="chunked",
        GZIP="gzip",
        IDENTITY="identity",
        KEEP_ALIVE="keep-alive",
        CONTINUE="100-continue",
        PROCESSING="102-processing",
        TE="TE",
        BYTES="bytes",
        NO_CACHE="no-cache",
        UPGRADE="Upgrade";

    public final static int
        CLOSE_ORDINAL=1,
        CHUNKED_ORDINAL=2,
        GZIP_ORDINAL=3,
        IDENTITY_ORDINAL=4,
        KEEP_ALIVE_ORDINAL=5,
        CONTINUE_ORDINAL=6,
        PROCESSING_ORDINAL=7,
        TE_ORDINAL=8,
        BYTES_ORDINAL=9,
        NO_CACHE_ORDINAL=10,
        UPGRADE_ORDINAL=11;
    
    public final static HttpHeaderValues CACHE= new HttpHeaderValues();

    public final static Buffer 
        CLOSE_BUFFER=CACHE.add(CLOSE,CLOSE_ORDINAL),
        CHUNKED_BUFFER=CACHE.add(CHUNKED,CHUNKED_ORDINAL),
        GZIP_BUFFER=CACHE.add(GZIP,GZIP_ORDINAL),
        IDENTITY_BUFFER=CACHE.add(IDENTITY,IDENTITY_ORDINAL),
        KEEP_ALIVE_BUFFER=CACHE.add(KEEP_ALIVE,KEEP_ALIVE_ORDINAL),
        CONTINUE_BUFFER=CACHE.add(CONTINUE, CONTINUE_ORDINAL),
        PROCESSING_BUFFER=CACHE.add(PROCESSING, PROCESSING_ORDINAL),
        TE_BUFFER=CACHE.add(TE,TE_ORDINAL),
        BYTES_BUFFER=CACHE.add(BYTES,BYTES_ORDINAL),
        NO_CACHE_BUFFER=CACHE.add(NO_CACHE,NO_CACHE_ORDINAL),
        UPGRADE_BUFFER=CACHE.add(UPGRADE,UPGRADE_ORDINAL);
        
    static
    {  
        int index=100;
        CACHE.add("gzip",index++);
        CACHE.add("gzip,deflate",index++);
        CACHE.add("deflate",index++);

        InputStream ua = HttpHeaderValues.class.getResourceAsStream("/org/eclipse/jetty/http/useragents");
        try
        {
            if (ua!=null)
            {
                try
                {
                    LineNumberReader in = new LineNumberReader(new InputStreamReader(ua));
                    String line = in.readLine();
                    while (line!=null)
                    {
                        CACHE.add(line,index++);
                        line = in.readLine();
                    }
                }
                finally
                {
                    ua.close();
                }
            }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
    }
}
