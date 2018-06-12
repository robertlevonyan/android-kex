package com.robertlevonyan.components.kex

import android.animation.Animator
import android.support.annotation.RequiresApi
import android.support.transition.Transition

fun Animator.addListener(
        onEnd: (Animator) -> Unit = {},
        onStart: (Animator) -> Unit = {},
        onCancel: (Animator) -> Unit = {},
        onRepeat: (Animator) -> Unit = {}
) {
    addListener(object : Animator.AnimatorListener {
        override fun onAnimationRepeat(animator: Animator) {
            onRepeat(animator)
        }

        override fun onAnimationEnd(animator: Animator) {
            onEnd(animator)
        }

        override fun onAnimationCancel(animator: Animator) {
            onCancel(animator)
        }

        override fun onAnimationStart(animator: Animator) {
            onStart(animator)
        }
    })
}

fun Animator.onStart(onStart: (Animator) -> Unit) {
    addListener(onStart = onStart)
}

fun Animator.onEnd(onEnd: (Animator) -> Unit) {
    addListener(onEnd = onEnd)
}

fun Animator.onCancel(onCancel: (Animator) -> Unit) {
    addListener(onCancel = onCancel)
}

fun Animator.onRepeat(onRepeat: (Animator) -> Unit) {
    addListener(onRepeat = onRepeat)
}

@RequiresApi(19)
fun Animator.addPauseListener(
        onResume: (Animator) -> Unit = {},
        onPause: (Animator) -> Unit = {}
): Animator.AnimatorPauseListener {
    val listener = object : Animator.AnimatorPauseListener {
        override fun onAnimationPause(animator: Animator) {
            onPause(animator)
        }

        override fun onAnimationResume(animator: Animator) {
            onResume(animator)
        }
    }
    addPauseListener(listener)
    return listener
}

@RequiresApi(19)
fun Animator.onResume(onResume: (Animator) -> Unit) {
    addPauseListener(onResume = onResume)
}

@RequiresApi(19)
fun Animator.onPause(onPause: (Animator) -> Unit) {
    addPauseListener(onPause = onPause)
}

fun Transition.addListener(
        onTransitionEnd: (Transition) -> Unit = {},
        onTransitionResume: (Transition) -> Unit = {},
        onTransitionPause: (Transition) -> Unit = {},
        onTransitionCancel: (Transition) -> Unit = {},
        onTransitionStart: (Transition) -> Unit = {}
) {
    addListener(object : Transition.TransitionListener {
        override fun onTransitionEnd(transition: Transition) {
            onTransitionEnd(transition)
        }

        override fun onTransitionResume(transition: Transition) {
            onTransitionResume(transition)
        }

        override fun onTransitionPause(transition: Transition) {
            onTransitionPause(transition)
        }

        override fun onTransitionCancel(transition: Transition) {
            onTransitionCancel(transition)
        }

        override fun onTransitionStart(transition: Transition) {
            onTransitionStart(transition)
        }

    })
}

fun Transition.onTransitionEnd(onTransitionEnd: (Transition) -> Unit) {
    addListener(onTransitionEnd = onTransitionEnd)
}
fun Transition.onTransitionResume(onTransitionResume: (Transition) -> Unit) {
    addListener(onTransitionResume = onTransitionResume)
}
fun Transition.onTransitionPause(onTransitionPause: (Transition) -> Unit) {
    addListener(onTransitionPause = onTransitionPause)
}
fun Transition.onTransitionCancel(onTransitionCancel: (Transition) -> Unit) {
    addListener(onTransitionCancel = onTransitionCancel)
}
fun Transition.onTransitionStart(onTransitionStart: (Transition) -> Unit) {
    addListener(onTransitionStart = onTransitionStart)
}