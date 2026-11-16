/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.javax.swing.*
import _root_.org.allbinary.logic.StdUtil

class DefaultListModelHelper() {

    private var defaultListModel : DefaultListModel[Object] = null

    private var vector : BasicArrayList = null

    //Constructor
    {
        this.vector = new BasicArrayListD()
        this.defaultListModel = new DefaultListModel[Object]()
    }

    def initDefaultModelList() : Unit = {
        this.defaultListModel = new DefaultListModel[Object]()
        val size : Int = this.vector.size()

        {
            var index : Int = 0
            while (index < size) {
                var moduleName : String = this.vector.get(index).asInstanceOf[String]
                this.defaultListModel.addElement(moduleName)
                index += 1
            }
        }
    }

    def getListModel() : ListModel[Object] = {
        return this.defaultListModel.asInstanceOf[ListModel[Object]]
    }

    def add(string : String) : Unit = {
        this.vector.add(string)
    }

    def remove(string : String) : Unit = {
        this.vector.remove(string)
    }

}


