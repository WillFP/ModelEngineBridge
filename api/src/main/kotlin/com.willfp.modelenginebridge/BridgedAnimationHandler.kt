package com.willfp.modelenginebridge

interface BridgedAnimationHandler {
    val model: BridgedActiveModel

    fun playAnimation(animation: String, lerpIn: Double, lerpOut: Double, speed: Double, force: Boolean): Boolean

    fun playAnimation(animation: BridgedAnimation, force: Boolean): Boolean

    fun isPlayingAnimation(animation: String): Boolean

    fun stopAnimation(animation: String)

    fun forceStopAnimation(animation: String)

    fun forceStopAllAnimations()

    fun getAnimation(animation: String): BridgedAnimation?
}
