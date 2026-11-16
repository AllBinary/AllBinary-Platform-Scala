/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.category.store.theme

import _root_.org.allbinary.logic.control.validate.ValidationInterface
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node

class StoreThemeCategoryValidationView(param_categoryInterface : StoreThemeCategoryInterface) extends StoreThemeCategoryView(param_categoryInterface.asInstanceOf[StoreThemeCategoryInterface]) with ValidationInterface {

    //Constructor
    {
        val categoryInterface : StoreThemeCategoryInterface = param_categoryInterface
    }

    def isValid() : _root_.java.lang.Boolean = {
        return _root_.java.lang.Boolean.TRUE
    }

    def toValidationInfoDoc() : Document = {
        return null
    }

    def toValidationInfoNode(document : Document) : Node = {
        return null
    }

    def validationInfo() : String = {
        return "Error"
    }

}


