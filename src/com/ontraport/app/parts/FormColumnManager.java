package com.ontraport.app.parts;

import com.ontraport.app.tools.AbstractPart;

public class FormColumnManager extends AbstractPart
{
    public FormColumnManager open (int index) { return this; }
    public FormColumnManager open () { open(-1); return this; }
    public FormColumnManager close () { return this; }
}
