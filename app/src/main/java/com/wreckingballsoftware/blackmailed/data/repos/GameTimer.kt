package com.wreckingballsoftware.blackmailed.data.repos

import android.os.CountDownTimer

const val MAX_TIME = 121L //2 minutes -- starts at 121 seconds so the first tick is 120
const val MAX_TIME_MILLISECONDS = MAX_TIME * 1000L
const val TIMER_INTERVAL = 1000L //one second

class GameTimer : CountDownTimer(
        MAX_TIME_MILLISECONDS,
        TIMER_INTERVAL,
) {
    private var onTick: ((Long) -> Unit)? = null
    private var onFinish: (() -> Unit)? = null

    fun startTimer(onTick: (Long) -> Unit, onFinish: () -> Unit) {
        this.onTick = onTick
        this.onFinish = onFinish
        this.start()
    }

    override fun onTick(millisUntilFinished: Long) {
        onTick?.let { tickFunc ->
            tickFunc(millisUntilFinished)
        }
    }

    override fun onFinish() {
        onFinish?.let { finishFunc ->
            finishFunc()
        }
    }
}
