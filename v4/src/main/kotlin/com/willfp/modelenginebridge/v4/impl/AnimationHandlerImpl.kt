package com.willfp.modelenginebridge.v4.impl

import com.ticxo.modelengine.api.animation.handler.AnimationHandler
import com.willfp.modelenginebridge.BridgedActiveModel
import com.willfp.modelenginebridge.BridgedAnimation
import com.willfp.modelenginebridge.BridgedAnimationHandler

class AnimationHandlerImpl(
    val handle: AnimationHandler,
    override val model: BridgedActiveModel
): BridgedAnimationHandler {
    override fun playAnimation(
        animation: String,
        lerpIn: Double,
        lerpOut: Double,
        speed: Double,
        force: Boolean
    ): Boolean {
        return handle.playAnimation(animation, lerpIn, lerpOut, speed, force) != null
    }

    override fun playAnimation(animation: BridgedAnimation, force: Boolean): Boolean {
        animation as AnimationImpl

        return handle.playAnimation(animation.handle, force)
    }

    override fun isPlayingAnimation(animation: String): Boolean {
        return handle.isPlayingAnimation(animation)
    }

    override fun stopAnimation(animation: String) {
        return handle.stopAnimation(animation)
    }

    override fun forceStopAnimation(animation: String) {
        handle.forceStopAnimation(animation)
    }
    override fun forceStopAllAnimations() {
        handle.forceStopAllAnimations()
    }

    override fun getAnimation(name: String): BridgedAnimation? {
        val animation = handle.getAnimation(name) ?: return null
        return AnimationImpl(animation)
    }
}
