/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.gui.swing.workers

import _root_.javax.swing.*

class JListSwingWorker(param_jList : JList[Object], param_listModel : ListModel[Object]) extends SwingWorker[Object, Object] {

    private var jList : JList[Object] = null

    private var listModel : ListModel[Object] = null

    //Constructor
    {
        val jList : JList[Object] = param_jList
        val listModel : ListModel[Object] = param_listModel
        this.setJList(jList)
        this.setListModel(listModel)
    }

    override def doInBackground() : Object = {
        return null
    }

    override def done() : Unit = {
        this.getJList().setModel(this.getListModel())
    }

    private def getJList() : JList[Object] = {
        return this.jList
    }

    private def setJList(jList : JList[Object]) : Unit = {
        this.jList = jList
    }

    private def getListModel() : ListModel[Object] = {
        return this.listModel
    }

    private def setListModel(listModel : ListModel[Object]) : Unit = {
        this.listModel = listModel
    }

}


