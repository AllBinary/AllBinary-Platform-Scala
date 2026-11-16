/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.style.css.property.font

import _root_.org.allbinary.logic.visual.dhtml.style.css.property.CssProperty
import _root_.org.allbinary.logic.visual.dhtml.style.css.property.CssPropertyView
import _root_.org.w3c.dom.Node

class FontFamilyView private (super_1 : CssProperty, constructor_ : Unit) extends CssPropertyView(super_1) {

    def this(node : Node) = {
        this(new CssProperty(node), ())
    }

    //Both constructors call super(CssProperty) since Scala lets the constructors of a class call only one super constructor.
    def this() = {
        this(new CssProperty(FontFamilyData.getInstance().VALUE), ())
    }

}


