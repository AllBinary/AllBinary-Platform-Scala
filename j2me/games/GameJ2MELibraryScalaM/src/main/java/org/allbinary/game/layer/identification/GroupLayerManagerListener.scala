/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.layer.identification

import _root_.org.allbinary.game.identification.Group
import _root_.org.allbinary.game.identification.GroupInterfaceCompositeInterface
import _root_.org.allbinary.layer.AllBinaryLayer
import _root_.org.allbinary.layer.event.LayerManagerEvent
import _root_.org.allbinary.layer.event.LayerManagerEventHandler
import _root_.org.allbinary.layer.event.LayerManagerEventListener
import _root_.org.allbinary.logic.communication.log.ForcedLogUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.util.event.AllBinaryEventObject
import _root_.org.allbinary.logic.util.event.EventStrings
import _root_.org.allbinary.string.CommonLabels
import _root_.org.allbinary.string.CommonSeps
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class GroupLayerManagerListener private() extends LayerManagerEventListener {
    import _root_.org.allbinary.game.layer.identification.GroupLayerManagerListener.{*}

    val logUtil : LogUtil = LogUtil.getInstance()

    //private final CommonStrings commonStrings = CommonStrings.getInstance();
    private val list : BasicArrayList = new BasicArrayListD()

    //Constructor
    {
        LayerManagerEventHandler.getInstance().addListener(this)
    }

    def clear() : Unit = {
        var groupList : BasicArrayList = null
        var size : Int = this.list.size()

        {
            var index : Int = size - 1
            while (index >= 0) {
                groupList = this.list.objectArray(index).asInstanceOf[BasicArrayList]
                groupList.clear()
                index -= 1
            }
        }
    }

    def getGroupSizeFromInterface(groupInterfaceCompositeInterface : GroupInterfaceCompositeInterface) : Int = {
        val groupInterfaceArray : Array[Group] = groupInterfaceCompositeInterface.getGroupInterface()
        return this.getGroupSize(groupInterfaceArray(0))
    }

    def getGroupSize(groupInterface : Group) : Int = {
        val id : Int = groupInterface.getGroupId().toInt
        return this.getGroupSizeById(id)
    }

    def getList(groupInterface : Group) : BasicArrayList = {
        val id : Int = groupInterface.getGroupId().toInt
        return this.getListById(id)
    }

    private def getListById(groupId : Int) : BasicArrayList = {
        val groupList : BasicArrayList = this.list.objectArray(groupId).asInstanceOf[BasicArrayList]
        return groupList
    }

    private def getGroupSizeById(groupId : Int) : Int = {
        val groupList : BasicArrayList = this.list.objectArray(groupId).asInstanceOf[BasicArrayList]
        //}
        val size : Int = groupList.size()
        return size
    }

    def areAllOtherGroupsEmpty(groupInterface : Group) : Boolean = {
        val id : Int = groupInterface.getGroupId().toInt
        val size : Int = this.list.size()

        {
            var index : Int = size - 1
            while (index >= 0) {
                if (id != index) {
                    var groupSize : Int = this.getGroupSizeById(index)
                    if (groupSize != 0) {
                        this.logUtil.putF(new StringMaker().append("Group Size: ").appendint(groupSize).toString(), this, "areAllOtherGroupsEmpty")
                        return false
                    }
                }
                index -= 1
            }
        }
        return true
    }

    private def isIdInList(id : Int, excludeGroupList : BasicArrayList) : Boolean = {
        val size : Int = excludeGroupList.size()
        var groupInterfaceArray : Array[Group] = null
        var groupInterface : Group = null
        var groupId : Int = 0

        {
            var index : Int = size - 1
            while (index >= 0) {
                groupInterfaceArray = excludeGroupList.objectArray(index).asInstanceOf[Array[Group]]
                val size2 : Int = groupInterfaceArray.length

                {
                    var index2 : Int = 0
                    while (index2 < size2) {
                        groupInterface = groupInterfaceArray(index2)
                        groupId = groupInterface.getGroupId().toInt
                        if (groupId == id) {
                            return true
                        }
                        index2 += 1
                    }
                }
                index -= 1
            }
        }
        return false
    }

    //Note: The PlayerLayer could be in the group list so 1 might be the minimum
    def areAllOtherGroupsLessThan(excludeGroupList : BasicArrayList, maxSize : Int) : Boolean = {
        //StringMaker stringBuffer = new StringMaker();
        val size : Int = this.list.size()

        {
            var index : Int = size - 1
            while (index >= 0) {
                if (!this.isIdInList(index, excludeGroupList)) {
                    var groupSize : Int = this.getGroupSizeById(index)
                    if (groupSize >= maxSize) {
                        //      stringBuffer.toString(), this, "areAllOtherGroupsLessThan");
                        return false
                    }
                }
                index -= 1
            }
        }
        return true
    }

    def init(total : Int) : Unit = {

        {
            while (this.list.size() <= (total + 1)) {
                this.list.add(new BasicArrayListD())
            }
        }
    }

    override def onEvent(eventObject : AllBinaryEventObject) : Unit = {
        ForcedLogUtil.log(EventStrings.getInstance().PERFORMANCE_MESSAGE, this)
    }

    override def onCreateLayerManagerEvent(layerManagerEvent : LayerManagerEvent) : Unit = {
        val layerInterface : AllBinaryLayer = layerManagerEvent.getLayerInterface()
        /*         if(!this.countWeapons && (layerInterface.getType() == WeaponLayer.getStaticType()))         {             return;         }         */
        val groupInterfaceArray : Array[Group] = layerInterface.getGroupInterface()
        val size : Int = groupInterfaceArray.length
        var id : Int = 0
        var groupList : BasicArrayList = null

        {
            var index : Int = 0
            while (index < size) {
                id = groupInterfaceArray(index).getGroupId().toInt
                groupList = this.list.objectArray(id).asInstanceOf[BasicArrayList]
                if (groupList == null) {
                    this.logUtil.putF(new StringMaker().append("id: ").appendint(id).toString(), this, "onCreateLayerManagerEvent")
                }
                //if(Group.ENEMY.getGroupId() == id)
                if (!groupList.contains(layerInterface)) {
                    //if(layerInterface.getType() != WeaponLayer.getStaticType())
                    groupList.add(layerInterface)
                } else {
                }
                index += 1
            }
        }
    }

    override def onDeleteLayerManagerEvent(layerManagerEvent : LayerManagerEvent) : Unit = {
        val layerInterface : AllBinaryLayer = layerManagerEvent.getLayerInterface()
        // }
        val groupInterfaceArray : Array[Group] = layerInterface.getGroupInterface()
        val size : Int = groupInterfaceArray.length
        var id : Int = 0
        var groupList : BasicArrayList = null

        {
            var index : Int = 0
            while (index < size) {
                id = groupInterfaceArray(index).getGroupId().toInt
                groupList = this.list.objectArray(id).asInstanceOf[BasicArrayList]
                // if(layerInterface.getType() != WeaponLayer.getStaticType())
                groupList.remove(layerInterface)
                index += 1
            }
        }
    }

    def log() : Unit = {
        val stringBuffer : StringMaker = new StringMaker()
        val GROUP : String = "Group: "
        val SPACE : String = CommonSeps.getInstance().SPACE
        val TOTAL_LABEL : String = CommonLabels.getInstance().TOTAL_LABEL
        var size : Int = this.list.size()

        {
            var index : Int = size - 1
            while (index >= 0) {
                val groupList : BasicArrayList = this.list.objectArray(index).asInstanceOf[BasicArrayList]
                //stringBuffer.delete(0, stringBuffer.length());
                stringBuffer.append(GROUP)
                stringBuffer.appendint(index)
                stringBuffer.append(SPACE)
                stringBuffer.append(TOTAL_LABEL)
                stringBuffer.appendint(groupList.size())
                stringBuffer.append(SPACE)
                index -= 1
            }
        }
        this.logUtil.putF(stringBuffer.toString(), this, "log")
    }

}

object GroupLayerManagerListener {
    private var SINGLETON : GroupLayerManagerListener = new GroupLayerManagerListener()

    def getInstance() : GroupLayerManagerListener = {
        return GroupLayerManagerListener.SINGLETON
    }

}


