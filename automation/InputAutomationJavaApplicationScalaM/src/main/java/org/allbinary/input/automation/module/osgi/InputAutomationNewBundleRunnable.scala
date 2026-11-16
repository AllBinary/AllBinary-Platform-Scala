/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.osgi

import _root_.java.io.File
import _root_.java.io.FileFilter
import _root_.java.io.FileInputStream
import _root_.java.net.URL
import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.java.util.jar.JarInputStream
import _root_.java.util.jar.Manifest
import _root_.org.osgi.framework.Bundle
import _root_.org.osgi.framework.BundleContext
import _root_.org.osgi.framework.Constants
import _root_.bundle.input.automation.InputAutomationBundleActivator
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.io.file.FileWrapperUtil
import _root_.org.allbinary.logic.io.file.directory.SubDirectory
import _root_.org.allbinary.logic.io.file.filter.BasicFileFilterUtil
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.RunnableInterface
import _root_.org.allbinary.time.TimeDelayHelper
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class InputAutomationNewBundleRunnable(param_inputAutomationBundleActivator : InputAutomationBundleActivator) extends RunnableInterface {
    import _root_.org.allbinary.input.automation.module.osgi.InputAutomationNewBundleRunnable.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private var inputAutomationBundleActivator : InputAutomationBundleActivator = null

    private var running : Boolean = false

    private var fileBasicArrayList : BasicArrayList = null

    //Constructor
    {
        val inputAutomationBundleActivator : InputAutomationBundleActivator = param_inputAutomationBundleActivator
        this.inputAutomationBundleActivator = inputAutomationBundleActivator
        this.fileBasicArrayList = new BasicArrayListD()
    }

    def setThread(thread : Thread) : Unit = {
    }

    def isRunning() : Boolean = this.synchronized {
        return this.running
    }

    def setRunning(running : Boolean) : Unit = this.synchronized {
        this.running = running
    }

    /*         this.addNewModules(vector);         serviceReference.getBundle()         context.         context.installBundle()            */
    private def updateModules() : Unit = {
        this.logUtil.putF(this.commonStrings.START, this, "updateModules")
        val list : BasicArrayList = this.findNewModules()
        val size : Int = list.size()
        var bundle : Bundle = null

        {
            var index : Int = 0
            while (index < size) {
                bundle = this.install(list.get(index).asInstanceOf[URL])
                if (bundle != null) {
                    bundle.start(InputAutomationNewBundleRunnable.MODULES_START_LEVEL)
                }
                index += 1
            }
        }
    }

    private def getAllJarSymbolicNameHashMap() : HashMap[Object, Object] = {
        this.logUtil.putF(this.commonStrings.START, this, "getAllJarSymbolicNameHashMap")
        val hashMap : HashMap[Object, Object] = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        val jarFileBasicArrayList : BasicArrayList = this.getJarModuleFileBasicArrayList()
        this.logUtil.putF("Jar Module Files: " + jarFileBasicArrayList, this, "getAllJarSymbolicNameHashMap")
        val size : Int = jarFileBasicArrayList.size()
        var file : File = null

        {
            var index : Int = 0
            while (index < size) {
                file = jarFileBasicArrayList.get(index).asInstanceOf[File]
                if (!file.isDirectory()) {
                    val fileInputStream : FileInputStream = new FileInputStream(file)
                    val jarInputStream : JarInputStream = new JarInputStream(fileInputStream)
                    val manifest : Manifest = jarInputStream.getManifest()
                    if (manifest == null) {
                    } else {
                        var symbolicName : String = manifest.getMainAttributes().getValue(Constants.BUNDLE_SYMBOLICNAME)
                        if (symbolicName != null) {
                            hashMap.put(symbolicName, new URL(InputAutomationNewBundleRunnable.FILE + file.getAbsolutePath()))
                        }
                    }
                }
                index += 1
            }
        }
        return hashMap
    }

    private def getJarModuleFileBasicArrayList() : BasicArrayList = {
        this.logUtil.putF(this.commonStrings.START, this, "getJarModuleFileBasicArrayList")
        var baseJarPath : String = System.getProperty(JAR_DIR_PROP)
        if (baseJarPath.startsWith(InputAutomationNewBundleRunnable.FILE)) {
            baseJarPath = baseJarPath.substring(InputAutomationNewBundleRunnable.FILE.length())
        }
        var jarFileFilter : FileFilter = BasicFileFilterUtil.getInstance(".jar")
        var path : String = baseJarPath + InputAutomationNewBundleRunnable.INPUT_AUTMATION_MODULE_BUNDLE_JAR_PATH
        this.logUtil.putF("Path: " + path, this, "getJarModuleFileBasicArrayList")
        var file : File = new File(path)
        this.logUtil.putF((("File: " + file.getAbsolutePath()) + " isDirectory: ") + file.isDirectory(), this, "getJarModuleFileBasicArrayList")
        return SubDirectory.getInstance().search(jarFileFilter, FileWrapperUtil.wrapFile(file))
    }

    private def getInstalledJarSymbolicNameBasicArrayList() : BasicArrayList = {
        this.logUtil.putF(this.commonStrings.START, this, "getInstalledJarSymbolicNameBasicArrayList")
        var vector : BasicArrayList = new BasicArrayListD()
        var bundleContext : BundleContext = InputAutomationBundleActivator.getBundleContext()
        var bundleArray : Array[Bundle] = bundleContext.getBundles()
        if (bundleArray != null) {
            this.logUtil.putF("bundleArray: " + bundleArray.length, this, "getInputAutomationModuleServices")

            {
                var index : Int = 0
                while (index < bundleArray.length) {
                    var bundle : Bundle = bundleArray(index)
                    vector.add(bundle.getSymbolicName())
                    index += 1
                }
            }
        }
        return vector
    }

    private def isInstalled(symbolicName : String) : Boolean = {
        this.logUtil.putF(CommonLabels.getInstance().START + symbolicName, this, "isInstalled")
        val list : BasicArrayList = this.getInstalledJarSymbolicNameBasicArrayList()
        val size : Int = list.size()
        var nextSymbolicName : String = null

        {
            var index : Int = 0
            while (index < size) {
                nextSymbolicName = list.get(index).asInstanceOf[String]
                if (nextSymbolicName.compareTo(symbolicName) == 0) {
                    return true
                }
                index += 1
            }
        }
        return false
    }

    private def findNewModules() : BasicArrayList = {
        this.logUtil.putF(this.commonStrings.START, this, "findNewModules")
        var vector : BasicArrayList = new BasicArrayListD()
        var hashMap : HashMap[Object, Object] = this.getAllJarSymbolicNameHashMap().asInstanceOf[HashMap[Object, Object]]
        this.logUtil.putF("All: " + hashMap, this, "findNewModules")
        var set : Set[Object] = hashMap.keySet().asInstanceOf[Set[Object]]
        val symbolicNameArray : Array[Object] = set.toArray()
        val size : Int = symbolicNameArray.length

        {
            var index : Int = 0
            while (index < size) {
                var symbolicName : String = symbolicNameArray(index).asInstanceOf[String]
                if (!this.isInstalled(symbolicName)) {
                    vector.add(hashMap.get(symbolicName))
                }
                index += 1
            }
        }
        return vector
    }

    private def install(url : URL) : Bundle = {
        this.logUtil.putF(CommonLabels.getInstance().START + url, this, "install")
        var bundleContext : BundleContext = InputAutomationBundleActivator.getBundleContext()
        return bundleContext.installBundle(url.toString())
    }

    def run() : Unit = {
        try {
            this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.RUN)
            this.setRunning(true)
            var timeHelper : TimeDelayHelper = new TimeDelayHelper(1000)

            {
                scala.util.boundary { (break_N78628 : scala.util.boundary.Label[Unit]) ?=>
                    while (this.isRunning()) {
                        timeHelper.setStartTimeTNT()
                        this.logUtil.putF(CommonLabels.getInstance().ELAPSED + timeHelper.getElapsedTNT(), this, this.commonStrings.RUN)
                        this.updateModules()
                        //Thread.sleep(10000);
                        scala.util.boundary.break()(using break_N78628)
                    }
                }
            }
            this.logUtil.putF(this.commonStrings.END, this, this.commonStrings.RUN)
        } catch {
            case breakException: scala.util.boundary.Break[?] => throw breakException
            case e : Exception => {
                this.logUtil.put(this.commonStrings.EXCEPTION, this, this.commonStrings.RUN, e)
            }
        }
    }

}

object InputAutomationNewBundleRunnable {
    private val FILE : String = "file:"

    private val JAR_DIR_PROP : String = "org.knopflerfish.gosg.jars"

    private val INPUT_AUTMATION_MODULE_BUNDLE_JAR_PATH : String = "ia/auto"

    private val MODULES_START_LEVEL : Int = 8

}


