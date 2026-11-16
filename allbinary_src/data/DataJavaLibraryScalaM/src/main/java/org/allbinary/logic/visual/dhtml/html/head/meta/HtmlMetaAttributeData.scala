/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.visual.dhtml.html.head.meta


class HtmlMetaAttributeData(param_id : Int, param_value : String) {

    private var id : Int = 0

    private var name : String = null

    //Constructor
    {
        val id : Int = param_id
        val value : String = param_value
        this.name = value
        this.id = id
    }

    def equals(htmlMetaAttributeData : HtmlMetaAttributeData) : Boolean = {
        if (htmlMetaAttributeData.id == this.id) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def toString() : String = {
        return this.name
    }

}


