package com.ontraport.app.tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Values
{
    private Map<String, Properties> map = new HashMap<String, Properties>();
    public Values ()
    {
        InputStream stream;
        List<String> files = new ArrayList<String>();
        //files.add("Users");
        //files.add("Contacts");
        //files.add("Sequences");
        //files.add("Rules");
        //files.add("SmartForms");
        files.add("Messages");
        for ( String file : files )
        {
            try
            {
                stream = this.getClass()
                             .getResourceAsStream("/" + file + ".properties");
                map.put(file, new Properties());
                map.get(file)
                   .load(stream);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    public String get ( String group, String name )
    {
        String output = "";
        try
        {
            output = map.get(group)
                        .getProperty(name, group + ":" + name + " could not be found.");
            //
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return output;
    }
}
