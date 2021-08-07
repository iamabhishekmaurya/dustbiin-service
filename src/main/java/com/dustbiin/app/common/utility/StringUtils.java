package com.dustbiin.app.common.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    private static final Logger logger = LogManager.getLogger(StringUtils.class);
    public static boolean isValidObj( final Object inObj )
    {
        if ( ( null == inObj ) )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public static boolean isEmpty( final String str )
    {
        if ( ( str == null ) || ( str.trim().length() == 0 ) )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean isValidEmailID( final String emailAddress )
    {
        boolean isValid = false;
        try
        {
            if ( !isEmpty( emailAddress ) )
            {
                final InternetAddress[] address = InternetAddress.parse( emailAddress );
                if ( address != null )
                {
                    if ( emailAddress.indexOf( '@' ) > -1 && emailAddress.indexOf( '.' ) > -1 )
                    {
                        isValid = true;
                    }
                }
            }
        }
        catch ( AddressException addrEx )
        {
            logger.warn( "AddressException in parsing email address : " + emailAddress + " Exception is : " + addrEx );
        }
        catch ( Exception ex )
        {
            logger.warn( "Exception in parsing email address : " + emailAddress + " Exception is : " + ex );
        }
        return isValid;
    }

    public static boolean isValidMobile( final String inMobile )
    {
        Pattern pattern = Pattern.compile( "[6-9][0-9]{9}" );
        Matcher matcher = pattern.matcher( inMobile );
        if ( matcher.matches() )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
