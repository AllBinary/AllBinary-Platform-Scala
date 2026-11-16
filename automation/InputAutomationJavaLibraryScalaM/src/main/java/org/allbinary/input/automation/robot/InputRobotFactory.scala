/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.robot

import _root_.java.awt.GraphicsDevice
import _root_.java.awt.GraphicsEnvironment
import _root_.java.util.Collection
import _root_.java.util.Iterator
import _root_.java.util.Set
import _root_.javax.help.HelpSet
import _root_.javax.help.event.HelpSetEvent
import _root_.javax.help.event.HelpSetListener
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.java.help.JavaHelpSetNotifier
import _root_.org.allbinary.logic.java.anyType.InterfaceUtil
import _root_.org.allbinary.logic.system.loader.SecuredNativeLibraryInterface
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.util.ABHashtable

class InputRobotFactory private() {
    import _root_.org.allbinary.input.automation.robot.InputRobotFactory.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    private val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val hashtable : ABHashtable[Object, Object] = StdUtil.getInstance().createHashtable()

    private var helpSetListenerInterface : HelpSetListener = null

    //Constructor
    {
        try {
            val graphenv : GraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment()
            val screens : Array[GraphicsDevice] = graphenv.getScreenDevices()
            var inputRobotInterface : InputRobotInterface = null

            {
                var i : Int = 0
                while (i < screens.length) {
                    inputRobotInterface = (new InputRobot(screens(i))).asInstanceOf[InputRobotInterface]
                    this.logUtil.putF("Adding Robot: " + inputRobotInterface.getName(), this, "getRobots")
                    this.get().put(inputRobotInterface.getName(), inputRobotInterface)
                    i += 1
                }
            }
            this.logUtil.putF("Number Of Robots: " + this.hashtable.size(), this, "getRobots")
        } catch {
            case e : Exception => {
                this.logUtil.putF(this.commonStrings.EXCEPTION, this, this.commonStrings.CONSTRUCTOR)
            }
        }
    }

    def addListener(helpSetListenerInterface : HelpSetListener) : Unit = {
        this.helpSetListenerInterface = helpSetListenerInterface
    }

    def add(inputRobotInterface : InputRobotInterface) : Unit = {
        this.logUtil.putF("Adding InputRobotInterface: " + inputRobotInterface.getName(), this, "add")
        this.get().put(inputRobotInterface.getName(), inputRobotInterface)
        val helpSet : HelpSet = inputRobotInterface.getHelpSet()
        if (this.helpSetListenerInterface != null) {
            if (helpSet != null) {
                if (!JavaHelpSetNotifier.isNotified(helpSet)) {
                    val helpSetEvent : HelpSetEvent = new HelpSetEvent(this, helpSet, HelpSetEvent.HELPSET_ADDED)
                    this.helpSetListenerInterface.helpSetAdded(helpSetEvent)
                }
            } else {
                this.logUtil.putF("Null HelpSet For: " + inputRobotInterface.getName(), this, "add")
            }
        } else {
            this.logUtil.putF("No HelpSet Listener", this, "add")
        }
    }

    def loadLibraries() : Unit = {
        val set : Set[Object] = this.get().keySet().asInstanceOf[Set[Object]]
        this.logUtil.putF("Loading Libraries", this, "loadLibraries")
        val nameArray : Array[Object] = set.toArray()
        val size : Int = nameArray.length

        {
            var index : Int = 0
            while (index < size) {
                var inputRobotInterface : InputRobotInterface = InputRobotFactory.getInstance().get(nameArray(index).asInstanceOf[String])
                InputRobotFactory.loadLibrary(inputRobotInterface)
                index += 1
            }
        }
    }

    def unloadLibraries() : Unit = {
        this.logUtil.putF("Unloading Libraries", this, "unloadLibraries")
        val set : Set[Object] = this.get().keySet().asInstanceOf[Set[Object]]
        var inputRobotInterface : InputRobotInterface = null
        val inputRobotArray : Array[Object] = set.toArray()
        val size : Int = inputRobotArray.length

        {
            var index : Int = 0
            while (index < size) {
                inputRobotInterface = this.get(inputRobotArray(index).asInstanceOf[String])
                if (InterfaceUtil.isImplemented(classOf[SecuredNativeLibraryInterface], inputRobotInterface)) {
                    this.logUtil.putF("Unloading Library: " + inputRobotInterface.getName(), this, "unloadLibraries")
                    var securedNativeLibraryInterface : SecuredNativeLibraryInterface = inputRobotInterface.asInstanceOf[SecuredNativeLibraryInterface]
                    securedNativeLibraryInterface.unload()
                }
                index += 1
            }
        }
    }

    def get() : ABHashtable[Object, Object] = {
        return this.hashtable
    }

    def get(name : String) : InputRobotInterface = {
        this.logUtil.putF("Getting Robot: " + name, this, "getRobots")
        return this.hashtable.get(name).asInstanceOf[InputRobotInterface]
    }

}

object InputRobotFactory {
    private val inputRobotFactory : InputRobotFactory = new InputRobotFactory()

    def getInstance() : InputRobotFactory = {
        return InputRobotFactory.inputRobotFactory
    }

    def loadLibraries(collection : Collection[Object]) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        logUtil.putF("Loading Libraries", "InputRobotFactory", "loadLibraries")
        val iterator : Iterator[? <: Object] = collection.iterator().asInstanceOf[Iterator[? <: Object]]

        {
            while (iterator.hasNext()) {
                InputRobotFactory.loadLibrary(iterator.next().asInstanceOf[InputRobotInterface])
            }
        }
    }

    def loadLibrary(inputRobotInterface : InputRobotInterface) : Unit = {
        val logUtil : LogUtil = LogUtil.getInstance()
        if (InterfaceUtil.isImplemented(classOf[SecuredNativeLibraryInterface], inputRobotInterface)) {
            logUtil.putF("Loading Library: " + inputRobotInterface.getName(), "InputRobotFactory", "loadLibraries")
            val securedNativeLibraryInterface : SecuredNativeLibraryInterface = inputRobotInterface.asInstanceOf[SecuredNativeLibraryInterface]
            securedNativeLibraryInterface.load()
        }
    }

}


