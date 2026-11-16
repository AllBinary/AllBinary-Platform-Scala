/* * AllBinary Open License Version 1 * Copyright (c) 2011 AllBinary *  * By agreeing to this license you and any business entity you represent are * legally bound to the AllBinary Open License Version 1 legal agreement. *  * You may obtain the AllBinary Open License Version 1 legal agreement from * AllBinary or the root directory of AllBinary's AllBinary Platform repository. *  * Created By: Travis Berthelot *  */
/* Generated Code Do Not Modify */
package org.allbinary.game.ag.life


class Life(param_lives : Short, param_maxlives : Short) extends LifeInterface {
    import _root_.org.allbinary.game.ag.life.Life.{NO_LIFE as _, *}
    def NO_LIFE : Life = _root_.org.allbinary.game.ag.life.Life.NO_LIFE

    private var lives : Short = 0

    private var startLives : Short = 0

    private var maxlives : Short = 0

    //Constructor
    {
        val lives : Short = param_lives
        val maxlives : Short = param_maxlives
        this.maxlives = maxlives
        if (lives > this.maxlives) {
            throw new Exception("To Many Lives")
        }
        this.lives = lives
        this.startLives = lives
    }

    override def get() : Short = {
        return this.lives
    }

    override def set(lives : Short) : Unit = {
        this.lives = lives
    }

    override def reset() : Unit = {
        this.lives = this.startLives
    }

    override def add(lives : Short) : Unit = {
        if (!this.reachedLimit()) {
            if ((this.lives + lives) <= this.getMaxlives()) {
                this.lives = (this.lives + lives).toShort
            } else {
                this.lives = this.getMaxlives()
            }
        }
    }

    override def isAlive() : Boolean = {
        if (this.lives <= 0) {
            return false
        } else {
            return true
        }
        throw new IllegalStateException()
    }

    override def getMaxlives() : Short = {
        return this.maxlives
    }

    private def reachedLimit() : Boolean = {
        if ((this.lives > this.maxlives) || (this.lives < 0)) {
            return true
        } else {
            return false
        }
        throw new IllegalStateException()
    }

    override def deaths(lives : Short) : Unit = {
        if (!this.reachedLimit()) {
            if ((this.lives - lives) >= 0) {
                this.lives = (this.lives - lives).toShort
            } else {
                this.lives = 0
            }
        }
    }

    /**      * @return the startLives      */
    def getStartLives() : Short = {
        return this.startLives
    }

    /**      * @param startLives the startLives to set      */
    def setStartLives(startLives : Short) : Unit = {
        this.startLives = startLives
    }

}

object Life {
    def createLife() : Life = {
        try {
            return new Life((0).toShort, (0).toShort)
        } catch {
            case e : Exception => {
                throw new RuntimeException()
            }
        }
        throw new IllegalStateException()
    }

    val NO_LIFE : Life = Life.createLife()

}


