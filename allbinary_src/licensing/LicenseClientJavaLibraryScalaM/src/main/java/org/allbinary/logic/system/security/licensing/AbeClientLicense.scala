/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.logic.system.security.licensing

import _root_.org.allbinary.logic.StdUtil
import _root_.org.allbinary.logic.string.StringMaker
import _root_.org.allbinary.logic.string.StringUtil
import _root_.org.allbinary.logic.string.StringValidationUtil
import _root_.org.allbinary.util.ABHashtable
import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD

class AbeClientLicense(param_hashtable : ABHashtable[Object, Object]) extends AbeLicenseInterface {
    import _root_.org.allbinary.logic.system.security.licensing.AbeClientLicense.{*}

    private var hashtable : ABHashtable[Object, Object] = null

    private var id : String = null

    private var servers : BasicArrayList = null

    private var special : String = null

    private var licenseType : LicenseType = null

    //Constructor
    {
        val hashtable : ABHashtable[Object, Object] = param_hashtable
        this.hashtable = StdUtil.getInstance().createHashtable()
        var abeClientInformationData : AbeClientInformationData = AbeClientInformationData.getInstance()
        var keyValue : Object = hashtable.get(abeClientInformationData.KEY)
        if (keyValue != null) {
            if (keyValue.isInstanceOf[String]) {
                this.hashtable.put(abeClientInformationData.KEY, keyValue)
            }
        }
        /*          * Set set = hashtable.keySet(); iter = set;          * while(iter.hasNext()) { String nextKey = (String) iter.next(); Object          * keyValue = hashtable.get(nextKey);          *           * if(keyValue instanceof String) { //this.hashtable.put(new          * String(nextKey),new String(keyValue)); this.hashtable.put(nextKey,          * keyValue); } }          */
        this.id = hashtable.get(abeClientInformationData.LICENSEID).asInstanceOf[String]
        var vector : BasicArrayList = hashtable.get(abeClientInformationData.LICENSESERVERS).asInstanceOf[BasicArrayList]
        this.servers = new BasicArrayListD()
        var size : Int = vector.size()

        {
            var index : Int = 0
            while (index < size) {
                this.servers.add(vector.get(index))
                index += 1
            }
        }
        val stringUtil : StringUtil = StringUtil.getInstance()
        this.setSpecial(stringUtil.getNonNull(hashtable.get(abeClientInformationData.SPECIAL).asInstanceOf[String]))
        var licenseTypeString : String = stringUtil.getNonNull(hashtable.get(abeClientInformationData.LICENSE_TYPE).asInstanceOf[String])
        this.licenseType = LicenseTypeFactory.getInstance().getInstance(licenseTypeString)
    }

    def hasKey() : Boolean = {
        return this.isValid()
    }

    def getKey(keyName : String) : String = {
        return this.hashtable.get(keyName).asInstanceOf[String]
    }

    def getLicenseId() : String = {
        return this.id
    }

    def getServers() : BasicArrayList = {
        return this.servers
    }

    def isValid() : Boolean = {
        val stringValidationUtil : StringValidationUtil = StringValidationUtil.getInstance()
        if (!stringValidationUtil.isEmpty(this.getKey(AbeClientInformationData.getInstance().KEY))) {
            return true
        }
        return false
    }

    /*      * public void setKey(String keyType, String keyValue) {      * this.keyHashtable.put(keyType,keyValue); }      */
    override def toString() : String = {
        var stringBuffer : StringMaker = new StringMaker()
        // getKey(String keyName);
        val BREAK : String = "<br/>"
        stringBuffer.append("License Id: ")
        stringBuffer.append(this.getLicenseId())
        stringBuffer.append(BREAK)
        stringBuffer.append("Is Valid: ")
        stringBuffer.appendboolean(this.isValid())
        stringBuffer.append(BREAK)
        stringBuffer.append("Keys: ")
        stringBuffer.append(this.hashtable.toString())
        stringBuffer.append(BREAK)
        var serverVector : BasicArrayList = this.getServers()
        var size : Int = serverVector.size()

        {
            var index : Int = 0
            while (index < size) {
                var nextServerString : String = serverVector.get(index).asInstanceOf[String]
                stringBuffer.append("Server: ")
                stringBuffer.append(nextServerString)
                stringBuffer.append(BREAK)
                index += 1
            }
        }
        return stringBuffer.toString()
    }

    private def setSpecial(special : String) : Unit = {
        this.special = special
    }

    def getSpecial() : String = {
        return this.special
    }

    def getLicenseType() : LicenseType = {
        return this.licenseType
    }

}

object AbeClientLicense {
    // Should only fail is server is not working correctly
    def hasRequiredKeys(resultHashtable : ABHashtable[Object, Object]) : Boolean = {
        val abeClientInformationData : AbeClientInformationData = AbeClientInformationData.getInstance()
        if (((resultHashtable.containsKey(abeClientInformationData.LICENSEID) && resultHashtable.containsKey(abeClientInformationData.LICENSESERVERS)) && resultHashtable.containsKey(abeClientInformationData.KEY)) && resultHashtable.containsKey(abeClientInformationData.LICENSE_TYPE)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

}


