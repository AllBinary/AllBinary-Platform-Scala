/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.input.automation.module.generic.configuration.profile

import _root_.java.io.DataOutputStream
import _root_.java.io.File
import _root_.java.io.FileInputStream
import _root_.java.io.FileOutputStream
import _root_.java.util.HashMap
import _root_.java.util.Set
import _root_.org.allbinary.data.tree.dom.DomNodeInterface
import _root_.org.allbinary.data.tree.dom.document.DomDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.XmlDocumentHelper
import _root_.org.allbinary.data.tree.dom.document.mapping.DomDocumentMappingInterface
import _root_.org.allbinary.input.automation.module.DefaultListModelHelper
import _root_.org.allbinary.input.automation.module.generic.configuration.profile.actions.GenericProfileActionData
import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.communication.log.LogUtil
import _root_.org.allbinary.string.CommonStrings
import _root_.org.w3c.dom.Document
import _root_.org.w3c.dom.Node
import _root_.org.w3c.dom.NodeList

class GenericProfiles(param_fileName : String) extends DomNodeInterface with DomDocumentMappingInterface {
    import _root_.org.allbinary.input.automation.module.generic.configuration.profile.GenericProfiles.{DEFAULT_PROFILES_PATH as _, DEFAULT_PROFILE_ACTIONS_PATH as _, DEFAULT_FILE as _, *}
    def DEFAULT_PROFILES_PATH : String = _root_.org.allbinary.input.automation.module.generic.configuration.profile.GenericProfiles.DEFAULT_PROFILES_PATH
    def DEFAULT_PROFILE_ACTIONS_PATH : String = _root_.org.allbinary.input.automation.module.generic.configuration.profile.GenericProfiles.DEFAULT_PROFILE_ACTIONS_PATH
    def DEFAULT_FILE : String = _root_.org.allbinary.input.automation.module.generic.configuration.profile.GenericProfiles.DEFAULT_FILE

    val logUtil : LogUtil = LogUtil.getInstance()

    private var hashMap : HashMap[Object, Object] = null

    private var profilesDefaultListModelHelper : DefaultListModelHelper = null

    private var fileName : String = null

    //Constructor
    {
        val fileName : String = param_fileName
        this.fileName = fileName
        this.profilesDefaultListModelHelper = new DefaultListModelHelper()
        this.hashMap = StdUtil.getInstance().createHashMap().asInstanceOf[HashMap[Object, Object]]
        if (new File(fileName).isFile()) {
            var bytes : Array[Byte] = new Array[Byte](100000)
            var idFile : FileInputStream = new FileInputStream(fileName)
            var length : Int = idFile.read(bytes)
            var data : String = new String(bytes)
            var endIndex : Int = data.lastIndexOf('>')
            var document : Document = DomDocumentHelper.create(data.substring(0, endIndex + 1))
            var nodeList : NodeList = document.getElementsByTagName(GenericProfilesData.NAME)
            this.logUtil.putF("Number Of Profiles Specified: " + nodeList.getLength(), this, "Contructor")
            if (nodeList != null) {
                this.initProfiles(nodeList.item(0))
            } else {
                throw new Exception(GenericProfileActionData.NAME + " Name Node Node Children")
            }
            this.logUtil.putF(("Loaded: " + this.hashMap.size()) + " Configuration Profile Actions", this, "Contructor")
        } else {
            this.logUtil.putF("No Generic Profile: " + fileName, this, "Contructor")
        }
        this.getDefaultListModelHelper().initDefaultModelList()
    }

    private def initProfiles(node : Node) : Unit = {
        var nodeList : NodeList = node.getChildNodes()

        {
            var index : Int = 0
            while (index < nodeList.getLength()) {
                var profileNameNode : Node = nodeList.item(index)
                if (profileNameNode.getNodeName().compareTo(GenericProfileData.NAME) == 0) {
                    var genericProfile : GenericProfile = new GenericProfile(profileNameNode)
                    this.hashMap.put(genericProfile.getName(), genericProfile)
                    this.getDefaultListModelHelper().add(genericProfile.getName())
                }
                index += 1
            }
        }
    }

    def getDefaultListModelHelper() : DefaultListModelHelper = {
        return this.profilesDefaultListModelHelper
    }

    def get(name : String) : GenericProfile = {
        var genericProfile : GenericProfile = this.hashMap.get(name).asInstanceOf[GenericProfile]
        if (genericProfile == null) {
            val commonStrings : CommonStrings = CommonStrings.getInstance()
            this.logUtil.putF((("No Generic Profile Named: " + name) + " availability was: ") + this.hashMap, this, commonStrings.GET)
        }
        return genericProfile
    }

    def add(name : String) : Unit = {
        this.hashMap.put(name, new GenericProfile(name))
        this.getDefaultListModelHelper().add(name)
        this.getDefaultListModelHelper().initDefaultModelList()
        this.save()
    }

    def remove(name : String) : Unit = {
        this.hashMap.remove(name)
        this.getDefaultListModelHelper().remove(name)
        this.getDefaultListModelHelper().initDefaultModelList()
        this.save()
    }

    def toXmlNode(document : Document) : Node = {
        var node : Node = document.createElement(GenericProfilesData.NAME)
        var set : Set[Object] = this.hashMap.keySet().asInstanceOf[Set[Object]]
        val nameArray : Array[Object] = set.toArray()
        val size : Int = nameArray.length

        {
            var index : Int = 0
            while (index < size) {
                var genericProfile : GenericProfile = this.hashMap.get(nameArray(index).asInstanceOf[String]).asInstanceOf[GenericProfile]
                node.appendChild(genericProfile.toXmlNode(document))
                index += 1
            }
        }
        return node
    }

    def toXmlDoc() : Document = {
        var document : Document = DomDocumentHelper.create()
        var node : Node = this.toXmlNode(document)
        document.appendChild(node)
        return document
    }

    def save() : Unit = {
        var idFile : FileOutputStream = new FileOutputStream(this.fileName)
        var idOutData : DataOutputStream = new DataOutputStream(idFile)
        var documentString : String = XmlDocumentHelper.toString(this.toXmlDoc())
        //this.logUtil.putF("Do: " + nodeList.getLength(), this, "Contructor");
        idOutData.writeBytes(documentString)
    }

}

object GenericProfiles {
    val DEFAULT_PROFILES_PATH : String = "./modules/configs/profiles/"

    val DEFAULT_PROFILE_ACTIONS_PATH : String = GenericProfiles.DEFAULT_PROFILES_PATH + "actions/"

    val DEFAULT_FILE : String = GenericProfiles.DEFAULT_PROFILES_PATH + "profiles.xml"

}


