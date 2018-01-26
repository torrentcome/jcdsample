package com.cto3543.jc2co.ui.splash

import com.cto3543.jc2co.ui.base.BasePresenter
import com.cto3543.jc2co.ui.base.BaseView

interface SplashContract {
    interface View : BaseView {
        fun load(anim: String)
    }

    interface Presenter : BasePresenter<View> {
        fun load()
    }
}