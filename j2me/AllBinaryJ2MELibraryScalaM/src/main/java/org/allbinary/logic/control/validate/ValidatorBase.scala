/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.control.validate

import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.java.bool.BooleanFactory
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListUtil
import _root_.org.allbinary.util.ABHashtable

class ValidatorBase() extends ValidatorBaseInterface {
    import _root_.org.allbinary.logic.control.validate.ValidatorBase.{*}

    /* (non-Javadoc)      * @see allbinary.logic.control.validate.ValidatorBaseInterface#isValid()      */
    override def isValid() : _root_.java.lang.Boolean = {
        return BooleanFactory.getInstance().TRUE
    }

    /* (non-Javadoc)      * @see allbinary.logic.control.validate.ValidatorBaseInterface#validationInfo()      */
    override def validationInfo() : String = {
        return StringUtil.getInstance().EMPTY_STRING
    }

    /* (non-Javadoc)      * @see allbinary.logic.control.validate.ValidatorBaseInterface#toHashMap()      */
    override def toHashtable() : ABHashtable[Object, Object] = {
        return StdUtil.getInstance().NULL_TABLE
    }

    /* (non-Javadoc)      * @see allbinary.logic.control.validate.ValidatorBaseInterface#toVector()      */
    override def toList() : BasicArrayList = {
        return BasicArrayListUtil.getInstance().getImmutableInstance()
    }

}

object ValidatorBase {
    private val instance : ValidatorBase = new ValidatorBase()

    def getInstance() : ValidatorBase = {
        return ValidatorBase.instance
    }

}


