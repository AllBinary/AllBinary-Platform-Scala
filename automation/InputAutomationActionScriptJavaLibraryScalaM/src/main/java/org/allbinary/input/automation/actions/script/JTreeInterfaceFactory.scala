/*  * To change this license header, choose License Headers in Project Properties.  * To change this template file, choose Tools | Templates  * and open the template in the editor.  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.actions.script


/**  *  * @author user  */
class JTreeInterfaceFactory {
    import _root_.org.allbinary.input.automation.actions.script.JTreeInterfaceFactory.{*}

    private var jTreeInterface : JTreeInterface = null

    def set(jTreeInterface : JTreeInterface) : Unit = {
        this.jTreeInterface = jTreeInterface
    }

    def getJTreeInterface() : JTreeInterface = {
        return this.jTreeInterface
    }

}

object JTreeInterfaceFactory {
    private val instance : JTreeInterfaceFactory = new JTreeInterfaceFactory()

    /**      * @return the instance      */
    def getInstance() : JTreeInterfaceFactory = {
        return JTreeInterfaceFactory.instance
    }

}


