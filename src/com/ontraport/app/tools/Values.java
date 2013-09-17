package com.ontraport.app.tools;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public final class Values
{
    protected final Properties prop = new Properties();
    protected String name;
    protected InputStream file;
    public Values (String suite)
    {
        name = suite+".properties";
        try
        {
            InputStream file = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
            prop.loadFromXML(file);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (InvalidPropertiesFormatException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public final String get (String field)
    {
        return String.valueOf(prop.getProperty(field));
    }
    public final void set (String field, String value)
    {
        prop.setProperty(field, value);
        try
        {
            prop.storeToXML(new FileOutputStream(name), null);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
