/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.html

import _root_.java.util.HashMap
import _root_.org.allbinary.logic.StdUtil

class HtmlTag() {

    var otherAttributes : HashMap[Object, Object] = null

    //Constructor
    {
        this.otherAttributes = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
    }

    def addAttribute(key : String, value : String) : Unit = {
        this.otherAttributes.put(key, value)
    }

}


