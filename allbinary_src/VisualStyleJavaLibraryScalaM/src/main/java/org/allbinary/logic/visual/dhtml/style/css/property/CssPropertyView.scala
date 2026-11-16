/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.style.css.property

import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class CssPropertyView private () extends DomNodeInterface {

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var cssProperty : CssProperty = null

    def this(name : String) = {
        this()
        this.cssProperty = new CssProperty(name)
    }

    def this(node : Node) = {
        this()
        this.cssProperty = new CssProperty(node)
    }

    //For a sub class with constructors for a name and a node, since Scala lets the constructors of a class call only one super constructor.
    def this(cssProperty : CssProperty) = {
        this()
        this.cssProperty = cssProperty
    }

    /*    public CssPropertyView(HashMap hashMap)    {       this.cssProperty = new CssProperty(hashMap);    } */
    def getProperty() : CssProperty = {
        return this.cssProperty
    }

    def toXmlNode(document : Document) : Node = {
        return this.cssProperty.toXmlNode(document)
    }

}


