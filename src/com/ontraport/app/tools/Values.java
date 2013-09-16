package com.ontraport.app.tools;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public final class Values
{
    public final Properties prop = new Properties();
    private String name = null;
    public Values (String suite)
    {
        name = "src/com/ontraport/app/suites/"+suite+".properties";
        FileInputStream xml;
        try
        {
            xml = new FileInputStream(name);
            prop.loadFromXML(xml);
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
        return prop.getProperty(field);
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
