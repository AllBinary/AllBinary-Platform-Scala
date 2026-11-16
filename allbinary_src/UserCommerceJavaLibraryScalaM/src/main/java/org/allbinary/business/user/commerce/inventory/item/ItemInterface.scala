/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.inventory.item

import _root_.org.allbinary.business.user.commerce.money.Money
import _root_.org.allbinary.data.tables.TableMappingInterface

trait ItemInterface extends TableMappingInterface {

    def setId(itemId : String) : Unit

    def setNumber(number : String) : Unit

    def setInBaskets(value : String) : Unit

    def setWeight(value : String) : Unit

    def setEnabled(value : String) : Unit

    def setNewOrUsed(value : String) : Unit

    def setSummary(value : String) : Unit

    def setDistributor(value : String) : Unit

    def setIdUsedByDistributor(value : String) : Unit

    def setProducedBy(value : String) : Unit

    def setProductionDate(value : String) : Unit

    def setStartProductionDate(value : String) : Unit

    def setDescription(value : String) : Unit

    def setKeywords(value : String) : Unit

    def setCategory(value : String) : Unit

    def setType(value : String) : Unit

    def setSmallImage(value : String) : Unit

    def setMediumImage(value : String) : Unit

    def setLargeImage(value : String) : Unit

    def setTimeEntered(value : String) : Unit

    def setLastModified(value : String) : Unit

    def setPrice(value : Money) : Unit

    def setComment(value : String) : Unit

    def setCustoms(value : String) : Unit

    def setDownloads(value : String) : Unit

    def setGroups(value : String) : Unit

    def setOptions(value : String) : Unit

    def setPermissions(value : String) : Unit

    def setSpecials(value : String) : Unit

    def getId() : String

    def getNumber() : String

    def getInBaskets() : String

    def getWeight() : String

    def getEnabled() : String

    def getNewOrUsed() : String

    def getSummary() : String

    def getDistributor() : String

    def getIdUsedByDistributor() : String

    def getProducedBy() : String

    def getProductionDate() : String

    def getStartProductionDate() : String

    def getDescription() : String

    def getKeywords() : String

    def getCategory() : String

    def getType() : String

    def getSmallImage() : String

    def getMediumImage() : String

    def getLargeImage() : String

    def getTimeEntered() : String

    def getLastModified() : String

    def getPrice() : Money

    def getComment() : String

    def getCustoms() : String

    def getDownloads() : String

    def getGroups() : String

    def getOptions() : String

    def getPermissions() : String

    def getSpecials() : String

    def getTotal() : Money

}


