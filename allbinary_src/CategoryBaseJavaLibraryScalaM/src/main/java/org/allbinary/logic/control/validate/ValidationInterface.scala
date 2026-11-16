/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.validate

import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

trait ValidationInterface {

    //Form or other data validation 
    def isValid() : _root_.java.lang.Boolean

    def toValidationInfoNode(document : Document) : Node

    def toValidationInfoDoc() : Document

    def validationInfo() : String

}


