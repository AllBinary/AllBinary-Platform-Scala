/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.configuration.profile

import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

trait GenericProfileDataWorkerTypeInterface {

    def getName() : String

    def setName(name : String) : Unit

    override def toString() : String

    def toXmlNode(document : Document) : Node

}


