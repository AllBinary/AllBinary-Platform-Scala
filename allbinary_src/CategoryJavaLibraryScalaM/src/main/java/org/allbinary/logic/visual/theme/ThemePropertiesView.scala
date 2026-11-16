/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.theme

import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class ThemePropertiesView(param_themeInterface : ThemeInterface) extends DomNodeInterface {

    private var themeInterface : ThemeInterface = null

    //Constructor
    {
        val themeInterface : ThemeInterface = param_themeInterface
        this.themeInterface = themeInterface
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = ModDomHelper.createNameValueNodes(document, ThemeData.getInstance().NAME, this.themeInterface.toHashMap())
        return node
    }

}


