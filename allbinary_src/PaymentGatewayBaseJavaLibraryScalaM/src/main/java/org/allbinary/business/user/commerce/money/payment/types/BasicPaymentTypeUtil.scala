/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.business.user.commerce.money.payment.types

import _root_.org.allbinary.util.BasicArrayList
import _root_.org.allbinary.util.BasicArrayListD
import _root_.org.allbinary.logic.StdUtil

/**  *  * @author user  */
class BasicPaymentTypeUtil private() {
    import _root_.org.allbinary.business.user.commerce.money.payment.types.BasicPaymentTypeUtil.{*}

    private var paymentTypeVector : BasicArrayList = new BasicArrayListD()

    def add(paymentType : BasicPaymentType) : Unit = {
        this.paymentTypeVector.add(paymentType)
    }

    def get(paymentTypeString : String) : BasicPaymentType = {
        var size : Int = this.paymentTypeVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var paymentType : BasicPaymentType = this.paymentTypeVector.get(i).asInstanceOf[BasicPaymentType]
                if (paymentType.getName().compareTo(paymentTypeString) == 0) {
                    return paymentType
                }
                i += 1
            }
        }
        throw new Exception("Unknown PaymentType: " + paymentTypeString)
    }

    def isContain(paymentType : BasicPaymentType) : Boolean = {
        return this.paymentTypeVector.contains(paymentType)
    }

    def difference(a_PaymentTypeVector : BasicArrayList) : BasicArrayList = {
        var diff : BasicArrayList = new BasicArrayListD()
        var size : Int = this.paymentTypeVector.size()

        {
            var i : Int = 0
            while (i < size) {
                var paymentType : BasicPaymentType = this.paymentTypeVector.get(i).asInstanceOf[BasicPaymentType]
                if (!a_PaymentTypeVector.contains(paymentType)) {
                    diff.add(paymentType)
                }
                i += 1
            }
        }
        return diff
    }

}

object BasicPaymentTypeUtil {
    private val instance : BasicPaymentTypeUtil = new BasicPaymentTypeUtil()

    {
    }

    /**      * @return the instance      */
    def getInstance() : BasicPaymentTypeUtil = {
        return BasicPaymentTypeUtil.instance
    }

}


