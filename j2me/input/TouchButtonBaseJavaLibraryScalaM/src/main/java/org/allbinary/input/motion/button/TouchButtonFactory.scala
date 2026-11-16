/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.motion.button

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListUtil

class TouchButtonFactory private() {
    import _root_.org.allbinary.input.motion.button.TouchButtonFactory.{*}

    private var LIST : BasicArrayList = BasicArrayListUtil.getInstance().getImmutableInstance()

    private var list : BasicArrayList = this.LIST

    private var savedList : BasicArrayList = this.LIST

    private var saved : Boolean = false

    def defaultList() : Unit = {
        this.list = this.LIST
        this.toggle(false, this.LIST)
    }

    def toggle(save : Boolean, list : BasicArrayList) : Unit = this.synchronized {
        //update savedlist and list if not in saved mode
        if (list ne BasicArrayListUtil.getInstance().getImmutableInstance()) {
            //PreLogUtil.put("Save: " + save + " list: " + list.toString(), this, "toggle");
            this.savedList = list
            if (!this.saved) {
                this.list = this.savedList
            }
        } else {
            if (save) {
                if (!this.saved) {
                    //PreLogUtil.put("Saving", this, "toggle");
                    this.saved = true
                    this.savedList = this.list
                    this.list = this.LIST
                } else {
                }
            } else {
                //PreLogUtil.put("Restoring", this, "toggle");
                this.list = this.savedList
                this.saved = false
            }
        }
    }

    def setList(list : BasicArrayList) : Unit = {
        //ForcedLogUtil.log("Touch Buttons: " + list, this);
        if (list == null) {
            throw new Exception("Null List")
        }
        this.list = list
    }

    /**      * @return the list      */
    def getList() : BasicArrayList = {
        return this.list
    }

}

object TouchButtonFactory {
    //protected final LogUtil logUtil = LogUtil.getInstance();
    private val SINGLETON : TouchButtonFactory = new TouchButtonFactory()

    def getInstance() : TouchButtonFactory = {
        return TouchButtonFactory.SINGLETON
    }

}


