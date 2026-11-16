/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.java.bool


class BooleanFactory {
    import _root_.org.allbinary.logic.java.bool.BooleanFactory.{*}

    //Boolean.TRUE;
    val TRUE : _root_.java.lang.Boolean = new _root_.java.lang.Boolean(true)

    //Boolean.FALSE;
    val FALSE : _root_.java.lang.Boolean = new _root_.java.lang.Boolean(false)

    //public final Boolean FALSE = Boolean.FALSE;    
    val TRUE_STRING : String = this.TRUE.toString()

    val FALSE_STRING : String = this.FALSE.toString()

    val YES : String = "yes"

    val NO : String = "no"

    def toStringb(bool : Boolean) : String = {
        if (bool) {
            return this.TRUE_STRING
        } else {
            return this.FALSE_STRING
        }
        throw new IllegalStateException()
    }

}

object BooleanFactory {
    private val instance : BooleanFactory = new BooleanFactory()

    def getInstance() : BooleanFactory = {
        return BooleanFactory.instance
    }

}


