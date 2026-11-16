/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.time.modified

import _root_.org.allbinary.business.entry.EntryData
import _root_.org.allbinary.data.tree.dom.DomNodeHelper
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.ModDomHelper
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class TimeLastModifiedView private () extends DomNodeInterface {

    private var timeLastModified : TimeLastModified = null

    def this(timeLastModified : TimeLastModified) = {
        this()
        this.setTimeLastModified(timeLastModified)
    }

    def this(node : Node) = {
        this()
        this.setTimeLastModified(new TimeLastModified(DomNodeHelper.getTextNodeValue(node)))
    }

    def toXmlNode(document : Document) : Node = {
        return ModDomHelper.createTextNode(document, EntryData.getInstance().TIMECREATED, this.getTimeLastModified().toString())
    }

    def getTimeLastModified() : TimeLastModified = {
        return this.timeLastModified
    }

    def setTimeLastModified(timeLastModified : TimeLastModified) : Unit = {
        this.timeLastModified = timeLastModified
    }

}


