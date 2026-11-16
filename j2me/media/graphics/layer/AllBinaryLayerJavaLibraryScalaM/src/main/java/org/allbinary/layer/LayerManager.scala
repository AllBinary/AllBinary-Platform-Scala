/* Generated Code Do Not Modify */
package org.allbinary.layer

import _root_.javax.microedition.lcdui.Graphics
import _root_.org.allbinary.TsUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.allbinary.thread.SynchObject
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.ABSystemWrapper

class LayerManager(param_layerManagerLogging : LayerManagerLoggingBase) {

    val logUtil : LogUtil = LogUtil.getInstance()

    val commonStrings : CommonStrings = CommonStrings.getInstance()

    private val systemWrapper : ABSystemWrapper = ABSystemWrapper.getInstance()

    private val tsUtil : TsUtil = TsUtil.getInstance()

    private var layerManagerLogging : LayerManagerLoggingBase = null

    private val list : BasicArrayList = new BasicArrayListD()

    private val anyType : SynchObject = new SynchObject()

    //Constructor
    {
        val layerManagerLogging : LayerManagerLoggingBase = param_layerManagerLogging
        this.logUtil.putF(this.commonStrings.START, this, this.commonStrings.CONSTRUCTOR)
        this.layerManagerLogging = layerManagerLogging
    }

    def contains(layerInterface : AllBinaryLayer) : Boolean = {
        return this.list.contains(layerInterface)
    }

    def update(layerInterface : AllBinaryLayer) : Unit = {
        var had : Boolean = this.list.remove(layerInterface)
        if (had) {
            var nextLayerInterface : AllBinaryLayer = null
            val size : Int = this.list.size()

            {
                var index : Int = 0
                while (index < size) {
                    nextLayerInterface = this.list.get(index).asInstanceOf[AllBinaryLayer]
                    if (layerInterface.getZP() > nextLayerInterface.getZP()) {
                        this.list.addAt(index, layerInterface)
                        return
                    }
                    index += 1
                }
            }
            this.list.add(layerInterface)
        }
    }

    def insert(layerInterface : AllBinaryLayer) : Unit = {
        var nextLayerInterface : AllBinaryLayer = null
        val size : Int = this.list.size()

        {
            var index : Int = 0
            while (index < size) {
                nextLayerInterface = this.list.get(index).asInstanceOf[AllBinaryLayer]
                if (layerInterface.getZP() > nextLayerInterface.getZP()) {
                    this.appendAt(layerInterface, index)
                    return
                }
                index += 1
            }
        }
        this.append(layerInterface)
    }

    def append(layerInterface : AllBinaryLayer) : Unit = {
        this.layerManagerLogging.append(layerInterface)
        this.list.add(layerInterface)
    }

    def appendAt(layerInterface : AllBinaryLayer, index : Int) : Unit = {
        this.layerManagerLogging.appendAt(layerInterface, index)
        this.list.addAt(index, layerInterface)
    }

    def remove(layerInterface : AllBinaryLayer) : Unit = {
        this.anyType.synchronized {
            this.layerManagerLogging.remove(layerInterface)
            val result : Boolean = this.list.remove(layerInterface)
            this.layerManagerLogging.removeResult(this, layerInterface, result)
        }
    }

    def getLayerAt(index : Int) : Layer = {
        return this.list.objectArray(index).asInstanceOf[Layer]
    }

    def getSize() : Int = {
        return this.list.size()
    }

    def cleanup() : Unit = {
        //this.logUtil.putF(this.commonStrings.CLEANUP, this, this.commonStrings.CLEANUP);
        this.anyType.synchronized {
            this.list.clear()
            this.layerManagerLogging.clear()
            this.tsUtil.gc()
            this.tsUtil.gc()
        }
    }

    //private final String PAINT = canvasStrings.PAINT;
    def paint(g : Graphics, x : Int, y : Int) : Unit = {
        this.anyType.synchronized {
            //}
            var comp : Layer = null
            //}

            {
                var index : Int = this.list.size()
                while ({ index -= 1; index } >= 0) {
                    comp = this.list.objectArray(index).asInstanceOf[Layer]
                    if ((comp != null) && comp.isVisible()) {
                        comp.paint(g)
                    }
                }
            }
        }
    }

}


